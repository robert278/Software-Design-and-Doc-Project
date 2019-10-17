/*
   ____             _____  _                       
  / __ \           |  __ \| |                      
 | |  | |_   _ _ __| |__) | | __ _ _   _  ___ _ __ 
 | |  | | | | | '__|  ___/| |/ _` | | | |/ _ \ '__|
 | |__| | |_| | |  | |    | | (_| | |_| |  __/ |   
  \____/ \__,_|_|  |_|    |_|\__,_|\__, |\___|_|   
                                    __/ |          
                                   |___/           
A file which is used to play, pause, and save songs which are created by the
generator. 
*/

import java.io.File;
import java.io.IOException;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;


import org.jfugue.midi.*;


public class OurPlayer {

   // The jfugue player is responsible for the playing
   private Player jfplayer = new Player();
   // The current song that is being stored in memory
   private Song currSong;
   
   // Constructor
   public OurPlayer() { /* do nothing... */ }

   // Sets a song to be the current song, and then plays the song.
   public void playSong(Song s) {
      currSong = s;
      jfplayer.play(s.GetSong());
   }
   // Save the current song
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