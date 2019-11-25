
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.border.TitledBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.*;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;


import javax.swing.SwingConstants;
import javax.swing.AbstractAction;

import java.awt.Label;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.border.LineBorder;

import java.util.ArrayList;

public class MusicGeneratorDriver extends JFrame implements ActionListener {
   // UI - Algorithm mediator
   UIAlgorithmBridge medi = new UIAlgorithmBridge();
   
   // Action Buttons
   private JButton btnExit, btnSave, btnGenerate, btnPlay, btnPause;
   
   // Radio Buttons
   private JRadioButton secA_Happy_Button, secA_Calm_Button, secA_Sad_Button, secA_Intense_Button, secA_Oriental_Button, secA_Spooky_Button;
   private JRadioButton secB_Happy_Button, secB_Calm_Button, secB_Sad_Button, secB_Intense_Button, secB_Oriental_Button, secB_Spooky_Button;
   private JRadioButton secC_Happy_Button, secC_Calm_Button, secC_Sad_Button, secC_Intense_Button, secC_Oriental_Button, secC_Spooky_Button;
   
   private JRadioButton secA_Piano_Button, secA_Brass_Button, secA_Synth_Button, secA_Guitar_Button, secA_Strings_Button;
   private JRadioButton secB_Piano_Button, secB_Brass_Button, secB_Synth_Button, secB_Guitar_Button, secB_Strings_Button;
   private JRadioButton secC_Piano_Button, secC_Brass_Button, secC_Synth_Button, secC_Guitar_Button, secC_Strings_Button;
   
