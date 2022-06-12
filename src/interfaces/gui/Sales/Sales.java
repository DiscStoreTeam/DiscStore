package interfaces.gui.Sales;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import main.Application;
import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JTable;









import logic.business.auxiliars.SearchManager;
import logic.business.controllers.SalesController;
import logic.business.core.Product;
import logic.business.core.Song;
import logic.business.core.Video;

import javax.swing.JScrollPane;


@SuppressWarnings("serial")
public class Sales extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panelCD;
	private JPanel panelDVD;
	private JPanel panelShoppingcar;
	private JButton btnSearchCD;
	private JButton btnSearchDVD;
	private JLabel lblIntroduzcaSuCriterioCD;
	private JLabel lblIntroduzcaSuCriterioDVD;
	private JButton buttonAddCD;
	private JButton buttonAddDVD;
	private JTextField textFieldSearchDVD;
	private JTextField textFieldSearchCD;
	private JButton btnCleanListCD;
	private JButton btnCleanListDVD;
	private JButton buttonMoveSC;
	private JButton buttonDel;
	private JTable table;
	private JLabel lblWarning;
	private	JButton btnBack;

	private SalesController controller;
	private JScrollPane scrollPaneDVD;
	private JScrollPane scrollPaneCD;
	private JTable tableCD;	
	private JTable tableDVD;
	private DefaultTableModel model;




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

		//tablas
		model = (new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Nombre", "\u00C1lbum", "Artista", " "
				}
				) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		//

		btnBack = new JButton("Volver");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				goMain();
			}
		});

		lblWarning = new JLabel("Warning");
		contentPane.add(lblWarning, "cell 2 0,alignx right");
		contentPane.add(btnBack, "cell 4 0,alignx right");
		lblWarning.setVisible(false);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, "cell 1 1 2 5,grow");

		panelCD = new JPanel();
		tabbedPane.addTab("Venta CD", null, panelCD, null);
		panelCD.setLayout(new MigLayout("", "[7.00][109.00,grow][251.00][grow][]", "[30.00][36.00][9.00][418.00,grow][19.00]"));

		lblIntroduzcaSuCriterioCD = new JLabel("Introduzca su criterio de busqueda");
		panelCD.add(lblIntroduzcaSuCriterioCD, "cell 1 0");

		textFieldSearchCD = new JTextField();
		panelCD.add(textFieldSearchCD, "cell 1 1 2 1,growx");
		textFieldSearchCD.setColumns(10);

		btnSearchCD = new JButton("Buscar");
		btnSearchCD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addToSearchList();
			}
		});
		panelCD.add(btnSearchCD, "cell 3 1");

		scrollPaneCD = new JScrollPane();
		panelCD.add(scrollPaneCD, "cell 1 3 3 1,grow");

		tableCD = new JTable();

		tableCD.setModel(model);
		tableCD.getColumnModel().getColumn(0).setPreferredWidth(160);
		tableCD.getColumnModel().getColumn(1).setPreferredWidth(160);
		tableCD.getColumnModel().getColumn(2).setPreferredWidth(160);
		tableCD.getColumnModel().getColumn(3).setPreferredWidth(20);
		tableCD.getColumnModel().getColumn(0).setResizable(false);
		tableCD.getColumnModel().getColumn(1).setResizable(false);
		tableCD.getColumnModel().getColumn(2).setResizable(false);
		tableCD.getColumnModel().getColumn(3).setResizable(false);



		scrollPaneCD.setViewportView(tableCD);


		btnCleanListCD = new JButton("Limpiar Lista");
		panelCD.add(btnCleanListCD, "cell 1 4");

		buttonAddCD = new JButton("A\u00F1adir");
		panelCD.add(buttonAddCD, "cell 2 4 2 1,alignx right");




		panelDVD = new JPanel();
		tabbedPane.addTab("Venta DVD", null, panelDVD, null);
		panelDVD.setLayout(new MigLayout("", "[7.00][109.00,grow][251.00][grow]", "[30.00][][9.00][418.00,grow][]"));

		lblIntroduzcaSuCriterioDVD = new JLabel("Introduzca su criterio de busqueda");
		panelDVD.add(lblIntroduzcaSuCriterioDVD, "cell 1 0");

		textFieldSearchDVD = new JTextField();
		panelDVD.add(textFieldSearchDVD, "cell 1 1 2 1,growx");
		textFieldSearchDVD.setColumns(10);

		btnSearchDVD = new JButton("Buscar");
		panelDVD.add(btnSearchDVD, "cell 3 1");

		scrollPaneDVD = new JScrollPane();
		panelDVD.add(scrollPaneDVD, "cell 1 3 3 1,grow");

		tableDVD = new JTable();
		scrollPaneDVD.setViewportView(tableDVD);

		btnCleanListDVD = new JButton("Limpiar Lista");
		panelDVD.add(btnCleanListDVD, "cell 1 4");

		buttonAddDVD = new JButton("A\u00F1adir");
		panelDVD.add(buttonAddDVD, "cell 2 4 2 1,alignx right");




		panelShoppingcar = new JPanel();
		tabbedPane.addTab("Carrito", null, panelShoppingcar, null);

		JLabel lblProducts = new JLabel("Productos agregados");
		contentPane.add(lblProducts, "cell 3 2 2 1,alignx center");

		table = new JTable();
		contentPane.add(table, "cell 3 3 2 2,grow");

		buttonMoveSC = new JButton("Enviar Al Carrito");
		buttonMoveSC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		buttonDel = new JButton("Eliminar");
		contentPane.add(buttonDel, "cell 3 5,aligny top");
		contentPane.add(buttonMoveSC, "cell 4 5,alignx right,aligny top");	
	}
	//methods
	public void goMain(){
		Application.changeWindow(this, Application.WindowType.main);
	}



	//de aqui pa abajoo

	/*public ArrayList<Song> searchSongs(){
		return controller.getCDManager().getSearch().search(textFieldSearchDVD.getText(), controller.getSongsList());
	}
	public ArrayList<Video> searchVideos(){
		return controller.getDVDManager().getSearch().search(textFieldSearchDVD.getText(), controller.getVideoList());
	}*/
	
	public ArrayList<Song> searchSongs(){
		ArrayList<Song> auxiliar = new ArrayList<Song>();
		ArrayList<Song> songslist = controller.getSongsList();
		for (Song song : songslist) {
			if(textFieldSearchCD.getText().equalsIgnoreCase(song.getTitle()) || textFieldSearchCD.getText().equalsIgnoreCase(song.getAlbum()) || textFieldSearchCD.getText().equalsIgnoreCase(song.getAuthor())){
				auxiliar.add(song);
			}
		}
		return auxiliar;
	}
	
	public void addToSearchList(){
		if(!textFieldSearchCD.getText().equals("")){
			ArrayList<Song> auxiliar = searchSongs();
			
			for (Song song : auxiliar) {
				Object rowns[] = {song.getTitle(), song.getAlbum(), song.getAuthor(), ""};
				model.addRow(rowns);
				
			}

		}	
		else{
			lblWarning.setText("Debe introducir su criterio de búsqueda en la caja de texto");
			lblWarning.setVisible(true);
		}
	}






}
