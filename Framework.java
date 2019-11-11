import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.junit.Test;

public class Framework{
	  public int tempo_test(int tempo) {  //rules to test tempo
		
		return 1;  
	  }	
	  
	  public int instrument_test(String instrument) { //rules to test instrument
		    
			return 1;  
		  }
	  
	  public int chordmap_test(String[][] chordmap) { //rules to test chordmap
			return 1;  
		  }
	  
	  public int note_test(ArrayList<String> notes) { //rules to test notes
			return 1;  
		  }
	  
	  public int rhythm_test(String[] rhythm) { //rules to test rhythm
			return 1;  
		  }
	@Test
	   public void Test(){	 
		  melody m = new melody();
		  Song s = m.generateSong(); //this is a method in melody that creates a song
		  							 //with random patterns
		  
		  assertEquals(tempo_test(s.gettempo()),1);//tempo test
		  
		  ArrayList<Voice> voices = s.getvoices();
		  for(int i=0;i<voices.size();i++) {
			  String instrument = voices.get(i).getinstrument();
			  
			  assertEquals(instrument_test(instrument),1); //instrument test
			  
			  ArrayList<Phrase> p = voices.get(i).getphrases();
			  for(int ii=0;ii<p.size();ii++) {
				  ArrayList<String> notes = p.get(ii).getnotes();
				  assertEquals(note_test(notes),1); //note test
			  }
		  }
		  //end
	}
}
