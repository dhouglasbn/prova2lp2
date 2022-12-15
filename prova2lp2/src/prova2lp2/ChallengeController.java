package prova2lp2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class ChallengeController {

	private ArrayList<Challenge> challengesList;
	
	private HashMap<String, Action> actionsMap;
	
	public ChallengeController() {
		this.challengesList = new ArrayList<Challenge>();
		this.actionsMap = new HashMap<String, Action>();
	}
	
	// IMPORTANTE
	// PERGUNTAR SE A CONTAGEM COMEÇA EM 1.
	public int addChallenge(String title, String description) {
		
		if (this.challengeAlreadyExists(title)) {
			throw new IllegalArgumentException("DESAFIO JÁ EXISTE!");
		}
		
		Challenge challenge = new Challenge(title, description);
		this.challengesList.add(challenge);
		return this.challengesList.indexOf(challenge) + 1;
	}
	
	public String showChallenge(int index) {
		int realIndex = index - 1;
		return this.challengesList.get(realIndex).toString();
	}
	
	public boolean addAction(int challengeIndex, String date, String code) {
		if (this.actionAlreadyExists(code)) {
			throw new IllegalArgumentException("AÇÂO JÁ EXISTE!");
		}
		
		int realIndex = challengeIndex - 1;
		Challenge challenge = this.challengesList.get(realIndex);
		
		Action action = new Action(challenge, date, code);
		this.actionsMap.put(code, action);
		return true;
	}
	
	public void addActionProgress(String code) {
		if (!this.actionAlreadyExists(code)) {
			throw new IllegalArgumentException("AÇÃO INEXISTENTE!");
		}
		
		Action action = this.actionsMap.get(code);
		if (action.isActionFinished()) {
			throw new IllegalStateException("DESAFIO CONCLUÍDO!");
		}
		
		action.incrementProgress();
	}
	
	public void addActionProgress(String code, int value) {
		if (!this.actionAlreadyExists(code)) {
			throw new IllegalArgumentException("AÇÃO INEXISTENTE!");
		}
		
		Action action = this.actionsMap.get(code);
		if (action.isActionFinished()) {
			throw new IllegalStateException("DESAFIO CONCLUÍDO!");
		}
		
		action.incrementProgress(value);
	}
	
	public String displayActionsByProgress() {
		String result = "";
		ArrayList<Action> actions = new ArrayList<Action>();
		
		for (Action action: this.actionsMap.values()) actions.add(action);
		
		Collections.sort(actions);
		for (Action action: actions) {
			result += "Acao "
					+ action.getCode()
					+ " - "
					+ action.getDate()
					+ "- "
					+ action.getChallenge().getTitle()
					+ "- Progresso "
					+ action.getProgress()
					+ "\n";
		}
		
		return result;
	}
	
	private boolean actionAlreadyExists(String code) {
		return this.actionsMap.containsKey(code);
	}
	
	private boolean challengeAlreadyExists(String title) {
		boolean challengeAlreadyExists = false;
		
		for (int index = 0; index < this.challengesList.size(); index++) {
			if (this.challengesList.get(index).getTitle().equals(title)) {
				challengeAlreadyExists = true;
			}
		}
		
		return challengeAlreadyExists;
	}
}
