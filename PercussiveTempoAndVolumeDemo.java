import java.util.Random;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.jfugue.rhythm.Rhythm;

public class PercussiveTempoAndVolumeDemo {
    public static void main(String[] args) {
        Rhythm rhythm = new Rhythm()
        .addLayer("O..oO...O..oOO..")
        .addLayer("..S...S...S...S.");
        //.addLayer("````````````````")
        //.addLayer("...............+");
        Player player = new Player();
        int count = 0;
        String toPlay = "";
        while(count < 32) {//32 quarter notes of random volume
        	count++;
        	Random random = new Random();
            int randomInteger = random.nextInt(120);
        	toPlay = toPlay + "Cqa" + randomInteger + "d64 ";
        }
        player.play(rhythm.getPattern()); //WHY IF YOU DON'T COMMENT THIS LINE OUT THE BELOW LINE IS A PERCUSSION?
    	player.play(toPlay); //WITH The above line, this plays a bongo-like drum, without the above line, it plays the default piano -- why is this...
    	//The pattern class has a .setTempo(value) method
    //new Player().play(rhythm.getPattern().repeat(2));
    }
}