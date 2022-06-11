package interfaces.gui.access;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Application;
import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JTable;

import logic.business.auxiliars.SearchManager;
import logic.business.controllers.SalesController;
import logic.business.core.Product;

@SuppressWarnings("serial")
public class Sales extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSearch;
	private JTable tableSearch;
	private JTable table;

	private SalesController controller;


	/**
	 * Launch the application.
	 */
	/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sales frame = new Sales();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Sales(SalesController controller) {		
		drawWindow();
		this.controller = controller;

	}
	private void drawWindow(){
		setTitle("Ventana De Venta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 678);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[15.00][53.00][496.00][158.00][162.00,grow]", "[][][36.00][86.00][377.00][grow]"));
		setLocationRelativeTo(null);
		JLabel lblNewLabel = new JLabel("Gesti\u00F3n de Venta");
		contentPane.add(lblNewLabel, "cell 1 0");
		
		JButton btnBack = new JButton("Volver");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				goMain();
			}
		});
		contentPane.add(btnBack, "cell 4 0,alignx right");

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, "cell 1 1 2 5,grow");

		JPanel panelCD = new JPanel();
		tabbedPane.addTab("Venta CD", null, panelCD, null);
		panelCD.setLayout(new MigLayout("", "[7.00][109.00,grow][251.00][grow]", "[30.00][][9.00][418.00,grow][19.00]"));

		JLabel lblIntroduzcaSuCriterioCD = new JLabel("Introduzca su criterio de busqueda");
		panelCD.add(lblIntroduzcaSuCriterioCD, "cell 1 0");

		textFieldSearch = new JTextField();
		panelCD.add(textFieldSearch, "cell 1 1 2 1,growx");
		textFieldSearch.setColumns(10);

		JButton btnSearchCD = new JButton("Buscar");
		panelCD.add(btnSearchCD, "cell 3 1");

		tableSearch = new JTable();
		panelCD.add(tableSearch, "cell 1 3 3 1,grow");
		
		JButton btnCleanListCD = new JButton("Limpiar Lista");
		panelCD.add(btnCleanListCD, "cell 1 4");

		JButton buttonAddCD = new JButton("A\u00F1adir");
		panelCD.add(buttonAddCD, "cell 2 4 2 1,alignx right");




		JPanel panelDVD = new JPanel();
		tabbedPane.addTab("Venta DVD", null, panelDVD, null);
		panelDVD.setLayout(new MigLayout("", "[7.00][109.00,grow][251.00][grow]", "[30.00][][9.00][418.00,grow][]"));

		JLabel lblIntroduzcaSuCriterioDVD = new JLabel("Introduzca su criterio de busqueda");
		panelDVD.add(lblIntroduzcaSuCriterioDVD, "cell 1 0");

		textFieldSearch = new JTextField();
		panelDVD.add(textFieldSearch, "cell 1 1 2 1,growx");
		textFieldSearch.setColumns(10);

		JButton btnSearchDVD = new JButton("Buscar");
		panelDVD.add(btnSearchDVD, "cell 3 1");

		tableSearch = new JTable();
		panelDVD.add(tableSearch, "cell 1 3 3 1,grow");
		
		JButton btnCleanListDVD = new JButton("Limpiar Lista");
		panelDVD.add(btnCleanListDVD, "cell 1 4");

		JButton buttonAddDVD = new JButton("A\u00F1adir");
		panelDVD.add(buttonAddDVD, "cell 2 4 2 1,alignx right");




		JPanel panelShoppingcar = new JPanel();
		tabbedPane.addTab("Carrito", null, panelShoppingcar, null);
		
				JLabel lblFicherosAadidos = new JLabel("Productos agregados");
				contentPane.add(lblFicherosAadidos, "cell 3 2 2 1,alignx center");

		table = new JTable();
		contentPane.add(table, "cell 3 3 2 2,grow");

		JButton buttonMoveSC = new JButton("Enviar Al Carrito");
		buttonMoveSC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		JButton buttonDel = new JButton("Eliminar");
		contentPane.add(buttonDel, "cell 3 5,aligny top");
		contentPane.add(buttonMoveSC, "cell 4 5,alignx right,aligny top");	
	}
	//methods
	public void goMain(){
		Application.changeWindow(this, Application.WindowType.main);
	}
	
	
	
}
