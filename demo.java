import org.jfugue.player.Player;
import java.io.*; 
import java.lang.*; 
  
public class demo {
  
   public demo() {
   
   }
   
   // Enum which contains all the chord types, which can be used to determine chords regardless of key.
   private enum Chords { OneMajor, TwoMinor, ThreeMinor, FourMajor, FiveMajor, SixMinor; }
   
   // Method to get what the next chord should be, given that the previous chord was.
   private Chords getNextChord(Chords prevChord) {
    // Viable chords: 2, 3, 4, 5, 6
      if(prevChord == Chords.OneMajor) {
         int decider = (int)(Math.random() * 5);
         if(decider == 0)
            return Chords.TwoMinor;
         else if(decider == 1)
            return Chords.ThreeMinor;
         else if(decider == 2)
            return Chords.FourMajor;
         else if(decider == 3)
            return Chords.FiveMajor;
         else // if(decider == 4)
            return Chords.SixMinor;
      }
      // Viable chords: 3, 5
      else if(prevChord == Chords.TwoMinor) {
         int decider = (int)(Math.random()*2);
         if(decider == 0)
            return Chords.FiveMajor;
         else // if(decider == 1
            return Chords.ThreeMinor;
      }
      // Viable chords: 4, 6
      else if(prevChord == Chords.ThreeMinor) {
         int decider = (int)(Math.random()*2);
         if(decider == 0)
            return Chords.FourMajor;
         else // if(decider == 1
            return Chords.SixMinor;
      }
      // Viable chords: 1, 2, 5
      else if(prevChord == Chords.FourMajor) {
         int decider = (int)(Math.random()*3);
         if(decider == 0)
            return Chords.FiveMajor;
         else if(decider == 1)
            return Chords.OneMajor;
         else // if(decider == 2
            return Chords.TwoMinor;
      }
      // Viable chords: 1, 3, 6
      else if(prevChord == Chords.FiveMajor) {
         int decider = (int)(Math.random()*3);
         if(decider == 0)
            return Chords.OneMajor;
         else if(decider == 1)
            return Chords.ThreeMinor;
         else // if(decider == 2
            return Chords.SixMinor;
      }
      // Viable chords: 2, 4
      else /*if(prevChord == SixMinor*/ {
         int decider = (int)(Math.random()*2);
         if(decider == 0)
            return Chords.TwoMinor;
         else // if(decider == 1
            return Chords.FourMajor;
      }
   }
   
   // Returns a string of notes, in jfugue notation, that can be played for the chord
   // Important extension: This can eventually be modified such that a key is also a parameter.
   // Currently uses the root and a fifth (For Cmaj chord this means
   private String getChordNotes(Chords chord) {
   	// if key == "C"
   	// C Scale: C, D, E, F, G, A, B
      if(chord == Chords.OneMajor)
         return " Cmajw";
      else if(chord == Chords.TwoMinor)
         return " Dminw";
      else if(chord == Chords.ThreeMinor)
         return " Eminw";
      else if(chord == Chords.FourMajor)
         return " Fmajw";
      else if(chord == Chords.FiveMajor)
         return " Gmajw";
      else // if(chord == Chords.SixMinor)
         return " Aminw";
   	
   	// else if key == "G" or whatever... this model can be extended
   	// G Scale: G, A, B, C, D, E, F#
   	// Thus the vi (6) chord would be F#min, since the 6th note is F#.
   }
   
   // Returns all three notes of the tritone of the chord, in order of root, skip, fifth.
   private String[] getChordTones(Chords measureChord) {
      String[] CMajor = {"C","D","E","F","G","A","B"};
     // Cmaj 1, 3, 5 (thus index 0, 4)
      if(measureChord == Chords.OneMajor) {
         String[] tones = {CMajor[0], CMajor[2], CMajor[4]};
         return tones;
      }
      // Dmin 2, 4, 6
      else if(measureChord == Chords.TwoMinor) {
         String[] tones = {CMajor[1], CMajor[3], CMajor[5]};
         return tones;
      }
      // Emin 3, 5, 7
      else if(measureChord == Chords.ThreeMinor) {
         String[] tones = {CMajor[2], CMajor[4], CMajor[6]};
         return tones;
      }
      // Fmaj 4, 6, 1
      else if(measureChord == Chords.FourMajor) {
         String[] tones = {CMajor[3], CMajor[5], CMajor[0]};
         return tones;
      }
      // Gmaj 5, 7, 2
      else if(measureChord == Chords.FiveMajor) {
         String[] tones = {CMajor[4], CMajor[6], CMajor[1]};
         return tones;
      }
      // Amin 6, 1, 3
      else /* if(measureChord == Chords.SixMinor) */ {
         String[] tones = {CMajor[5], CMajor[0], CMajor[2]};
         return tones;
      }
   }
   
