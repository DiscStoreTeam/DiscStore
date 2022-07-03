package interfaces.gui.workers;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.business.controllers.HRController;
import logic.business.core.Store;
import net.miginfocom.swing.MigLayout;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import logic.util.PositionValue;
import logic.util.PublicScholarDegree;
import logic.util.Validator;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class HireWorker extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private HRController controller;
	private JTextField textFieldName;
	private JTextField textFieldLastName;
	private JTextField textFieldCI;
	JComboBox<PublicScholarDegree> comboBox;
	private JLabel lblError;

	public HireWorker(Store store) {
		setTitle("Contratar Nuevo Trabajador");
		this.controller = store.getHumanResourcesController();
		drawWindow();
	}
	
	private void drawWindow(){
		setBounds(100, 100, 450, 269);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[grow]", "[grow]"));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Informaci\u00F3n Personal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, "cell 0 0,grow");
			panel.setLayout(new MigLayout("", "[][grow]", "[][][][][35.00]"));
			{
				JLabel lblNombre = new JLabel("Nombre : ");
				panel.add(lblNombre, "cell 0 0,alignx trailing");
			}
			{
				textFieldName = new JTextField();
				panel.add(textFieldName, "cell 1 0,growx");
				textFieldName.setColumns(10);
			}
			{
				JLabel lblApellidos = new JLabel("Apellidos : ");
				panel.add(lblApellidos, "cell 0 1,alignx trailing");
			}
			{
				textFieldLastName = new JTextField();
				panel.add(textFieldLastName, "cell 1 1,growx");
				textFieldLastName.setColumns(10);
			}
			{
				JLabel lblCi = new JLabel("CI : ");
				panel.add(lblCi, "cell 0 2,alignx trailing");
			}
			{
				textFieldCI = new JTextField();
				panel.add(textFieldCI, "cell 1 2,growx");
				textFieldCI.setColumns(10);
			}
			{
				JLabel lblGradoEscolar = new JLabel("Grado Escolar : ");
				panel.add(lblGradoEscolar, "cell 0 3,alignx trailing");
			}
			{
				comboBox = new JComboBox<PublicScholarDegree>();
				comboBox.setModel(new DefaultComboBoxModel<PublicScholarDegree>(PublicScholarDegree.values()));
				panel.add(comboBox, "cell 1 3,growx");
			}
			{
				lblError = new JLabel("Error");
				lblError.setForeground(Color.RED);
				panel.add(lblError, "cell 0 4 2 1,alignx center,aligny center");
				lblError.setVisible(false);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Contratar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						okButton();
					}
				});
				{
					JButton button = new JButton(" ? ");
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							helpMessage();
						}
					});
					buttonPane.add(button);
				}
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		setLocationRelativeTo(null);
	}
	
	/**
	 * 
	 */
	private void okButton(){
		if(validateFields()){
			controller.hireWorker(textFieldName.getText(), textFieldLastName.getText(), textFieldCI.getText(), PositionValue.dependent, (PublicScholarDegree)comboBox.getSelectedItem());
			JOptionPane.showMessageDialog(null, "Credenciales Temporales:\nNombre de Usuario : " + textFieldName.getText() + "\nContraseña : " + textFieldCI.getText(), "Trabajador Contratado Exitosamente", 1);
			dispose();
		}
	}
	
	private void helpMessage(){
		JOptionPane.showMessageDialog(null, "Credenciales Temporales:\nNombre de Usuario : Nombre del Trabajador\nContraseña : Carnet de Identidad");
	}
	
	private boolean validateFields(){
		boolean valid = true;
		if(Validator.emptyString(textFieldName.getText())){
			lblError.setText("Existen campos vacíos");
			lblError.setVisible(true);
			valid = false;
		}
		else{
			if(Validator.emptyString(textFieldLastName.getText())){
				lblError.setText("Existen campos vacíos");
				lblError.setVisible(true);
				valid = false;
			}
			else{
				if(Validator.emptyString(textFieldCI.getText())){
					lblError.setText("Existen campos vacíos");
					lblError.setVisible(true);
					valid = false;
				}
				else{
					if(!Validator.ci(textFieldCI.getText())){
						lblError.setText("El carnet de indentidad es incorrecto");
						lblError.setVisible(true);
						valid = false;
					}
					else{
						lblError.setVisible(false);
					}
				}
			}
		}
		return valid;
	}

}
