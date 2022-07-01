package interfaces.gui.database;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.business.auxiliars.SearchManager;
import logic.business.controllers.DBController;
import logic.business.core.Product;
import logic.business.core.Song;
import logic.business.core.Store;
import logic.util.ProductType;
import net.miginfocom.swing.MigLayout;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class DeleteProduct extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private DBController controller;
	private JTextField textFieldSearch;
	private JTable table;
	private DefaultTableModel model;
	private JLabel error;
	
	public DeleteProduct(Store store) {
		setTitle("Eliminar Productos");
		this.controller = store.getDatabaseController();
		drawWindow();
	}
	
	public void drawWindow(){
		setBounds(100, 100, 580, 470);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[grow]", "[][149.00,grow][30.00]"));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Buscador", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, "cell 0 0,grow");
			panel.setLayout(new MigLayout("", "[grow][]", "[]"));
			{
				textFieldSearch = new JTextField();
				panel.add(textFieldSearch, "cell 0 0,growx");
				textFieldSearch.setColumns(10);
			}
			{
				JButton btnBuscar = new JButton("Buscar");
				btnBuscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						search();
					}
				});
				panel.add(btnBuscar, "cell 1 0");
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Resultados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, "cell 0 1,grow");
			panel.setLayout(new MigLayout("", "[grow]", "[grow]"));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, "cell 0 0,grow");
				{
					String columns[] = {"Título", "Género", "Intérprete", "ID", "Tipo",""};
					final boolean editable[] = {false, false, false, false, false, true};
					final Class data[] = {java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class};
					model = new DefaultTableModel(){
						public boolean isCellEditable(int row, int col){
							return editable[col];
						}
						public Class getColumnClass(int index){
							return data[index];
						}
					};
					
					table = new JTable();
					scrollPane.setViewportView(table);
					model.setColumnIdentifiers(columns);
					table.setModel(model);
					table.getColumnModel().getColumn(0).setPreferredWidth(160);
					table.getColumnModel().getColumn(1).setPreferredWidth(160);
					table.getColumnModel().getColumn(2).setPreferredWidth(160);
					table.getColumnModel().getColumn(3).setPreferredWidth(100);
					table.getColumnModel().getColumn(4).setPreferredWidth(60);
					table.getColumnModel().getColumn(0).setResizable(false);
					table.getColumnModel().getColumn(1).setResizable(false);
					table.getColumnModel().getColumn(2).setResizable(false);
					table.getColumnModel().getColumn(3).setResizable(false);
					table.getColumnModel().getColumn(4).setResizable(false);
				}
			}
		}
		{
			error = new JLabel("Error");
			error.setForeground(Color.RED);
			contentPanel.add(error, "cell 0 2,alignx center,aligny center");
			error.setVisible(false);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Eliminar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						deleteButton();
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
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
	
	private void updateTable(){
		cleanTable();
		SearchManager<Product> searcher = new SearchManager<Product>();
		ArrayList<Product> database = controller.getProducts();
		ArrayList<Product> products = searcher.search(textFieldSearch.getText(), database);
		if(database.size() == 0){
			System.out.println("Empty");
		}
		for(Product product : products){
			System.out.println(product.getTitle());
			Object rowns[] = {product.getTitle(), product.getGenre(), product.getInterpreter(), product.getID(), (product instanceof Song) ? "Canción": "Vídeo", false};
			model.addRow(rowns);
		}
	}
	
	private void cleanTable(){
		int centinel = model.getRowCount();
		for(int i=0; i<centinel; i++){
			model.removeRow(0);
		}
	}
	
	private void deleteButton(){
		boolean selected = false;
		for(int i = 0; i < model.getRowCount(); i++){
			if((boolean)model.getValueAt(i, 5)){
				selected = true;
				error.setVisible(false);
				Integer id = (Integer)model.getValueAt(i, 3);
				controller.removeItem(id.intValue(), (model.getValueAt(1, 4) == "Canción" ? ProductType.song : ProductType.video));
			}
		}
		if(!selected){
			error.setVisible(true);
			error.setText("Debe seleccionar al menos 1 elemento");
		}
		updateTable();
	}

}
