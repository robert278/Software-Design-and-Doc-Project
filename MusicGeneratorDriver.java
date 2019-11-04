import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Dialog.ModalExclusionType;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.Box;
import javax.swing.border.TitledBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.*;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JList;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;

public class MusicGeneratorDriver extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup KeySignatureGroup = new ButtonGroup();
	private final ButtonGroup TimeSignatureGroup = new ButtonGroup();
	private final ButtonGroup InstrumentsGroup = new ButtonGroup();
	private final ButtonGroup TempoGroup = new ButtonGroup();
	private final ButtonGroup EmotionsGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MusicGeneratorDriver frame = new MusicGeneratorDriver();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MusicGeneratorDriver() {
		setFont(new Font("Myanmar Text", Font.BOLD, 13));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Anbang Wang\\Desktop\\SDD_MusicGenerator_Image\\RMG_Icon.png"));
		setTitle("RandomMusicGenerator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1330, 600);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		setContentPane(contentPane);
		
		// Exit button setup
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(730, 455, 200, 70);
		btnExit.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 30));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		contentPane.setLayout(null);
		btnExit.setForeground(SystemColor.activeCaptionText);
		btnExit.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.add(btnExit);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(400, 455, 200, 70);
		btnSave.setForeground(Color.BLACK);
		btnSave.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 30));
		btnSave.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.add(btnSave);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setBounds(70, 455, 200, 70);
		btnGenerate.setForeground(Color.BLACK);
		btnGenerate.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 30));
		btnGenerate.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.add(btnGenerate);
		
		JPanel KeySignaturePanel = new JPanel();
		KeySignaturePanel.setBounds(70, 130, 100, 250);
		KeySignaturePanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Key Signature", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.activeCaptionText));
		contentPane.add(KeySignaturePanel);
		KeySignaturePanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("C");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		KeySignaturePanel.add(lblNewLabel, "2, 2");
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("");
		KeySignatureGroup.add(rdbtnNewRadioButton);
		KeySignaturePanel.add(rdbtnNewRadioButton, "4, 2");
		
		JLabel lblNewLabel_1 = new JLabel("F");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		KeySignaturePanel.add(lblNewLabel_1, "2, 4");
		
		JRadioButton radioButton = new JRadioButton("");
		KeySignatureGroup.add(radioButton);
		KeySignaturePanel.add(radioButton, "4, 4");
		
		JLabel lblG = new JLabel("G");
		lblG.setFont(new Font("Tahoma", Font.PLAIN, 13));
		KeySignaturePanel.add(lblG, "2, 6");
		
		JRadioButton radioButton_1 = new JRadioButton("");
		KeySignatureGroup.add(radioButton_1);
		KeySignaturePanel.add(radioButton_1, "4, 6");
		
		JLabel lblD = new JLabel("D");
		lblD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		KeySignaturePanel.add(lblD, "2, 8");
		
		JRadioButton radioButton_2 = new JRadioButton("");
		KeySignatureGroup.add(radioButton_2);
		KeySignaturePanel.add(radioButton_2, "4, 8");
		
		JLabel lblA = new JLabel("A");
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 13));
		KeySignaturePanel.add(lblA, "2, 10");
		
		JRadioButton radioButton_3 = new JRadioButton("");
		KeySignatureGroup.add(radioButton_3);
		KeySignaturePanel.add(radioButton_3, "4, 10");
		
		JLabel lblE = new JLabel("E");
		lblE.setFont(new Font("Tahoma", Font.PLAIN, 13));
		KeySignaturePanel.add(lblE, "2, 12");
		
		JRadioButton radioButton_4 = new JRadioButton("");
		KeySignatureGroup.add(radioButton_4);
		KeySignaturePanel.add(radioButton_4, "4, 12");
		
		JPanel TimeSignaturePanel = new JPanel();
		TimeSignaturePanel.setBounds(195, 130, 100, 250);
		TimeSignaturePanel.setBorder(new TitledBorder(null, "Time Signature", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(TimeSignaturePanel);
		TimeSignaturePanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel_2 = new JLabel("(4,4)");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TimeSignaturePanel.add(lblNewLabel_2, "2, 2");
		
		JRadioButton radioButton_5 = new JRadioButton("");
		TimeSignatureGroup.add(radioButton_5);
		TimeSignaturePanel.add(radioButton_5, "4, 2");
		
		JLabel label = new JLabel("(2,2)");
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TimeSignaturePanel.add(label, "2, 4");
		
		JRadioButton radioButton_6 = new JRadioButton("");
		TimeSignatureGroup.add(radioButton_6);
		TimeSignaturePanel.add(radioButton_6, "4, 4");
		
		JLabel label_1 = new JLabel("(2,4)");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TimeSignaturePanel.add(label_1, "2, 6");
		
		JRadioButton radioButton_7 = new JRadioButton("");
		TimeSignatureGroup.add(radioButton_7);
		TimeSignaturePanel.add(radioButton_7, "4, 6");
		
		JLabel label_2 = new JLabel("(3,4)");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TimeSignaturePanel.add(label_2, "2, 8");
		
		JRadioButton radioButton_8 = new JRadioButton("");
		TimeSignatureGroup.add(radioButton_8);
		TimeSignaturePanel.add(radioButton_8, "4, 8");
		
		JLabel label_3 = new JLabel("(3,8)");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TimeSignaturePanel.add(label_3, "2, 10");
		
		JRadioButton radioButton_9 = new JRadioButton("");
		TimeSignatureGroup.add(radioButton_9);
		TimeSignaturePanel.add(radioButton_9, "4, 10");
		
		JPanel InstrumentsPanel = new JPanel();
		InstrumentsPanel.setBounds(320, 130, 100, 250);
		InstrumentsPanel.setBorder(new TitledBorder(null, "Instruments", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(InstrumentsPanel);
		InstrumentsPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel_3 = new JLabel("Keyboard");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		InstrumentsPanel.add(lblNewLabel_3, "2, 2");
		
		JRadioButton radioButton_10 = new JRadioButton("");
		InstrumentsGroup.add(radioButton_10);
		InstrumentsPanel.add(radioButton_10, "4, 2");
		
		JLabel lblPiano = new JLabel("Piano");
		lblPiano.setFont(new Font("Tahoma", Font.PLAIN, 13));
		InstrumentsPanel.add(lblPiano, "2, 4");
		
		JRadioButton radioButton_11 = new JRadioButton("");
		InstrumentsGroup.add(radioButton_11);
		InstrumentsPanel.add(radioButton_11, "4, 4");
		
		JLabel lblGuitar = new JLabel("Guitar");
		lblGuitar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		InstrumentsPanel.add(lblGuitar, "2, 6");
		
		JRadioButton radioButton_12 = new JRadioButton("");
		InstrumentsGroup.add(radioButton_12);
		InstrumentsPanel.add(radioButton_12, "4, 6");
		
		JLabel lblViolin = new JLabel("Violin");
		lblViolin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		InstrumentsPanel.add(lblViolin, "2, 8");
		
		JRadioButton radioButton_13 = new JRadioButton("");
		InstrumentsGroup.add(radioButton_13);
		InstrumentsPanel.add(radioButton_13, "4, 8");
		
		JLabel lblTrumpet = new JLabel("Trumpet");
		lblTrumpet.setFont(new Font("Tahoma", Font.PLAIN, 13));
		InstrumentsPanel.add(lblTrumpet, "2, 10");
		
		JRadioButton radioButton_14 = new JRadioButton("");
		InstrumentsGroup.add(radioButton_14);
		InstrumentsPanel.add(radioButton_14, "4, 10");
		
		JLabel lblHarp = new JLabel("Harp");
		lblHarp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		InstrumentsPanel.add(lblHarp, "2, 12");
		
		JRadioButton radioButton_15 = new JRadioButton("");
		InstrumentsGroup.add(radioButton_15);
		InstrumentsPanel.add(radioButton_15, "4, 12");
		
		JPanel TempoPanel = new JPanel();
		TempoPanel.setBounds(445, 130, 167, 312);
		TempoPanel.setBorder(new TitledBorder(null, "Tempo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(TempoPanel);
		TempoPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel_4 = new JLabel("Grave 40 BPM");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TempoPanel.add(lblNewLabel_4, "2, 2");
		
		JRadioButton radioButton_16 = new JRadioButton("");
		TempoGroup.add(radioButton_16);
		TempoPanel.add(radioButton_16, "4, 2");
		
		JLabel lblLargo = new JLabel("Larghetto 50 BPM");
		lblLargo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TempoPanel.add(lblLargo, "2, 4");
		
		JRadioButton radioButton_17 = new JRadioButton("");
		TempoGroup.add(radioButton_17);
		TempoPanel.add(radioButton_17, "4, 4");
		
		JLabel lblLento = new JLabel("Adagio 60 BPM");
		lblLento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TempoPanel.add(lblLento, "2, 6");
		
		JRadioButton radioButton_18 = new JRadioButton("");
		TempoGroup.add(radioButton_18);
		TempoPanel.add(radioButton_18, "4, 6");
		
		JLabel lblAdagio = new JLabel("Andantte 70 BPM");
		lblAdagio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TempoPanel.add(lblAdagio, "2, 8");
		
		JRadioButton radioButton_19 = new JRadioButton("");
		TempoGroup.add(radioButton_19);
		TempoPanel.add(radioButton_19, "4, 8");
		
		JLabel lblAndante = new JLabel("Andantino 80 BPM");
		lblAndante.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TempoPanel.add(lblAndante, "2, 10");
		
		JRadioButton radioButton_20 = new JRadioButton("");
		TempoGroup.add(radioButton_20);
		TempoPanel.add(radioButton_20, "4, 10");
		
		JLabel lblModeratoBpm = new JLabel("Moderato 95 BPM");
		lblModeratoBpm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TempoPanel.add(lblModeratoBpm, "2, 12");
		
		JRadioButton radioButton_27 = new JRadioButton("");
		TempoPanel.add(radioButton_27, "4, 12");
		
		JLabel lblAllegroBpm = new JLabel("Allegro 120 BPM");
		lblAllegroBpm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TempoPanel.add(lblAllegroBpm, "2, 14");
		
		JRadioButton radioButton_28 = new JRadioButton("");
		TempoPanel.add(radioButton_28, "4, 14");
		
		JLabel lblVivaceBpm = new JLabel("Vivace 145 BPM");
		lblVivaceBpm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TempoPanel.add(lblVivaceBpm, "2, 16");
		
		JRadioButton radioButton_29 = new JRadioButton("");
		TempoPanel.add(radioButton_29, "4, 16");
		
		JLabel lblPrestoBpm = new JLabel("Presto 180 BPM");
		lblPrestoBpm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TempoPanel.add(lblPrestoBpm, "2, 18");
		
		JRadioButton radioButton_30 = new JRadioButton("");
		TempoPanel.add(radioButton_30, "4, 18");
		
		JLabel lblPretissimoBpm = new JLabel("Pretissimo 220 BPM");
		lblPretissimoBpm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TempoPanel.add(lblPretissimoBpm, "2, 20");
		
		JRadioButton radioButton_31 = new JRadioButton("");
		TempoPanel.add(radioButton_31, "4, 20");
		
		JPanel EmotionsPanel = new JPanel();
		EmotionsPanel.setBounds(636, 130, 110, 250);
		EmotionsPanel.setBorder(new TitledBorder(null, "Emotions", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(EmotionsPanel);
		EmotionsPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel_5 = new JLabel("Joy");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		EmotionsPanel.add(lblNewLabel_5, "2, 2");
		
		JRadioButton radioButton_21 = new JRadioButton("");
		EmotionsGroup.add(radioButton_21);
		EmotionsPanel.add(radioButton_21, "4, 2");
		
		JLabel lblExcitement = new JLabel("Excitement");
		lblExcitement.setFont(new Font("Tahoma", Font.PLAIN, 13));
		EmotionsPanel.add(lblExcitement, "2, 4");
		
		JRadioButton radioButton_22 = new JRadioButton("");
		EmotionsGroup.add(radioButton_22);
		EmotionsPanel.add(radioButton_22, "4, 4");
		
		JLabel lblSurprise = new JLabel("Surprise");
		lblSurprise.setFont(new Font("Tahoma", Font.PLAIN, 13));
		EmotionsPanel.add(lblSurprise, "2, 6");
		
		JRadioButton radioButton_23 = new JRadioButton("");
		EmotionsGroup.add(radioButton_23);
		EmotionsPanel.add(radioButton_23, "4, 6");
		
		JLabel lblSadness = new JLabel("Sadness");
		lblSadness.setFont(new Font("Tahoma", Font.PLAIN, 13));
		EmotionsPanel.add(lblSadness, "2, 8");
		
		JRadioButton radioButton_24 = new JRadioButton("");
		EmotionsGroup.add(radioButton_24);
		EmotionsPanel.add(radioButton_24, "4, 8");
		
		JLabel lblDepress = new JLabel("Depress");
		lblDepress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		EmotionsPanel.add(lblDepress, "2, 10");
		
		JRadioButton radioButton_25 = new JRadioButton("");
		EmotionsGroup.add(radioButton_25);
		EmotionsPanel.add(radioButton_25, "4, 10");
		
		JLabel lblCure = new JLabel("Cure");
		lblCure.setFont(new Font("Tahoma", Font.PLAIN, 13));
		EmotionsPanel.add(lblCure, "2, 12");
		
		JRadioButton radioButton_26 = new JRadioButton("");
		EmotionsGroup.add(radioButton_26);
		EmotionsPanel.add(radioButton_26, "4, 12");
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(1064, 69, 220, 44);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.addItem("Simple whole rhythms");
		comboBox.addItem("Complex fractional rhythms");
		comboBox.setSelectedIndex(0);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_6 = new JLabel("Rhythm Complexity");
		lblNewLabel_6.setBounds(1064, 37, 155, 35);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Title Goes Here");
		lblNewLabel_7.setBounds(70, 26, 601, 87);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 35));
		contentPane.add(lblNewLabel_7);
		
		JButton btnAdvancedOptionsButton = new JButton("Advanced Options");
		btnAdvancedOptionsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdvancedOptionsFrame advancedOptionsFrame = new AdvancedOptionsFrame();
				advancedOptionsFrame.setVisible(true);
			}
		});
		btnAdvancedOptionsButton.setBounds(1064, 264, 220, 61);
		btnAdvancedOptionsButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 20));
		contentPane.add(btnAdvancedOptionsButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Lead Instruments", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(774, 130, 208, 260);
		contentPane.add(panel);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel Brass = new JLabel("Brass");
		Brass.setHorizontalAlignment(SwingConstants.LEFT);
		Brass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(Brass, "2, 2");
		
		JComboBox BrassBox = new JComboBox();
		panel.add(BrassBox, "4, 2, fill, default");
		
		JLabel Woodwind = new JLabel("Woodwind");
		Woodwind.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(Woodwind, "2, 4");
		
		JComboBox WoodwindBox = new JComboBox();
		panel.add(WoodwindBox, "4, 4, fill, default");
		
		JLabel Piano = new JLabel("Piano");
		Piano.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(Piano, "2, 6");
		
		JComboBox PianoBox = new JComboBox();
		panel.add(PianoBox, "4, 6, fill, default");
		
		JLabel ViolinFamily = new JLabel("Violin Family");
		ViolinFamily.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(ViolinFamily, "2, 8");
		
		JComboBox VoilinBox = new JComboBox();
		panel.add(VoilinBox, "4, 8, fill, default");
		
		JLabel GuitarFamily = new JLabel("Guitar Family");
		GuitarFamily.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(GuitarFamily, "2, 10");
		
		JComboBox GuitarBox = new JComboBox();
		panel.add(GuitarBox, "4, 10, fill, default");
		
		JLabel Percussion = new JLabel("Percussion");
		Percussion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(Percussion, "2, 12");
		
		JComboBox PercussionBox = new JComboBox();
		panel.add(PercussionBox, "4, 12, fill, default");
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
