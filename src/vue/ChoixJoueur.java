package vue;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class ChoixJoueur extends JFrame {

	private JPanel contentPane;
	private JTextField txtPseudo;
	private JLabel lblPersonnage;
	private int numPerso = 1;
	private static final int NBPERSOS = 3;

	/**
	 * Méthodes évenementielles
	 */
	
	private void lblFlechePrecedent_clic() {
		numPerso = ((numPerso+1)%NBPERSOS)+1;
		affichePerso();
	}
	
	private void lblFlecheSuivant_clic() {
		numPerso = (numPerso%NBPERSOS)+1 ;
		affichePerso();
	}
	
	private void lblGo_clic() {
		(new Arene()).setVisible(true);
		this.dispose();
	}
	
	private void affichePerso() {
		this.lblPersonnage.setIcon(new ImageIcon(ChoixJoueur.class.getResource("/personnages/perso"+this.numPerso+"marche1d1.gif")));
	}
	
	private void sourisNormal() {
		contentPane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
	
	private void sourisDoigt() {
		contentPane.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	/**
	 * Create the frame.
	 */
	public ChoixJoueur() {
		
		/**
		 * ContentPane
		 */
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.getContentPane().setPreferredSize(new Dimension(400, 275));
		this.pack();
		this.setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * Affichage personnages
		 */
		
		lblPersonnage = new JLabel("");
		lblPersonnage.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonnage.setBounds(143, 115, 120, 121);
		contentPane.add(lblPersonnage);
		
		/**
		 * Fond du choix du joueur
		 */
		
		JLabel lblChoixJoueur = new JLabel("");
		lblChoixJoueur.setIcon(new ImageIcon(ChoixJoueur.class.getResource("/fonds/fondchoix.jpg")));
		lblChoixJoueur.setBounds(0, 0, 400, 275);
		contentPane.add(lblChoixJoueur);
		
		/**
		 * Label pour flèche précédent
		 */
		
		JLabel lblFlechePrecedent = new JLabel("");
		lblFlechePrecedent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblFlechePrecedent_clic();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				sourisDoigt();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				sourisNormal();
			}
		});
		lblFlechePrecedent.setBounds(67, 146, 39, 43);
		contentPane.add(lblFlechePrecedent);
		
		/**
		 * Label flèche suivant
		 */
		
		JLabel lblFlecheSuivant = new JLabel("");
		lblFlecheSuivant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblFlecheSuivant_clic();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				sourisDoigt();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				sourisNormal();
			}
		});
		lblFlecheSuivant.setBounds(287, 146, 45, 43);
		contentPane.add(lblFlecheSuivant);
		
		/**
		 * Label bouton go
		 */
		
		JLabel lblGo = new JLabel("");
		lblGo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblGo_clic();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				sourisDoigt();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				sourisNormal();
			}
		});
		lblGo.setBounds(311, 199, 61, 66);
		contentPane.add(lblGo);
		
		/**
		 * Zone de saisie du pseudo
		 */
		
		txtPseudo = new JTextField();
		txtPseudo.setBounds(143, 246, 120, 19);
		contentPane.add(txtPseudo);
		txtPseudo.setColumns(10);
		
		
	}
}
