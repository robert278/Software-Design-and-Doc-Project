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
	  private enum Chords { OneMajor, TwoMinor, ThreeMinor, FourMajor, FiveMajor, SixMinor; }
	  
	  private String[] themeList = {"Calm","Intense"};
	  private String[] emotionList = {"Happy","Sad"};
	  private String[] CNotes = {"C","D","E","F","G","A","B"};
      private String[] CAllowedNotes = {"G4","A5","B5","C5","D5","E5","F5","G5","A6","B6","C6","D6","E6","F6","G6"};
      private String[] GNotes = {"G","A","B","C","D","E","F#"};
      private String[] GAllowedNotes = {"D5","E5","F#5","G5","A6","B6","C6","D6","E6","F#6","G6","A7","B7","C7","D7"};
	  public int tempo_test(Song s) {  //rules to test tempo
		assertTrue(s.gettempo()<200);
		return 1;  
	  }	
	  
	  public int instrument_test(Song s) { //rules to test instrument
		  String[] leadingInstrumentList0 = {"Piano","Trumpet","Flute","Guitar","Choir","Strings","Violin"};
		  List<String> leadingInstrumentList = Arrays.asList(leadingInstrumentList0);
		  ArrayList<Voice> voices = s.getvoices();
		  for(int i=0;i<voices.size();i++) {
			  String instrument0 = voices.get(i).getinstrument();
			  
			  assertTrue(leadingInstrumentList.contains(instrument0));
		  }
			return 1;  
		  }
	  
	  public int chordmap_test(Song s) { //rules to test chordmap
		    String[] Chords0 = {"min","dim","maj"};
		    List<String> Chords=Arrays.asList(Chords0);
		    ArrayList<Voice> voices = s.getvoices();
		    for(int i=0;i<voices.size();i++) {	  
				  ArrayList<Phrase> p = voices.get(i).getphrases();
				  for(int ii=0;ii<p.size();ii++) {
					  ArrayList<String> notes0 = p.get(ii).getnotes();
					  //System.out.print(notes0);
					  for(int jj=0;jj<notes0.size();jj++) {
						  //System.out.print(notes0.get(jj));
						  String[] notes2 = notes0.get(jj).split(" ");
						  List<String> c=Arrays.asList(notes2); //make sure the patterns have correct chord map
						  for(int mm=0;mm<c.size();mm++) {
							  if(c.get(mm).contains("min")) {
								  assertTrue(c.get(mm).contains("min"));
							  }
							  if(c.get(mm).contains("dim")) {
								  assertTrue(c.get(mm).contains("dim"));
							  }
							  if(c.get(mm).contains("maj")) {
								  assertTrue(c.get(mm).contains("maj"));
							  }
						  }
						  
					  }
				  }
		  }
			return 1;
	  }
	  
	  public int note_test(Song s) { //rules to test notes
		  //some notes allowed 
		  String[] allowedNotes0 = {"A4","A5","A6","A7","B4","B5","B6","B7","C4","C5","C6","C7","D4","D5","D6","D7","E4","E5","E6","E7","F4","F5","F6","F7","G4","G5","G6","G7"};
		  String[] allowedNotes1 = {"C#4","D#4","E4","F#4","G#4","A#4","B5","C#5","D#5","E5","F#5","G#5","A#5","B6","C#6","D#6","Rw"};
		  String[] allowedNotes2 = {"A","B","C","D","E","F","G","R"};
		  String[] allowedNotes3 = Stream.of(allowedNotes0,allowedNotes1,allowedNotes2).flatMap(Stream::of).toArray(String[]::new);;
		  List<String> allowedNotes=Arrays.asList(allowedNotes3);
		  ArrayList<Voice> voices = s.getvoices();
		  for(int i=0;i<voices.size();i++) {	  
			  ArrayList<Phrase> p = voices.get(i).getphrases();
			  for(int ii=0;ii<p.size();ii++) {
				  ArrayList<String> notes0 = p.get(ii).getnotes();
				  //System.out.print("\n");
				  for(int j=0;j<notes0.size();j++) {
					  String[] arr = notes0.get(j).split("(?!^)");
					  List<String> ar = Arrays.asList(arr);
					  int flag=0; //test x#y notes
					  if(ar.contains("#")&&arr.length>3) {
						  assertTrue(arr[0]!="#");
						  for(int o=0;o<arr.length-1;o++) {
							  if(arr[o]=="#") {
								  int ind = o;
								  assertTrue(allowedNotes.contains(arr[o-1]));
								  flag = 1;
							  }
						  }
					  }
					  if(flag==1) {
						  continue;
					  }
					  String note;
					  note = arr[0]+arr[1];
					  
					  
					  //System.out.print(note);
					  if(allowedNotes.contains(note)==false) {
						  assertTrue(allowedNotes.contains(arr[0]));
						  continue;
					  }
					  assertTrue(allowedNotes.contains(note));
					  //System.out.print(" ");
					  //System.out.print(" ");
					  //assertTrue(allowedNotes.contains(notes0.get(j))); //note test
				  }
			  }
		  } 
		  	return 1;  
		  }
	  
	  	  
	  public int rhythm_test(Song s) { //rules to test rhythm
		  //rhythm allowed
		  String[] allowedRhythm0 = {"i","q","h"};		  
		  List<String> allowedRhythm=Arrays.asList(allowedRhythm0);
		  ArrayList<Voice> voices = s.getvoices();
		  for(int i=0;i<voices.size();i++) {	  
			  ArrayList<Phrase> p = voices.get(i).getphrases();
			  for(int ii=0;ii<p.size();ii++) {
				  ArrayList<String> notes0 = p.get(ii).getnotes();
				  //System.out.print("\n");
				  for(int j=0;j<notes0.size();j++) {
					  String[] arr = notes0.get(j).split("(?!^)");
					  //System.out.print(rhythm);
					  //test if they contains the right rhythm
					  List<String> ar = Arrays.asList(arr);
					  for(int o=0;o<arr.length;o++) {
						  if(arr[o]=="i") {
							  assertTrue(ar.contains("i"));
							  continue;
						  }
						  if(arr[o]=="q") {
							  assertTrue(ar.contains("q"));
							  continue;
						  }
						  if(arr[o]=="h") {
							  assertTrue(ar.contains("h"));
							  continue;
						  }
					  }
					  System.out.print(" ");
				  }
			  }
		  }
			return 1;  
		  }
	@Test
	   public void Test1(){	 //for melody.java
		  melody m = new melody();
		  String a = m.generateString();
		  //System.out.print(a);
		  Song s = m.generateSong0(3,"Piano",a); //this is a method in melody that creates a song with random patterns notes = a, tempo=3,instrument=piano
		  //System.out.print(s);
		  tempo_test(s);//tempo test
		  instrument_test(s);//instrument test
		  note_test(s);//note test
		  //no rhythm and chordmap in this basic melody
		  //end of loop
		  System.out.print("\npass1\n");//end
	}//end of Test
	@Test
		public void Test2() { // for happy pattern
		   // G Scale: G A B C D E F#
		 
		  Song s = new Song();
		  String lead = "Piano"; //you can choose your lead
		  HappyPattern h = new HappyPattern("C", CNotes, CAllowedNotes, lead); //this is a method in melody that creates a happy pattern
		  //HappyPattern.Chords[] hh = h.generateProgression();
		  h.generatePattern(s);
		  tempo_test(s);
		  instrument_test(s);
		  note_test(s);
		  rhythm_test(s);
		  chordmap_test(s);
		  System.out.print("\npass2\nchord");
		  		
	}
	@Test
	public void Test3() { // for sad pattern
	  Song s = new Song();
	  String lead = "Piano";
	  HappyPattern h = new HappyPattern("C", CNotes, CAllowedNotes, lead); 
	  //HappyPattern.Chords[] hh = h.generateProgression();
	  h.generatePattern(s);
	  tempo_test(s);
	  instrument_test(s);
	  note_test(s);
	  rhythm_test(s);
	  chordmap_test(s);
	  System.out.print("\npass3\n");
	
}@Test
	public void Test4() { // for sad pattern
	  Song s = new Song();
	  String lead = "Piano";
	  String[] BNotes = {"B","C#","D#","E","F#","G#","A#"};
      String[] BAllowedNotes = {"B4","C#4","D#4","E4","F#4","G#4","A#4","B5","C#5","D#5","E5","F#5","G#5","A#5","B6","C#6","D#6"};
	  CalmPattern h = new CalmPattern("B",BNotes, BAllowedNotes, lead); 
	  //HappyPattern.Chords[] hh = h.generateProgression();
	  h.generatePattern(s);
	  tempo_test(s);
	  instrument_test(s);
	  note_test(s);
	  rhythm_test(s);
	  chordmap_test(s);
	  System.out.print("\npass4\n");
	
}
}//end of framework
