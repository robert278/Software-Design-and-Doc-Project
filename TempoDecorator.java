public class TempoDecorator implements SongRuleSet {
	int tempo;
	
	public TempoDecorator(int t) { tempo = t; };
	
	public void generateSong(Song s) {
		s.setTempo(tempo);
	}
}