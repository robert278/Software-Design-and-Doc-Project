public class ConclusionDecorator implements SongRuleSet {
	String key;
	
	public ConclusionDecorator(String k) { key = k; };
	
	public Song generateSong(Song s) {
		String jfugueSong = s.GetSong();
		// Last measure will either have an C major, F major, or A minor chord.
		int decider = (int)(Math.random()*3);
		String lastMeasure = "";
		if(decider == 0)
			lastMeasure = "Cmajw+Cq_Eq_Gq_Cq";
		else if(decider == 1)
			lastMeasure = "Fmajw+Fq_Aq_Aq_Cq";
		else // if(decider == 2)
			lastMeasure = "Aminw+Eq_Gq_Aq_Cq";
		return new Song(jfugueSong+lastMeasure);
	}
}