package interfaces.gui.main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.business.controllers.HRController;
import logic.business.core.Store;
import net.miginfocom.swing.MigLayout;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Choice;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ChangeManager extends JDialog {

	private final JPanel contentPanel = new JPanel();
	Choice choiceWorker;

	private HRController controller;
	
	public ChangeManager(Store store) {
		setTitle("Cambiar Administrador");
		this.controller = store.getHumanResourcesController();
		drawWindow();
	}
	
	private void drawWindow(){
		setBounds(100, 100, 450, 239);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[grow]", "[54.00][]"));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Actual Administrador", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, "cell 0 0,grow");
			panel.setLayout(new MigLayout("", "[][grow][][][][][][][][]", "[][][]"));
			{
				JLabel lblNombre = new JLabel("Nombre y Apellidos : ");
				panel.add(lblNombre, "cell 0 0");
			}
			{
				JLabel lblNewLabel = new JLabel(controller.getManager().getName() + " " + controller.getManager().getLastName());
				panel.add(lblNewLabel, "cell 1 0 6 1");
			}
			{
				JLabel lblId = new JLabel("ID : ");
				panel.add(lblId, "cell 8 0");
			}
			{
				JLabel lblNewLabel_2 = new JLabel(controller.getManager().getWorkerID().toString());
				panel.add(lblNewLabel_2, "cell 9 0");
			}
			{
				JLabel lblCi = new JLabel("CI : ");
				panel.add(lblCi, "cell 0 1");
			}
			{
				JLabel lblNewLabel_1 = new JLabel(controller.getManager().getCi());
				panel.add(lblNewLabel_1, "cell 1 1 6 1");
			}
			{
				JLabel lblFechaDeInicio = new JLabel("Fecha de Inicio : ");
				panel.add(lblFechaDeInicio, "cell 0 2");
			}
			{
				JLabel lblDate = new JLabel(controller.getDate());
				panel.add(lblDate, "cell 1 2");
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Nuevo Administrador", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, "cell 0 1,grow");
			panel.setLayout(new MigLayout("", "[grow]", "[]"));
			{
				choiceWorker = new Choice();
				panel.add(choiceWorker, "cell 0 0,grow");
				ArrayList<String> workers = controller.getWorkers();
				for(int i = 1; i < workers.size(); i++){
					choiceWorker.add(workers.get(i));
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Cambiar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						changeButton();
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
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		setLocationRelativeTo(null);
	}
	
	private void changeButton(){
		controller.changeManager(choiceWorker.getSelectedIndex() + 1);
		JOptionPane.showMessageDialog(null, "Administrador Cambiado Exitosamente");
		dispose();
	}

}
