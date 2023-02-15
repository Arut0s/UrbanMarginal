/**
 * 
 */
package controleur;

/**
 * Global contient les constantes du programme
 * @author emds
 *
 */
public interface Global {
	
	/**
	 * N° du port d'écoute du serveur
	 */
	int PORT = 6666;
	/**
	 * Nombre de personnages différents
	 */
	int NBPERSOS = 3;
	/**
	 * Caractère de séparation dans un chemin de fichiers
	 */
	String CHEMINSEPARATOR = "/";
	/**
	 * Chemin du dossier des images de fonds
	 */
	String CHEMINFONDS = "fonds"+CHEMINSEPARATOR;
	/**
	 * Chemin du dossier de l'image de la boule
	 */
	String CHEMINBOULES = "boules"+CHEMINSEPARATOR;
	/**
	 * Chemin du dossier de l'image du mur
	 */
	String CHEMINMURS = "murs"+CHEMINSEPARATOR;
	/**
	 * Chemin du dossier des images des personnages
	 */
	String CHEMINPERSONNAGES = "personnages"+CHEMINSEPARATOR;
	/**
	 * Chemin du dossier des sons
	 */
	String CHEMINSONS = "sons"+CHEMINSEPARATOR;
	/**
	 * Chemin de l'image de fond de la vue ChoixJoueur
	 */
	String FONDCHOIX = CHEMINFONDS+"fondchoix.jpg";
	/**
	 * Chemin de l'image de fond de la vue Arene
	 */
	String FONDARENE = CHEMINFONDS+"fondarene.jpg";
	/**
	 * Extension des fichiers des images des personnages
	 */
	String EXTFICHIERPERSO = ".gif";
	/**
	 * Début du nom des images des personnages
	 */
	String PERSO = "perso";
	/**
	 * Chemin de l'image de la boule
	 */
	String BOULE = CHEMINBOULES+"boule.gif";
	/**
	 * Chemin de l'image du mur
	 */
	String MUR = CHEMINMURS+"mur.gif";
	/**
	 * État marche du personnage
	 */
	String MARCHE = "marche";
	/**
	 * État touché du personnage
	 */
	String TOUCHE = "touche";
	/**
	 * État mort du personnage
	 */
	String MORT = "mort";
	/**
	 * Caractère de séparation dans les chaines transformées
	 */
	String STRINGSEPARE = "~";
	/**
	 * Message "connexion" envoyé par la classe Connection
	 */
	String CONNEXION = "connexion";
	/**
	 * Message "réception" envoyé par la classe Connection
	 */
	String RECEPTION = "réception";
	/**
	 * Message "déconnexion" envoyé par la classe Connection
	 */
	String DECONNEXION = "déconnexion";
	/**
	 * Message "pseudo" envoyé pour la création d'un joueur
	 */
	String PSEUDO = "pseudo";
	/**
	 * Ordre pour ajouter un mur dans l'arène du serveur
	 */
	String AJOUTMUR = "ajout mur";
	/**
	 * vie de départ pour tous les joueurs
	 */
	int MAXVIE = 10 ;
	/**
	 * gain de points de vie lors d'une attaque
	 */
	int GAIN = 1 ; 
	/**
	 * perte de points de vie lors d'une attaque
	 */
	int PERTE = 2 ; 
	/**
	 * Hauteur de la zone de jeu de l'arène
	 */
	int HAUTEURARENE = 600;
	/**
	 * Largeur de la zone de jeu de l'arène
	 */
	int LARGEURARENE = 800;
	/**
	 * Hauteur d'un mur
	 */
	int HAUTEURMUR = 35;
	/**
	 * Largeur d'un mur
	 */
	int LARGEURMUR = 34;
	/**
	 * Nombre de murs
	 */
	int NBMURS = 20;
}
