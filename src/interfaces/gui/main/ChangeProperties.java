package interfaces.gui.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.business.core.Store;

public class ChangeProperties extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ChangeProperties(Store store, Window father) {
		setDefaultCloseOperation(father);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	private void setDefaultCloseOperation(Window father) {
		father.setEnabled(true);
		dispose();
	}

}
