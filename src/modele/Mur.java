package modele;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import controleur.Global;
import java.net.URL;

/**
 * Gestion des murs
 *
 */
public class Mur extends Objet implements Global{

	/**
	 * Constructeur : créer un mur à une position aléatoire et lui affecte une image de mur
	 */
	public Mur() {
		//Position aléatoire du mur
		posX = (int) Math.round(Math.random()*(LARGEURARENE-LARGEURMUR));
		posY = (int) Math.round(Math.random()*(HAUTEURARENE-HAUTEURMUR));
		//Création label
		JLabel jLabel = new JLabel();
		//caractéristiques du mur (image et taille)
		jLabel.setBounds(posX,posY,LARGEURMUR,HAUTEURMUR);
		URL resource = getClass().getClassLoader().getResource(MUR);
		jLabel.setIcon(new ImageIcon(resource));
	}
	
}

