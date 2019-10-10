import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class demo_driver extends Frame implements ActionListener {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Button generateButton;
   private Button exitButton;
   // check box groups
   private CheckboxGroup keySignature, timeSignature, instruments, tempo, durationofPiece, emotions, melodyType;
   private Checkbox chkDisjunct;
   private Checkbox chkConjunct;
   private demo MusicPlayer = new demo();
   
   // supporting options lists for each of the checkbox group
   private String[] keySignatureList = {"C","F","G","D","A","E"};
   private String[] timeSignatureList = {"4,4","2,2","2,4","3,4","3,8"};
   private String[] instrumentsList = {"Keyboard","Piano","Guitar","Violin","Trumpet","Harp"};
   private String[] tempoList = {"Tempo","Grave","Largo","Lento","Adagio","Andante"};
   private String[] emotionList = {"Joy","Excitement","Surprise","Sadness","Depress","Cure"};
   
   
   
   
   public demo_driver() {
	   
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
      emo = new Label("Time Signature");
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
      System.out.println("Button clicked.");
      if(chkDisjunct.getState()) {
         System.out.println("Disjunct is selected.");
         MusicPlayer.playMelody(chkDisjunct.getState());
      }
      else {
         System.out.println("Disjunct is not selected.");
         MusicPlayer.playMelody(chkDisjunct.getState());
      }
   }
   
   public void setCheckboxGroup(CheckboxGroup g, String[] arr, int x, int y, int w, int h ) {
	   
	   for(int i=0;i<arr.length;i++) {
		   Checkbox c = new Checkbox(arr[i], g, false);
		   c.setBounds(x, (y+i*h), w, h);
		   this.add(c);
		   
	   }
   }
   
   public static void main (String args[]) {
      demo_driver app = new demo_driver();
   }
}