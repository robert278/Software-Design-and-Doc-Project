package mymusic;
import java.io.File;
import java.io.IOException;

import org.jfugue.*;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;


import org.jfugue.midi.*;


public class Toplay {
	public static void main(String[] args) {
		demo d1= new demo();
		d1.playMelody(true);
	}
	public void createSong() {
		PatternBank bank= new PatternBank();
		Pattern p1= new Pattern("A1");
		Pattern p2= new Pattern("B2");
		bank.addToBank(p1);
		bank.addToBank(p2);
		Song s1= new Song();
		s1.AcceptPatterns(bank.getPatterns(2));
		String finalsong= s1.GetSong();
		Player p= new Player();
		p.play(finalsong);
		
		    try {
		        MidiFileManager.savePatternToMidi(p1,new File("Song.mid"));
		    }
	    catch (IOException e) {
	        System.err.println(e.getMessage());
	        e.printStackTrace();
	    }
	}
}
	

