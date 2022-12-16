package prova2lp2;

import java.util.ArrayList;

//IMPORTANTE
// PERGUNTAR SE A CONTAGEM COMEÇA EM 1.
// PERGUNTAR O QUE É A SEGUNDA STRING NO ADD_CHALLENGE

/** Representação do Controller de challenges.
 * 
 * @author Dhouglas Bandeira
 *
 */
public class ChallengeController {

	/**
	 * Lista de challenges.
	 */
	private ArrayList<Challenge> challengesList;
	
	/**
	 *  Cria um controller de challenges.
	 */
	public ChallengeController() {
		this.challengesList = new ArrayList<Challenge>();
	}
	
	/** Adiciona uma challenge à lista
	 * Operação não permitida se uma challenge de mesmo
	 * título já foi cadastrada.
	 * 
	 * @param title
	 * @param description
	 * @return posição da challenge.
	 */
	public int addChallenge(String title, String description) {
		
		if (this.challengeAlreadyExists(title)) {
			throw new IllegalArgumentException("DESAFIO JÁ EXISTE!");
		}
		
		Challenge challenge = new Challenge(title, description);
		this.challengesList.add(challenge);
		return this.challengesList.indexOf(challenge) + 1;
	}
	
	/** Pega uma challenge.
	 * 
	 * @param index
	 * @return Challenge
	 */
	public Challenge getChallenge(int index) {
		int realIndex = index - 1;
		return this.challengesList.get(realIndex);
	}
	
	/** Pega a representação de uma Challenge.
	 * 
	 * @param index
	 * @return representação da challenge.
	 */
	public String showChallenge(int index) {
		int realIndex = index - 1;
		return this.challengesList.get(realIndex).toString();
	}
	
	/** Percorre toda a lista de challenges
	 *  e verifica se há alguma challenge
	 *  com o título especificado.
	 *  
	 * @param title
	 * @return true - Challenge existe, false - Challenge inexistente.
	 */
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
