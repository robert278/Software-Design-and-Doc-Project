/*
  _____      _   _                  _____       _       _____      _   
 |  __ \    | | | |                |  __ \     | |     / ____|    | |  
 | |__) |_ _| |_| |_ ___ _ __ _ __ | |__) |   _| | ___| (___   ___| |_ 
 |  ___/ _` | __| __/ _ \ '__| '_ \|  _  / | | | |/ _ \\___ \ / _ \ __|
 | |  | (_| | |_| ||  __/ |  | | | | | \ \ |_| | |  __/____) |  __/ |_ 
 |_|   \__,_|\__|\__\___|_|  |_| |_|_|  \_\__,_|_|\___|_____/ \___|\__|                                                                       

An interface for defining what makes a complete pattern, and what methods
need to be present for a ruleset to be considered complete.

In words the requirements for a complete pattern are as follows:
1. What are the instruments that can be used in this pattern?                                                                       
*/

public interface PatternRuleSet {
   void generatePattern(Song s);
}