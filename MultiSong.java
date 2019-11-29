import java.util.ArrayList;

public class MultiSong {

ArrayList<Song> sections;

public MultiSong() {
   sections = new ArrayList<Song>();
}

public boolean addSection(Song s) {
   sections.add(s);
   return true;
}

public boolean clear() {
   sections.clear();
   return true;
}

public String toString() {
   String result = "";
   for(int i = 0; i < sections.size(); i++) {
      result = result+sections.get(i).toString();
   }
   return result;
}

}