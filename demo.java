import org.jfugue.player.Player;

public class demo {
  
  public demo() {
  
  }
  
  public void playMelody(boolean isDisjunct) {
    Player player = new Player();
    
    int notesplayed = 0;
    int previousNote = 0;
    
    //CONJUNCT -> STEPWISE with the "PREVIOUS NOTE" 
    //DISJUNCT -> LEAPS
    
    int disjunct = 1;
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
	    	if(number == 0) {
	        	player.play("B4");
	    	} else if(number == 1) {
	        	player.play("C4");    		
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
  }
}