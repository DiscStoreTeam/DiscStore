package interfaces.gui.access;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JPasswordField textFieldPassword;
	private JButton btnIniciarSesin;
	private JLabel lblError;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		drawWindow();
		initializeComponents();
	}
	
	private void drawWindow(){
		setTitle("Inicio de Sesi\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 201);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow]", "[23.00][][][][]"));
		
		setLocationRelativeTo(null);
		
		JLabel lblCredencialesDeAcceso = new JLabel("Credenciales de Acceso");
		contentPane.add(lblCredencialesDeAcceso, "cell 0 0 2 1,alignx center,aligny center");
		JLabel lblUsername = new JLabel("Nombre de Usuario : ");
		contentPane.add(lblUsername, "cell 0 1,alignx trailing");
		JLabel lblContrasea = new JLabel("Contrase\u00F1a : ");
		contentPane.add(lblContrasea, "cell 0 2,alignx trailing");
	}
	
	private void initializeComponents(){
		textFieldUsername = new JTextField();
		contentPane.add(textFieldUsername, "cell 1 1,growx");
		textFieldUsername.setColumns(10);
		
		textFieldPassword = new JPasswordField();
		contentPane.add(textFieldPassword, "cell 1 2,growx");
		
		lblError = new JLabel("Error Message");
		lblError.setForeground(Color.RED);
		contentPane.add(lblError, "cell 1 3");
		lblError.setVisible(false);		
		
		btnIniciarSesin = new JButton("Iniciar Sesi\u00F3n");
		contentPane.add(btnIniciarSesin, "cell 0 4 2 1,alignx center,aligny center");
	}

}
