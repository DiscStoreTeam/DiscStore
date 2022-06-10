package interfaces.gui.access;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Application;
import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logic.business.controllers.AccessController;
import logic.util.Validator;

@SuppressWarnings("serial")
public class Login extends JFrame {
	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JPasswordField textFieldPassword;
	private JButton btnIniciarSesin;
	private JLabel lblError;
	
	private AccessController controller;

	/**
	 * Launch the application.
	 */
	/*
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
	 */

	/**
	 * Create the frame.
	 */
	public Login(AccessController controller) {
		this.controller = controller;
		drawWindow();
	}
	
	private void drawWindow(){
		setTitle("Inicio de Sesi\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 201);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow]", "[23.00][][][22.00][grow]"));
		
		setLocationRelativeTo(null);
		
		JLabel lblCredencialesDeAcceso = new JLabel("Credenciales de Acceso");
		contentPane.add(lblCredencialesDeAcceso, "cell 0 0 2 1,alignx center,aligny center");
		JLabel lblUsername = new JLabel("Nombre de Usuario : ");
		contentPane.add(lblUsername, "cell 0 1,alignx trailing");
		JLabel lblContrasea = new JLabel("Contrase\u00F1a : ");
		contentPane.add(lblContrasea, "cell 0 2,alignx trailing");
		
		textFieldUsername = new JTextField();
		contentPane.add(textFieldUsername, "cell 1 1,growx");
		textFieldUsername.setColumns(10);
		
		textFieldPassword = new JPasswordField();
		contentPane.add(textFieldPassword, "cell 1 2,growx");
		
		lblError = new JLabel("Error Message");
		lblError.setForeground(Color.RED);
		contentPane.add(lblError, "cell 0 3 2 1,alignx center,aligny center");
		lblError.setVisible(false);		
		
		btnIniciarSesin = new JButton("Iniciar Sesi\u00F3n");
		btnIniciarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loginButton();
			}
		});
		contentPane.add(btnIniciarSesin, "cell 0 4 2 1,alignx center,aligny bottom");
	}
	
	private void loginButton(){
		if(!validateFields()){
			lblError.setText("Existen Campos Vacíos");
			lblError.setVisible(true);
		}
		else{
			switch (login()) {
			case -1:
				lblError.setText("Contraseña Incorrecta");
				lblError.setVisible(true);
				break;
			case -2:
				lblError.setText("Credenciales Incorrectas");
				lblError.setVisible(true);
				break;
			default:
				lblError.setVisible(false);
				JOptionPane.showMessageDialog(null, "Sesión Iniciada Correctamente");
				nextWindow();
				break;
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	private int login(){
		return controller.login(textFieldUsername.getText(), textFieldPassword.getText());
	}
	
	@SuppressWarnings("deprecation")
	private boolean validateFields(){
		boolean valid = true;
		
		if(Validator.emptyString(textFieldUsername.getText())){
			valid = false;
		}
		else{
			if(Validator.emptyString(textFieldPassword.getText())){
				valid = false;
			}
		}
		
		return valid;
	}
	
	private void nextWindow(){
		if(controller.fistLogin()){
			Application.changeWindow(this, Application.WindowType.credentials);
		}
		else{
			
		}
	}

}
