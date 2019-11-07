/*

  __  __           _       _____                           _             _____       _                
 |  \/  |         (_)     / ____|                         | |           |  __ \     (_)               
 | \  / |_   _ ___ _  ___| |  __  ___ _ __   ___ _ __ __ _| |_ ___  _ __| |  | |_ __ ___   _____ _ __ 
 | |\/| | | | / __| |/ __| | |_ |/ _ \ '_ \ / _ \ '__/ _` | __/ _ \| '__| |  | | '__| \ \ / / _ \ '__|
 | |  | | |_| \__ \ | (__| |__| |  __/ | | |  __/ | | (_| | || (_) | |  | |__| | |  | |\ V /  __/ |   
 |_|  |_|\__,_|___/_|\___|\_____|\___|_| |_|\___|_|  \__,_|\__\___/|_|  |_____/|_|  |_| \_/ \___|_|   
                                                                                                     
This file is used to run the UI, and is the entry point for the entire program.                                                                                                   

*/

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MusicGeneratorDriver extends Frame {
   // UI Bridge.
   private UIAlgorithmBridge Interface = new UIAlgorithmBridge();
   // Buttons
   private Button generateButton;
   private Button exitButton;
   private Button saveButton;
   // check box groups
   private CheckboxGroup leadingInstrument, theme, emotion;
   
   // supporting options lists for each of the checkbox group
   private String[] leadingInstrumentList = {"Piano","Trumpet","Flute","Guitar","Choir","Strings","Violin"};
   private String[] themeList = {"Calm","Intense"};
   private String[] emotionList = {"Happy","Sad"};
   
   
   // Constructor for the driver, which contains most of the functionality for the UI.
   public MusicGeneratorDriver() {
      
      // add the default window(frame) closing method
      addWindowListener(
         new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
               dispose();
            }
         });
     
      //setLayout(new FlowLayout());
      
      // create generate button
      generateButton = new Button("Generate");
      generateButton.setBounds(40,60,100,50);
      add(generateButton);
      generateButton.addActionListener(
         new ActionListener(){
            public void actionPerformed(ActionEvent e) {
               UIRequest thisReq = createGenerateRequest(0);
               Interface.acceptRequest(thisReq);
            }
         }
         );
      
      // create exit button
      exitButton = new Button("Exit");
      exitButton.addActionListener(
         new ActionListener(){
            public void actionPerformed(ActionEvent e){
               // createGenerateRequest(1) ??
               System.exit(0);
            }
         });
      exitButton.setBounds(150, 60, 100, 50);
      //todo using selectionListener to exit the shell
      add(exitButton);
      
      // create save button
      saveButton = new Button("Save");
      saveButton.addActionListener(
         new ActionListener(){
            public void actionPerformed(ActionEvent e) {
               UIRequest thisReq = createGenerateRequest(2);
               Interface.acceptRequest(thisReq);
            }
         }
         );
      saveButton.setBounds(260, 60, 100, 50);
      add(saveButton);
      
      
      // create the checkbox groups on frame
      Label li, thm, emo;
      li = new Label("Lead Instrument");
      li.setBounds(50,150,85,30);
      add(li);
      thm = new Label("Theme");
      thm.setBounds(200, 150, 85, 30);
      add(thm);
      emo = new Label("Emotion");
      emo.setBounds(350, 150, 85, 30);
      add(emo);
      
        
      leadingInstrument = new CheckboxGroup();
      theme = new CheckboxGroup();
      emotion = new CheckboxGroup();
      setCheckboxGroup(leadingInstrument, leadingInstrumentList, 50, 200, 80, 40);     
      setCheckboxGroup(theme, themeList, 200, 200, 80, 40);     
      setCheckboxGroup(emotion, emotionList, 350, 200, 80, 40);    
      
      // set title and screen size
      setTitle("Music Generator");
      setSize(900, 500);
      
      setLayout(null);
      setVisible(true);
   }
   
   public void setCheckboxGroup(CheckboxGroup g, String[] arr, int x, int y, int w, int h ) {
      for(int i=0;i<arr.length;i++) {
         Checkbox c = new Checkbox(arr[i], g, false);
         c.setBounds(x, (y+i*h), w, h);
         this.add(c);
         
      }
   }
   
   // Uses the current configuration of the UI to create the UIRequest object.
   public UIRequest createGenerateRequest(int ReqType) {
      // For parameter ReqType: 0 = Generate 1 = Exit 2 = Save
      // Need request type, leading instrument, theme, emotion
      // Request
      UIEnums.RequestType req;
      if(ReqType == 0)
         req = UIEnums.RequestType.GENERATE;
      else if(ReqType == 2)
         req = UIEnums.RequestType.SAVE;
      else 
         req = UIEnums.RequestType.EXIT;
         
      // Pattern type
      UIEnums.PatternType pat = UIEnums.PatternType.HAPPYCALM;
      if(theme.getSelectedCheckbox() == null || emotion.getSelectedCheckbox() == null) {
         pat = UIEnums.PatternType.HAPPYCALM; // This is what I'd like to be ^_^
      }
      else {
         UIEnums.PatternType[] pats = {UIEnums.PatternType.SADCALM, UIEnums.PatternType.SADINTENSE, UIEnums.PatternType.HAPPYCALM, UIEnums.PatternType.HAPPYINTENSE};
         String[] choices = {"SadCalm","SadIntense","HappyCalm","HappyIntense"};
         String t = theme.getSelectedCheckbox().getLabel();
         String e = emotion.getSelectedCheckbox().getLabel();
         for(int i = 0; i < pats.length; i++) {
            if(choices[i].equals(e+t))
               pat = pats[i];
         }
      }
      
      // Leading instrument
      UIEnums.LeadingInstrument lead = UIEnums.LeadingInstrument.PIANO;
      if(leadingInstrument.getSelectedCheckbox() == null) {
         lead = UIEnums.LeadingInstrument.PIANO;
      }
      else {
         String l = leadingInstrument.getSelectedCheckbox().getLabel();
         UIEnums.LeadingInstrument[] leads = {UIEnums.LeadingInstrument.PIANO, UIEnums.LeadingInstrument.FLUTE, UIEnums.LeadingInstrument.TRUMPET, UIEnums.LeadingInstrument.GUITAR,
		 UIEnums.LeadingInstrument.CHOIR, UIEnums.LeadingInstrument.STRINGS, UIEnums.LeadingInstrument.VIOLIN};
         String[] choices2 = {"Piano","Trumpet","Flute","Guitar","Choir","Strings","Violin"};
         for(int i = 0; i < leads.length; i++) {
            if(choices2[i].equals(l))
               lead = leads[i];
         }
      }
            
      // Create UIRequest object with the enums.
      UIRequest thisRequest = new UIRequest(req, pat, lead);
      return thisRequest;
   }
   
   public static void main (String args[]) {
      MusicGeneratorDriver app = new MusicGeneratorDriver();
   }
}