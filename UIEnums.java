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
      GENERATE, EXIT, SAVE;
   }
   public enum PatternType {
      HAPPYCALM, HAPPYINTENSE, SADCALM, SADINTENSE;
   }
   public enum LeadingInstrument {
      PIANO, FLUTE, TRUMPET;
   }
}