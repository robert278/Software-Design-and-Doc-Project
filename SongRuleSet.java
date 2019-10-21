/*
   _____                   _____       _       _____      _   
  / ____|                 |  __ \     | |     / ____|    | |  
 | (___   ___  _ __   __ _| |__) |   _| | ___| (___   ___| |_ 
  \___ \ / _ \| '_ \ / _` |  _  / | | | |/ _ \\___ \ / _ \ __|
  ____) | (_) | | | | (_| | | \ \ |_| | |  __/____) |  __/ |_ 
 |_____/ \___/|_| |_|\__, |_|  \_\__,_|_|\___|_____/ \___|\__|
                      __/ |                                   
                     |___/                                    
An interface for defining what makes a complete song, from an array
of patterns, and what methods need to be present for a ruleset to be 
considered complete.

In words the requirements for a complete pattern are as follows:
1. How are patterns modified? (If at all)
2. How are patterns fit together?
*/
import org.jfugue.pattern.Pattern;
import java.util.ArrayList;

interface SongRuleSet {
   Song generateSong(ArrayList<Pattern> patterns);
}