package prova2lp2;

/** Representação de um desafio.
 * Todo desasfio precisa de um título e uma descrição.
 * A quantidade de vezes que o desafio foi completo
 * começa em 0.
 * 
 * @author Dhouglas Bandeira
 *
 */
public class Challenge {

	/**
	 * Título do desafio.
	 */
	private String title;
	
	/**
	 * Descrição do desafio
	 */
	private String description;
	
	/**
	 * quantidade de vezes que o desafio foi executado.
	 */
	private int performedTimes;
	
	/** Cria uma Challenge a partir de um título e descrição.
	 *  quantidade de execuções começa em 0.
	 * 
	 * @param title
	 * @param description
	 */
	public Challenge(String title, String description) {
		this.title = title;
		this.description = description;
		this.performedTimes = 0;
	}
	
	/** Pega o título da Challenge
	 * 
	 * @return title
	 */
	public String getTitle() {
		return this.title;
	}
	
	/** Pega a descrição da Challenge
	 * 
	 * @return description
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * Pega a quantidade de vezes 
	 * que o desafio foi executado.
	 * @return performedTimes
	 */
	public int getPerformedTimes() {
		return this.performedTimes;
	}
	
	/**
	 * incremeta uma vez que o desafio foi executado.
	 */
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
