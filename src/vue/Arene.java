package vue;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Arene extends JFrame {

	private JPanel contentPane;
	private JTextField textSaisie;
	private final JScrollPane jspChat = new JScrollPane();

	public Arene() {
		
		/**
		 * ContentPane
		 */
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.getContentPane().setPreferredSize(new Dimension(800, 600+25+140));
		this.pack();
		this.setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * Fond de l'arène
		 */
		
		JLabel lblArene = new JLabel("");
		lblArene.setIcon(new ImageIcon(Arene.class.getResource("/fonds/fondarene.jpg")));
		lblArene.setBounds(0, 0, 800, 600);
		contentPane.add(lblArene);
		
		/**
		 * Zone de saisie de texte
		 */
		
		textSaisie = new JTextField();
		textSaisie.setBounds(0, 600, 800, 25);
		contentPane.add(textSaisie);
		textSaisie.setColumns(10);
		
		/**
		 * Zone de défilement de texte
		 */
		
		jspChat.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jspChat.setBounds(0, 625, 800, 140);
		contentPane.add(jspChat);
	}
}
