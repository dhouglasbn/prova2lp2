package prova2lp2;

public class Action implements Comparable<Action> {

	private Challenge challenge;
	
	private String date;
	
	private int progress;
	
	private String code;
	
	private boolean finishedAction;
	
	public Action(Challenge challenge, String date, String code) {
		this.challenge = challenge;
		this.date = date;
		this.code = code;
		this.progress = 0;
		this.finishedAction = false;
	}
	
	public Challenge getChallenge() {
		return this.challenge;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public int getProgress() {
		return this.progress;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public void incrementProgress() {
		this.progress += 10;
		this.verifyProgress();
	}
	
	public void incrementProgress(int value) {
		this.progress += value;
		this.verifyProgress();
	}
	
	public boolean isActionFinished() {
		return this.finishedAction;
	}
	
	@Override
	public int compareTo(Action object) {
		return this.progress - object.getProgress();
	}
	
	private void verifyProgress() {
		if (progress > 100) {
			this.progress = 100;
			this.challenge.performChallenge();
			this.finishedAction = true;
		}
	}
}
