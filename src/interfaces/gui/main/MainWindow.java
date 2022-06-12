package interfaces.gui.main;

import interfaces.gui.workflow.SalesHandler;

import java.awt.BorderLayout;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		drawWindow();
	}

	private void drawWindow(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnTienda = new JMenu("Tienda");
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
		
		JMenu mnProbando = new JMenu("Probando");
		menuBar.add(mnProbando);
		
		JMenuItem mntmTesteandoVentas = new JMenuItem("Testeando Ventas");
		mntmTesteandoVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				test();
			}
		});
		mnProbando.add(mntmTesteandoVentas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[]", "[]"));
		setLocationRelativeTo(null);
	}
	
	private void test(){
		Application.changeWindow(this, WindowType.sales);
	}
	
	private void changePropertiesButton(){
		Application.openChildWindow(this, WindowType.properties);
	}
}
