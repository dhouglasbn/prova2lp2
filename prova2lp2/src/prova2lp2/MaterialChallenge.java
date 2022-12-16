package prova2lp2;

/** Representação de um desafio material.
 * Todo desasfio material precisa de um título e uma descrição opcional.
 * A quantidade de vezes que o desafio foi completo
 * começa em 0.
 * 
 * @author dhouglas.nobrega
 *
 */
public class MaterialChallenge extends Challenge {
	
	/**
	 * meta de investimento.
	 */
	private int goal;

	/** Cria um desafio material a partir de um título e descrição.
	 * 
	 * @param title
	 * @param description
	 */
	public MaterialChallenge(String title, String description, int goal) {
		super(title, description);
		this.goal = goal;
	}
	
	/** Cria um desafio material a partir de um título.
	 * 
	 * @param title
	 */
	public MaterialChallenge(String title, int goal) {
		super(title);
		this.goal = goal;
	}
	
	/** Pega a meta de investimento.
	 * 
	 * @return goal
	 */
	public int getGoal() {
		return this.goal;
	}
	
	@Override
	public void performChallenge() {
		this.performedTimes++;
		this.calculateSatisfaction();
	}
	
	@Override
	public String toString() {
		String result = "Título: " + this.title + " (material)\n"
		+ this.performedTimes + " execuções\n";

		return result;
	}

	@Override
	public void calculateSatisfaction() {
		this.satisfaction += this.goal / 100 * 10;
	}
}
