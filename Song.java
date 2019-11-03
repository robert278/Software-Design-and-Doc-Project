/*
   _____                   
  / ____|                  
 | (___   ___  _ __   __ _ 
  \___ \ / _ \| '_ \ / _` |
  ____) | (_) | | | | (_| |
 |_____/ \___/|_| |_|\__, |
                      __/ |
                     |___/ 
A class which creates a single song, which can be passed to a player and played.
Accepts patterns from various pattern generators, the rulesets, and stitches them
together using certain rules. 

These rules are defined as:
1. Concatenate all patterns together.
*/
import java.util.ArrayList;
import org.jfugue.pattern.Pattern;

public class Song {
   int tempo;
   ArrayList<Voice> voices;

   public Song() {
      voices = new ArrayList<Voice>();
      tempo = 120;
   }
   
   public boolean addVoice(Voice v) {
      voices.add(v);
      return true;
   }
   
   public boolean setTempo(int t) {
      tempo = t;
      return true;
   }
   
   public String toString() {
      String song = "T"+tempo+" ";
      for(int i = 0; i < voices.size(); i++) {
         song = song+" V"+i+" "+voices.get(i).toString();
      }
      return song;
   }
}