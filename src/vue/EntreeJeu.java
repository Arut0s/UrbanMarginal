package vue;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class EntreeJeu extends JFrame {

	private JPanel contentPane;
	private JTextField txtIP;

/**
 * Méthodes événementielles
 */
	
	private void btnExit_clic() {
		System.exit(0);
	}
	
	private void btnStart_clic() {
		(new Arene()).setVisible(true);
		this.dispose();
	}
	
	private void btnConnect_clic() {
		(new ChoixJoueur()).setVisible(true);
		this.dispose();
	}
	
	public EntreeJeu() {
		
		/**
		 * ContentPane
		 */
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 203);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * Bouton et label Start
		 */
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnStart_clic();
			}
		});
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnStart.setBounds(230, 8, 97, 29);
		contentPane.add(btnStart);
		
		JLabel lblStart = new JLabel("Start a server : ");
		lblStart.setBounds(10, 18, 112, 20);
		lblStart.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblStart);
		
		/**
		 * Bouton Exit
		 */
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExit_clic();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExit.setBounds(230, 113, 97, 29);
		contentPane.add(btnExit);
		
		/**
		 * Zone de connection
		 */
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConnect_clic();
			}
		});
		btnConnect.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConnect.setBounds(230, 74, 97, 29);
		contentPane.add(btnConnect);
		
		JLabel lblConnectAnExisting = new JLabel("Connect an existing server :");
		lblConnectAnExisting.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConnectAnExisting.setBounds(10, 48, 219, 20);
		contentPane.add(lblConnectAnExisting);
		
		JLabel lblIpServer = new JLabel("IP server:");
		lblIpServer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIpServer.setBounds(10, 78, 69, 20);
		contentPane.add(lblIpServer);
		
		txtIP = new JTextField();
		txtIP.setText("127.0.0.1");
		txtIP.setBounds(85, 81, 129, 19);
		contentPane.add(txtIP);
		txtIP.setColumns(10);
	}
}
