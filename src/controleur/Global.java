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
	 * N� du port d'�coute du serveur
	 */
	int PORT = 6666;
	/**
	 * Nombre de personnages diff�rents
	 */
	int NBPERSOS = 3;
	/**
	 * Caract�re de s�paration dans un chemin de fichiers
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
	
	String SONPRECEDENT = CHEMINSONS+"precedent.wav";
	
	String SONSUIVANT = CHEMINSONS+"suivant.wav";
	
	String SONWELCOME = CHEMINSONS+"welcome.wav";
	
	String SONGO = CHEMINSONS+"go.wav";
	
	String SONFIGHT = CHEMINSONS+"fight.wav";
	/**
	 * Chemin du son hurt (joueur blessé)
	 */
	String SONHURT = CHEMINSONS+"hurt.wav";
	/**
	 * Chemin du son death (joueur tué)
	 */
	String SONDEATH = CHEMINSONS+"death.wav";
	
	String[] SON = {CHEMINSONS+"fight.wav", CHEMINSONS+"hurt.wav", CHEMINSONS+"death.wav"};
	
	int FIGHT = 0;
	
	int HURT = 1;
	
	int DEATH = 2;
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
	 * D�but du nom des images des personnages
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
	 * �tat marche du personnage
	 */
	String MARCHE = "marche";
	/**
	 * �tat touch� du personnage
	 */
	String TOUCHE = "touche";
	/**
	 * �tat mort du personnage
	 */
	String MORT = "mort";
	/**
	 * Caract�re de s�paration dans les chaines transf�r�es
	 */
	String STRINGSEPARE = "~";
	/**
	 * Message "connexion" envoy� par la classe Connection
	 */
	String CONNEXION = "connexion";
	/**
	 * Message "r�ception" envoy� par la classe Connection
	 */
	String RECEPTION = "r�ception";
	/**
	 * Message "d�connexion" envoy� par la classe Connection
	 */
	String DECONNEXION = "d�connexion";
	/**
	 * Message "pseudo" envoy� pour la cr�ation d'un joueur
	 */
	String PSEUDO = "pseudo";
	/**
	 * vie de d�part pour tous les joueurs
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
	 * nombre de murs dans l'ar�ne
	 */
	int NBMURS = 20;
	/**
	 * hauteur de la zone de jeu de l'ar�ne
	 */
	int HAUTEURARENE = 600;
	/**
	 * largeur de la zone de heu de l'ar�ne
	 */
	int LARGEURARENE = 800;
	/**
	 * hauteur d'un mur
	 */
	int HAUTEURMUR = 35;
	/**
	 * largeur d'un mur
	 */
	int LARGEURMUR = 34;
	/**
	 * Largeur d'un perso
	 */
	int LARGEURPERSO = 39;
	/**
	 * Hauteur d'un perso
	 */
	int HAUTEURPERSO = 44;
	/**
	 * Hauteur d'un message
	 */
	int HAUTEURMESSAGE = 8;
	/**
	 * Orientation du perso a droite
	 */
	int DROITE = 1;
	/**
	 * Orientation du perso a gauche
	 */
	int GAUCHE = 0;
	
	int HAUT = 2;
	
	int BAS = 3;
	/**
	 * Message "serveur" pour la cr�ation d'un serveur
	 */
	String SERVEUR = "serveur";
	/**
	 * ordre pour ajouter un mur dans l'ar�ne du serveur
	 */
	String AJOUTMUR = "ajout mur";
	/**
	 * ordre pour ajouter le panel des murs dans l'ar�ne du client
	 */
	String AJOUTPANELMURS = "ajout panel murs";
	/**
	 * Ordre pour ajouter le panel dans l'arene
	 */
	String AJOUTLABELJEU = "ajout label jeu";
	/**
	 * Ordre pour modif le panel du jeu dans l'arène du client
	 */
	String MODIFPANELJEU = "modif panel jeu";
	
	String TCHAT = "tchat";
	/**
	 * Ordre pour ajouter une phrase dans le chat
	 */
	String AJOUTPHRASE = "ajout phrase";
	/**
	 * Ordre pour modifier le chat côté client
	 */
	String MODIFTCHAT = "modif chat";
	
	String CLIENT = "client";
	
	String ACTION = "action";
	/**
	 * Valeur d'un pas
	 */
	int PAS = 10;
	
	int NBETAPESMARCHE = 4;
	
	int NBETAPESTOUCHE = 2;
	
	int NBETAPESMORT = 2;
	
	int LARGEURBOULE = 17;
			
	int HAUTEURBOULE = 17;
	
	String PLAYSON = "play son";
	
	String FINJEU = "fin jeu";
}
