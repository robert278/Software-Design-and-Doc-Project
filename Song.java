import java.util.ArrayList;
import org.jfugue.pattern.Pattern;

public class Song {
   String song; // Formatted as a JFugue string 

   public Song() {
      song = "";
   }
   
   public boolean AcceptPatterns(ArrayList<Pattern> patternBank) {
      String newSong = "";
      for(int i = 0; i < patternBank.size(); i++) {
         newSong = newSong + patternBank.get(i);
      }
      if(!newSong.equals("")) {
         SetSong(newSong);
         return true;
      }
      return false;
   }
   
   private void SetSong(String s) {
      song = s;
   }
   
   public String GetSong() {
      return song;
   }
}