package interfaces.gui.sales;


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
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JTable;

import logic.business.abstractions.IProduct;
import logic.business.auxiliars.CDManager;
import logic.business.auxiliars.SCManager;
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
	private JLabel lblWarning;
	private	JButton btnBack;

	private JScrollPane scrollPaneDVD;
	private JScrollPane scrollPaneCD;
	private JTable tableCD;	
	private JTable tableDVD;

	private JButton buttonInfo;
	private JScrollPane scrollPaneCont;
	private JTable tableCont;
	private ArrayList<Song>auxSong;
	private ArrayList<Video>auxVideo;
	private ArrayList<Song>auxSCSong;
	private ArrayList<Video>auxSCVideo;

	//test tabla

	String columnas[]={ "Titulo","Album","Artista","ID",""};
	boolean columnasEditables[]={false, false, false, false, true};
	Class data[]={java.lang.Object.class,java.lang.Object.class , java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class };
	DefaultTableModel model = new DefaultTableModel(){
		public boolean isCellEditable(int row, int col){
			return columnasEditables[col];
		}
		public Class getColumnClass(int index){
			return data[index];
		}
	};
	DefaultTableModel modelCont = new DefaultTableModel(){
		public boolean isCellEditable(int row, int col){
			return columnasEditables[col];
		}
		public Class getColumnClass(int index){
			return data[index];
		}
	};


	private SalesController controller;
	private CDManager manager;
	private SCManager scManager;
	private JButton btnGoShoppingcar;



	/**
	 * Create the frame.
	 */
	public Sales(SalesController controller) {		
		drawWindow();
		this.scManager = controller.getSCManager();
		this.manager = controller.getCDManager();
		this.controller = controller;
		auxSong = new ArrayList<Song>();
		auxVideo = new ArrayList<Video>();
		auxSCSong = new ArrayList<Song>();
		auxSCVideo = new ArrayList<Video>();
	}
	private void drawWindow(){
		setTitle("Ventana De Venta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 678);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(new MigLayout("", "[82px][440px][42px][69px][9px][169px][32px][111px]", "[23px][60px][10px][474px][4px][43px]"));
		JLabel lblNewLabel = new JLabel("Gesti\u00F3n de Venta");
		contentPane.add(lblNewLabel, "cell 0 0,alignx left,aligny center");

		btnBack = new JButton("Volver");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				goMain();
			}
		});

		lblWarning = new JLabel("Warning");
		contentPane.add(lblWarning, "cell 2 0,alignx right,aligny center");

		btnGoShoppingcar = new JButton("Carrito");
		btnGoShoppingcar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i=0; i<scManager.getShoppingcar().getDiscs().size();i++){
					System.out.println(scManager.getShoppingcar().getDiscs().get(i).getID()+ "\n");
				}
			}
		});
		contentPane.add(btnGoShoppingcar, "cell 5 0,alignx right,aligny top");
		contentPane.add(btnBack, "cell 7 0,alignx right,aligny top");
		lblWarning.setVisible(false);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, "cell 0 1 3 5,grow");

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
				addToSearchListSong(model);
			}
		});
		panelCD.add(btnSearchCD, "cell 3 1");

		scrollPaneCD = new JScrollPane();
		panelCD.add(scrollPaneCD, "cell 1 3 3 1,grow");

		tableCD = new JTable();
		model.setColumnIdentifiers(columnas);
		tableCD.setModel(model);
		tableCD.getColumnModel().getColumn(0).setPreferredWidth(160);
		tableCD.getColumnModel().getColumn(1).setPreferredWidth(160);
		tableCD.getColumnModel().getColumn(2).setPreferredWidth(160);
		tableCD.getColumnModel().getColumn(3).setPreferredWidth(60);
		tableCD.getColumnModel().getColumn(4).setPreferredWidth(35);
		tableCD.getColumnModel().getColumn(0).setResizable(false);
		tableCD.getColumnModel().getColumn(1).setResizable(false);
		tableCD.getColumnModel().getColumn(2).setResizable(false);
		tableCD.getColumnModel().getColumn(3).setResizable(false);
		tableCD.getColumnModel().getColumn(3).setResizable(false);



		scrollPaneCD.setViewportView(tableCD);


		btnCleanListCD = new JButton("Limpiar Lista");
		btnCleanListCD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cleanTableSearch(model);
			}
		});
		panelCD.add(btnCleanListCD, "cell 1 4");

		buttonAddCD = new JButton("A\u00F1adir");
		buttonAddCD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				moveToVerifyListSong(tableCD, modelCont, 12, auxSong);
			}
		});
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

		JLabel lblProducts = new JLabel("Productos agregados a contenedor");
		contentPane.add(lblProducts, "cell 5 1,alignx center,aligny bottom");

		buttonInfo = new JButton("?");
		buttonInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				msgInfo();
			}
		});
		contentPane.add(buttonInfo, "cell 7 1,alignx center,aligny bottom");

		buttonMoveSC = new JButton("Enviar Al Carrito");
		buttonMoveSC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addSongsToDisc();
			}
		});

		scrollPaneCont = new JScrollPane();
		contentPane.add(scrollPaneCont, "cell 3 3 5 1,grow");

		tableCont = new JTable();
		scrollPaneCont.setViewportView(tableCont);
		modelCont.setColumnIdentifiers(columnas);
		tableCont.setModel(modelCont);
		tableCont.getColumnModel().getColumn(0).setPreferredWidth(160);
		tableCont.getColumnModel().getColumn(1).setPreferredWidth(160);
		tableCont.getColumnModel().getColumn(2).setPreferredWidth(160);
		tableCont.getColumnModel().getColumn(3).setPreferredWidth(60);
		tableCont.getColumnModel().getColumn(4).setPreferredWidth(35);
		tableCont.getColumnModel().getColumn(0).setResizable(false);
		tableCont.getColumnModel().getColumn(1).setResizable(false);
		tableCont.getColumnModel().getColumn(2).setResizable(false);
		tableCont.getColumnModel().getColumn(3).setResizable(false);
		tableCont.getColumnModel().getColumn(3).setResizable(false);


		buttonDel = new JButton("Eliminar");
		buttonDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				delVerifySong(tableCont, modelCont);
			}
		});
		contentPane.add(buttonDel, "cell 3 5,alignx left,aligny top");
		contentPane.add(buttonMoveSC, "cell 7 5,alignx right,aligny top");	
	}
	//methods
	public void goMain(){
		Application.changeWindow(this, Application.WindowType.main);
	}

	public void msgInfo(){
		JOptionPane.showMessageDialog(null, "Esta lista contiene los elementos que conformarán vuestro CD o DVD, al enviar al carrito enviará los productos en formato de disco,\n"
				+ "quedando registrado el mismo con un id asignado por el sistema.");
	}

	public void cleanTableSearch(DefaultTableModel modelOrigen){
		int centinel = modelOrigen.getRowCount();
		for(int i=0; i<centinel; i++){
			modelOrigen.removeRow(0);
		}
	}

	//Metodos para canciones
	public ArrayList<Song> searchSongs(){
		return manager.search(textFieldSearchCD.getText());
	}	

	public void addToSearchListSong(DefaultTableModel modelOrigen){
		auxSong.clear();
		cleanTableSearch(modelOrigen);
		if(!textFieldSearchCD.getText().equals("")){
			ArrayList<Song> auxiliar = searchSongs();
			for (Song song : auxiliar) {
				Object rowns[] = {song.getTitle(), song.getAlbum(), song.getAuthor(),song.getID(), false};
				modelOrigen.addRow(rowns);		
			}
			lblWarning.setVisible(false);
			auxSong=searchSongs();
		}	
		else{
			lblWarning.setText("Debe introducir su criterio de búsqueda en la caja de texto");
			lblWarning.setVisible(true);
		}
	}


	public void moveToVerifyListSong(JTable tableOrigen, DefaultTableModel modelSC, int max, ArrayList<Song> auxSearch){
		ArrayList<Song>auxiliar = searchSelectedSong(tableOrigen, auxSearch);
		if(!(auxiliar.size() > (max-modelSC.getRowCount()))){
			for (Song song : auxiliar) {
				Object rowns[] = {song.getTitle(), song.getAlbum(), song.getAuthor(),song.getID(), false};
				modelSC.addRow(rowns);	
				auxSCSong.add(song);
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "El limite maximo de productos a agregar es " + max);
		}
	}

	public ArrayList<Song> searchSelectedSong(JTable table, ArrayList<Song> auxSong){
		ArrayList<Song>search = new ArrayList<Song>();
		boolean confirm = false;
		for(int i = 0; i<table.getRowCount(); i++){
			if((boolean) table.getValueAt(i, 4)){
				int id = (int) table.getValueAt(i, 3);				
				for(int j = 0; j<auxSong.size();j++){
					if(auxSong.get(j).getID() == id){
						search.add(auxSong.get(j));
						confirm = true;
					}
				}
			}
		}
		if(!confirm){	
			JOptionPane.showMessageDialog(null, "Debe seleccionar al menos un elemento para agregar");	
		}
		return search;
	}

	public void delVerifySong(JTable tableCont, DefaultTableModel modelCont){
		boolean confirm = false;
		for(int i = 0; i<tableCont.getRowCount(); i++){
			if((boolean) tableCont.getValueAt(i, 4)){			
				modelCont.removeRow(i);
				auxSCSong.remove(i);
				confirm = true;
				i--;
			}		
		}		
		if(!confirm){	
			JOptionPane.showMessageDialog(null, "Debe seleccionar al menos un elemento para eliminar");	
		}
	}

	public void updateVerifySong(DefaultTableModel modelSC){
		cleanTableSearch(modelSC);
		for (Song song : auxSCSong) {
			Object rowns[] = {song.getTitle(), song.getAlbum(), song.getAuthor(),song.getID(), false};
			modelSC.addRow(rowns);	
		}
	}

	public void addSongsToDisc(){
		for(int i =0; i<auxSCSong.size();i++){
			manager.getCD().addItem(auxSCSong.get(i));
		}
		scManager.addItem(manager.getCD());
		/*manager.getCD().getContents().clear();
		for(int i = 0; i<auxSCSong.size();i++){
			manager.getCD().addSong(auxSCSong.get(i));
		}
		scManager.addItem(manager.getCD());*/
	}

	//Metodos para Videos
	public ArrayList<Video> searchVideos(){
		return controller.getDVDManager().getSearch().search(textFieldSearchDVD.getText(), controller.getVideoList());
	}

	public void addToSearchListVideo(DefaultTableModel modelOrigen){
		auxSong.clear();
		cleanTableSearch(modelOrigen);
		if(!textFieldSearchCD.getText().equals("")){
			ArrayList<Video> auxiliar = searchVideos();
			for (Video video : auxiliar) {
				Object rowns[] = {video.getTitle(), video.getInterpreter(),video.getID(), false};
				modelOrigen.addRow(rowns);		
			}
			lblWarning.setVisible(false);
			auxSong=searchSongs();
		}	
		else{
			lblWarning.setText("Debe introducir su criterio de búsqueda en la caja de texto");
			lblWarning.setVisible(true);
		}
	}


	public void moveToVerifyListVideo(JTable tableOrigen, DefaultTableModel modelSC, int max, ArrayList<Video> auxSearch){
		ArrayList<Video>auxiliar = searchSelectedVideo(tableOrigen, auxSearch);
		if(!(auxiliar.size() > (max-modelSC.getRowCount()))){
			for (Video video : auxiliar) {
				Object rowns[] = {video.getTitle(), video.getInterpreter(),video.getID(), false};
				modelSC.addRow(rowns);	
				auxSCVideo.add(video);
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "El limite maximo de productos a agregar es " + max);
		}
	}

	public ArrayList<Video> searchSelectedVideo(JTable table, ArrayList<Video> auxSearch){
		ArrayList<Video>search = new ArrayList<Video>();
		boolean confirm = false;
		for(int i = 0; i<table.getRowCount(); i++){
			if((boolean) table.getValueAt(i, 4)){
				int id = (int) table.getValueAt(i, 3);				
				for(int j = 0; j<auxSearch.size();j++){
					if(auxSearch.get(j).getID() == id){
						search.add(auxSearch.get(j));
						confirm = true;
					}
				}
			}
		}
		if(!confirm){	
			JOptionPane.showMessageDialog(null, "Debe seleccionar al menos un elemento para agregar");	
		}
		return search;
	}

	public void delVerifyVideo(JTable tableCont, DefaultTableModel modelCont){
		boolean confirm = false;
		for(int i = 0; i<tableCont.getRowCount(); i++){
			if((boolean) tableCont.getValueAt(i, 4)){
				modelCont.moveRow(i, tableCont.getRowCount(), 0);
				modelCont.removeRow(0);
				auxSCVideo.remove(i);
				confirm = true;

			}
		}
		if(!confirm){	
			JOptionPane.showMessageDialog(null, "Debe seleccionar al menos un elemento para eliminar");	
		}
	}



}
