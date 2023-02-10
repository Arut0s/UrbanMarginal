package vue;
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

public class ChoixJoueur extends JFrame {

	/**
	 * Méthodes évenementielles
	 */
	
	private void lblFlechePrecedent_clic() {
		System.out.println("Clic sur précédent");
	}
	
	private void lblFlecheSuivant_clic() {
		System.out.println("Clic sur Suivant");
	}
	
	private void lblGo_clic() {
		(new Arene()).setVisible(true);
		this.dispose();
	}
	
	private JPanel contentPane;
	private JTextField txtPseudo;

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
		});
		lblFlechePrecedent.setBounds(61, 146, 45, 43);
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
