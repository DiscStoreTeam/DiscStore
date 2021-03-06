package interfaces.gui.sales;

import logic.business.abstractions.Disc;
import logic.business.auxiliars.SCManager;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logic.business.controllers.SalesController;
import logic.business.core.Store;
import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class ShoppingCarGUI extends JFrame {

	private JPanel contentPane;
	private JTable tableShoppingcar;
	private JPanel panel;
	private JLabel lblListaDeProductos;
	private JButton btnRefresh;
	private JButton btnShow;
	private JButton btnDel;
	private JScrollPane scrollPane;
	private JButton btnBack;
	private JButton btnSell;

	private SCManager scManager;
	private SalesController controller;


	//TableModel
	String columnas[]={"Nombre","ID","Tipo","Costo"};
	boolean columnasEditables[]={false,false,false,false};
	@SuppressWarnings("rawtypes")
	Class data[]={java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class};

	DefaultTableModel model = new DefaultTableModel(){
		public boolean isCellEditable(int row, int col){
			return columnasEditables[col];
		}
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public Class getColumnClass(int index){
			return data[index];
		}
	};
	private JLabel lblNewLabel;
	private JLabel lblCost;

	/**
	 * Create the frame.
	 */
	public ShoppingCarGUI(Store store) {
		drawWindow();
		this.controller=store.getSalesController();
		this.scManager=controller.getSCManager();
		refreshShopingCar();

	}


	public void drawWindow(){
		setTitle("Carrito");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 716, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[400:n:400][50:n:50][351.00][]", "[35:n:35][35px:n:35px][35:n:35][610.00][638.00px][638.00px][638.00px][638.00px][327px]"));
		setLocationRelativeTo(null);

		panel = new JPanel();
		contentPane.add(panel, "cell 0 0 3 9,grow");
		panel.setLayout(new MigLayout("", "[230:n:230,grow][100:n:100][140:n:140][80:n:80]", "[][][grow]"));

		lblListaDeProductos = new JLabel("Lista de Productos");
		panel.add(lblListaDeProductos, "flowx,cell 0 0");

		btnRefresh = new JButton("Refrescar");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshShopingCar();
			}
		});
		panel.add(btnRefresh, "cell 1 0,alignx right");

		btnShow = new JButton("Ver Contenido");
		panel.add(btnShow, "cell 2 0,alignx center");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showContents();
			}
		});

		btnDel = new JButton("Borrar");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteItem();
			}
		});
		panel.add(btnDel, "cell 3 0,alignx right");

		scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 0 1 4 2,grow");

		tableShoppingcar = new JTable();
		tableShoppingcar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2){
					showContents();
				}
			}

		});
		scrollPane.setViewportView(tableShoppingcar);
		model.setColumnIdentifiers(columnas);
		tableShoppingcar.setModel(model);

		btnBack = new JButton("Atr\u00E1s");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeWindown();
			}
		});
		contentPane.add(btnBack, "cell 3 0,alignx right");

		lblNewLabel = new JLabel("Costo Total");
		contentPane.add(lblNewLabel, "cell 3 6,aligny bottom");

		lblCost = new JLabel("");
		contentPane.add(lblCost, "cell 3 7,alignx center,aligny center");

		btnSell = new JButton("Vender");
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(model.getRowCount()>0){
				sell();
				}
				else{
					JOptionPane.showMessageDialog(null, "Debe agregar productos al carrito poder llevar a cabo la venta");
					}
			}
		});
		contentPane.add(btnSell, "cell 3 8");
	}

	//methods

	public void refreshShopingCar(){
		cleanTable();
		for (Disc disc : scManager.getDiscs()) {
			System.out.println("Size :  " + scManager.getDiscs().size());
			Object row[] = {disc.getName(), disc.getID(),disc.getType(),disc.calculateCost()+"$"};
			model.addRow(row);
		}
		lblCost.setText(Double.toString(showTotalCost())+"$");

	}
	public void cleanTable(){	
		int centinel = model.getRowCount();
		for(int i=0; i<centinel; i++){
			model.removeRow(0);
		}
	}

	public void showContents() {
		if(tableShoppingcar.getSelectedRow() != -1){
			int pos = tableShoppingcar.getSelectedRow();
			String text = scManager.getDiscs().get(pos).getStringContent();
			JOptionPane.showMessageDialog(null, text);
		}else{
			JOptionPane.showMessageDialog(null, "Seleccione un producto para ver su contenido");
		}
	}

	public void deleteItem(){
		if(model.getRowCount()>0){
			if(tableShoppingcar.getSelectedRow() >= 0 && tableShoppingcar.getSelectedRow() < model.getRowCount()){
				int auxiliar = tableShoppingcar.getSelectedRow();
				scManager.removeItem(auxiliar);
				refreshShopingCar();
			}
			else{
				JOptionPane.showMessageDialog(null, "Debe seleccionar un elemento para elmininar");
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "Debe agregar al menos un elemento para poder eliminar");
		}
	}

	public double showTotalCost(){
		return scManager.calculateCost();
	}

	public void closeWindown(){
		dispose();
	}
	public void sell(){
		if((JOptionPane.showConfirmDialog(null, "Seguro que desea realizar la compra por un costo de: " + scManager.getTotalCost()+"$")) == 0){
			controller.sell();
			refreshShopingCar();
		}
	}



}

