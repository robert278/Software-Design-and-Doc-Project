import org.jfugue.pattern.Pattern;
import java.util.ArrayList;

class PatternBank {
   ArrayList<Pattern> bank;
   
   public PatternBank() {
      bank = new ArrayList<Pattern>();
   }
   
   public ArrayList<Pattern> getPatterns(int numPatterns) { // TODO: discuss way to get by type
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