   private JPanel mainPanel;
   private final ButtonGroup secA_LeadInstrumentGroup = new ButtonGroup();
   private final ButtonGroup secA_ThemeGroup = new ButtonGroup();
   private final ButtonGroup secB_ThemeGroup = new ButtonGroup();
   private final ButtonGroup secB_LeadInstrumentGroup = new ButtonGroup();
   private final ButtonGroup secC_ThemeGroup = new ButtonGroup();
   private final ButtonGroup secC_LeadInstrumentGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
   public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
      UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
      EventQueue.invokeLater(
         new Runnable() {
            public void run() {
               try {
                  MusicGeneratorDriver frame = new MusicGeneratorDriver();
                  frame.setVisible(true);
               } 
               catch (Exception e) {
                  e.printStackTrace();
               }
            }
         });
   }
	
	/**
	 * This method will add one section panel when called
	 * @param p, the panel which will added to the mainPanel
	 */
   public void addPanel(JPanel p) {
      mainPanel.add(p);
      mainPanel.repaint();
      mainPanel.revalidate();
   }
	

	/**
	 * Create the frame.
	 */
   public MusicGeneratorDriver() {
      
      setFont(new Font("Myanmar Text", Font.BOLD, 13));
      setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Anbang Wang\\Desktop\\SDD_MusicGenerator_Image\\RMG_Icon.png"));
      setTitle("RandomMusicGenerator");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 1250, 700);
      mainPanel = new JPanel();
      mainPanel.setToolTipText("");
      setContentPane(mainPanel);
   	
   	// Exit button setup
      btnExit = new JButton("Exit");
      btnExit.setBounds(1000, 559, 200, 70);
      btnExit.setFont(new Font("΢���ź�", Font.BOLD, 30));
      btnExit.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
               System.exit(0);
            }
         });  
      mainPanel.setLayout(null);
      btnExit.setForeground(SystemColor.activeCaptionText);
      btnExit.setBackground(SystemColor.inactiveCaptionBorder);
      mainPanel.add(btnExit);
      
      // Save button
      btnSave = new JButton("Save");
      btnSave.setBounds(760, 559, 200, 70);
      btnSave.setForeground(Color.BLACK);
      btnSave.setFont(new Font("΢���ź�", Font.BOLD, 30));
      btnSave.setBackground(SystemColor.inactiveCaptionBorder);
      btnSave.addActionListener(this);
      mainPanel.add(btnSave);
   	
      
      // Generate button
      btnGenerate = new JButton("Generate");
      btnGenerate.setBounds(40, 559, 200, 70);
      btnGenerate.setForeground(Color.BLACK);
      btnGenerate.setFont(new Font("΢���ź�", Font.BOLD, 30));
      btnGenerate.setBackground(SystemColor.inactiveCaptionBorder);
      btnGenerate.addActionListener(this);
      mainPanel.add(btnGenerate);
   	
      
      // Load / Play button
      btnPlay = new JButton("Load");
      btnPlay.setForeground(Color.BLACK);
      btnPlay.setFont(new Font("΢���ź�", Font.BOLD, 30));
      btnPlay.setBackground(SystemColor.inactiveCaptionBorder);
      btnPlay.setBounds(280, 559, 200, 70);
      btnPlay.addActionListener(this);
      mainPanel.add(btnPlay);
   	
      
      // Pause / Unpause button
      btnPause = new JButton("Pause");
      btnPause.setForeground(Color.BLACK);
      btnPause.setFont(new Font("΢���ź�", Font.BOLD, 30));
      btnPause.setBackground(SystemColor.inactiveCaptionBorder);
      btnPause.setBounds(520, 559, 200, 70);
      btnPause.addActionListener(this);
      mainPanel.add(btnPause);
   	
      
      // Title setup
      JLabel UITitelLable = new JLabel("Red Giraffe Music Generator");
      UITitelLable.setBounds(346, 26, 601, 87);
      UITitelLable.setHorizontalAlignment(SwingConstants.CENTER);
      UITitelLable.setFont(new Font("Times New Roman", Font.BOLD, 35));
      mainPanel.add(UITitelLable);
   	
   	// Create new panel for each section 
      JPanel SectionA_Panel = new JPanel();
      JPanel SectionB_Panel = new JPanel();
      JPanel SectionC_Panel = new JPanel();
   	
      SectionA_Panel.setBorder(new LineBorder(new Color(128, 128, 128), 2, true));
      SectionA_Panel.setBounds(40, 124, 270, 341);
      mainPanel.add(SectionA_Panel);
      SectionA_Panel.setLayout(null);
   	
      JPanel SectionA_Theme_Panel = new JPanel();
      SectionA_Theme_Panel.setBounds(20, 61, 110, 210);
      SectionA_Panel.add(SectionA_Theme_Panel);
      SectionA_Theme_Panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Theme", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
      SectionA_Theme_Panel.setLayout(new FormLayout(new ColumnSpec[] {
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
   	
      JLabel secA_Happy_Label = new JLabel("Happy");
      secA_Happy_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
      SectionA_Theme_Panel.add(secA_Happy_Label, "2, 2");
   	
      secA_Happy_Button = new JRadioButton("");
      secA_ThemeGroup.add(secA_Happy_Button);
      SectionA_Theme_Panel.add(secA_Happy_Button, "4, 2");
   	
      JLabel secA_Calm_Label = new JLabel("Calm");
      secA_Calm_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
      SectionA_Theme_Panel.add(secA_Calm_Label, "2, 4");
   	
      secA_Calm_Button = new JRadioButton("");
      secA_ThemeGroup.add(secA_Calm_Button);
      SectionA_Theme_Panel.add(secA_Calm_Button, "4, 4");
   	
      JLabel secA_Sad_Label = new JLabel("Sad");
      secA_Sad_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
      SectionA_Theme_Panel.add(secA_Sad_Label, "2, 6");
   	
      secA_Sad_Button = new JRadioButton("");
      secA_ThemeGroup.add(secA_Sad_Button);
      SectionA_Theme_Panel.add(secA_Sad_Button, "4, 6");
   	
      JLabel secA_Intense_Label = new JLabel("Intense");
      secA_Intense_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
      SectionA_Theme_Panel.add(secA_Intense_Label, "2, 8");
   	
      secA_Intense_Button = new JRadioButton("");
      secA_ThemeGroup.add(secA_Intense_Button);
      SectionA_Theme_Panel.add(secA_Intense_Button, "4, 8");
   	
      JLabel secA_Oriental_Label = new JLabel("Oriental");
      secA_Oriental_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
      SectionA_Theme_Panel.add(secA_Oriental_Label, "2, 10");
   	
      secA_Oriental_Button = new JRadioButton("");
      secA_ThemeGroup.add(secA_Oriental_Button);
      SectionA_Theme_Panel.add(secA_Oriental_Button, "4, 10");
   	
      JLabel secA_Spooky_Label = new JLabel("Spooky");
      secA_Spooky_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
      SectionA_Theme_Panel.add(secA_Spooky_Label, "2, 12");
   	
      secA_Spooky_Button = new JRadioButton("");
      secA_ThemeGroup.add(secA_Spooky_Button);
      SectionA_Theme_Panel.add(secA_Spooky_Button, "4, 12");
   	
      JPanel SectionA_LeadInstrument_Panel = new JPanel();
      SectionA_LeadInstrument_Panel.setBounds(140, 61, 110, 210);
      SectionA_Panel.add(SectionA_LeadInstrument_Panel);
      SectionA_LeadInstrument_Panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Lead Instrument", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, Color.BLACK));
      SectionA_LeadInstrument_Panel.setLayout(new FormLayout(new ColumnSpec[] {
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
   	
      JLabel secA_Piano_Label = new JLabel("Piano");
      secA_Piano_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
      SectionA_LeadInstrument_Panel.add(secA_Piano_Label, "2, 2");
   	
      secA_Piano_Button = new JRadioButton("");
      secA_LeadInstrumentGroup.add(secA_Piano_Button);
      SectionA_LeadInstrument_Panel.add(secA_Piano_Button, "4, 2");
   	
      JLabel secA_Brass_Label = new JLabel("Brass");
      secA_Brass_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
      SectionA_LeadInstrument_Panel.add(secA_Brass_Label, "2, 4");
   	
      secA_Brass_Button = new JRadioButton("");
      secA_LeadInstrumentGroup.add(secA_Brass_Button);
      SectionA_LeadInstrument_Panel.add(secA_Brass_Button, "4, 4");
   	
      JLabel secA_Synth_Label = new JLabel("Synth");
      secA_Synth_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
      SectionA_LeadInstrument_Panel.add(secA_Synth_Label, "2, 6");
   	
      secA_Synth_Button = new JRadioButton("");
      secA_LeadInstrumentGroup.add(secA_Synth_Button);
      SectionA_LeadInstrument_Panel.add(secA_Synth_Button, "4, 6");
   	
      JLabel secA_Guitar_Label = new JLabel("Guitar");
      secA_Guitar_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
      SectionA_LeadInstrument_Panel.add(secA_Guitar_Label, "2, 8");
   	
      secA_Guitar_Button = new JRadioButton("");
      secA_LeadInstrumentGroup.add(secA_Guitar_Button);
      SectionA_LeadInstrument_Panel.add(secA_Guitar_Button, "4, 8");
   	
      JLabel secA_Strings_Label = new JLabel("Strings");
      secA_Strings_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
      SectionA_LeadInstrument_Panel.add(secA_Strings_Label, "2, 10");
   	
      secA_Strings_Button = new JRadioButton("");
      secA_LeadInstrumentGroup.add(secA_Strings_Button);
      SectionA_LeadInstrument_Panel.add(secA_Strings_Button, "4, 10");
   	
      JButton secA_AddSection_Button = new JButton("Add New Section");
      secA_AddSection_Button.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
               SectionB_Panel.show();
               secA_AddSection_Button.disable();
               secA_AddSection_Button.hide();
            }
         });
      secA_AddSection_Button.setBounds(70, 290, 130, 34);
      SectionA_Panel.add(secA_AddSection_Button);
   	
      Label secA_Title_Label = new Label("Section A");
      secA_Title_Label.setAlignment(Label.CENTER);
      secA_Title_Label.setFont(new Font("Dialog", Font.BOLD, 20));
      secA_Title_Label.setBounds(85, 20, 100, 28);
      SectionA_Panel.add(secA_Title_Label);
   	
   	
      SectionB_Panel.setBorder(new LineBorder(Color.GRAY, 2, true));
      SectionB_Panel.setBounds(345, 124, 270, 341);
      mainPanel.add(SectionB_Panel);
      SectionB_Panel.hide();
      SectionB_Panel.setLayout(null);
   	
      Label secB_Title_Label = new Label("Section B");
      secB_Title_Label.setFont(new Font("Dialog", Font.BOLD, 20));
      secB_Title_Label.setAlignment(Label.CENTER);
      secB_Title_Label.setBounds(85, 20, 100, 28);
      SectionB_Panel.add(secB_Title_Label);
   	
      JPanel SectionB_Theme_Panel = new JPanel();
      SectionB_Theme_Panel.setBounds(20, 61, 110, 210);
      SectionB_Panel.add(SectionB_Theme_Panel);
      SectionB_Theme_Panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Theme", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
      SectionB_Theme_Panel.setLayout(new FormLayout(new ColumnSpec[] {
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
   	
      JLabel secB_Happy_Label = new JLabel("Happy");
      secB_Happy_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
      SectionB_Theme_Panel.add(secB_Happy_Label, "2, 2");
   	
      secB_Happy_Button = new JRadioButton("");
      secB_ThemeGroup.add(secB_Happy_Button);
      SectionB_Theme_Panel.add(secB_Happy_Button, "4, 2");
   	
      JLabel secB_Calm_Label = new JLabel("Calm");
      secB_Calm_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
      SectionB_Theme_Panel.add(secB_Calm_Label, "2, 4");
   	
      secB_Calm_Button = new JRadioButton("");
      secB_ThemeGroup.add(secB_Calm_Button);
      SectionB_Theme_Panel.add(secB_Calm_Button, "4, 4");
   	
      JLabel secB_Sad_Label = new JLabel("Sad");
      secB_Sad_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
      SectionB_Theme_Panel.add(secB_Sad_Label, "2, 6");
   	
      secB_Sad_Button = new JRadioButton("");
      secB_ThemeGroup.add(secB_Sad_Button);
      SectionB_Theme_Panel.add(secB_Sad_Button, "4, 6");
   	
      JLabel secB_Intense_Label = new JLabel("Intense");
      secB_Intense_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
      SectionB_Theme_Panel.add(secB_Intense_Label, "2, 8");
   	
      secB_Intense_Button = new JRadioButton("");
      secB_ThemeGroup.add(secB_Intense_Button);
      SectionB_Theme_Panel.add(secB_Intense_Button, "4, 8");
   	
      JLabel secB_Oriental_Label = new JLabel("Oriental");
      secB_Oriental_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
      SectionB_Theme_Panel.add(secB_Oriental_Label, "2, 10");
   	
      secB_Oriental_Button = new JRadioButton("");
      secB_ThemeGroup.add(secB_Oriental_Button);
      SectionB_Theme_Panel.add(secB_Oriental_Button, "4, 10");
   	
      JLabel secB_Spooky_Label = new JLabel("Spooky");
      secB_Spooky_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
      SectionB_Theme_Panel.add(secB_Spooky_Label, "2, 12");
   	
      secB_Spooky_Button = new JRadioButton("");
      secB_ThemeGroup.add(secB_Spooky_Button);
      SectionB_Theme_Panel.add(secB_Spooky_Button, "4, 12");
   	
      JPanel SectionB_LeadInstrument_Panel = new JPanel();
      SectionB_LeadInstrument_Panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Lead Instrument", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
      SectionB_LeadInstrument_Panel.setBounds(152, 61, 100, 210);
      SectionB_Panel.add(SectionB_LeadInstrument_Panel);
      SectionB_LeadInstrument_Panel.setLayout(new FormLayout(new ColumnSpec[] {
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
   	
      JLabel secB_Piano_Label = new JLabel("Piano");
      secB_Piano_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
      SectionB_LeadInstrument_Panel.add(secB_Piano_Label, "2, 2");
   	
      secB_Piano_Button = new JRadioButton("");
      secB_LeadInstrumentGroup.add(secB_Piano_Button);
      SectionB_LeadInstrument_Panel.add(secB_Piano_Button, "4, 2");
   	
      JLabel secB_Brass_Label = new JLabel("Brass");
      secB_Brass_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
      SectionB_LeadInstrument_Panel.add(secB_Brass_Label, "2, 4");
   	
      secB_Brass_Button = new JRadioButton("");
      secB_LeadInstrumentGroup.add(secB_Brass_Button);
      SectionB_LeadInstrument_Panel.add(secB_Brass_Button, "4, 4");
   	
      JLabel secB_Synth_Label = new JLabel("Synth");
      secB_Synth_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
      SectionB_LeadInstrument_Panel.add(secB_Synth_Label, "2, 6");
   	
      secB_Synth_Button = new JRadioButton("");
      secB_LeadInstrumentGroup.add(secB_Synth_Button);
      SectionB_LeadInstrument_Panel.add(secB_Synth_Button, "4, 6");
   	
      JLabel secB_Guitar_Label = new JLabel("Guitar");
      secB_Guitar_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
      SectionB_LeadInstrument_Panel.add(secB_Guitar_Label, "2, 8");
   	
      secB_Guitar_Button = new JRadioButton("");
      secB_LeadInstrumentGroup.add(secB_Guitar_Button);
      SectionB_LeadInstrument_Panel.add(secB_Guitar_Button, "4, 8");
   	
      JLabel secB_Strings_Label = new JLabel("Strings");
      secB_Strings_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
      SectionB_LeadInstrument_Panel.add(secB_Strings_Label, "2, 10");
   	
      secB_Strings_Button = new JRadioButton("");
      secB_LeadInstrumentGroup.add(secB_Strings_Button);
      SectionB_LeadInstrument_Panel.add(secB_Strings_Button, "4, 10");
   	
      JButton secB_AddSection_Button = new JButton("Add New Section");
      secB_AddSection_Button.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
               SectionC_Panel.show();
               secB_AddSection_Button.disable();
               secB_AddSection_Button.hide();
            }
         });
      secB_AddSection_Button.setBounds(70, 290, 130, 34);
      SectionB_Panel.add(secB_AddSection_Button);
   	
      SectionC_Panel.setBorder(new LineBorder(Color.GRAY, 2, true));
      SectionC_Panel.setBounds(650, 124, 270, 341);
      mainPanel.add(SectionC_Panel);
      SectionC_Panel.hide();
      SectionC_Panel.setLayout(null);
   	
      JPanel SectionC_Theme_Panel = new JPanel();
      SectionC_Theme_Panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Theme", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
      SectionC_Theme_Panel.setBounds(20, 61, 110, 210);
      SectionC_Panel.add(SectionC_Theme_Panel);
      SectionC_Theme_Panel.setLayout(new FormLayout(new ColumnSpec[] {
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
   	
      JLabel secC_Happy_Label = new JLabel("Happy");
      secC_Happy_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
      SectionC_Theme_Panel.add(secC_Happy_Label, "2, 2");
   	
      secC_Happy_Button = new JRadioButton("");
      secC_ThemeGroup.add(secC_Happy_Button);
      SectionC_Theme_Panel.add(secC_Happy_Button, "4, 2");
   	
      JLabel secC_Calm_Label = new JLabel("Calm");
      secC_Calm_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
      SectionC_Theme_Panel.add(secC_Calm_Label, "2, 4");
   	
      secC_Calm_Button = new JRadioButton("");
      secC_ThemeGroup.add(secC_Calm_Button);
      SectionC_Theme_Panel.add(secC_Calm_Button, "4, 4");
   	
      JLabel secC_Sad_Label = new JLabel("Sad");
      secC_Sad_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
      SectionC_Theme_Panel.add(secC_Sad_Label, "2, 6");
   	
      secC_Sad_Button = new JRadioButton("");
      secC_ThemeGroup.add(secC_Sad_Button);
      SectionC_Theme_Panel.add(secC_Sad_Button, "4, 6");
   	
      JLabel secC_Intense_Label = new JLabel("Intense");
      secC_Intense_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
      SectionC_Theme_Panel.add(secC_Intense_Label, "2, 8");
   	
      secC_Intense_Button = new JRadioButton("");
      secC_ThemeGroup.add(secC_Intense_Button);
      SectionC_Theme_Panel.add(secC_Intense_Button, "4, 8");
   	
      JLabel secC_Oriental_Label = new JLabel("Oriental");
      secC_Oriental_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
      SectionC_Theme_Panel.add(secC_Oriental_Label, "2, 10");
   	
      secC_Oriental_Button = new JRadioButton("");
      secC_ThemeGroup.add(secC_Oriental_Button);
      SectionC_Theme_Panel.add(secC_Oriental_Button, "4, 10");
   	
      JLabel secC_Spooky_Label = new JLabel("Spooky");
      secC_Spooky_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
      SectionC_Theme_Panel.add(secC_Spooky_Label, "2, 12");
   	
      secC_Spooky_Button = new JRadioButton("");
      secC_ThemeGroup.add(secC_Spooky_Button);
      SectionC_Theme_Panel.add(secC_Spooky_Button, "4, 12");
   	
      JPanel SectionC_LeadInstrument_Panel = new JPanel();
      SectionC_LeadInstrument_Panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Lead Instrument", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
      SectionC_LeadInstrument_Panel.setBounds(140, 61, 110, 210);
      SectionC_Panel.add(SectionC_LeadInstrument_Panel);
      SectionC_LeadInstrument_Panel.setLayout(new FormLayout(new ColumnSpec[] {
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
   	
      JLabel secC_Piano_Label = new JLabel("Piano");
      secC_Piano_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
      SectionC_LeadInstrument_Panel.add(secC_Piano_Label, "2, 2");
   	
      secC_Piano_Button = new JRadioButton("");
      secC_LeadInstrumentGroup.add(secC_Piano_Button);
      SectionC_LeadInstrument_Panel.add(secC_Piano_Button, "4, 2");
   	
      JLabel secC_Brass_Label = new JLabel("Brass");
      secC_Brass_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
      SectionC_LeadInstrument_Panel.add(secC_Brass_Label, "2, 4");
   	
      secC_Brass_Button = new JRadioButton("");
      secC_LeadInstrumentGroup.add(secC_Brass_Button);
      SectionC_LeadInstrument_Panel.add(secC_Brass_Button, "4, 4");
   	
      JLabel secC_Synth_Label = new JLabel("Synth");
      secC_Synth_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
      SectionC_LeadInstrument_Panel.add(secC_Synth_Label, "2, 6");
   	
      secC_Synth_Button = new JRadioButton("");
      secC_LeadInstrumentGroup.add(secC_Synth_Button);
      SectionC_LeadInstrument_Panel.add(secC_Synth_Button, "4, 6");
   	
      JLabel secC_Guitar_Label = new JLabel("Guitar");
      secC_Guitar_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
      SectionC_LeadInstrument_Panel.add(secC_Guitar_Label, "2, 8");
   	
      secC_Guitar_Button = new JRadioButton("");
      secC_LeadInstrumentGroup.add(secC_Guitar_Button);
      SectionC_LeadInstrument_Panel.add(secC_Guitar_Button, "4, 8");
   	
      JLabel secC_Strings_Label = new JLabel("Strings");
      secC_Strings_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
      SectionC_LeadInstrument_Panel.add(secC_Strings_Label, "2, 10");
   	
      secC_Strings_Button = new JRadioButton("");
      secC_LeadInstrumentGroup.add(secC_Strings_Button);
      SectionC_LeadInstrument_Panel.add(secC_Strings_Button, "4, 10");
   	
      Label secC_Title_Label = new Label("Section C");
      secC_Title_Label.setFont(new Font("Dialog", Font.BOLD, 20));
      secC_Title_Label.setAlignment(Label.CENTER);
      secC_Title_Label.setBounds(85, 20, 100, 28);
      SectionC_Panel.add(secC_Title_Label);
   	
   	//JButton secC_AddSection_Button = new JButton("Add New Section");
   	//secC_AddSection_Button.setBounds(70, 290, 130, 34);
   	//SectionC_Panel.add(secC_AddSection_Button);
   }
   
   public void actionPerformed(ActionEvent e) {
      String action = e.getActionCommand();
      UIRequest thisRequest;
      //System.out.println(action);
      if(action.equals("Generate") == true)
         thisRequest = createGenerateRequest(0);
      else if(action.equals("Pause") == true) {
         thisRequest = createGenerateRequest(1);
         btnPause.setText("Unpause");
      }
      else if(action.equals("Save") == true)
         thisRequest = createGenerateRequest(2);
      else if(action.equals("Load") == true) {
         btnPlay.setText("Play");
         thisRequest = createGenerateRequest(3);
      }
      else if(action.equals("Play") == true) {
         thisRequest = createGenerateRequest(4);
         btnPlay.setText("Load");
      }
      else /*if(action.equals("Unpause") == true)*/ {
         thisRequest = createGenerateRequest(5);
         btnPause.setText("Pause");
      }
      
      medi.acceptRequest(thisRequest);
   }
   
   private class SwingAction extends AbstractAction {
      public SwingAction() {
         putValue(NAME, "SwingAction");
         putValue(SHORT_DESCRIPTION, "Some short description");
      }
      public void actionPerformed(ActionEvent e) {
      }
   }
   
   public UIRequest createGenerateRequest(int ReqType) {
      // For parameter ReqType: 
      // 0 = Generate 
      // 1 = Pause 
      // 2 = Save
      // 3 = Browse
      // 4 = PlayLoaded
      // 5 = Unpause
      // Need request type, leading instrument(s), theme(s)
      // Request
      UIEnums.RequestType req;
      if(ReqType == 0)
         req = UIEnums.RequestType.GENERATE;
      else if(ReqType == 1)
         req = UIEnums.RequestType.PAUSE;
      else if(ReqType == 2)
         req = UIEnums.RequestType.SAVE;
      else if(ReqType == 3)
         req = UIEnums.RequestType.BROWSE;
      else if(ReqType == 4)
         req = UIEnums.RequestType.PLAYLOADED;
      else //if(ReqType == 5)
         req = UIEnums.RequestType.UNPAUSE;
         
      // Reading in themes
      ArrayList<UIEnums.Theme> themes = new ArrayList<UIEnums.Theme>();
      // Section A
      if(secA_Happy_Button.isSelected() == true)
         themes.add(UIEnums.Theme.HAPPY);
      else if(secA_Calm_Button.isSelected() == true)
         themes.add(UIEnums.Theme.CALM);
      else if(secA_Sad_Button.isSelected() == true)
         themes.add(UIEnums.Theme.SAD);
      else if(secA_Intense_Button.isSelected() == true)
         themes.add(UIEnums.Theme.INTENSE);
      else if(secA_Oriental_Button.isSelected() == true)
         themes.add(UIEnums.Theme.ORIENTAL);
      else if(secA_Spooky_Button.isSelected() == true)
         themes.add(UIEnums.Theme.SPOOKY);
        
      // Section B
      if(secB_Happy_Button.isSelected() == true)
         themes.add(UIEnums.Theme.HAPPY);
      else if(secB_Calm_Button.isSelected() == true)
         themes.add(UIEnums.Theme.CALM);
      else if(secB_Sad_Button.isSelected() == true)
         themes.add(UIEnums.Theme.SAD);
      else if(secB_Intense_Button.isSelected() == true)
         themes.add(UIEnums.Theme.INTENSE);
      else if(secB_Oriental_Button.isSelected() == true)
         themes.add(UIEnums.Theme.ORIENTAL);
      else if(secB_Spooky_Button.isSelected() == true)
         themes.add(UIEnums.Theme.SPOOKY);
         
      // Section C 
      if(secC_Happy_Button.isSelected() == true)
         themes.add(UIEnums.Theme.HAPPY);
      else if(secC_Calm_Button.isSelected() == true)
         themes.add(UIEnums.Theme.CALM);
      else if(secC_Sad_Button.isSelected() == true)
         themes.add(UIEnums.Theme.SAD);
      else if(secC_Intense_Button.isSelected() == true)
         themes.add(UIEnums.Theme.INTENSE);
      else if(secC_Oriental_Button.isSelected() == true)
         themes.add(UIEnums.Theme.ORIENTAL);
      else if(secC_Spooky_Button.isSelected() == true)
         themes.add(UIEnums.Theme.SPOOKY);
         
      // Reading in leading instruments
      ArrayList<UIEnums.Instrument> instruments = new ArrayList<UIEnums.Instrument>();
      // Section A
      if(secA_Piano_Button.isSelected() == true)
         instruments.add(UIEnums.Instrument.PIANO);
      else if(secA_Brass_Button.isSelected() == true)
         instruments.add(UIEnums.Instrument.BRASS);
      else if(secA_Synth_Button.isSelected() == true)
         instruments.add(UIEnums.Instrument.SYNTH);
      else if(secA_Guitar_Button.isSelected() == true)
         instruments.add(UIEnums.Instrument.GUITAR);
      else if(secA_Strings_Button.isSelected() == true)
         instruments.add(UIEnums.Instrument.STRINGS);
      
      // Section B
      if(secB_Piano_Button.isSelected() == true)
         instruments.add(UIEnums.Instrument.PIANO);
      else if(secB_Brass_Button.isSelected() == true)
         instruments.add(UIEnums.Instrument.BRASS);
      else if(secB_Synth_Button.isSelected() == true)
         instruments.add(UIEnums.Instrument.SYNTH);
      else if(secB_Guitar_Button.isSelected() == true)
         instruments.add(UIEnums.Instrument.GUITAR);
      else if(secB_Strings_Button.isSelected() == true)
         instruments.add(UIEnums.Instrument.STRINGS);
         
     // Section C
      if(secC_Piano_Button.isSelected() == true)
         instruments.add(UIEnums.Instrument.PIANO);
      else if(secC_Brass_Button.isSelected() == true)
         instruments.add(UIEnums.Instrument.BRASS);
      else if(secC_Synth_Button.isSelected() == true)
         instruments.add(UIEnums.Instrument.SYNTH);
      else if(secC_Guitar_Button.isSelected() == true)
         instruments.add(UIEnums.Instrument.GUITAR);
      else if(secC_Strings_Button.isSelected() == true)
         instruments.add(UIEnums.Instrument.STRINGS);
         
      return new UIRequest(req, instruments, themes);
   }
}
