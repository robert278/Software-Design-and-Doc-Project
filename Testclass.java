import org.jfugue.player.Player;
import org.junit.Test;
 
import static org.junit.Assert.*;
import java.lang.String;
//again I test the generated pattern when it's string. But it should be a Pattern type
public class Testclass extends melody{
   @Test
   public void ruleset(){
	  String[] pattern = generatePattern().split(" "); //store patterns into array
	  int i = 0;
	  while(i<pattern.length-2) {
		  String[] a = pattern[i].split("(?!^)"); //split each pattern =>["C","4"]
		  String[] b = pattern[i+1].split("(?!^)");
		  String[] c = pattern[i+2].split("(?!^)");
		  
		  assertEquals(a.length,2); //assert pattern has length 2 e.g["C","4"]
		  assertEquals(b.length,2);
		  assertEquals(c.length,2);
		  
		  char x = Character.toLowerCase(a[0].charAt(0));
		  char y = Character.toLowerCase(b[0].charAt(0));
		  char z = Character.toLowerCase(c[0].charAt(0));
		  int d12 = y-x;
		  int d23= z-y;
		  if(d12>2) {
			  if(y=='g') {assertEquals(b[0],c[0]);//if the second note is g, the third note repeats
			  			  assertEquals(b[1],c[1]);
			  			  i=i+1;
			  			  continue;
			  }
			  assertEquals(d23,1);
			  assertEquals(b[1],c[1]);
		  }
		  if(d12<-2) {
			  if(y=='a') {assertEquals(b[0],c[0]);//if the second note is a, the third note repeats
  			  assertEquals(b[1],c[1]);
  			  i=i+1;
  			  continue;
			  }
			  assertEquals(d23,-1);
			  assertEquals(b[1],c[1]);
		  }
		  
		  i=i+1;
	  }
	
	  
   }
   //other tests can be made here
   
}

