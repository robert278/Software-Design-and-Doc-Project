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
public class UIRequest {
   
   private UIEnums.RequestType request;
   private UIEnums.PatternType pattern;
   private UIEnums.LeadingInstrument instrument;
   
   // Regular constructor, to be used by UI
   public UIRequest(UIEnums.RequestType r, UIEnums.PatternType p, UIEnums.LeadingInstrument i) {
      request = r;
      pattern = p;
      instrument = i;
   }
   
   // Copy constructor, to be used by Bridge
   public UIRequest(UIRequest other) {
      this.request = other.request;
      this.pattern = other.pattern;
      this.instrument = other.instrument;
   }
   
   public UIEnums.RequestType GetRequestType() {
      return request;
   }
   public UIEnums.LeadingInstrument GetLeadingInstrument() {
      return instrument;
   }
   public UIEnums.PatternType GetPattern() {
      return pattern;
   }
}