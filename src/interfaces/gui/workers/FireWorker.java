package interfaces.gui.workers;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import logic.business.controllers.HRController;
import logic.business.core.Store;
import logic.business.core.Worker;
import net.miginfocom.swing.MigLayout;

import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.ScrollPane;

import javax.swing.JTable;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Color;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class FireWorker extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private HRController controller;
	private JTextField textFieldSearch;
	private JLabel error;
	private JTable table;
	private DefaultTableModel model;

	public FireWorker(Store store) {
		setTitle("Despedir Trabajador");
		this.controller = store.getHumanResourcesController();
		drawWindow();
	}
	
	private void drawWindow(){
		setBounds(100, 100, 470, 438);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[412.00px,grow][430px]", "[60px][251px][]"));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Buscador", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, "cell 0 0 2 1,grow");
			panel.setLayout(new MigLayout("", "[grow][]", "[]"));
			{
				textFieldSearch = new JTextField();
				panel.add(textFieldSearch, "cell 0 0,growx");
				textFieldSearch.setColumns(10);
			}
			{
				JButton btnSearch = new JButton("Buscar");
				btnSearch.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						search();
					}
				});
				panel.add(btnSearch, "cell 1 0");
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Resultados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, "cell 0 1 2 1,grow");
			{
				String columns[] = {"Nombre", "Apellidos", "ID", ""};
				final boolean editable[] = {false, false, false, true};
				final Class data[] = {java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class};
				model = new DefaultTableModel(){
					public boolean isCellEditable(int row, int col){
						return editable[col];
					}
					public Class getColumnClass(int index){
						return data[index];
					}
				};
				
				table = new JTable();
				model.setColumnIdentifiers(columns);
				table.setModel(model);
				table.getColumnModel().getColumn(0).setPreferredWidth(160);
				table.getColumnModel().getColumn(1).setPreferredWidth(160);
				table.getColumnModel().getColumn(2).setPreferredWidth(60);
				table.getColumnModel().getColumn(3).setPreferredWidth(60);
				table.getColumnModel().getColumn(0).setResizable(false);
				table.getColumnModel().getColumn(1).setResizable(false);
				table.getColumnModel().getColumn(2).setResizable(false);
				table.getColumnModel().getColumn(3).setResizable(false);
			}
			panel.setLayout(new MigLayout("", "[404px]", "[214px]"));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, "cell 0 0,grow");
				scrollPane.setViewportView(table);
			}
		}
		{
			error = new JLabel("New label");
			error.setForeground(Color.RED);
			contentPanel.add(error, "cell 0 2 2 1,alignx center,growy");
			error.setVisible(false);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnEliminar = new JButton("Eliminar");
				buttonPane.add(btnEliminar);
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						deleteButton();
					}
				});
			}
			{
				JButton cancelButton = new JButton("Volver");
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
	
	private void cleanTable(){
		int centinel = model.getRowCount();
		for(int i=0; i<centinel; i++){
			model.removeRow(0);
		}
	}
	
	private void search(){
		if(!isEmpty()){
			error.setVisible(false);
			updateTable();
		}
		else{
			error.setText("El campo de búsquede no puede estar vacío");
			error.setVisible(true);
		}
	}
	
	private boolean isEmpty(){
		return textFieldSearch.getText().isEmpty();
	}
	
	private void deleteButton(){
		boolean selected = false;
		for(int i = 0; i < model.getRowCount(); i++){
			if((boolean)model.getValueAt(i, 3)){
				selected = true;
				error.setVisible(false);
				Integer id = (Integer)model.getValueAt(i, 2);
				controller.fireWorker(id.intValue());
			}
		}
		if(!selected){
			error.setVisible(true);
			error.setText("Debe seleccionar al menos 1 elemento");
		}
		updateTable();
	}
	
	private void updateTable(){
		cleanTable();
		ArrayList<Worker> workers = controller.findWorkers(textFieldSearch.getText());
		for(Worker worker : workers){
			Object rowns[] = {worker.getName(), worker.getLastName(), worker.getWorkerID(), false};
			model.addRow(rowns);
		}
	}

}
