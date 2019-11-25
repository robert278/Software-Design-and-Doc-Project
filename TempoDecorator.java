/*

  _______                         _____                           _             
 |__   __|                       |  __ \                         | |            
    | | ___ _ __ ___  _ __   ___ | |  | | ___  ___ ___  _ __ __ _| |_ ___  _ __ 
    | |/ _ \ '_ ` _ \| '_ \ / _ \| |  | |/ _ \/ __/ _ \| '__/ _` | __/ _ \| '__|
    | |  __/ | | | | | |_) | (_) | |__| |  __/ (_| (_) | | | (_| | || (_) | |   
    |_|\___|_| |_| |_| .__/ \___/|_____/ \___|\___\___/|_|  \__,_|\__\___/|_|   
                     | |                                                        
                     |_|                                                       
                     
This file is a decorator which takes in a song object and adds a specific tempo to that song.
This is one of the decorators that can be applied to a song after it has been modified by 
going through a pattern rule set.

*/

public class TempoDecorator implements SongRuleSet {
	int tempo;
	
	public TempoDecorator(int t) { tempo = t; };
	
	public void generateSong(Song s) {
		s.setTempo(tempo);
	}
}