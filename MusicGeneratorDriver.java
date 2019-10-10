import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MusicGeneratorDriver extends Frame implements ActionListener {
   // UI Bridge.
   private UIAlgorithmBridge Interface = new UIAlgorithmBridge();
   // Buttons
   private Button generateButton;
   private Button exitButton;
   // check box groups
   private CheckboxGroup keySignature, timeSignature, instruments, tempo, durationofPiece, emotions, melodyType;
   private Checkbox chkDisjunct;
   private Checkbox chkConjunct;
   
   // supporting options lists for each of the checkbox group
   private String[] keySignatureList = {"C","F","G","D","A","E"};
   private String[] timeSignatureList = {"4,4","2,2","2,4","3,4","3,8"};
   private String[] instrumentsList = {"Keyboard","Piano","Guitar","Violin","Trumpet","Harp"};
   private String[] tempoList = {"Tempo","Grave","Largo","Lento","Adagio","Andante"};
   private String[] emotionList = {"Joy","Excitement","Surprise","Sadness","Depress","Cure"};
   
   
   
   
   public MusicGeneratorDriver() {
	   
	   // add the default window(frame) closing method
	   addWindowListener(new WindowAdapter() {
		   public void windowClosing(WindowEvent e) {
			   dispose();
		   }
	   });
	  
      //setLayout(new FlowLayout());
      
	   // create generate button
      generateButton = new Button("Generate");
      generateButton.setBounds(40,60,100,50);
      add(generateButton);
      generateButton.addActionListener(this);
      
      // create exit button
      exitButton = new Button("Exit");
      exitButton.setBounds(750, 380, 100, 50);
      //todo using selectionListener to exit the shell
      add(exitButton);
      
      melodyType = new CheckboxGroup();
      chkDisjunct = new Checkbox("Disjunct", false, melodyType);
      chkDisjunct.setBounds(250, 80, 80, 30);
      chkConjunct = new Checkbox("Conjunct", false, melodyType);
      chkConjunct.setBounds(350, 80, 80, 30);
      add(chkDisjunct);
      add(chkConjunct);
      
      
      // create the checkbox groups on frame
      Label ks, ts, ins, tem, emo;
      ks = new Label("Key Signature");
      ks.setBounds(70,150,85,30);
      add(ks);
      ts = new Label("Time Signature");
      ts.setBounds(180, 150, 85, 30);
      add(ts);
      ins = new Label("Instruments");
      ins.setBounds(300, 150, 85, 30);
      add(ins);
      tem = new Label("Tempo");
      tem.setBounds(400, 150, 85, 30);
      add(tem);
      emo = new Label("Emotion");
      emo.setBounds(500, 150, 85, 30);
      add(emo);
      
        
      keySignature = new CheckboxGroup();
      timeSignature = new CheckboxGroup();
      instruments = new CheckboxGroup();
      tempo = new CheckboxGroup();
      emotions = new CheckboxGroup();
      setCheckboxGroup(keySignature, keySignatureList, 100, 200, 80, 40);     
      setCheckboxGroup(timeSignature, timeSignatureList, 200, 200, 80, 40);     
      setCheckboxGroup(instruments, instrumentsList, 300, 200, 80, 40);    
      setCheckboxGroup(tempo, tempoList, 400, 200, 80, 40); 
      setCheckboxGroup(emotions, emotionList, 500, 200, 80, 40);
      
      // set title and screen size
      setTitle("Music Generator");
      setSize(900, 500);
      
      setLayout(null);
      setVisible(true);
   }
   
   @Override
   public void actionPerformed(ActionEvent evt) {
      System.out.println("Generate clicked. Creating UI Request.");
      UIRequest gen = createGenerateRequest();
      if(Interface.acceptRequest(gen)) {
         System.out.println("Request accepted.");
      }
      else {
         System.out.println("Request denied.");
      }
   }
   
   public void setCheckboxGroup(CheckboxGroup g, String[] arr, int x, int y, int w, int h ) {
	   
	   for(int i=0;i<arr.length;i++) {
		   Checkbox c = new Checkbox(arr[i], g, false);
		   c.setBounds(x, (y+i*h), w, h);
		   this.add(c);
		   
	   }
   }
   
   // Uses the current configuration of the UI to create the UIRequest object.
   public UIRequest createGenerateRequest() {
      // Need request type, key, key signature, tempo, emotion
      // Request
      UIEnums.RequestType req = UIEnums.RequestType.GENERATE;
      
      // Key
      UIEnums.Key key;
      switch(keySignature.getSelectedCheckbox().getLabel()) {
         case "C": key = UIEnums.Key.C;
         case "F": key = UIEnums.Key.F;
         case "G": key = UIEnums.Key.G;
         case "D": key = UIEnums.Key.D;
         case "A": key = UIEnums.Key.A;
         case "E": key = UIEnums.Key.E;
         default: key = UIEnums.Key.C;
      }
      
      // Key Signature
      UIEnums.KeySignature keysig;
      switch(timeSignature.getSelectedCheckbox().getLabel()) {
         case "4,4": keysig = UIEnums.KeySignature.FOURFOUR;
         case "2,2": keysig = UIEnums.KeySignature.TWOTWO;
         case "2,4": keysig = UIEnums.KeySignature.TWOFOUR;
         case "3,4": keysig = UIEnums.KeySignature.THREEFOUR;
         case "3,8": keysig = UIEnums.KeySignature.THREEEIGHT;
         default: keysig = UIEnums.KeySignature.FOURFOUR;
      }
      
      // Tempo
      UIEnums.Tempo tem;
      switch(tempo.getSelectedCheckbox().getLabel()) {
         case "Grave": tem = UIEnums.Tempo.GRAVE;
         case "Largo": tem = UIEnums.Tempo.LARGO;
         case "Lento": tem = UIEnums.Tempo.LENTO;
         case "Adagio": tem = UIEnums.Tempo.ADAGIO;
         case "Andante": tem = UIEnums.Tempo.ANDANTE;
         default: tem = UIEnums.Tempo.ANDANTE;
      }
      
      // Emotion
      UIEnums.Emotion emote;
      switch(emotions.getSelectedCheckbox().getLabel()) {
         case "Joy": emote = UIEnums.Emotion.JOY;
         case "Excitement": emote = UIEnums.Emotion.EXCITEMENT;
         case "Surprise": emote = UIEnums.Emotion.SURPRISE;
         case "Sadness": emote = UIEnums.Emotion.SADNESS;
         case "Depress": emote = UIEnums.Emotion.DEPRESS;
         case "Cure": emote = UIEnums.Emotion.CURE;
         default: emote = UIEnums.Emotion.JOY;
      }
      
      // Create UIRequest object with the enums.
      UIRequest thisRequest = new UIRequest(req, key, keysig, tem, emote);
      return thisRequest;
   }
   
   public static void main (String args[]) {
      MusicGeneratorDriver app = new MusicGeneratorDriver();
   }
}