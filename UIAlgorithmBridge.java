/* Class:
*   _    _ _____          _                  _ _   _               ____       _     _            
*  | |  | |_   _|   /\   | |                (_) | | |             |  _ \     (_)   | |           
*  | |  | | | |    /  \  | | __ _  ___  _ __ _| |_| |__  _ __ ___ | |_) |_ __ _  __| | __ _  ___ 
*  | |  | | | |   / /\ \ | |/ _` |/ _ \| '__| | __| '_ \| '_ ` _ \|  _ <| '__| |/ _` |/ _` |/ _ \
*  | |__| |_| |_ / ____ \| | (_| | (_) | |  | | |_| | | | | | | | | |_) | |  | | (_| | (_| |  __/
*   \____/|_____/_/    \_\_|\__, |\___/|_|  |_|\__|_| |_|_| |_| |_|____/|_|  |_|\__,_|\__, |\___|
*                            __/ |                                                     __/ |     
*                           |___/                                                     |___/    
*  
* The goal of this class is to provide a way for the UI and the music generation algorthm to communicate.
* This is done indirectly by having the UI and the Algorithm components communicate solely with this class.
* The UI does this by passing in all the options which have been selected by the user. At this point, the UI
* has finished it's role in the particular music generation. Programming wise, this is done by passing a
* selection object to the bridge, which is responsible for unpacking it, creating the necessary subcomponents
* from the generator algorithm, and making sure the correct calls are made. The bridge's responsibility ends
* when the request from the UI is fulfilled. 
*/

import java.util.ArrayList;
import org.jfugue.pattern.Pattern;

public class UIAlgorithmBridge {
   private UIRequest request;
   
   public UIAlgorithmBridge() { /* do nothing */  } 
   
   public boolean acceptRequest(UIRequest newAction) {
      // Check the type of the request
      request = newAction;
      if(request.GetRequestType() == UIEnums.RequestType.STOP) {
         // OurPlayer.stop()
      }
      if(request.GetRequestType() == UIEnums.RequestType.SAVE) {
         // OurPlayer.save()?
      }
      if(request.GetRequestType() == UIEnums.RequestType.GENERATE) {
         // Get the patterns for the request
         melody melodyGenerator = new melody();
         ArrayList<Pattern> patterns = new ArrayList<Pattern>();
         for(int i = 0; i < 5; i++) {
            patterns.add(melodyGenerator.generatePattern());
         }
         // Send created patterns to the pattern bank (is this necessary?)
         
         // Have the song accept the patterns
         Song thisSong = new Song();
         thisSong.AcceptPatterns(patterns);
         
         // Send the completed song to the player
         OurPlayer thisPlayer = new OurPlayer();
         thisPlayer.playSong(thisSong);
      }
      return true;
   }
}