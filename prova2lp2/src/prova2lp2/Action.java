package prova2lp2;

/** Representação de uma ação que implementa
 * Comparable.
 * 
 * @author Dhouglas Bandeira
 *
 */
public class Action implements Comparable<Action> {

	/**
	 * Desafio contido em action.
	 */
	private Challenge challenge;
	
	/**
	 * Data que a ação começou.
	 */
	private String date;
	
	/**
	 * Progresso(0 - 100).
	 */
	private int progress;
	
	/**
	 * Código único da ação.
	 */
	private String code;
	
	/**
	 * Indica se a ação finalizou.
	 */
	private boolean finishedAction;
	
	/** Constrói uma action a partir de
	 * uma challenge, uma data de início e
	 * um código único.
	 * 
	 * @param challenge
	 * @param date
	 * @param code
	 */
	public Action(Challenge challenge, String date, String code) {
		this.challenge = challenge;
		this.date = date;
		this.code = code;
		this.progress = 0;
		this.finishedAction = false;
	}
	
	/** Pega a challenge a qual a Action pertence.
	 * 
	 * @return challenge
	 */
	public Challenge getChallenge() {
		return this.challenge;
	}
	
	/** Pega a data de início da ação.
	 * 
	 * @return date
	 */
	public String getDate() {
		return this.date;
	}
	
	/** Pega o progresso da ação.
	 * 
	 * @return progress
	 */
	public int getProgress() {
		return this.progress;
	}
	
	/** Pega o código único da ação.
	 * 
	 * @return code
	 */
	public String getCode() {
		return this.code;
	}
	
	/** incrementa o valor 10 no progresso.
	 * verifica o progresso.
	 */
	public void incrementProgress() {
		this.progress += 10;
		this.verifyProgress();
	}
	
	/** incrementa um valor ao progresso.
	 * verifica o progresso.
	 * 
	 * @param value
	 */
	public void incrementProgress(int value) {
		this.progress += value;
		this.verifyProgress();
	}
	
	/** Verifica se a ação já acabou.
	 * 
	 * @return true - finalizado, false - em progresso.
	 */
	public boolean isActionFinished() {
		return this.finishedAction;
	}
	
	@Override
	public int compareTo(Action object) {
		return this.progress - object.getProgress();
	}
	
	/** Se o progresso atingiu o valor 100.
	 * O progresso se torna 100.
	 * Incrementa uma execução na challenge.
	 * A action torna-se finalizada.
	 * 
	 */
	private void verifyProgress() {
		if (progress >= 100) {
			this.progress = 100;
			this.challenge.performChallenge();
			this.finishedAction = true;
		}
	}
}