   // Generate a passing tone, given what the previous chord tone was.
   // Requires the previous note, as a position within the tritone, and the chord.
   // For example, if the previous chord was I in C major, and the position of the note was 3 (E)
   // then the possible passing tones are 4 and 2, and the next notes after that would be 5 and 1 respectively.
   // This method will return two notes together in JFugue format.
   // Example: Given 3, and that the current chord is TwoMinor, it will return either "E5 D5" or "G5 A5" 
   // Alternate:
   // Given the previous note and the next note, return the passing tone that is between them, if it exists.
   // If such a passing tone does not exist, return an empty string.
   private String getPassingTone(String prevNote, String nextNote) {
      String[] CMajor = {"C","D","E","F","G","A","B"};
     // Find which note prevNote is within the scale
      int prevNoteIndex = 0;
      for(int i = 0; i < CMajor.length; i++) {
         if(prevNote.equals(CMajor[i])) {
            prevNoteIndex = i;
            break;
         }
      }
     // check if the nextNote is two up or two down from the prev note
      if(CMajor[(prevNoteIndex+2)%7].equals(nextNote)) { // two notes up
         return CMajor[(prevNoteIndex+1)%7];
      }
      else if(CMajor[((prevNoteIndex-2)+7)%7].equals(nextNote)) { // two notes down
         return CMajor[((prevNoteIndex-1)+7)%7];
      }
      else { // No passing tone possible
         return "";
      }
   }
   
   // Method to generate all the chord progressions at once, that way we can
   // know what the next chord is going to be before the measure has started.
   // This is necessary for passing tones at the start of measures.
   private Chords[] generateProgression() {
      Chords[] progression = new Chords[8];
      progression[1] = Chords.OneMajor;
      for(int i = 1; i < 6; i++) {
         progression[i+1] = getNextChord(progression[i]); // Get next chord based on previous
      }
   	// 7th and 8th chords are special, to ensure that these chord progressions can chain together nicely,
   	// the 8th chord has to be a IV or V so it can resolve to a I.
   	// Thus the 7th chord must be something that can resolve to a IV or a V, 
   	// the chords which fit that description are: ii, iii, IV, vi.
   	// At least ONE of these chords is reachable from any position in the chord progression, therefore, for the
   	// 7th chord, we just keep generating chords until it fits with what we require. Same for the 8th chord.
      boolean resolved = false;
      while(resolved == false) {
         Chords seventhChord = getNextChord(progression[5]);
         if(seventhChord == Chords.TwoMinor || seventhChord == Chords.ThreeMinor || seventhChord == Chords.FourMajor || seventhChord == Chords.SixMinor) {
            resolved = true;
            progression[6] = seventhChord;
         }
      }
   	// Do the same for the 8th chord
      while(resolved == true) {
         Chords eighthChord = getNextChord(progression[6]);
         if(eighthChord == Chords.FourMajor || eighthChord == Chords.FiveMajor) {
            resolved = false;
            progression[7] = eighthChord;
         }
      }
      return progression;
   }
   
