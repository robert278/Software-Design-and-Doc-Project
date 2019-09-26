import java.awt.*;
import java.awt.event.*;

public class demo_driver extends Frame implements ActionListener {
   private Button generateButton;
   private CheckboxGroup melodyType;
   private Checkbox chkDisjunct;
   private Checkbox chkConjunct;
   private demo MusicPlayer = new demo();
   
   public demo_driver() { 
      setLayout(new FlowLayout());
      
      generateButton = new Button("Generate");
      add(generateButton);
      generateButton.addActionListener(this);
      
      chkDisjunct = new Checkbox("Disjunct", false, melodyType);
      chkConjunct = new Checkbox("Conjunct", false, melodyType); 
      add(chkDisjunct);
      add(chkConjunct);
      
      setTitle("Music Generator");
      setSize(250, 100);
      
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
   
   public static void main (String args[]) {
      demo_driver app = new demo_driver();
   }
}