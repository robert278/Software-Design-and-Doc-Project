import org.jfugue.pattern.Pattern;
import java.util.ArrayList;

interface SongRuleSet {
   Song generateSong(ArrayList<Pattern> patterns);
}