  // Method to play the melody that is created
   public void playMelody(boolean isDisjunct) {
      Player player = new Player();
      Player player2 = new Player();
    
      int notesplayed = 0;
      int previousNote = 0;
    
    //CONJUNCT -> STEPWISE with the "PREVIOUS NOTE" 
    //DISJUNCT -> LEAPS
    
    //REMOVE THIS TO REMOVE THE CHORD GENERATION
    
    
      String returnSong = "none";
    
      String nextFirstNote = "C";
      int numMeasures = 8; // Number of measures to play. This should really not be changed...
     // Generate chord progression
      Chords[] progression = generateProgression();
      for(int i = 0; i < numMeasures; i++) {
      //"D#min" Plays in closed position
      //Forgot to mention -- It's not triads on Hooktheory. Sometimes chords are evoked by simply -- the root of the chord, triads need a bit more work.
      //For example chords in "Bad Apple" are represented by playing the root and fifth back and forth.
      //So a D# minor chord in Bad Apple would consist of D#-A#-D#-A# back and forth
      
      //player.play("C3w+C4q C4q"); //A I chord -- assumming D# minor
         
       // Determine the first note based on the chord.
         String[] chordToneChoices = getChordTones(progression[i]);
         String firstNote = nextFirstNote;
       /*int firstNoteDecider = (int)(Math.random()*2);
       if(firstNoteDecider == 0)
      	 firstNote = chordToneChoices[0]; // root
       else
      	 firstNote = chordToneChoices[2]; // fifth*/
       
         // Add the chord in the progression and the first note of the measure to the string.
         returnSong = returnSong + getChordNotes(progression[i]) + "+" + firstNote + " ";
       
       // Second note can either be a repeat of the first note (25% of the time), and the third note a random chord tone
       // or the second note and third note can be jointly determined to be a passing and chord tone (75% of the time)
         int secondNoteDecider = (int)(Math.random()*4);
         String secondNote = "";
         String thirdNote = "";
         if(secondNoteDecider == 0) { 
         // Repeat the first note
            secondNote = firstNote;
            returnSong = returnSong + secondNote + " ";
         // Make the third note a chord tone
            int thirdNoteDecider = (int)(Math.random()*3);
            if(thirdNoteDecider == 0) 
               thirdNote = chordToneChoices[0];
            else if(thirdNoteDecider == 1)
               thirdNote = chordToneChoices[1];
            else
               thirdNote = chordToneChoices[2];
         }
         else {
          // Need to pick a third note such that there can be a passing tone.
          // Cycle through the choices, pick the first one that works. Biases the process but...
          // If in the future you want to unbias it... Make it a random sample of the order, without replacement.
            for(int j = 0; j < chordToneChoices.length; j++) {
            // Check what the passing tone could be.
               String possibleNote = getPassingTone(firstNote, chordToneChoices[j]);
               if(possibleNote.equals("") == false) { // If we have a valid passing tone...
                  secondNote = possibleNote;
                  thirdNote = chordToneChoices[j];
                  break; // No need to keep searching
               }
            }
          // There should always be a passing tone between notes within the same chord.
         }
       // Add the second and third notes to the song.
         returnSong = returnSong + secondNote + " ";
         returnSong = returnSong + thirdNote + " ";
       
       // The fourth note can be a repeat of the third note (if no passing tone exists)
       // or the fourth note can be a passing tone between two chords (if it exists)
       // If we are on the last measure, the "next" chord is a I chord.
       
       // Check if a passing tone could even exist
         boolean possiblePassing = false;
         String fourthNote = "";
         String[] nextFirstNoteOptions = getChordTones(progression[(i+1)%8]);
         for(int j = 0; i < nextFirstNoteOptions.length; j++) {
            String possibleNote = getPassingTone(thirdNote, nextFirstNoteOptions[j]);
            if(possibleNote.equals("") == false) { // if we have a valid passing tone...
               fourthNote = possibleNote;
               nextFirstNote = nextFirstNoteOptions[j];
               break;
            }
         }
         if(fourthNote.equals("") == true) { // if we did not find a valid passing note
            fourthNote = thirdNote;
         // The next first note can be random.
            int nextFirstNoteDecider =  (int)(Math.random()*3);
            if(nextFirstNoteDecider == 0)
               nextFirstNote = nextFirstNoteOptions[0];
            else if(nextFirstNoteDecider == 1)
               nextFirstNote = nextFirstNoteOptions[1];
            else 
               nextFirstNote = nextFirstNoteOptions[2];
         }
       
       // Fourth note and the next first note are decided.
         returnSong = returnSong + fourthNote + " ";
       
       
         /*if(returnSong == "none") { //Assuming C major and 4/4 time
            // First note should also match the key, hence the C with the C chord.
            returnSong = "C3majw+C5q "; //Assume I chord with 1^ in the melody
         } 
         else {
            // If this is not the first measure, we need a new chord.
            Chords nextChord = getNextChord(prevChord);
            prevChord = nextChord; // Set the previous chord equal to the next chord, for the progression.
            returnSong = returnSong + getChordNotes(nextChord) + "+C5q "; //PUT NEW CHORD HERE... ? Or in another loop
         } //Then if(statement the new chord to decided what 'measure' block to go into...*/
      
         /*int num2 = (int)(Math.random() * 4);
         if(num2 == 1) {
            returnSong = returnSong + " C5q"; //repeat the previous 1^
            int num3 = (int)(Math.random() * 2);
            if(num3 == 1) {
               returnSong = returnSong + " Eb5q"; //Rules state third beat is a chord tone
               int num4 = (int)(Math.random() * 3);
               if(num4 == 1) {
                  returnSong = returnSong + " D5q"; //2^
                  prevMeasureNote = "D5q";
               } 
               else if(num4 == 2) {
                  returnSong = returnSong + " Eb5q"; //3^
                  prevMeasureNote = "Eb5q";
               } 
               else {
                  returnSong = returnSong + " F5q"; //4^
                  prevMeasureNote = "F5q";
               }
            } 
            else {								//Options are to go to 3^ or 5^
               returnSong = returnSong + " G4q"; //Assuming you go down to 5^
            //Options are: repeat 5, down to 4, or up to 6
               int num4 = (int)(Math.random() * 3);
               if(num4 == 1) {
                  returnSong = returnSong + " G5q"; //5^
                  prevMeasureNote = "G5q";
               } 
               else if(num4 == 2) {
                  returnSong = returnSong + " A5bq"; //6^
                  prevMeasureNote = "Ab5q"; //I am not sure if(we should evoke 6^... It's a 'tricky' scale degree when it comes to music theory for me at least... 
               } 
               else {
                  returnSong = returnSong + " F5q"; //4^
                  prevMeasureNote = "F5q";
               }
            }
         } 
         else if(num2 == 2){
            returnSong = returnSong + " D5q"; //Move to 2^
            int num3 = (int)(Math.random()*2);
            if(num3 == 1) {
               returnSong = returnSong + " C5q";//Moves back down to 1^
               int num4 = (int)(Math.random() * 3);
               if(num4 == 1) {
                  returnSong = returnSong + " D5q"; //2^
                  prevMeasureNote = "D5q";
               } 
               else if(num4 == 2) {
                  returnSong = returnSong + " C5q"; //1^
                  prevMeasureNote = "C5q";
               } 
               else {
                  returnSong = returnSong + " Bb4q"; //7^
                  prevMeasureNote = "Bb4q";
               }
            } 
            else {
               returnSong = returnSong + " Eb5q";//Moves up to 3^
               int num4 = (int)(Math.random() * 3);
               if(num4 == 1) {
                  returnSong = returnSong + " D5q"; //2^
                  prevMeasureNote = "D5q";
               } 
               else if(num4 == 2) {
                  returnSong = returnSong + " Eb5q"; //3^
                  prevMeasureNote = "Eb5q";
               } 
               else {
                  returnSong = returnSong + " F5q"; //4^
                  prevMeasureNote = "F5q";
               }
            }
         } 
         else if(num2 == 3){
            returnSong = returnSong + " Bb4q"; //Move down to 7^, in this ruleset next note must be 1^
            returnSong = returnSong + " C5q"; //Note to self {B5 -> C5 is a seventh apart, B4 is adjacent to C5}
            int num4 = (int)(Math.random() * 3);
            if(num4 == 1) {
               returnSong = returnSong + " D5q"; //2^
               prevMeasureNote = "D5q";
            } 
            else if(num4 == 2) {
               returnSong = returnSong + " C5q"; //1^
               prevMeasureNote = "C5q";
            } 
            else {
               returnSong = returnSong + " Bb4q"; //7^
               prevMeasureNote = "Bb4q";
            }
         } 
         else {
            returnSong = returnSong + " Eb5q"; //Move up to 3^, next note must be 5^
            returnSong = returnSong + " G5q";
            int num4 = (int)(Math.random() * 3);
            if(num4 == 1) {
               returnSong = returnSong + " G5q"; //5^
               prevMeasureNote = "G5q";
            } 
            else if(num4 == 2) {
               returnSong = returnSong + " A5bq"; //6^
               prevMeasureNote = "Ab5q"; //I am not sure if(we should evoke 6^... It's a 'tricky' scale degree when it comes to music theory for me at least... 
            } 
            else {
               returnSong = returnSong + " F5q"; //4^
               prevMeasureNote = "F5q";
            }
         }
      
      //Possibilities for prevMeasureNote: [((lower)7^->1^) && (1^-6^)]
      //Prev Chord = 'i or I', potential next chord = II, VII, VI, III 
         if(prevMeasureNote == "Bb4q") {
         //figure out what chords with the given ruleset
         } 
         else if(prevMeasureNote == "C5q") {
         
         }*/
      
      //player.play(returnSong);
      //SECOND ".PLAY" WILL PLAY AFTER ALL OF THE FIRST PLAYS. USE THE ABOVE TO MODEL VARYING RYTHYMS
      //player.play("D#3h+A#5q+C#5q"); //build the entire string - then play the entire string
      //player.play("D#3h+D#5q+C#5q");
      //player.play("C#5q");
      
      
      
      
      /*	Will have to figure out how to play two notes at once with different duration;
      	for example a half note for harmony while a quarter note melody in the top line 
      	is being played. SOLUTION: player.play("D#3h+A#5q+C#5q+C#5w");
      */
      
      //Start on i [5511]
      //Go to VI [2311]
      //Perhaps VII next [7276]
      //Perhaps V next [5457]
      //go to i [1711]
      //go to ii [2343
      //go to III [3355]
      //go to V [5456]
      
      //i'm not too up on newer stuff, but musicians have always foregone
      //flat out playing chords in favor of arpeggiating them?
      //to make it more "music-y" arpeggios are necessary
       
      //rarely includes the fifths in chords, almost always just do the 3rd and the root
      
      
      //Why does the last note played end 'abruptly' for example [C D E F] the F is about half the beat of the others 
      }
    
      player.play(returnSong);
    //return;
    
    //Just some notes about some music notes:
    	//Futatsuiwa from Sado
    		//The first 8 outline the baseline of the next 8. 
    		//After the listener is primed, the next 8's dissonances aren't as noticable.
    		//STRETCH GOAL TO RECORD -> THE IMPLEMENTATION OF THIS.
    
    
    
    //int disjunct = 1;
      if(isDisjunct) { 
         while(true) {
         //	(int)(Math.random() * ((max - min) + 1)) + min
         // It's interesting, randomly generating notes between C4 and C5
         // only has two potential dissonances: C4 -> B4 (well also D4 -> C5) and the tritone B -> F 
            int number = 0;
            while(Math.abs(number - previousNote) < 4) {
               number = (int)(Math.random() * 8);
            }
         
            if(number == 1) {
               player.play("C4");
               if(notesplayed > 16) { //breaks arbitrary after returning to C4 after 16 or more notes were played
                  break;
               }
            } 
            else if(number == 2) {
               player.play("D4");    		
            } 
            else if(number == 3) {
               player.play("E4");
            } 
            else if(number == 4) {
               player.play("F4");
            } 
            else if(number == 5) {
               player.play("G4");
            } 
            else if(number == 6) {
               player.play("A4");
            } 
            else if(number == 7) {
               player.play("B4");
            } 
            else if(number == 8) {
               player.play("C5");
            }
            notesplayed++;
            previousNote = number;
         }
      }
      
      /*else {
         int previousLeap = 0;
         int number = (int)((Math.random() * 9) - 1);
         while(true) {
         
         	    //PLUS SIGN TO PLAY MULTIPLE NOTES TOGETHER {This plays 3 C's}
         	    
         //	(int)(Math.random() * ((max - min) + 1)) + min
            int max = 2;
            int min = 0;
            number = previousNote + (1 - (int)(Math.random() * ((max - min) + 1)) + min);
            if(number < 0) {
               number = 1;
            }
            if(number > 8) {
               number = 5;
            }
         //CHORDS NEED TO BE OPEN POSITION -- CLOSED POSITION SOUNDS KINDA... BAD... 
            if(number == 0) {
               player.play("V0 B4");
               if(notesplayed % 4 == 0) {
                  player2.play("V1 G3majw"); //These play and then wait for the next notes to play...
               }
            } 
            else if(number == 1) {
               player.play("V0 C4");  
               if(notesplayed % 4 == 0) {
                  player2.play("V1 C3majw");
               }
            } 
            else if(number == 2) {
               player.play("V0 D4");
               if(notesplayed % 4 == 0) {
                  player2.play("V1 D3minw");
               }
            } 
            else if(number == 3) {
               player.play("V0 E4");
               if(notesplayed % 4 == 0) {
                  player2.play("V1 C3majw");
               }
            } 
            else if(number == 4) {
               player.play("V0 F4");
               if(notesplayed % 4 == 0 && (previousNote == 3 || previousNote == 5)) {
                  player2.play("V1 D3minw");
               } 
               else if(notesplayed % 4 == 0) {
                  player2.play("V1 F3majw");
               }
            } 
            else if(number == 5) {
               player.play("V0 G4");
               if(notesplayed % 4 == 0) {
                  player2.play("V1 G3majw");
               }
            } 
            else if(number == 6) {
               player.play("V0 A4");
               if(notesplayed % 4 == 0) {
                  player2.play("V1 F3majw");
               }
            } 
            else if(number == 7) {
               player.play("V0 B4");
               if(notesplayed % 4 == 0) {
                  player2.play("V1 G3majw");
               }
            } 
            else if(number == 8) {
               player.play("V0 C5");
               if(notesplayed % 4 == 0) {
                  player2.play("V1 C3majw");
               }
            }
            notesplayed++;
            previousNote = number;
         }
      }*/
   }
}