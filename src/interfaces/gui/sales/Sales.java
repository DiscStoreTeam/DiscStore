package interfaces.gui.sales;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;






import main.Application;
import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;





import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JTable;

import logic.business.abstractions.Disc;
import logic.business.auxiliars.CDManager;
import logic.business.auxiliars.SCManager;
import logic.business.controllers.SalesController;
import logic.business.core.CD;
import logic.business.core.Song;
import logic.business.core.Video;

import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


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
	@SuppressWarnings("rawtypes")
	Class data[]={java.lang.Object.class,java.lang.Object.class , java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class };
	DefaultTableModel model = new DefaultTableModel(){
		public boolean isCellEditable(int row, int col){
			return columnasEditables[col];
		}
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public Class getColumnClass(int index){
			return data[index];
		}
	};
	DefaultTableModel modelCont = new DefaultTableModel(){
		public boolean isCellEditable(int row, int col){
			return columnasEditables[col];
		}
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public Class getColumnClass(int index){
			return data[index];
		}
	};


	private SalesController controller;
	private CDManager manager;
	private SCManager scManager;
	private JTabbedPane tabbedPane_1;
	private JPanel panel;
	private JButton btnVerCarrito;



	/**
	 * Create the frame.
	 */
	public Sales(SalesController controller) {		
		drawWindow();
		this.controller = controller;
		this.scManager = controller.getSCManager();
		this.manager = controller.getCDManager();
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
		contentPane.setLayout(new MigLayout("", "[82px][387px][40px][449px]", "[23px][591px]"));
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
		contentPane.add(btnBack, "cell 3 0,alignx right,aligny top");
		lblWarning.setVisible(false);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, "cell 0 1 3 1,grow");

		panelCD = new JPanel();
		tabbedPane.addTab("Venta CD", null, panelCD, null);
		panelCD.setLayout(new MigLayout("", "[7.00][109.00,grow][251.00][grow][]", "[30.00][36.00][9.00][418.00,grow][19.00]"));

		lblIntroduzcaSuCriterioCD = new JLabel("Introduzca su criterio de busqueda");
		panelCD.add(lblIntroduzcaSuCriterioCD, "cell 1 0");

		textFieldSearchCD = new JTextField();
		textFieldSearchCD.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					addToSearchListSong(model);
				}
			}
		});
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
				if(tableCD.getRowCount()>0){
					cleanTableSearch(model);
				}
				else{
					JOptionPane.showMessageDialog(null, "La tabla ya se encuentra vacia");
				}
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
		modelCont.setColumnIdentifiers(columnas);

		tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setToolTipText("Confirmación");
		contentPane.add(tabbedPane_1, "cell 3 1,grow");

		panel = new JPanel();
		tabbedPane_1.addTab("Confirmación a disco", null, panel, null);
		panel.setLayout(new MigLayout("", "[150px:n:150px][109.00][100px:n:130px]", "[29.00][49.00][505.00][52.00]"));

		JLabel lblProducts = new JLabel("Productos agregados a contenedor");
		panel.add(lblProducts, "cell 0 1");

		buttonInfo = new JButton("?");
		panel.add(buttonInfo, "cell 1 1 2 1,alignx right");
		buttonInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				msgInfo();
			}
		});

		scrollPaneCont = new JScrollPane();
		panel.add(scrollPaneCont, "cell 0 2 3 1,growy");


		tableCont = new JTable();
		scrollPaneCont.setViewportView(tableCont);
		tableCont.setModel(modelCont);


		buttonDel = new JButton("Eliminar");
		panel.add(buttonDel, "cell 0 3,alignx right");

		buttonMoveSC = new JButton("Enviar Al Carrito");
		panel.add(buttonMoveSC, "flowx,cell 1 3,alignx center");

		btnVerCarrito = new JButton("Ver Carrito");
		btnVerCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changeShoppingcar();
				//goShopingcar();
			}
		});
		panel.add(btnVerCarrito, "cell 2 3,alignx center");
		buttonMoveSC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tableCont.getRowCount()>0){
					moveToShoppingcar(addSongsToDisc());
					auxSCSong.clear();
					cleanTableSearch(modelCont);
				}
				else{
					JOptionPane.showMessageDialog(null, "Debe agregar al menos un elemento para enviar al carrito");	
				}
			}
		});
		buttonDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				delVerifySong(tableCont, modelCont);
			}
		});
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
		
		textFieldSearchCD.requestFocus();
	}
	//methods
	public void goMain(){
		Application.changeWindow(this, Application.WindowType.main);
	}
	public void goShopingcar(){
		Application.changeWindow(this, Application.WindowType.shoppingcar);
	}
	public void changeShoppingcar() {
		Application.openChildWindow(this, Application.WindowType.shoppingcar);
	}

	public void msgInfo(){
		JOptionPane.showMessageDialog(null,"Los costos base son:\nCD  : 12.50$\nDVD : 15.50$\nY el precio de cada"
				+ " producto es: 2.50$\n\nEsta lista contiene los elementos que conformarán vuestro CD o DVD, al enviar"
				+ " al carrito enviará los \nproductos en formato de disco, quedando registrado el mismo con un id "
				+ "asignado por el sistema.");
	}

	public void cleanTableSearch(DefaultTableModel modelOrigen){
		int centinel = modelOrigen.getRowCount();
		for(int i=0; i<centinel; i++){
			modelOrigen.removeRow(0);
		}
	}

	public int asignId(){
		return controller.getReportId();
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
		boolean secure = false;
		for(int i = 0; i<table.getRowCount(); i++){
			if((boolean) table.getValueAt(i, 4)){
				int id = (int) table.getValueAt(i, 3);				
				for(int j = 0; j<auxSong.size() && !secure;j++){
					if(auxSong.get(j).getID() == id){
						search.add(auxSong.get(j));
						confirm = true;
						secure = true;
					}
				}
				secure = false;
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

	public Disc addSongsToDisc(){
		CD cd = new CD();
		for (Song song : auxSCSong) {
			cd.addItem(song);	
		}
		return cd;
	}

	public String assignCDName(){
		String name = auxSCSong.get(0).getAuthor();
		boolean more = false;
		for(int i = 1; i<auxSCSong.size() && !more;i++){
			if(!auxSCSong.get(i).getAuthor().equals(name)){
				more = true;
			}
		}
		if(more){
			name += " y otros";
		}
		return name;
	}

	public void moveToShoppingcar(Disc disc){
		disc.setID(asignId());
		disc.setName(assignCDName());
		scManager.addItem(disc);
		controller.addHistory(disc);
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
