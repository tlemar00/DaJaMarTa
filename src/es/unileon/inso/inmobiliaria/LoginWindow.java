package es.unileon.inso.inmobiliaria;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class LoginWindow {
	ImageIcon imagen;
	String nombre;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Demo application");
		frame.setSize(1022, 594);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponents(panel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\git\\DaJaMarTa\\img\\logo.PNG"));
		lblNewLabel.setBounds(546, 92, 212, 277);
		panel.add(lblNewLabel);

		frame.setVisible(true);
	}
	
	public void paint() {
		imagen=new ImageIcon(getClass().getResource(""));
		
	}

	private static void placeComponents(JPanel panel) {

		panel.setLayout(null);

		JLabel userLabel = new JLabel("Usuario");
		userLabel.setBounds(70, 62, 80, 25);
		panel.add(userLabel);

		JTextField userText = new JTextField(20);
		userText.setBounds(277, 62, 160, 25);
		panel.add(userText);

		JLabel passwordLabel = new JLabel("Contrase\u00F1a");
		passwordLabel.setBounds(70, 178, 80, 25);
		panel.add(passwordLabel);

		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(277, 178, 160, 25);
		panel.add(passwordText);

		JButton loginButton = new JButton("Login");
		loginButton.setBounds(90, 268, 86, 50);
		panel.add(loginButton);
		
		JButton registerButton = new JButton("Registro");
		registerButton.setBounds(277, 268, 93, 50);
		panel.add(registerButton);
	}
}