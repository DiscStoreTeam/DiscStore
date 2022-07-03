package interfaces.gui.main;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.business.core.Store;
import main.Application;
import main.Application.WindowType;
import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

@SuppressWarnings({ "serial", "unused" })
public class MainWindow extends JFrame {

	private JPanel contentPane;
	JMenu mnProducts;
	JMenu mnAdmin;
	
	private boolean manager;

	
	public MainWindow(Store store) {
		setTitle("Tienda " + store.getProperties().getName());
		manager = store.getAccessController().isManager();
		drawWindow();
	}

	private void drawWindow(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 628);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnSesin = new JMenu("Sesi\u00F3n");
		menuBar.add(mnSesin);
		
		JMenuItem mntmCerrarSesin = new JMenuItem("Cerrar Sesi\u00F3n");
		mntmCerrarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logout();
			}
		});
		mnSesin.add(mntmCerrarSesin);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		mnSesin.add(mntmSalir);
		
		mnProducts = new JMenu("Productos y Venta");
		menuBar.add(mnProducts);
		
		JMenuItem mntmGestionarVenta = new JMenuItem("Gestionar Venta");
		mntmGestionarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salesButton();
			}
		});
		mnProducts.add(mntmGestionarVenta);
		
		JMenuItem mntmAadirProducto_1 = new JMenuItem("A\u00F1adir Producto");
		mntmAadirProducto_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newProductButton();
			}
		});
		mnProducts.add(mntmAadirProducto_1);
		
		JMenuItem mntmEliminarProducto_1 = new JMenuItem("Eliminar Producto");
		mntmEliminarProducto_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteProductButton();
			}
		});
		mnProducts.add(mntmEliminarProducto_1);
		
		mnAdmin = new JMenu("Trabajadores y Tienda");
		menuBar.add(mnAdmin);
		
		JMenuItem mntmCambiarAdministrador_1 = new JMenuItem("Cambiar Administrador");
		mntmCambiarAdministrador_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changeManagerButton();
			}
		});
		mnAdmin.add(mntmCambiarAdministrador_1);
		
		JMenuItem mntmContratarNuevoTrabajador_1 = new JMenuItem("Contratar Nuevo Trabajador");
		mntmContratarNuevoTrabajador_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hireWorkerButton();
			}
		});
		
		JMenuItem mntmCambiarPropiedadesDe_1 = new JMenuItem("Cambiar Propiedades de la Tienda");
		mntmCambiarPropiedadesDe_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changePropertiesButton();
			}
		});
		mnAdmin.add(mntmCambiarPropiedadesDe_1);
		mnAdmin.add(mntmContratarNuevoTrabajador_1);
		
		JMenuItem mntmDespedirTrabajador_1 = new JMenuItem("Despedir Trabajador");
		mntmDespedirTrabajador_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fireWorkerButton();
			}
		});
		mnAdmin.add(mntmDespedirTrabajador_1);
		contentPane = new JPanel(){
			public void paintComponent(Graphics pic){
				Image image = Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/interfaces/assets/pic-750x628.jpg"));
				pic.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[]", "[]"));
		setLocationRelativeTo(null);
		updatePermissions();
	}
	
	private void updatePermissions(){
		if(manager){
			mnAdmin.setEnabled(true);
		}
		else{
			mnAdmin.setEnabled(false);
		}
	}
	
	private void salesButton(){
		Application.changeWindow(this, WindowType.sales);
	}
	
	private void changePropertiesButton(){
		Application.openChildWindow(this, WindowType.properties);
	}
	
	private void logout(){
		Application.changeWindow(this, WindowType.login);
	}
	
	private void newProductButton(){
		Application.openChildWindow(this, WindowType.newProduct);
	}
	
	private void deleteProductButton(){
		Application.openChildWindow(this, WindowType.deleteProduct);
	}
	
	private void hireWorkerButton(){
		Application.openChildWindow(this, WindowType.hireWorker);
	}
	
	private void fireWorkerButton(){
		Application.openChildWindow(this, WindowType.fireWorker);
	}
	
	private void changeManagerButton(){
		Application.openChildWindow(this, WindowType.changeManager);
	}
}
