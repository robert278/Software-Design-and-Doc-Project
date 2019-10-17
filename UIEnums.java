/*
  _    _ _____ ______                           
 | |  | |_   _|  ____|                          
 | |  | | | | | |__   _ __  _   _ _ __ ___  ___ 
 | |  | | | | |  __| | '_ \| | | | '_ ` _ \/ __|
 | |__| |_| |_| |____| | | | |_| | | | | | \__ \
  \____/|_____|______|_| |_|\__,_|_| |_| |_|___/

This file is used to store the various options that are used in the UI, as
well as the types of requests that are supported by the bridge.
*/
public class UIEnums {
   public enum RequestType {
      GENERATE, STOP, SAVE;
   }
   public enum Key {
      C, CSHARP, D, DSHARP, E, F, FSHARP, G, GSHARP, A, ASHARP, B;
   }
   enum KeySignature {
      FOURFOUR, TWOTWO, TWOFOUR, THREEFOUR, THREEEIGHT; 
   }
   enum Tempo {
      GRAVE, LARGO, LENTO, ADAGIO, ANDANTE;
   }
   enum Emotion {
      JOY, EXCITEMENT, SURPRISE, SADNESS, DEPRESS, CURE;
   }
}