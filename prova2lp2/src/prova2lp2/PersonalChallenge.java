package prova2lp2;

/** Representação de um desafio pessoal.
 * Todo desasfio pessoal precisa de um título e uma descrição opcional.
 * A quantidade de vezes que o desafio foi completo
 * começa em 0.
 * 
 * @author Dhouglas Bandeira
 *
 */
public class PersonalChallenge extends Challenge {

	/** Cria um desafio pessoal a partir de um título e descrição.
	 * 
	 * @param title
	 * @param description
	 */
	public PersonalChallenge(String title, String description) {
		super(title, description);
	}
	
	/** Cria um desafio pessoal a partir de um título.
	 * 
	 * @param title
	 */
	public PersonalChallenge(String title) {
		super(title);
		
	}
	
	@Override
	public void performChallenge() {
		this.performedTimes++;
		this.calculateSatisfaction();
	}
	
	@Override
	public String toString() {
		String result = "Título: " + this.title + " (pessoal)\n"
		+ this.performedTimes + " execuções\n";

		return result;
	}

	@Override
	public void calculateSatisfaction() {
		this.satisfaction += 10;
	}
}
