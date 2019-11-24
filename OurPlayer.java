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
import org.jfugue.player.ManagedPlayer;

import javax.sound.midi.Sequence;
import javax.sound.midi.MidiSystem;

import org.jfugue.midi.MidiFileManager;


public class OurPlayer {

   // The current song that is being stored in memory from a genereate
   private Song currSong;
   
   // Player which does the playing, pausing, resuming, etc..
   private ThreadPlayer tp = new ThreadPlayer();
   
   // Loaded file from desktop
   private File loadedFile;
   
   // Constructor
   public OurPlayer() {
      currSong = new Song();
   }
   
   public boolean setLoadedFile(File f) {
      loadedFile = f;
      System.out.println("Loaded file set.");
      return true;
   }
   
   public boolean playLoadedFile() {
      Sequence savedSequence = null;
      try { 
         savedSequence = MidiSystem.getSequence(loadedFile);
      }
      catch(Exception e) {
         // If it failed to get the sequence, stacktrace and return
         System.err.println(e.getMessage());
         e.printStackTrace();
         return false;
      }
   
      tp.setSequence(savedSequence);
      tp.run();
      return true;
   }

   // Sets a song to be the current song, and then plays the song.
   public void playSong(Song s) {
      currSong = s;
      saveSong("currSong");
      
      File savedFile = new File("currSong.mid");
      Sequence savedSequence = null;
      try { 
         savedSequence = MidiSystem.getSequence(savedFile);
      }
      catch(Exception e) {
         System.err.println(e.getMessage());
         e.printStackTrace();
      }
   
      tp.setSequence(savedSequence);
      tp.run();
   }
   
   // Pauses the currently playing song, if there is one.
   public void pauseSong() {
      tp.pauseSong();
   }
   
   // Unpauses the currently playing song, if there is one that is paused.
   public void unpauseSong() {
      tp.unpauseSong();
   }
   
   // Save the current song
   public void saveSong(String name) {
      Pattern p = new Pattern(currSong.toString());
      try {
         MidiFileManager.savePatternToMidi(p,new File(name+".mid"));
      }
      catch (IOException e) {
         System.err.println(e.getMessage());
         e.printStackTrace();
      }
   }
}

// ThreadPlayer needs to be the one that is actually playing or saving or whatever.
// Has it's own player
class ThreadPlayer extends Thread {
   private ManagedPlayer jfplayer;
   private Sequence seq;
   
   public ThreadPlayer() {
      jfplayer = new ManagedPlayer();
      seq = null;
   }
   
   public void setSequence(Sequence s) {
      seq = s;
   }
   
   public void pauseSong() {
      if(jfplayer.isPlaying())
         jfplayer.pause();
   }
   
   public void unpauseSong() {
      if(jfplayer.isPaused())
         jfplayer.resume();
   }
   
   public void stopSong() {
      jfplayer.finish();
   }
   
   @Override
   public void run() {
      try { 
         jfplayer.start(seq);
      }
      catch(Exception e) {
         System.err.println(e.getMessage());
         e.printStackTrace();
      }
   }
}