import org.jfugue.pattern.Pattern;

public class ChordMelodyPattern implements PatternRuleSet {
   // Empty constructor
   public ChordMelodyPattern() {/* do nothing */ };
   
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
   // Currently uses the jfugue notation, which means major chords use root, fifth, and octive.
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
   public Pattern generatePattern() {
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
       
         // Add the chord in the progression and the first note of the measure to the string.
         returnSong = returnSong + getChordNotes(progression[i]) + "+" + firstNote + "q ";
       
       // Second note can either be a repeat of the first note (25% of the time), and the third note a random chord tone
       // or the second note and third note can be jointly determined to be a passing and chord tone (75% of the time)
         int secondNoteDecider = (int)(Math.random()*4);
         String secondNote = "";
         String thirdNote = "";
         if(secondNoteDecider == 0) { 
         // Repeat the first note
            secondNote = firstNote;
            returnSong = returnSong + secondNote + "_";
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
         returnSong = returnSong + secondNote + "_";
         returnSong = returnSong + thirdNote + "_";
       
       // The fourth note can be a repeat of the third note (if no passing tone exists)
       // or the fourth note can be a passing tone between two chords (if it exists)
       // If we are on the last measure, the "next" chord is a I chord.
       
       // Check if a passing tone could even exist
         boolean possiblePassing = false;
         String fourthNote = "";
         String[] nextFirstNoteOptions = getChordTones(progression[(i+1)%8]);
         for(int j = 0; j < nextFirstNoteOptions.length; j++) {
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
      }
      return(new Pattern(returnSong));
    
     // Beyond this point is additional comments left over from the original attempt to model chords and melody.
      
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
      
      //How do you 'hold' one chord for 2 beats while playing two melody notes of 1 beat?
      //Why does the last note played end 'abruptly' for example [C D E F] the F is about half the beat of the others
    //Just some notes about some music notes:
    	//Futatsuiwa from Sado
    		//The first 8 outline the baseline of the next 8. 
    		//After the listener is primed, the next 8's dissonances aren't as noticable.
    		//STRETCH GOAL TO RECORD -> THE IMPLEMENTATION OF THIS.
   }

@Override
public void generatePattern(Song s) {
	// TODO Auto-generated method stub
	
}

}