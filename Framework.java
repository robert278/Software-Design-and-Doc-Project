import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import java.lang.reflect.Array;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.jfugue.theory.Chord;
import org.junit.Test;


public class Framework{
	  public int tempo_test(Song s,int tempo) {  //rules to test tempo
		assertEquals(s.gettempo(),tempo);
		return 1;  
	  }	
	  
	  public int instrument_test(Song s, String instrument) { //rules to test instrument
		  ArrayList<Voice> voices = s.getvoices();
		  for(int i=0;i<voices.size();i++) {
			  String instrument0 = voices.get(i).getinstrument();
			  
			  assertEquals(instrument0,instrument);
		  }
			return 1;  
		  }
	  
	  public int chordmap_test(Song s, String[][] chordmap) { //rules to test chordmap
			return 1;  
		  }
	  
	  public int note_test(Song s) { //rules to test notes
		  //some notes allowed 
		  String[] allowedNotes0 = {"A4","A5","A6","A7","B4","B5","B6","B7","C4","C5","C6","C7","D4","D5","D6","D7","E4","E5","E6","E7","F4","F5","F6","F7","G4","G5","G6","G7"};
		  String[] allowedNotes1 = {"C#4","D#4","E4","F#4","G#4","A#4","B5","C#5","D#5","E5","F#5","G#5","A#5","B6","C#6","D#6"};
		  String[] allowedNotes2 = Stream.of(allowedNotes0,allowedNotes1).flatMap(Stream::of).toArray(String[]::new);;
		  List<String> allowedNotes=Arrays.asList(allowedNotes2);
		  ArrayList<Voice> voices = s.getvoices();
		  for(int i=0;i<voices.size();i++) {	  
			  ArrayList<Phrase> p = voices.get(i).getphrases();
			  for(int ii=0;ii<p.size();ii++) {
				  ArrayList<String> notes0 = p.get(ii).getnotes();
				  //System.out.print("\n");
				  for(int j=0;j<notes0.size();j++) {
					  //System.out.print(notes0.get(j));
					  //System.out.print(" ");
					  assertTrue(allowedNotes.contains(notes0.get(j))); //note test
				  }
			  }
		  }
		  	return 1;  
		  }
	  	  
	  public int rhythm_test(Song s, String[] rhythm) { //rules to test rhythm
		  //rhythm allowed
		  String[] allowedRhythm0 = {"A4","A5","A6","A7","B4","B5","B6","B7","C4","C5","C6","C7","D4","D5","D6","D7","E4","E5","E6","E7","F4","F5","F6","F7","G4","G5","G6","G7"};
		  String[] allowedRhythm1 = {"C#4","D#4","E4","F#4","G#4","A#4","B5","C#5","D#5","E5","F#5","G#5","A#5","B6","C#6","D#6"};
		  String[] allowedRhythm2 = Stream.of(allowedRhythm0,allowedRhythm1).flatMap(Stream::of).toArray(String[]::new);;
		  List<String> allowedRhythm=Arrays.asList(allowedRhythm2);
		  ArrayList<Voice> voices = s.getvoices();
		  for(int i=0;i<voices.size();i++) {	  
			  ArrayList<Phrase> p = voices.get(i).getphrases();
			  for(int ii=0;ii<p.size();ii++) {
				  ArrayList<String> notes0 = p.get(ii).getnotes();
				  //System.out.print("\n");
				  for(int j=0;j<notes0.size();j++) {
					  //System.out.print(notes0.get(j));
					  //System.out.print(" ");
					  assertTrue(allowedRhythm.contains(notes0.get(j))); //note test
				  }
			  }
		  }
			return 1;  
		  }
	@Test
	   public void Test(){	 
		  melody m = new melody();
		  String a = m.generateString();
		  //System.out.print(a);
		  Song s = m.generateSong0(3,"piano",a); //this is a method in melody that creates a song
		  							 //with random patterns notes = a, tempo=3,instrument=piano
		  //System.out.print(s);
		  
		  tempo_test(s,3);//tempo test
		  instrument_test(s,"piano");//instrument test
		  note_test(s);//note test
		  
		  //end of loop
		  System.out.print("pass");//end
	}//end of Test
}//end of framework
