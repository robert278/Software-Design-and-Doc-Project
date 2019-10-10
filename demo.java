import org.jfugue.player.Player;

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
    
    while(chords == 1) {
    	//"D#min" Plays in closed position
    	//Forgot to mention -- It's not triads on Hooktheory. Sometimes chords are evoked by simply -- the root of the chord, triads need a bit more work.
    	//For example chords in "Bad Apple" are represented by playing the root and fifth back and forth.
    	//So a D# minor chord in Bad Apple would consist of D#-A#-D#-A# back and forth
    	
    	player.play("D#3h+A#5q"); //A I chord -- assumming D# minor
    	player.play("D#3h+A#5q"); //build the entire string - then play the entire string
    	player.play("D#3h+D#5q");
    	player.play("D#3h+D#5q");
    	
    	/*	Will have to figure out how to play two notes at once with different duration;
    		for example a half note for harmony while a quarter note melody in the top line 
    		is being played. 
    	*/
    	
    	//Start on i [5511]
    	//Go to VI [2311]
    	//Perhaps VII next [7276]
    	//Perhaps V next [5457]
    	//go to i [1711]
    	//go to ii [2343
    	//go to III [3355]
    	//go to V [5456]
    	
    	
    	
    	//How do you 'hold' one chord for 2 beats while playing two melody notes of 1 beat?
    	//Why does the last note played end 'abruptly' for example [C D E F] the F is about half the beat of the others 
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
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