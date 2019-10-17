/*

  __  __      _           _       
 |  \/  |    | |         | |      
 | \  / | ___| | ___   __| |_   _ 
 | |\/| |/ _ \ |/ _ \ / _` | | | |
 | |  | |  __/ | (_) | (_| | |_| |
 |_|  |_|\___|_|\___/ \__,_|\__, |
                             __/ |
                            |___/ 
This is an implementation of the pattern rule set interface, and is one of the 
pattern sets which is used to create songs. This pattern that this file is
implementing is the simple melody, which just creates a conjunct melody with the
following rules:

TODO: Fill in rules.

*/

import java.util.Random;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

class melody implements PatternRuleSet {
   
   // Constructor for melody.
   public melody() { /* do nothing... */ }
   
   
   // Returns a single pattern which contains 8 4/4 measures, all of which follow the
   // rules listed above. 
   public Pattern generatePattern() {
      int duration = 32;
      int i=0;
   	
      String[] letter = {"A","B","C","D","E","F","G"};
      String[] number = {"4","5"};	
   			
      int[] charset=new int[duration];     //store [1,3,4,6,4,6,4,5,0,1,0.......] index of letter
      int[] intset= new int[duration]; //store [0,1,0,1,1......] index of number
   	
      while(i<duration) {
         Random rand = new Random();
         String alphabet;
         int n1 = rand.nextInt(7);
         int n2 = rand.nextInt(2);
         if(i>1) {
            int dist = charset[i-1]-charset[i-2];
            int dist2 = intset[i-1]-intset[i-2];
            if(dist>2) {
               if(charset[i-1]==6) {charset[i]=6;} //e.g A5 -> G5 -> G5
               else{charset[i]=charset[i-1]+1;}// e.g A5 ->F5 -> G5 
               intset[i]=intset[i-1];
               i=i+1;
               continue;
            }
            if(dist<-2) {
               if(charset[i-1]==0) {charset[i]=0;} //e.g G5->A5->A5
               else {charset[i]=charset[i-1]-1;} // e.g G5->B2->A5 
               intset[i]=intset[i-1];
               i=i+1;
               continue;
            }
         	
         }
         charset[i]=n1;
         intset[i]=n2;
         i = i+1;
      }
      i=0;
      String pattern="";
      while(i<duration) {
         pattern = pattern + letter[charset[i]];
         pattern = pattern + number[intset[i]];
         pattern = pattern+" ";
         i = i+1;
      }
      return new Pattern(pattern);	  
   }
}