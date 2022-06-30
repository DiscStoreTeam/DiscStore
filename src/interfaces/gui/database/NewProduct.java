package interfaces.gui.database;

import interfaces.util.SongPreForm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.business.controllers.DBController;
import logic.business.core.Store;
import logic.util.Validator;
import net.miginfocom.swing.MigLayout;

import javax.swing.border.TitledBorder;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

@SuppressWarnings("serial")
public class NewProduct extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private JTextField textFieldTitle;
	private JTextField textFieldGender;
	private JTextField textFieldAlbum;
	private JTextField textFieldInterpreter;
	private JTextField textFieldCollaborators;
	private JTextField textFieldAuthor;
	private JComboBox<String> comboBoxResolution;
	private JPanel panelType;
	private JPanel panelCaract;
	private JPanel panelArtist;
	private JPanel panelTec;
	private JRadioButton radioVideo;
	private JRadioButton radioSong;
	private JLabel lblError;
	
	private DBController controller;
	
	private JTextField textFieldMinutes;
	private JLabel label;
	private JTextField textFieldSeconds;
	private JTextField textFieldSize;
	
	private int lastRightM;
	private int lastRightS;
	

	/**
	 * Create the dialog.
	 */
	public NewProduct(Store store) {
		setTitle("A\u00F1adir Nuevo Producto");
		this.controller = store.getDatabaseController();
		drawWindow();
	}

	private void drawWindow(){
		setBounds(100, 100, 450, 521);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[grow]", "[22.00][74.00][76.00][][grow]"));

		panelType = new JPanel();
		panelType.setBorder(new TitledBorder(null, "Tipo de Producto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.add(panelType, "cell 0 0,grow");
		panelType.setLayout(new MigLayout("", "[179.00][grow]", "[]"));

		ButtonGroup radio = new ButtonGroup();
		radioSong = new JRadioButton("Canci\u00F3n");
		radioSong.setSelected(true);
		radioSong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateTypes();
			}
		});
		panelType.add(radioSong, "cell 0 0");
		radio.add(radioSong);
		radioVideo = new JRadioButton("V\u00EDdeo");
		radioVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateTypes();
			}
		});
		panelType.add(radioVideo, "cell 1 0");
		radio.add(radioVideo);

		panelCaract = new JPanel();
		panelCaract.setBorder(new TitledBorder(null, "Caracter\u00EDsticas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.add(panelCaract, "cell 0 1,grow");
		panelCaract.setLayout(new MigLayout("", "[][grow]", "[][][]"));

		JLabel lblTtulo = new JLabel("T\u00EDtulo : ");
		panelCaract.add(lblTtulo, "cell 0 0,alignx trailing");

		textFieldTitle = new JTextField();
		panelCaract.add(textFieldTitle, "cell 1 0,growx");
		textFieldTitle.setColumns(10);

		JLabel lblGnero = new JLabel("G\u00E9nero : ");
		panelCaract.add(lblGnero, "cell 0 1,alignx trailing");

		textFieldGender = new JTextField();
		panelCaract.add(textFieldGender, "cell 1 1,growx");
		textFieldGender.setColumns(10);

		JLabel lbllbum = new JLabel("\u00C1lbum : ");
		panelCaract.add(lbllbum, "cell 0 2,alignx trailing");

		textFieldAlbum = new JTextField();
		panelCaract.add(textFieldAlbum, "cell 1 2,growx");
		textFieldAlbum.setColumns(10);

		panelArtist = new JPanel();
		panelArtist.setBorder(new TitledBorder(null, "Artistas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.add(panelArtist, "cell 0 2,grow");
		panelArtist.setLayout(new MigLayout("", "[][grow]", "[][][]"));

		JLabel lblIntrprete = new JLabel("Int\u00E9rprete : ");
		panelArtist.add(lblIntrprete, "cell 0 0,alignx trailing");

		textFieldInterpreter = new JTextField();
		panelArtist.add(textFieldInterpreter, "cell 1 0,growx");
		textFieldInterpreter.setColumns(10);

		JLabel lblColaboradores = new JLabel("Colaboradores : ");
		panelArtist.add(lblColaboradores, "cell 0 1,alignx trailing");

		textFieldCollaborators = new JTextField();
		panelArtist.add(textFieldCollaborators, "cell 1 1,growx");
		textFieldCollaborators.setColumns(10);

		JLabel lblAutor = new JLabel("Autor : ");
		panelArtist.add(lblAutor, "cell 0 2,alignx trailing");

		textFieldAuthor = new JTextField();
		panelArtist.add(textFieldAuthor, "cell 1 2,growx");
		textFieldAuthor.setColumns(10);

		panelTec = new JPanel();
		panelTec.setBorder(new TitledBorder(null, "Caracter\u00EDsticas T\u00E9cnicas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.add(panelTec, "cell 0 3,grow");
		panelTec.setLayout(new MigLayout("", "[][117.00][][grow]", "[][][]"));

		JLabel lblDuracin = new JLabel("Duraci\u00F3n : ");
		panelTec.add(lblDuracin, "cell 0 0,alignx trailing");
		
		textFieldMinutes = new JTextField();
		textFieldMinutes.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				validateDuration();
			}
		});
		panelTec.add(textFieldMinutes, "cell 1 0,growx");
		textFieldMinutes.setColumns(10);
		
		label = new JLabel(" : ");
		panelTec.add(label, "cell 2 0,alignx trailing");
		
		textFieldSeconds = new JTextField();
		panelTec.add(textFieldSeconds, "cell 3 0,growx");
		textFieldSeconds.setColumns(10);

		JLabel lblTamaoDelArchivo = new JLabel("Tama\u00F1o del archivo : ");
		panelTec.add(lblTamaoDelArchivo, "cell 0 1,alignx trailing");
		
		textFieldSize = new JTextField();
		panelTec.add(textFieldSize, "cell 1 1,growx");
		textFieldSize.setColumns(10);


		JLabel lblResolucin = new JLabel("Resoluci\u00F3n : ");
		panelTec.add(lblResolucin, "cell 0 2,alignx trailing");


		comboBoxResolution = new JComboBox<String>();
		comboBoxResolution.setModel(new DefaultComboBoxModel<String>(new String[] {"800x600", "1280x720", "1920x1080", "2048x1080", "4096x2160"}));
		panelTec.add(comboBoxResolution, "cell 1 2,growx");
		
		lblError = new JLabel("Error!");
		lblError.setForeground(Color.RED);
		contentPanel.add(lblError, "cell 0 4,alignx center,aligny center");


		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("A\u00F1adir");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addButton();
			}
		});
		okButton.setActionCommand("Ok");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);


		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelButton();
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		
		setLocationRelativeTo(null);
		lblError.setVisible(false);
		updateTypes();
	}
	
	private void updateTypes(){
		if(radioSong.isSelected()){
			textFieldAlbum.setEnabled(true);
			textFieldAuthor.setEnabled(true);
			comboBoxResolution.setEnabled(false);
		}
		else if(radioVideo.isSelected()){
			textFieldAlbum.setEnabled(false);
			textFieldAuthor.setEnabled(false);
			comboBoxResolution.setEnabled(true);
		}
	}
	
	private void addButton(){
		if(validateFields()){
			if(radioSong.isEnabled()){
				SongPreForm form = new SongPreForm();
				form.setTitle(textFieldTitle.getText());
				form.setGenre(textFieldGender.getText());
				form.setAlbum(textFieldAlbum.getText());
				form.setAuthor(textFieldAuthor.getText());
				form.setInterpreter(textFieldInterpreter.getText());
				form.setCollaborators(textFieldCollaborators.getText());
				System.out.println(form.getDuration());
			}
		}
	}
	
	private void validateDuration(){
		Integer minutes = new Integer(textFieldMinutes.getText());
		Integer seconds = new Integer(textFieldSeconds.getText());
		if(minutes > 0 && minutes < 60){
			lastRightM = minutes;
		}
		else{
			textFieldMinutes.setText(minutes.toString());
		}
		if(seconds > 0 && seconds < 60){
			lastRightS = seconds;
		}
		else if(seconds == 60){
			minutes = new Integer(textFieldMinutes.getText());
			minutes++;
			textFieldMinutes.setText(minutes.toString());
		}
		else{
			textFieldSeconds.setText(seconds.toString());
		}
	}
	
	private void cancelButton(){
		dispose();
	}
	
	private boolean validateFields(){
		boolean valid = true;
		if(!Validator.emptyString(textFieldTitle.getText())){
			if(!Validator.emptyString(textFieldGender.getText())){
				if(!Validator.emptyString(textFieldInterpreter.getText())){
					if(!Validator.emptyString(textFieldCollaborators.getText())){
						lblError.setVisible(false);
					}
					else{
						valid = false;
						lblError.setVisible(true);
						lblError.setText("Existen campos vacíos");
					}
				}
				else{
					valid = false;
					lblError.setVisible(true);
					lblError.setText("Existen campos vacíos");
				}
			}
			else{
				valid = false;
				lblError.setVisible(true);
				lblError.setText("Existen campos vacíos");
			}
		}
		else{
			valid = false;
			lblError.setVisible(true);
			lblError.setText("Existen campos vacíos");
		}
		if(valid){
			if(!Validator.alphabeticalString(textFieldGender.getText())){
				valid = false;
				lblError.setVisible(true);
				lblError.setText("El género introducido no es válido");
			}
		}
		return valid;
	}
}
