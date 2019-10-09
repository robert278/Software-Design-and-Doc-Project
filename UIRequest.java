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
   private UIEnums.Key key;
   private UIEnums.KeySignature keysig;
   private UIEnums.Tempo tempo;
   private UIEnums.Emotion emotion;
   
   // Regular constructor, to be used by UI
   public UIRequest(UIEnums.RequestType r, UIEnums.Key k, UIEnums.KeySignature ks, UIEnums.Tempo t, UIEnums.Emotion e) {
      request = r;
      key = k;
      keysig = ks;
      tempo = t;
      emotion = e;
   }
   
   // Copy constructor, to be used by Bridge
   public UIRequest(UIRequest other) {
      this.request = other.request;
      this.key = other.key;
      this.keysig = other.keysig;
      this.tempo = other.tempo;
      this.emotion = other.emotion;
   }
   
   public UIEnums.RequestType GetRequestType() {
      return request;
   }
   public UIEnums.Key GetKey() {
      return key;
   }
   public UIEnums.KeySignature GetKeySignature() {
      return keysig;
   }
   public UIEnums.Tempo GetTempo() {
      return tempo;
   }
   public UIEnums.Emotion GetEmotion() {
      return emotion;
   }
   
}