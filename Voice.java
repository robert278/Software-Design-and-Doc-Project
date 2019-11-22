import java.util.ArrayList;

public class Voice {
   String instrument;
   ArrayList<Phrase> phrases;
   
   public Voice(String i) {
      instrument = i;
      phrases = new ArrayList<Phrase>();
   }
   
   public boolean addPhrase(Phrase p) {
      phrases.add(p);
      return true;
   }
   
   public String toString() {
      String voice = " I["+instrument+"] ";
      for(int i = 0; i < phrases.size(); i++) {
         voice = voice+phrases.get(i).toString();
      }
      return voice;
   }
   
   public Voice concatVoices(Voice other) {
      for(int i = 0; i < other.phrases.size(); i++) {
         this.phrases.add(other.phrases.get(i));
      }
      return this;
   }
}