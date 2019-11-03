import java.util.ArrayList;

public class Phrase {
   ArrayList<String> notes;
   
   public Phrase() {
      // Blank phrase
      notes = new ArrayList<String>();
   }
   
   public Phrase(String[] initialNotes) {
      for(int i = 0; i < notes.size(); i++) {
         notes.add(initialNotes[i]);
      }
   }
   
   public Phrase(ArrayList<String> initialNotes) {
      notes = initialNotes;
   }
   
   public boolean addNotes(ArrayList<String> extraNotes) {
      notes.addAll(extraNotes);
      return true;
   }
   
   // Appends notes to the end of the phrase
   public boolean addNotes(String[] extraNotes) {
      for(int i = 0; i < extraNotes.length; i++) {
         notes.add(extraNotes[i]);
      }
      return true;
   }
   
   // Sets volume for all notes in phrase. Phrases only have a SINGLE UNIFORM volume
   public boolean setVolume(int a, int d) {
      // Attack and decay volumes
      if(notes.size() == 0)
         return false;
         
      String testNote = notes.get(0);
      
      if(testNote.indexOf("a") != -1) { // Volume has been set before
         // Scrape volumes off the notes
         for(int i = 0; i < notes.size(); i++) {
            notes.set(i, notes.get(i).substring(0, notes.get(i).indexOf("a")));
         }
      }
      
      // apply the attack and decay volumes
      String volume = "a"+a+"d"+d;
      for(int i = 0; i < notes.size(); i++) {
         notes.set(i, notes.get(i)+volume);
      }
      return true;
   }
   
   public boolean clear() {
      notes.clear();
      return true;
   }
   
   public String toString() {
      String phrase = "";
      for(int i = 0; i < notes.size(); i++) {
         phrase = phrase+" "+notes.get(i);
      }
      return phrase;
   }
}