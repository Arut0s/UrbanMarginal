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
public class Boule extends Objet implements Global{
	
	private Collection lesMurs;
	
	private Joueur attaquant;

	/**
	 * instance de JeuServeur pour la communication
	 */
	private JeuServeur jeuServeur ;
	
	/**
	 * Constructeur
	 */
	public Boule(JeuServeur jeuServeur) {
		this.jeuServeur = jeuServeur;
		super.jLabel = new JLabel();
		super.jLabel.setVisible(false);
		URL resource = getClass().getClassLoader().getResource(BOULE);
		super.jLabel.setIcon(new ImageIcon(resource));
		super.jLabel.setBounds(0,0,LARGEURBOULE,HAUTEURBOULE);
	}
	
	/**
	 * Tire d'une boule
	 */
	public void tireBoule(Joueur attaquant, ArrayList<Mur> lesMurts) {
		this.lesMurs = lesMurs;
		this.attaquant = attaquant;
		
	}
	
}
