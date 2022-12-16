package prova2lp2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/** Representação de um Controller de actions.
 * Todo ActionController precisa de um ChallengeController.
 * 
 * @author Dhouglas Bandeira
 *
 */
public class ActionController {
	
	/**
	 * Mapa (code, Action) de actions.
	 */
	private HashMap<String, Action> actionsMap;
	
	/**
	 * Controller de challenges.
	 */
	private ChallengeController challengeController;
	
	/** Cria um controller a partir de um challengeController.
	 * 
	 * @param challengeController
	 */
	public ActionController(ChallengeController challengeController) {
		this.actionsMap = new HashMap<String, Action>();
		this.challengeController = challengeController;
	}
	
	/** Adiciona uma ação.
	 * Operação não permitida se existir action de
	 * código já cadastrado ou challenge inexistente.
	 * 
	 * @param challengeIndex
	 * @param date
	 * @param code
	 * @return true - operação bem sucedida
	 */
	public boolean addAction(int challengeIndex, String date, String code) {
		if (this.actionAlreadyExists(code)) {
			throw new IllegalArgumentException("AÇÂO JÁ EXISTE!");
		}
		
		Challenge challenge = this.challengeController.getChallenge(challengeIndex);
		
		Action action = new Action(challenge, date, code);
		this.actionsMap.put(code, action);
		return true;
	}
	
	/** Pega uma action no mapa.
	 * 
	 * @param code
	 * @return Action
	 */
	public Action getAction(String code) {
		return this.actionsMap.get(code);
	}
	
	/** adiciona progress à action.
	 * Operação não permitida se a action não existir
	 * ou a action estiver finalizada.
	 * 
	 * @param Action code
	 */
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
	
	/** adiciona progress à action.
	 * Operação não permitida se a action não existir
	 * ou a action estiver finalizada.
	 * 
	 * @param Action code
	 * @param value
	 */
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
	
	/** Lista todas as actions registradas ordenadas
	 * pelos seus respectivos progressos.
	 * 
	 * @return
	 */
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
					+ " - "
					+ action.getChallenge().getTitle()
					+ " - Progresso "
					+ action.getProgress()
					+ "\n";
		}
		
		return result;
	}
	
	/** verifica se a action foi cadastrada.
	 * 
	 * @param code
	 * @return true - action existe, false - action inexistente.
	 */
	private boolean actionAlreadyExists(String code) {
		return this.actionsMap.containsKey(code);
	}
}
