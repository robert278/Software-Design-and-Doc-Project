/*
  _____      _   _                  ____              _    
 |  __ \    | | | |                |  _ \            | |   
 | |__) |_ _| |_| |_ ___ _ __ _ __ | |_) | __ _ _ __ | | __
 |  ___/ _` | __| __/ _ \ '__| '_ \|  _ < / _` | '_ \| |/ /
 | |  | (_| | |_| ||  __/ |  | | | | |_) | (_| | | | |   < 
 |_|   \__,_|\__|\__\___|_|  |_| |_|____/ \__,_|_| |_|_|\_\
                                                           
The pattern bank serves to be a data structure to hold all the various patterns
created by the various rulesets, and distribute them to the songs which will use
them.                                                           
*/
import org.jfugue.pattern.Pattern;
import java.util.ArrayList;

class PatternBank {
   ArrayList<Pattern> bank;
   
   public PatternBank() {
      bank = new ArrayList<Pattern>();
   }
   
   public ArrayList<Pattern> getPatterns(int numPatterns) { // TODO: discuss way to get by type. ANSWER: Use many methods, getHappy, getSad
      int numPatternsToGet = Math.min(bank.size(), numPatterns);
      ArrayList<Pattern> returnedPatterns = new ArrayList<Pattern>();
      for(int i = 0; i < numPatternsToGet; i++) {
         returnedPatterns.add(bank.get(i));
      }
      return returnedPatterns;
   }
   
   public void addToBank(Pattern p) {
      bank.add(p);
   }
}
