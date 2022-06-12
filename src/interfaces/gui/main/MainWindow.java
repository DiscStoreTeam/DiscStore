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
	JMenu mnTienda;
	JMenu mnGestionarTrabajadores;
	
	private boolean manager;

	/**
	 * Create the frame.
	 */
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
		
		JMenu mnProbando = new JMenu("Gestionar Venta");
		menuBar.add(mnProbando);
		
		JMenuItem mntmTesteandoVentas = new JMenuItem("Vender Producto");
		mntmTesteandoVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				test();
			}
		});
		mnProbando.add(mntmTesteandoVentas);
		
		JMenu mnGestionarBaseDe = new JMenu("Gestionar Base de Datos");
		menuBar.add(mnGestionarBaseDe);
		
		JMenuItem mntmAadirProducto = new JMenuItem("A\u00F1adir Producto");
		mntmAadirProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newProductButton();
			}
		});
		mnGestionarBaseDe.add(mntmAadirProducto);
		
		JMenuItem mntmEliminarProducto = new JMenuItem("Eliminar Producto");
		mnGestionarBaseDe.add(mntmEliminarProducto);
		
		mnTienda = new JMenu("Tienda");
		menuBar.add(mnTienda);
		
		JMenuItem mntmCambiarPropiedadesDe = new JMenuItem("Cambiar Propiedades de la Tienda");
		mntmCambiarPropiedadesDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changePropertiesButton();
			}
		});
		mnTienda.add(mntmCambiarPropiedadesDe);
		
		JMenuItem mntmCambiarAdministrador = new JMenuItem("Cambiar Administrador");
		mnTienda.add(mntmCambiarAdministrador);
		
		mnGestionarTrabajadores = new JMenu("Gestionar Trabajadores");
		menuBar.add(mnGestionarTrabajadores);
		
		JMenuItem mntmContratarNuevoTrabajador = new JMenuItem("Contratar Nuevo Trabajador");
		mnGestionarTrabajadores.add(mntmContratarNuevoTrabajador);
		
		JMenuItem mntmDespedirTrabajador = new JMenuItem("Despedir Trabajador");
		mnGestionarTrabajadores.add(mntmDespedirTrabajador);
		contentPane = new JPanel(){
			public void paintComponent(Graphics pic){
				Image image = Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/assets/images/pic-750x628.jpg"));
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
			mnTienda.setEnabled(true);
			mnGestionarTrabajadores.setEnabled(true);
		}
		else{
			mnTienda.setEnabled(false);
			mnGestionarTrabajadores.setEnabled(false);
		}
	}
	
	private void test(){
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
}
