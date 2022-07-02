package interfaces.gui.main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.business.core.Store;
import logic.util.StoreProperties;
import logic.util.Validator;
import net.miginfocom.swing.MigLayout;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ChangeProperties extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private StoreProperties properties;
	private JTextField textFieldName;
	private JTextField textFieldPhone;
	private JTextField textFieldStreet;
	private JTextField textFieldLatA;
	private JTextField textFieldLatB;
	private JTextField textFieldNumber;
	private JLabel lblError;

	/**
	 * Create the dialog.
	 */
	public ChangeProperties(Store store) {
		setTitle("Cambiar Propiedades de la Tienda");
		properties = store.getProperties();
		drawWindow();
	}
	
	private void drawWindow(){
		setBounds(100, 100, 450, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[grow]", "[27.00][][grow,fill]"));
		setLocationRelativeTo(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Nombre y Tel\u00E9fono", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, "cell 0 0,grow");
			panel.setLayout(new MigLayout("", "[][grow]", "[][]"));
			{
				JLabel lblNombreDeLa = new JLabel("Nombre de la Tienda : ");
				panel.add(lblNombreDeLa, "cell 0 0,alignx trailing");
			}
			{
				textFieldName = new JTextField();
				panel.add(textFieldName, "cell 1 0,growx");
				textFieldName.setColumns(10);
				textFieldName.setText(properties.getName());
			}
			{
				JLabel lblNmeroTelefnico = new JLabel("N\u00FAmero Telef\u00F3nico : ");
				panel.add(lblNmeroTelefnico, "cell 0 1,alignx trailing");
			}
			{
				textFieldPhone = new JTextField();
				panel.add(textFieldPhone, "cell 1 1,growx");
				textFieldPhone.setColumns(10);
				textFieldPhone.setText(properties.getPhoneNumber());
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Direcci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, "cell 0 1,grow");
			panel.setLayout(new MigLayout("", "[][grow]", "[][][][]"));
			{
				JLabel lblCalle = new JLabel("Calle : ");
				panel.add(lblCalle, "cell 0 0,alignx trailing");
			}
			{
				textFieldStreet = new JTextField();
				panel.add(textFieldStreet, "cell 1 0,growx");
				textFieldStreet.setColumns(10);
				textFieldStreet.setText(properties.getAddress().getStreet());
			}
			{
				JLabel lblCalleLateral = new JLabel("Calle Lateral #1 : ");
				panel.add(lblCalleLateral, "cell 0 1,alignx trailing");
			}
			{
				textFieldLatA = new JTextField();
				panel.add(textFieldLatA, "cell 1 1,growx");
				textFieldLatA.setColumns(10);
				textFieldLatA.setText(properties.getAddress().getLatStreetA());
			}
			{
				JLabel lblCalleLateral_1 = new JLabel("Calle Lateral # 2 : ");
				panel.add(lblCalleLateral_1, "cell 0 2,alignx trailing");
			}
			{
				textFieldLatB = new JTextField();
				panel.add(textFieldLatB, "cell 1 2,growx");
				textFieldLatB.setColumns(10);
				textFieldLatB.setText(properties.getAddress().getLatStreetB());
			}
			{
				JLabel lblNmero = new JLabel("N\u00FAmero : ");
				panel.add(lblNmero, "cell 0 3,alignx trailing");
			}
			{
				textFieldNumber = new JTextField();
				panel.add(textFieldNumber, "cell 1 3,growx");
				textFieldNumber.setColumns(10);
				textFieldNumber.setText(properties.getAddress().getNumber());
			}
		}
		{
			lblError = new JLabel("Error");
			lblError.setForeground(Color.RED);
			contentPanel.add(lblError, "cell 0 2,alignx center,aligny center");
			lblError.setVisible(false);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						okButton();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						cancelButton();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void cancelButton(){
		dispose();
	}
	
	private void okButton(){
		if(validateNumbers()){
			properties.setName(textFieldName.getText());
			properties.setPhoneNumber(textFieldPhone.getText());
			properties.getAddress().setStreet(textFieldStreet.getText()).setLatStreetA(textFieldLatA.getText());
			properties.getAddress().setLatStreetB(textFieldLatB.getText()).setNumber(textFieldNumber.getText());
			JOptionPane.showMessageDialog(null, "Propiedades Cambiadas Correctamente");
			dispose();
		}
	}
	
	private boolean validateNumbers(){
		boolean valid = true;
		if(!Validator.phoneNumber(textFieldPhone.getText())){
			lblError.setText("El número de teléfono introducido no es válido");
			valid = false;
			lblError.setVisible(true);
		}
		else if(!Validator.stringNumber(textFieldNumber.getText())){
			lblError.setText("El número introducido en la dirección no es válido");
			valid = false;
			lblError.setVisible(true);
		}
		else{
			lblError.setVisible(false);
		}
		return valid;
	}
}
