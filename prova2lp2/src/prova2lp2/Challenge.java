package prova2lp2;

public class Challenge {

	private String title;
	
	private String description;
	
	private int performedTimes;
	
	public Challenge(String title, String description) {
		this.title = title;
		this.description = description;
		this.performedTimes = 0;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public int getPerformedTimes() {
		return this.performedTimes;
	}
	
	public void performChallenge() {
		this.performedTimes++;
	}
	
	@Override
	public String toString() {
		String result = "Título: " + this.title + "\n"
		+ this.performedTimes + " execuções\n";

		return result;
	}
}
