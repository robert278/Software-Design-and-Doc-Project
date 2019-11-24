/* 
*   _    _ _____ _____                            _   
*  | |  | |_   _|  __ \                          | |  
*  | |  | | | | | |__) |___  __ _ _   _  ___  ___| |_ 
*  | |  | | | | |  _  // _ \/ _` | | | |/ _ \/ __| __|
*  | |__| |_| |_| | \ \  __/ (_| | |_| |  __/\__ \ |_ 
*   \____/|_____|_|  \_\___|\__, |\__,_|\___||___/\__|
*                              | |                    
*                              |_|                    
*
* The purpose of this class to encapsulate the state of the UI as a request, that can be passed to the bridge between the UI and SongGenerator.
* The SongGenerator bridge can then unpack it, and fulfil the request with the help of the SongGenerator subcomponets.
*/
import java.util.ArrayList;
import java.io.File;

public class UIRequest {
   
   // Member variables for generate.
   private UIEnums.RequestType request;
   private ArrayList<UIEnums.Instrument> instrument = new ArrayList<UIEnums.Instrument>();
   private ArrayList<UIEnums.Theme> theme = new ArrayList<UIEnums.Theme>();
   
   // Member variables for loading
   private File loadedFile;
   
   
   // Regular constructor, to be used by UI
   public UIRequest(UIEnums.RequestType r, ArrayList<UIEnums.Instrument> i, ArrayList<UIEnums.Theme> t) {
      request = r;
      instrument.addAll(i);
      theme.addAll(t);
   }
   
   public boolean setFile(File f) {
      loadedFile = f;
      return true;
   }
   
   public File getFile() {
      return loadedFile;
   }
   
   // Copy constructor, to be used by Bridge
   public UIRequest(UIRequest other) {
      this.request = other.request;
      this.instrument = other.instrument;
      this.theme = other.theme;
   }
   
   public UIEnums.RequestType GetRequestType() {
      return request;
   }
   public UIEnums.Instrument GetInstrument(int num) {
      if(num < instrument.size())
         return instrument.get(num);
      return null;
   }
   public UIEnums.Theme GetTheme(int num) {
      if(num < theme.size())
         return theme.get(num);
      return null;
   }
   public int GetNumInstruments() {
      return instrument.size();
   }
   public int GetNumThemes() {
      return theme.size();
   }
}