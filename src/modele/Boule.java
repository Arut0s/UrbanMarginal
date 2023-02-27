package modele;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controleur.Global;

/**
 * Gestion de la boule
 *
 */
public class Boule extends Objet implements Global, Runnable {

	private Collection lesMurs;

	private Joueur attaquant;

	/**
	 * instance de JeuServeur pour la communication
	 */
	private JeuServeur jeuServeur;

	/**
	 * Constructeur
	 */
	public Boule(JeuServeur jeuServeur) {
		this.jeuServeur = jeuServeur;
		super.jLabel = new JLabel();
		super.jLabel.setVisible(false);
		URL resource = getClass().getClassLoader().getResource(BOULE);
		super.jLabel.setIcon(new ImageIcon(resource));
		super.jLabel.setBounds(0, 0, LARGEURBOULE, HAUTEURBOULE);
	}

	/**
	 * Tire d'une boule
	 * 
	 * @param lesMurs
	 */
	public void tireBoule(Joueur attaquant, Collection lesMurs) {
		this.lesMurs = lesMurs;
		this.attaquant = attaquant;
		if (attaquant.getOrientation() == GAUCHE) {
			posX = attaquant.getPosX() - LARGEURBOULE - 1;
			posY = attaquant.getPosY() + HAUTEURPERSO / 2;
		} else if (attaquant.getOrientation() == DROITE) {
			posX = attaquant.getPosX() + LARGEURPERSO + 1;
			posY = attaquant.getPosY() + HAUTEURPERSO / 2;
		} else if (attaquant.getOrientation() == HAUT) {
			posY = attaquant.getPosY() - HAUTEURBOULE;
			posX = attaquant.getPosX() + LARGEURPERSO / 2;
		} else if (attaquant.getOrientation() == BAS) {
			posY = attaquant.getPosY() + HAUTEURPERSO;
			posX = attaquant.getPosX() + LARGEURPERSO / 2;
		}
		// lancement thread indépendant
		new Thread(this).start();
	}

	@Override
	public void run() {
		// afficher l'attaquant à l'étape repos de la marche
		this.attaquant.affiche(MARCHE, 1);
		// rendre la boule visible
		super.jLabel.setVisible(true);
		// jouer son de la boule
		this.jeuServeur.envoi(FIGHT);
		// préparer la victime (dans le cas où un joueur est touché)
		Joueur victime = null;
		// pas positif ou négatif (suivant l'orientation du joueur) pour faire avancer
		// la boule
		int lePas;
		if (attaquant.getOrientation() == GAUCHE || attaquant.getOrientation() == HAUT) {
			lePas = -PAS;
		} else {
			lePas = PAS;
		}
		// gestion de la trajectoire de la boule
		do {
			// la boule avance
			if (attaquant.getOrientation() == DROITE || attaquant.getOrientation() == GAUCHE) {
				posX += lePas;
			}else {
				posY += lePas;
			}
			jLabel.setBounds(posX, posY, LARGEURBOULE, HAUTEURBOULE);
			// envoi de la nouvelle zone de jeu à tous (pour que tous voient la boule
			// avancer)
			this.jeuServeur.envoiJeuATous();
			// récupère la collection actuelle de joueurs
			Collection lesJoueurs = this.jeuServeur.getLesJoueurs();
			// récupération de l'éventuelle victime
			victime = (Joueur) super.toucheCollectionObjets(lesJoueurs);
		} while (posY >= 0 && posY <= HAUTEURARENE && posX >= 0 && posX <= LARGEURARENE && victime == null && super.toucheCollectionObjets(lesMurs) == null);
		if (victime != null && !victime.estMort()) {
			victime.perteVie();
			attaquant.gainVie();
			this.jeuServeur.envoi(HURT);
			for (int k = 1; k <= NBETAPESTOUCHE; k++) {
				victime.affiche(TOUCHE, k);
				pause(80, 0);
			}
			if (victime.estMort()) {
				this.jeuServeur.envoi(DEATH);
				for (int k = 1; k <= NBETAPESMORT; k++) {
					victime.affiche(MORT, k);
					pause(80, 0);
				}
				victime.removeMort();
			} else {
				victime.affiche(MARCHE, 1);
			}
		}
		super.jLabel.setVisible(false);
		this.jeuServeur.envoiJeuATous();
	}

	private void pause(long millis, int nanos) {
		try {
			Thread.sleep(millis, nanos);
		} catch (InterruptedException e) {
			System.out.println("erreur pause");
		}
	}
}
