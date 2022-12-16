package prova2lp2;

/** Representação de um desafio social.
 * Todo desasfio social precisa de um título e uma descrição opcional.
 * A quantidade de vezes que o desafio foi completo
 * começa em 0.
 * 
 * @author dhouglas.nobrega
 *
 */
public class SocialChallenge extends Challenge {
	
	/**
	 * Número de pessoas atingidas pelo desafio.
	 */
	private int persons;

	/** Cria um desafio social a partir de um título e descrição.
	 * 
	 * @param title
	 * @param description
	 */
	public SocialChallenge(String title, String description, int persons) {
		super(title, description);
		this.persons = persons;
	}
	
	/** Cria um desafio social a partir de um título.
	 * 
	 * @param title
	 */
	public SocialChallenge(String title, int persons) {
		super(title);
		this.persons = persons;
	}
	
	/** Pega o número de pessoas atingidas pelo desafio.
	 * 
	 * @return persons
	 */
	public int getPersons() {
		return this.persons;
	}
	
	@Override
	public void performChallenge() {
		this.performedTimes++;
		this.calculateSatisfaction();
	}
	
	@Override
	public String toString() {
		String result = "Título: " + this.title + " (social)\n"
		+ this.performedTimes + " execuções\n";

		return result;
	}

	@Override
	public void calculateSatisfaction() {
		if (this.persons >= 10 && this.persons <= 50) {
			this.satisfaction += 20;
		}else if (this.persons >= 51 && this.persons <= 100) {
			this.satisfaction += 50;
		}else if (this.persons > 100) {
			this.satisfaction += this.persons;
		}
	}
}
