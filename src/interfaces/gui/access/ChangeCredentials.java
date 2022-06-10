package interfaces.gui.access;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Application;
import main.Application.WindowType;
import net.miginfocom.swing.MigLayout;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import logic.business.controllers.AccessController;
import logic.util.Validator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class ChangeCredentials extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JTextField textFieldUsername;
	private JPasswordField textFieldPassword;
	private JPasswordField textFieldPasswordConfirm;
	JLabel lblError;

	private AccessController controller;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
			ChangeCredentials dialog = new ChangeCredentials();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	/**
	 * Create the dialog.
	 */
	public ChangeCredentials(AccessController controller) {
		this.controller = controller;
		drawWindow();
	}

	private void drawWindow(){
		setTitle("Cambiar Credenciales");
		setBounds(100, 100, 450, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[10px,grow]", "[10px,grow]"));
		setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Nuevas Credenciales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.add(panel, "cell 0 0,grow");
		panel.setLayout(new MigLayout("", "[][grow]", "[][][][grow]"));

		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario : ");
		panel.add(lblNombreDeUsuario, "cell 0 0,alignx trailing");

		textFieldUsername = new JTextField();
		panel.add(textFieldUsername, "cell 1 0,growx");
		textFieldUsername.setColumns(10);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a : ");
		panel.add(lblContrasea, "cell 0 1,alignx trailing");

		textFieldPassword = new JPasswordField();
		panel.add(textFieldPassword, "cell 1 1,growx");

		JLabel lblConfirmarContrasea = new JLabel("Confirmar Contrase\u00F1a : ");
		panel.add(lblConfirmarContrasea, "cell 0 2,alignx trailing");

		textFieldPasswordConfirm = new JPasswordField();
		panel.add(textFieldPasswordConfirm, "cell 1 2,growx");
		
		lblError = new JLabel("New label");
		lblError.setForeground(Color.RED);
		panel.add(lblError, "cell 0 3 2 1,alignx center");
		lblError.setVisible(false);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				okButton();
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelButton();
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	}
	
	@SuppressWarnings("deprecation")
	private void okButton(){
		if(validateFields()){
			controller.updateCredentials(textFieldUsername.getText(), textFieldPassword.getText());
			Application.changeWindow(this, WindowType.main);
		}
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
			else{
				if(Validator.emptyString(textFieldPasswordConfirm.getText())){
					valid = false;
				}
			}
		}
		if(valid){
			if(controller.compareUsername(textFieldUsername.getText())){
				lblError.setText("El nombre de Usuario ya existe");
				lblError.setVisible(true);
				valid = false;
			}
			else{
				if(!textFieldPassword.getText().equals(textFieldPasswordConfirm.getText())){
					lblError.setText("Las contraseñas no coinciden, revise los datos introducidos");
					lblError.setVisible(true);
				}
				else{
					lblError.setVisible(false);
				}
			}
		}
		else{
			lblError.setText("Existen campos vacíos");
			lblError.setVisible(true);
		}
		return valid;
	}
	
	private void cancelButton(){
		if(controller.fistLogin()){
			JOptionPane.showMessageDialog(null, "Usted debe cambiar sus Credenciales de Acceso   \npor defecto antes de iniciar sesión por primera vez", "Acción Obligatoria", 1);
		}
		else{
			dispose();
		}
	}
}
