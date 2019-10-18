import java.io.File;
import java.io.IOException;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;


import org.jfugue.midi.*;


public class OurPlayer {

   private Player jfplayer = new Player();
   private Song currSong;
   
   public OurPlayer() { /* do nothing... */ }

   public void playSong(Song s) {
      currSong = s;
      jfplayer.play(s.GetSong());
   }
   // Save the current song. (Should it be save a given song?)
   public void saveSong() {
      Pattern p = new Pattern(currSong.GetSong());
      try {
         MidiFileManager.savePatternToMidi(p,new File("Song.mid"));
      }
      catch (IOException e) {
         System.err.println(e.getMessage());
         e.printStackTrace();
      }
   }
}