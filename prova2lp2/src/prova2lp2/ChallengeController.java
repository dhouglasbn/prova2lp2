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
	
	/** Adiciona uma challenge pessoal à lista
	 * Operação não permitida se uma challenge de mesmo
	 * título já foi cadastrada.
	 * 
	 * @param title
	 * @param description
	 * @return posição da challenge.
	 */
	public int addPersonalChallenge(String title, String description) {
		
		if (this.challengeAlreadyExists(title)) {
			throw new IllegalArgumentException("DESAFIO JÁ EXISTE!");
		}
		
		PersonalChallenge personalChallenge = new PersonalChallenge(title, description);
		this.challengesList.add(personalChallenge);
		return this.challengesList.indexOf(personalChallenge) + 1;
	}
	
	/** Adiciona uma challenge pessoal sem descrição à lista
	 * Operação não permitida se uma challenge de mesmo
	 * título já foi cadastrada.
	 * 
	 * @param title
	 * @param description
	 * @return posição da challenge.
	 */
	public int addPersonalChallenge(String title) {
		
		if (this.challengeAlreadyExists(title)) {
			throw new IllegalArgumentException("DESAFIO JÁ EXISTE!");
		}
		
		PersonalChallenge personalChallenge = new PersonalChallenge(title);
		this.challengesList.add(personalChallenge);
		return this.challengesList.indexOf(personalChallenge) + 1;
	}
	
	/** Adiciona uma challenge material à lista
	 * Operação não permitida se uma challenge de mesmo
	 * título já foi cadastrada.
	 * 
	 * @param title
	 * @param description
	 * @param goal
	 * @return posição da challenge.
	 */
	public int addMaterialChallenge(String title, String description, int goal) {
		
		if (this.challengeAlreadyExists(title)) {
			throw new IllegalArgumentException("DESAFIO JÁ EXISTE!");
		}
		
		MaterialChallenge materialChallenge = new MaterialChallenge(title, description, goal);
		this.challengesList.add(materialChallenge);
		return this.challengesList.indexOf(materialChallenge) + 1;
	}
	
	/** Adiciona uma challenge material sem descrição à lista
	 * Operação não permitida se uma challenge de mesmo
	 * título já foi cadastrada.
	 * 
	 * @param title
	 * @param description
	 * @param goal
	 * @return posição da challenge.
	 */
	public int addMaterialChallenge(String title, int goal) {
		
		if (this.challengeAlreadyExists(title)) {
			throw new IllegalArgumentException("DESAFIO JÁ EXISTE!");
		}
		
		MaterialChallenge materialChallenge = new MaterialChallenge(title, goal);
		this.challengesList.add(materialChallenge);
		return this.challengesList.indexOf(materialChallenge) + 1;
	}
	
	/** Adiciona uma challenge social à lista
	 * Operação não permitida se uma challenge de mesmo
	 * título já foi cadastrada.
	 * 
	 * @param title
	 * @param description
	 * @param persons
	 * @return posição da challenge.
	 */
	public int addSocialChallenge(String title, String description, int persons) {
		
		if (this.challengeAlreadyExists(title)) {
			throw new IllegalArgumentException("DESAFIO JÁ EXISTE!");
		}
		
		SocialChallenge materialChallenge = new SocialChallenge(title, description, persons);
		this.challengesList.add(materialChallenge);
		return this.challengesList.indexOf(materialChallenge) + 1;
	}
	
	/** Adiciona uma challenge social sem descrição à lista
	 * Operação não permitida se uma challenge de mesmo
	 * título já foi cadastrada.
	 * 
	 * @param title
	 * @param description
	 * @param persons
	 * @return posição da challenge.
	 */
	public int addSocialChallenge(String title, int persons) {
		
		if (this.challengeAlreadyExists(title)) {
			throw new IllegalArgumentException("DESAFIO JÁ EXISTE!");
		}
		
		SocialChallenge socialChallenge = new SocialChallenge(title, persons);
		this.challengesList.add(socialChallenge);
		return this.challengesList.indexOf(socialChallenge) + 1;
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
