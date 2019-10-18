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

public class MusicGeneratorDriver extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	private final ButtonGroup buttonGroup_4 = new ButtonGroup();

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
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		setContentPane(contentPane);
		
		// Exit button setup
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.setBounds(730, 440, 200, 70);
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		contentPane.setLayout(null);
		btnNewButton.setForeground(SystemColor.activeCaptionText);
		btnNewButton.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.add(btnNewButton);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(400, 440, 200, 70);
		btnSave.setForeground(Color.BLACK);
		btnSave.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 30));
		btnSave.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.add(btnSave);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setBounds(70, 440, 200, 70);
		btnGenerate.setForeground(Color.BLACK);
		btnGenerate.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 30));
		btnGenerate.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.add(btnGenerate);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Key Signature", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.activeCaptionText));
		panel.setBounds(70, 130, 100, 250);
		contentPane.add(panel);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
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
		panel.add(lblNewLabel, "2, 2");
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("");
		buttonGroup.add(rdbtnNewRadioButton);
		panel.add(rdbtnNewRadioButton, "4, 2");
		
		JLabel lblNewLabel_1 = new JLabel("F");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblNewLabel_1, "2, 4");
		
		JRadioButton radioButton = new JRadioButton("");
		buttonGroup.add(radioButton);
		panel.add(radioButton, "4, 4");
		
		JLabel lblG = new JLabel("G");
		lblG.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblG, "2, 6");
		
		JRadioButton radioButton_1 = new JRadioButton("");
		buttonGroup.add(radioButton_1);
		panel.add(radioButton_1, "4, 6");
		
		JLabel lblD = new JLabel("D");
		lblD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblD, "2, 8");
		
		JRadioButton radioButton_2 = new JRadioButton("");
		buttonGroup.add(radioButton_2);
		panel.add(radioButton_2, "4, 8");
		
		JLabel lblA = new JLabel("A");
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblA, "2, 10");
		
		JRadioButton radioButton_3 = new JRadioButton("");
		buttonGroup.add(radioButton_3);
		panel.add(radioButton_3, "4, 10");
		
		JLabel lblE = new JLabel("E");
		lblE.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblE, "2, 12");
		
		JRadioButton radioButton_4 = new JRadioButton("");
		buttonGroup.add(radioButton_4);
		panel.add(radioButton_4, "4, 12");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Time Signature", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(195, 130, 100, 250);
		contentPane.add(panel_1);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
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
		panel_1.add(lblNewLabel_2, "2, 2");
		
		JRadioButton radioButton_5 = new JRadioButton("");
		buttonGroup_1.add(radioButton_5);
		panel_1.add(radioButton_5, "4, 2");
		
		JLabel label = new JLabel("(2,2)");
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_1.add(label, "2, 4");
		
		JRadioButton radioButton_6 = new JRadioButton("");
		buttonGroup_1.add(radioButton_6);
		panel_1.add(radioButton_6, "4, 4");
		
		JLabel label_1 = new JLabel("(2,4)");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_1.add(label_1, "2, 6");
		
		JRadioButton radioButton_7 = new JRadioButton("");
		buttonGroup_1.add(radioButton_7);
		panel_1.add(radioButton_7, "4, 6");
		
		JLabel label_2 = new JLabel("(3,4)");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_1.add(label_2, "2, 8");
		
		JRadioButton radioButton_8 = new JRadioButton("");
		buttonGroup_1.add(radioButton_8);
		panel_1.add(radioButton_8, "4, 8");
		
		JLabel label_3 = new JLabel("(3,8)");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_1.add(label_3, "2, 10");
		
		JRadioButton radioButton_9 = new JRadioButton("");
		buttonGroup_1.add(radioButton_9);
		panel_1.add(radioButton_9, "4, 10");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Instruments", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(320, 130, 100, 250);
		contentPane.add(panel_2);
		panel_2.setLayout(new FormLayout(new ColumnSpec[] {
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
		panel_2.add(lblNewLabel_3, "2, 2");
		
		JRadioButton radioButton_10 = new JRadioButton("");
		buttonGroup_2.add(radioButton_10);
		panel_2.add(radioButton_10, "4, 2");
		
		JLabel lblPiano = new JLabel("Piano");
		lblPiano.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_2.add(lblPiano, "2, 4");
		
		JRadioButton radioButton_11 = new JRadioButton("");
		buttonGroup_2.add(radioButton_11);
		panel_2.add(radioButton_11, "4, 4");
		
		JLabel lblGuitar = new JLabel("Guitar");
		lblGuitar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_2.add(lblGuitar, "2, 6");
		
		JRadioButton radioButton_12 = new JRadioButton("");
		buttonGroup_2.add(radioButton_12);
		panel_2.add(radioButton_12, "4, 6");
		
		JLabel lblViolin = new JLabel("Violin");
		lblViolin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_2.add(lblViolin, "2, 8");
		
		JRadioButton radioButton_13 = new JRadioButton("");
		buttonGroup_2.add(radioButton_13);
		panel_2.add(radioButton_13, "4, 8");
		
		JLabel lblTrumpet = new JLabel("Trumpet");
		lblTrumpet.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_2.add(lblTrumpet, "2, 10");
		
		JRadioButton radioButton_14 = new JRadioButton("");
		buttonGroup_2.add(radioButton_14);
		panel_2.add(radioButton_14, "4, 10");
		
		JLabel lblHarp = new JLabel("Harp");
		lblHarp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_2.add(lblHarp, "2, 12");
		
		JRadioButton radioButton_15 = new JRadioButton("");
		buttonGroup_2.add(radioButton_15);
		panel_2.add(radioButton_15, "4, 12");
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Tempo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(445, 130, 155, 291);
		contentPane.add(panel_3);
		panel_3.setLayout(new FormLayout(new ColumnSpec[] {
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
		panel_3.add(lblNewLabel_4, "2, 2");
		
		JRadioButton radioButton_16 = new JRadioButton("");
		buttonGroup_3.add(radioButton_16);
		panel_3.add(radioButton_16, "4, 2");
		
		JLabel lblLargo = new JLabel("Larghetto 50 BPM");
		lblLargo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_3.add(lblLargo, "2, 4");
		
		JRadioButton radioButton_17 = new JRadioButton("");
		buttonGroup_3.add(radioButton_17);
		panel_3.add(radioButton_17, "4, 4");
		
		JLabel lblLento = new JLabel("Adagio 60 BPM");
		lblLento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_3.add(lblLento, "2, 6");
		
		JRadioButton radioButton_18 = new JRadioButton("");
		buttonGroup_3.add(radioButton_18);
		panel_3.add(radioButton_18, "4, 6");
		
		JLabel lblAdagio = new JLabel("Andantte 70 BPM");
		lblAdagio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_3.add(lblAdagio, "2, 8");
		
		JRadioButton radioButton_19 = new JRadioButton("");
		buttonGroup_3.add(radioButton_19);
		panel_3.add(radioButton_19, "4, 8");
		
		JLabel lblAndante = new JLabel("Andantino 80 BPM");
		lblAndante.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_3.add(lblAndante, "2, 10");
		
		JRadioButton radioButton_20 = new JRadioButton("");
		buttonGroup_3.add(radioButton_20);
		panel_3.add(radioButton_20, "4, 10");
		
		JLabel lblModeratoBpm = new JLabel("Moderato 95 BPM");
		lblModeratoBpm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_3.add(lblModeratoBpm, "2, 12");
		
		JRadioButton radioButton_27 = new JRadioButton("");
		panel_3.add(radioButton_27, "4, 12");
		
		JLabel lblAllegroBpm = new JLabel("Allegro 120 BPM");
		lblAllegroBpm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_3.add(lblAllegroBpm, "2, 14");
		
		JRadioButton radioButton_28 = new JRadioButton("");
		panel_3.add(radioButton_28, "4, 14");
		
		JLabel lblVivaceBpm = new JLabel("Vivace 145 BPM");
		lblVivaceBpm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_3.add(lblVivaceBpm, "2, 16");
		
		JRadioButton radioButton_29 = new JRadioButton("");
		panel_3.add(radioButton_29, "4, 16");
		
		JLabel lblPrestoBpm = new JLabel("Presto 180 BPM");
		lblPrestoBpm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_3.add(lblPrestoBpm, "2, 18");
		
		JRadioButton radioButton_30 = new JRadioButton("");
		panel_3.add(radioButton_30, "4, 18");
		
		JLabel lblPretissimoBpm = new JLabel("Pretissimo 220 BPM");
		lblPretissimoBpm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_3.add(lblPretissimoBpm, "2, 20");
		
		JRadioButton radioButton_31 = new JRadioButton("");
		panel_3.add(radioButton_31, "4, 20");
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Emotions", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(628, 130, 110, 250);
		contentPane.add(panel_4);
		panel_4.setLayout(new FormLayout(new ColumnSpec[] {
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
		panel_4.add(lblNewLabel_5, "2, 2");
		
		JRadioButton radioButton_21 = new JRadioButton("");
		buttonGroup_4.add(radioButton_21);
		panel_4.add(radioButton_21, "4, 2");
		
		JLabel lblExcitement = new JLabel("Excitement");
		lblExcitement.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_4.add(lblExcitement, "2, 4");
		
		JRadioButton radioButton_22 = new JRadioButton("");
		buttonGroup_4.add(radioButton_22);
		panel_4.add(radioButton_22, "4, 4");
		
		JLabel lblSurprise = new JLabel("Surprise");
		lblSurprise.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_4.add(lblSurprise, "2, 6");
		
		JRadioButton radioButton_23 = new JRadioButton("");
		buttonGroup_4.add(radioButton_23);
		panel_4.add(radioButton_23, "4, 6");
		
		JLabel lblSadness = new JLabel("Sadness");
		lblSadness.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_4.add(lblSadness, "2, 8");
		
		JRadioButton radioButton_24 = new JRadioButton("");
		buttonGroup_4.add(radioButton_24);
		panel_4.add(radioButton_24, "4, 8");
		
		JLabel lblDepress = new JLabel("Depress");
		lblDepress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_4.add(lblDepress, "2, 10");
		
		JRadioButton radioButton_25 = new JRadioButton("");
		buttonGroup_4.add(radioButton_25);
		panel_4.add(radioButton_25, "4, 10");
		
		JLabel lblCure = new JLabel("Cure");
		lblCure.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_4.add(lblCure, "2, 12");
		
		JRadioButton radioButton_26 = new JRadioButton("");
		buttonGroup_4.add(radioButton_26);
		panel_4.add(radioButton_26, "4, 12");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.addItem("Simple whole rhythms");
		comboBox.addItem("Complex fractional rhythms");
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(710, 75, 220, 44);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_6 = new JLabel("Rhythm Complexity");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(710, 40, 155, 35);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Title Goes Here");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblNewLabel_7.setBounds(70, 26, 601, 87);
		contentPane.add(lblNewLabel_7);
	}
}
