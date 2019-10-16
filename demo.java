import org.jfugue.player.Player;
import java.io.*; 
import java.lang.*; 
  
public class demo {
  
  public demo() {
  
  }
  
  public void playMelody(boolean isDisjunct) {
    Player player = new Player();
    Player player2 = new Player();
    
    int notesplayed = 0;
    int previousNote = 0;
    
    //CONJUNCT -> STEPWISE with the "PREVIOUS NOTE" 
    //DISJUNCT -> LEAPS
    
    //REMOVE THIS TO REMOVE TEH CHORD GENERATION
    
    
    
    int chords = 1;
    String returnSong = "string";
    
	String prevMeasureNote = "";
	int measureCount = 0;
    while(chords == 1) {
    	if(measureCount == 8) {
    		break;
    	}
    	//"D#min" Plays in closed position
    	//Forgot to mention -- It's not triads on Hooktheory. Sometimes chords are evoked by simply -- the root of the chord, triads need a bit more work.
    	//For example chords in "Bad Apple" are represented by playing the root and fifth back and forth.
    	//So a D# minor chord in Bad Apple would consist of D#-A#-D#-A# back and forth
    	
    	//player.play("C3w+C4q C4q"); //A I chord -- assumming D# minor
    	
    	if(returnSong == "string") { //Assuming C major and 4/4 time
    		returnSong = "C3w+C5q "; //Assume I chord with 1^ in the melody
    	} else {
    		returnSong = returnSong + " C3w+C5q "; //PUT NEW CHORD HERE... ? Or in another loop
    	} //Then if statement the new chord to decided what 'measure' block to go into...
    	
    	int num2 = (int)(Math.random() * 4);
    	if(num2 == 1) {
    		returnSong = returnSong + " C5q"; //repeat the previous 1^
    		int num3 = (int)(Math.random() * 2);
    		if(num3 == 1) {
    			returnSong = returnSong + " Eb5q"; //Rules state third beat is a chord tone
    			int num4 = (int)(Math.random() * 3);
    			if (num4 == 1) {
    				returnSong = returnSong + " D5q"; //2^
    				prevMeasureNote = "D5q";
    			} else if (num4 == 2) {
    				returnSong = returnSong + " Eb5q"; //3^
    				prevMeasureNote = "Eb5q";
    			} else {
    				returnSong = returnSong + " F5q"; //4^
    				prevMeasureNote = "F5q";
    			}
    		} else {								//Options are to go to 3^ or 5^
    			returnSong = returnSong + " G4q"; //Assuming you go down to 5^
    			//Options are: repeat 5, down to 4, or up to 6
    			int num4 = (int)(Math.random() * 3);
    			if (num4 == 1) {
    				returnSong = returnSong + " G5q"; //5^
    				prevMeasureNote = "G5q";
    			} else if (num4 == 2) {
    				returnSong = returnSong + " A5bq"; //6^
    				prevMeasureNote = "Ab5q"; //I am not sure if we should evoke 6^... It's a 'tricky' scale degree when it comes to music theory for me at least... 
    			} else {
    				returnSong = returnSong + " F5q"; //4^
    				prevMeasureNote = "F5q";
    			}
    		}
    	} else if (num2 == 2){
    		returnSong = returnSong + " D5q"; //Move to 2^
    		int num3 = (int)(Math.random()*2);
    		if(num3 == 1) {
    			returnSong = returnSong + " C5q";//Moves back down to 1^
    			int num4 = (int)(Math.random() * 3);
    			if (num4 == 1) {
    				returnSong = returnSong + " D5q"; //2^
    				prevMeasureNote = "D5q";
    			} else if (num4 == 2) {
    				returnSong = returnSong + " C5q"; //1^
    				prevMeasureNote = "C5q";
    			} else {
    				returnSong = returnSong + " Bb4q"; //7^
    				prevMeasureNote = "Bb4q";
    			}
    		} else {
    			returnSong = returnSong + " Eb5q";//Moves up to 3^
    			int num4 = (int)(Math.random() * 3);
    			if (num4 == 1) {
    				returnSong = returnSong + " D5q"; //2^
    				prevMeasureNote = "D5q";
    			} else if (num4 == 2) {
    				returnSong = returnSong + " Eb5q"; //3^
    				prevMeasureNote = "Eb5q";
    			} else {
    				returnSong = returnSong + " F5q"; //4^
    				prevMeasureNote = "F5q";
    			}
    		}
    	} else if (num2 == 3){
    		returnSong = returnSong + " Bb4q"; //Move down to 7^, in this ruleset next note must be 1^
    		returnSong = returnSong + " C5q"; //Note to self {B5 -> C5 is a seventh apart, B4 is adjacent to C5}
    		int num4 = (int)(Math.random() * 3);
			if (num4 == 1) {
				returnSong = returnSong + " D5q"; //2^
				prevMeasureNote = "D5q";
			} else if (num4 == 2) {
				returnSong = returnSong + " C5q"; //1^
				prevMeasureNote = "C5q";
			} else {
				returnSong = returnSong + " Bb4q"; //7^
				prevMeasureNote = "Bb4q";
			}
    	} else {
    		returnSong = returnSong + " Eb5q"; //Move up to 3^, next note must be 5^
    		returnSong = returnSong + " G5q";
    		int num4 = (int)(Math.random() * 3);
			if (num4 == 1) {
				returnSong = returnSong + " G5q"; //5^
				prevMeasureNote = "G5q";
			} else if (num4 == 2) {
				returnSong = returnSong + " A5bq"; //6^
				prevMeasureNote = "Ab5q"; //I am not sure if we should evoke 6^... It's a 'tricky' scale degree when it comes to music theory for me at least... 
			} else {
				returnSong = returnSong + " F5q"; //4^
				prevMeasureNote = "F5q";
			}
    	}
    	
    	measureCount++;
    	
    	//Possibilities for prevMeasureNote: [((lower)7^->1^) && (1^-6^)]
    	//Prev Chord = 'i or I', potential next chord = II, VII, VI, III 
    	if(prevMeasureNote == "Bb4q") {
    		//figure out what chords with the given ruleset
    	} else if (prevMeasureNote == "C5q") {
    		
    	}
    	
    	//player.play(returnSong);
    	//SECOND ".PLAY" WILL PLAY AFTER ALL OF THE FIRST PLAYS. USE THE ABOVE TO MODEL VARYING RYTHYMS
    	//player.play("D#3h+A#5q+C#5q"); //build the entire string - then play the entire string
    	//player.play("D#3h+D#5q+C#5q");
    	//player.play("C#5q");
    	
    	
    	
    	
    	/*	Will have to figure out how to play two notes at once with different duration;
    		for example a half note for harmony while a quarter note melody in the top line 
    		is being played. SOLUTION: player.play("D#3h+A#5q+C#5q+C#5w");
    	*/
    	
    	//Start on i [5511]
    	//Go to VI [2311]
    	//Perhaps VII next [7276]
    	//Perhaps V next [5457]
    	//go to i [1711]
    	//go to ii [2343
    	//go to III [3355]
    	//go to V [5456]
    	
    	//i'm not too up on newer stuff, but musicians have always foregone
    	//flat out playing chords in favor of arpeggiating them?
    	//to make it more "music-y" arpeggios are necessary
    	 
    	//rarely includes the fifths in chords, almost always just do the 3rd and the root
    	
    	
    	//How do you 'hold' one chord for 2 beats while playing two melody notes of 1 beat?
    	//Why does the last note played end 'abruptly' for example [C D E F] the F is about half the beat of the others 
    }
    
    player.play(returnSong);
    //return;
    
    //Just some notes about some music notes:
    	//Futatsuiwa from Sado
    		//The first 8 outline the baseline of the next 8. 
    		//After the listener is primed, the next 8's dissonances aren't as noticable.
    		//STRETCH GOAL TO RECORD -> THE IMPLEMENTATION OF THIS.
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //int disjunct = 1;
    if(isDisjunct) { 
	   while(true) {
	    	//	(int)(Math.random() * ((max - min) + 1)) + min
	    	// It's interesting, randomly generating notes between C4 and C5
	    	// only has two potential dissonances: C4 -> B4 (well also D4 -> C5) and the tritone B -> F 
	    	int number = 0;
		   while(Math.abs(number - previousNote) < 4) {
	    		number = (int)(Math.random() * 8);
	    	}
	    	
	    	if(number == 1) {
	        	player.play("C4");
	        	if(notesplayed > 16) { //breaks arbitrary after returning to C4 after 16 or more notes were played
	        		break;
	        	}
	    	} else if(number == 2) {
	        	player.play("D4");    		
	    	} else if(number == 3) {
	    		player.play("E4");
	    	} else if(number == 4) {
	    		player.play("F4");
	    	} else if(number == 5) {
	    		player.play("G4");
	    	} else if(number == 6) {
	    		player.play("A4");
	    	} else if(number == 7) {
	    		player.play("B4");
	    	} else if(number == 8) {
	    		player.play("C5");
	    	}
	    	notesplayed++;
	    	previousNote = number;
	    }
	  }
     
     else {
	    int previousLeap = 0;
		int number = (int)((Math.random() * 9) - 1);
	    while(true) {
	    	
	    		    //PLUS SIGN TO PLAY MULTIPLE NOTES TOGETHER {This plays 3 C's}
	    		    
	    	//	(int)(Math.random() * ((max - min) + 1)) + min
	    	int max = 2;
	    	int min = 0;
	    	number = previousNote + (1 - (int)(Math.random() * ((max - min) + 1)) + min);
	    	if(number < 0) {
	    		number = 1;
	    	}
	    	if(number > 8) {
	    		number = 5;
	    	}
	    	//CHORDS NEED TO BE OPEN POSITION -- CLOSED POSITION SOUNDS KINDA... BAD... 
	    	if(number == 0) {
	        	player.play("V0 B4");
	        	if(notesplayed % 4 == 0) {
	        		player2.play("V1 G3majw"); //These play and then wait for the next notes to play...
	        	}
	    	} else if(number == 1) {
	        	player.play("V0 C4");  
	        	if(notesplayed % 4 == 0) {
	        		player2.play("V1 C3majw");
	        	}
	    	} else if(number == 2) {
	        	player.play("V0 D4");
	        	if(notesplayed % 4 == 0) {
	        		player2.play("V1 D3minw");
	        	}
	    	} else if(number == 3) {
	    		player.play("V0 E4");
	    		if(notesplayed % 4 == 0) {
	        		player2.play("V1 C3majw");
	        	}
	    	} else if(number == 4) {
	    		player.play("V0 F4");
	    		if(notesplayed % 4 == 0 && (previousNote == 3 || previousNote == 5)) {
	        		player2.play("V1 D3minw");
	        	} else if(notesplayed % 4 == 0) {
	        		player2.play("V1 F3majw");
	        	}
	    	} else if(number == 5) {
	    		player.play("V0 G4");
	    		if(notesplayed % 4 == 0) {
	        		player2.play("V1 G3majw");
	        	}
	    	} else if(number == 6) {
	    		player.play("V0 A4");
	    		if(notesplayed % 4 == 0) {
	        		player2.play("V1 F3majw");
	        	}
	    	} else if(number == 7) {
	    		player.play("V0 B4");
	    		if(notesplayed % 4 == 0) {
	        		player2.play("V1 G3majw");
	        	}
	    	} else if(number == 8) {
	    		player.play("V0 C5");
	    		if(notesplayed % 4 == 0) {
	        		player2.play("V1 C3majw");
	        	}
	    	}
	    	notesplayed++;
	    	previousNote = number;
	    }
	  }
  }
}