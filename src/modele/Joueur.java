package modele;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controleur.Global;

/**
 * Gestion des joueurs
 *
 */
public class Joueur extends Objet implements Global {

	/**
	 * pseudo saisi
	 */
	private String pseudo;
	/**
	 * n� correspondant au personnage (avatar) pour le fichier correspondant
	 */
	private int numPerso;
	/**
	 * instance de JeuServeur pour communiquer avec lui
	 */
	private JeuServeur jeuServeur;
	/**
	 * num�ro d'�tape dans l'animation (de la marche, touch� ou mort)
	 */
	private int etape;
	/**
	 * la boule du joueur
	 */
	private Boule boule;
	/**
	 * vie restante du joueur
	 */
	private int vie;
	/**
	 * tourn� vers la gauche (0) ou vers la droite (1)
	 */
	private int orientation;
	/**
	 * Label message
	 */
	private JLabel message;

	/**
	 * Constructeur
	 */
	public Joueur(JeuServeur jeuServeur) {
		this.jeuServeur = jeuServeur;
		this.vie = MAXVIE;
		this.orientation = DROITE;
		this.etape = 1;
	}

	public String getPseudo() {
		return this.pseudo;
	}

	/**
	 * getter sur l'orientation
	 */
	public int getOrientation() {
		return orientation;
	}

	/**
	 * Initialisation d'un joueur (pseudo et num�ro, calcul de la 1�re position,
	 * affichage, cr�ation de la boule)
	 * 
	 * @param numPerso num�ro du personnage
	 * @param pseudo   pseudo du joueur
	 */
	public void initPerso(String pseudo, int numPerso, Collection<Joueur> lesJoueurs, ArrayList<Mur> lesMurs) {
		this.pseudo = pseudo;
		this.numPerso = numPerso;
		System.out.println("joueur " + pseudo + " - num perso " + numPerso + " cree");
		// création du label
		super.jLabel = new JLabel();
		// création label message
		this.message = new JLabel();
		message.setHorizontalAlignment(SwingConstants.CENTER);
		message.setFont(new Font("Dialog", Font.PLAIN, 8));
		// Création de la boule
		this.boule = new Boule(this.jeuServeur);
		// Calcul première position du joueur
		this.premierePosition(lesJoueurs, lesMurs);
		// Insertion dans l'arène des 2 labels
		this.jeuServeur.ajoutJLabelJeuArene(jLabel);
		this.jeuServeur.ajoutJLabelJeuArene(message);
		this.jeuServeur.ajoutJLabelJeuArene(boule.getjLabel());
		// affichage
		this.affiche(MARCHE, this.etape);

	}

	/**
	 * Calcul de la premi�re position al�atoire du joueur (sans chevaucher un autre
	 * joueur ou un mur)
	 */
	private void premierePosition(Collection lesJoueurs, Collection lesMurs) {
		jLabel.setBounds(0, 0, LARGEURPERSO, HAUTEURPERSO);
		do {
			posX = (int) Math.round(Math.random() * (LARGEURARENE - LARGEURPERSO));
			posY = (int) Math.round(Math.random() * (HAUTEURARENE - HAUTEURPERSO - HAUTEURMESSAGE));
		} while (toucheCollectionObjets(lesJoueurs) != null || toucheCollectionObjets(lesMurs) != null);
	}

	/**
	 * Affiche le personnage et son message
	 */
	public void affiche(String etat, int etape) {
		// positionnement du personnage et affectation de la bonne image
		super.jLabel.setBounds(posX, posY, LARGEURPERSO, HAUTEURPERSO);
		String chemin = CHEMINPERSONNAGES + PERSO + this.numPerso + etat + etape + "d" + this.orientation
				+ EXTFICHIERPERSO;
		URL resource = getClass().getClassLoader().getResource(chemin);
		super.jLabel.setIcon(new ImageIcon(resource));
		// Label message
		this.message.setBounds(posX - 10, posY + HAUTEURPERSO, 10 + LARGEURPERSO, HAUTEURMESSAGE);
		this.message.setText(this.pseudo + ":" + this.vie);
		this.jeuServeur.envoiJeuATous();
	}

	/**
	 * G�re une action re�ue et qu'il faut afficher (d�placement, tire de boule...)
	 */
	public void action(int action, Collection<Joueur> lesJoueurs, ArrayList<Mur> lesMurs) {
		if (!this.estMort()) {
			switch (action) {
			case KeyEvent.VK_UP:
				posY = deplace(posY, action, -PAS, HAUTEURARENE - HAUTEURPERSO - HAUTEURMESSAGE, lesJoueurs, lesMurs);
				break;
			case KeyEvent.VK_DOWN:
				posY = deplace(posY, action, PAS, HAUTEURARENE - HAUTEURPERSO - HAUTEURMESSAGE, lesJoueurs, lesMurs);
				break;
			case KeyEvent.VK_LEFT:
				orientation = GAUCHE;
				posX = deplace(posX, action, -PAS, LARGEURARENE - LARGEURPERSO, lesJoueurs, lesMurs);
				break;
			case KeyEvent.VK_RIGHT:
				orientation = DROITE;
				posX = deplace(posX, action, PAS, LARGEURARENE - LARGEURPERSO, lesJoueurs, lesMurs);
				break;
			case KeyEvent.VK_SPACE:
				if (!this.boule.getjLabel().isVisible()) {
					this.boule.tireBoule(this, lesMurs);
				}
			}
			affiche(MARCHE, this.etape);
		}
	}

	/**
	 * G�re le d�placement du personnage
	 */
	private int deplace(int position, int action, int lepas, int max, Collection lesJoueurs, Collection lesMurs) {
		int ancpos = position;
		position += lepas;
		position = Math.max(position, 0);
		position = Math.min(position, max);
		if (action == KeyEvent.VK_LEFT || action == KeyEvent.VK_RIGHT) {
			posX = position;
		} else {
			posY = position;
		}
		// controle collision
		if (toucheCollectionObjets(lesJoueurs) != null || toucheCollectionObjets(lesMurs) != null) {
			position = ancpos;
		}
		etape = (etape % NBETAPESMARCHE) + 1;
		return position;
	}

	/**
	 * Gain de points de vie apr�s avoir touch� un joueur
	 */
	public void gainVie() {
		this.vie += GAIN;
	}

	/**
	 * Perte de points de vie apr�s avoir �t� touch�
	 */
	public void perteVie() {
		this.vie = Math.max(0, this.vie - PERTE);
	}

	/**
	 * vrai si la vie est � 0
	 * 
	 * @return true si vie = 0
	 */
	public Boolean estMort() {
		return (this.vie == 0);
	}

	/**
	 * Le joueur se d�connecte et disparait
	 */
	public void departJoueur() {
		if(super.jLabel != null) {
			super.jLabel.setVisible(false);
			this.message.setVisible(false);
			this.boule.getjLabel().setVisible(false);
			this.jeuServeur.envoiJeuATous();
		}
	}

}
