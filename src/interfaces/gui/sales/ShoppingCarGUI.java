package interfaces.gui.sales;

import logic.business.abstractions.Disc;
import logic.business.auxiliars.SCManager;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logic.business.controllers.SalesController;
import logic.business.core.Product;
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
	String columnas[]={"Nombre","ID"};
	boolean columnasEditables[]={false,false};
	@SuppressWarnings("rawtypes")
	Class data[]={java.lang.Object.class,java.lang.Object.class};

	DefaultTableModel model = new DefaultTableModel(){
		public boolean isCellEditable(int row, int col){
			return columnasEditables[col];
		}
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public Class getColumnClass(int index){
			return data[index];
		}
	};

	/**
	 * Create the frame.
	 */
	public ShoppingCarGUI(Store store) {
		drawWindow();
		this.controller=store.getSalesController();
		this.scManager=controller.getSCManager();
	}


	public void drawWindow(){
		setTitle("Carrito");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 716, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[400:n:400][50:n:50][351.00][]", "[35:n:35][35px:n:35px][35:n:35][610.00][638.00px][327px]"));
		setLocationRelativeTo(null);

		panel = new JPanel();
		contentPane.add(panel, "cell 0 0 3 6,grow");
		panel.setLayout(new MigLayout("", "[261.00:n:600,grow][100:n:100][140:n:140][89.00:n:40]", "[][][grow]"));

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

		btnDel = new JButton("-");
		panel.add(btnDel, "cell 3 0,alignx right");

		scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 0 1 4 2,grow");

		tableShoppingcar = new JTable();
		tableShoppingcar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				showContents();
			}
			
		});
		scrollPane.setViewportView(tableShoppingcar);
		model.setColumnIdentifiers(columnas);
		tableShoppingcar.setModel(model);

		btnBack = new JButton("Atr\u00E1s");
		contentPane.add(btnBack, "cell 3 0,alignx right");

		btnSell = new JButton("Vender");
		contentPane.add(btnSell, "cell 3 5");
	}

	//methods

	public void refreshShopingCar(){
		cleanTable();
		for (Disc disc : scManager.getShoppingcar().getDiscs()) {
			Object row[] = {disc.getName(), disc.getID()};
			model.addRow(row);
		}

	}
	public void cleanTable(){
		for(int i=0; i<model.getRowCount(); i++){
			model.removeRow(0);
		}
	}

	public void showContents() {
		if(tableShoppingcar.getSelectedRow() != -1){
			int pos = tableShoppingcar.getSelectedRow();
			String text = "El disco contiene: \n\n" ; int num = 1;
			for(Product product : scManager.getShoppingcar().getDiscs().get(pos).getProducts()){
				text += (num++) + " " +product.getTitle() + " " +product.getInterpreter() + "\n";
			}
			JOptionPane.showMessageDialog(null, text);
		}else{
			JOptionPane.showMessageDialog(null, "Seleccione un producto para ver su contendio");
		}
	}


}
