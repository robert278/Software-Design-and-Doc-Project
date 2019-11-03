/* Class:
*   _    _ _____          _                  _ _   _               ____       _     _            
*  | |  | |_   _|   /\   | |                (_) | | |             |  _ \     (_)   | |           
*  | |  | | | |    /  \  | | __ _  ___  _ __ _| |_| |__  _ __ ___ | |_) |_ __ _  __| | __ _  ___ 
*  | |  | | | |   / /\ \ | |/ _` |/ _ \| '__| | __| '_ \| '_ ` _ \|  _ <| '__| |/ _` |/ _` |/ _ \
*  | |__| |_| |_ / ____ \| | (_| | (_) | |  | | |_| | | | | | | | | |_) | |  | | (_| | (_| |  __/
*   \____/|_____/_/    \_\_|\__, |\___/|_|  |_|\__|_| |_|_| |_| |_|____/|_|  |_|\__,_|\__, |\___|
*                            __/ |                                                     __/ |     
*                           |___/                                                     |___/    
*  
* The goal of this class is to provide a way for the UI and the music generation algorthm to communicate.
* This is done indirectly by having the UI and the Algorithm components communicate solely with this class.
* The UI does this by passing in all the options which have been selected by the user. At this point, the UI
* has finished it's role in the particular music generation. Programming wise, this is done by passing a
* selection object to the bridge, which is responsible for unpacking it, creating the necessary subcomponents
* from the generator algorithm, and making sure the correct calls are made. The bridge's responsibility ends
* when the request from the UI is fulfilled. 
*/

import java.util.ArrayList;
import org.jfugue.pattern.Pattern;

public class UIAlgorithmBridge {
   private UIRequest request;
   
   public UIAlgorithmBridge() { /* do nothing */  } 
   
   public boolean acceptRequest(UIRequest newAction) {
      // Check the type of the request
      request = newAction;
      Song s;
      if(request.GetRequestType() == UIEnums.RequestType.EXIT) {
         // ???
      }
      if(request.GetRequestType() == UIEnums.RequestType.SAVE) {
         // OurPlayer.save()?
      }
      if(request.GetRequestType() == UIEnums.RequestType.GENERATE) {
      // Determine the lead instrument
         String lead;
         if(request.GetLeadingInstrument() == UIEnums.LeadingInstrument.FLUTE)
            lead = "Violin";
         else if(request.GetLeadingInstrument() == UIEnums.LeadingInstrument.TRUMPET)
            lead = "French_Horn";
         else
            lead = "Piano";
         TempoDecorator t;
       // Create an empty song
         s = new Song();
         // Check the pattern type
         ArrayList<Pattern> patterns = new ArrayList<Pattern>();
         if(request.GetPattern() == UIEnums.PatternType.HAPPYCALM) {
         // Really means happy.
            t = new TempoDecorator((int)(Math.random()*100)+120);
            HappyPattern h;
            String[] CNotes = {"C","D","E","F","G","A","B"};
            String[] CAllowedNotes = {"G4","A5","B5","C5","D5","E5","F5","G5","A6","B6","C6","D6","E6","F6","G6"};
            String[] GNotes = {"G","A","B","C","D","E","F#"};
            String[] GAllowedNotes = {"D5","E5","F#5","G5","A6","B6","C6","D6","E6","F#6","G6","A7","B7","C7","D7"};
            int keyDecider = (int)(Math.random()*2);
            if(keyDecider == 0) {
               h = new HappyPattern("C", CNotes, CAllowedNotes, lead);
            }
            else {
               h = new HappyPattern("G", GNotes, GAllowedNotes, lead);
            }
         
            h.generatePattern(s);
         }
         else if(request.GetPattern() == UIEnums.PatternType.HAPPYINTENSE) {
          // Really means intense
          System.out.println("Is intense.");
          int tempoDecider = ((int)(Math.random()*75)) + 300;
            t = new TempoDecorator(tempoDecider);
         
            SadPattern sad;
            String[] DNotes = {"D", "E", "F", "G", "A", "Bb", "C"};
            String[] DAllowedNotes = {"D4","E4","F4","G4","A5","Bb5","C5","D5","E5","F5","G5","A6"};
            String[] ANotes = {"A", "B", "C", "D", "E", "F", "G"};
            String[] AAllowedNotes = {"A4","B4","C4","D4","E4","F4","G4","A5","B5","C5","D5","E5"};
            int keyDecider = (int)(Math.random()*2);
            if(keyDecider == 0) {
               sad = new SadPattern("D", DNotes, DAllowedNotes, lead);
            }
            else {
               sad = new SadPattern("A", ANotes, AAllowedNotes, lead);
            }
         
            sad.generatePattern(s);
         }
         else if(request.GetPattern() == UIEnums.PatternType.SADCALM) {
          // Really means calm
            t = new TempoDecorator(80);
         
            CalmPattern c;
            String[] BNotes = {"B","C#","D#","E","F#","G#","A#"};
            String[] BAllowedNotes = {"B4","C#4","D#4","E4","F#4","G#4","A#4","B5","C#5","D#5","E5","F#5","G#5","A#5","B6","C#6","D#6"};
            c = new CalmPattern("B",BNotes, BAllowedNotes, lead);
         
            c.generatePattern(s);
         }
         else { // SADINTENSE
         // Really means sad
            t = new TempoDecorator((int)(Math.random()*70)+40);
         
            SadPattern sad;
            String[] DNotes = {"D", "E", "F", "G", "A", "Bb", "C"};
            String[] DAllowedNotes = {"D4","E4","F4","G4","A5","Bb5","C5","D5","E5","F5","G5","A6"};
            String[] ANotes = {"A", "B", "C", "D", "E", "F", "G"};
            String[] AAllowedNotes = {"A4","B4","C4","D4","E4","F4","G4","A5","B5","C5","D5","E5"};
            int keyDecider = (int)(Math.random()*2);
            if(keyDecider == 0) {
               sad = new SadPattern("D", DNotes, DAllowedNotes, lead);
            }
            else {
               sad = new SadPattern("A", ANotes, AAllowedNotes, lead);
            }
         
            sad.generatePattern(s);
         }
       
         
         
      // Have the song go through the various song rule decorators
         t.generateSong(s);
         
         // Send the completed song to the player
         System.out.println(s.toString());
         OurPlayer thisPlayer = new OurPlayer();
         thisPlayer.playSong(s);
      }
      return true;
   }
}