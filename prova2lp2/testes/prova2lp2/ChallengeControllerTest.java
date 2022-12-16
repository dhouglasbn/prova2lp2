package prova2lp2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Test Case do controller das challenges.
 * 
 * @author Dhouglas Bandeira
 *
 */
class ChallengeControllerTest {
	
	private ChallengeController challengeController;

	@BeforeEach
	void setUp() throws Exception {
		this.challengeController = new ChallengeController();
	}
	
	@Test
	void addPersonalChallengeTest() {
		String msg = "Espera-se que seja adicionado um desafio pessoal ao controller, "
				+ "retornando o valor do índice do elemento 1.";
		int expectedValue = 1;
		
		int result = this.challengeController.addPersonalChallenge("Desafio teste", "teste");
		
		assertEquals(expectedValue, result, msg);
	}
	
	@Test
	void addAlreadyExistentPersonalChallengeTest() {
		String msg = "Espera-se que não seja possível adicionar um desafio pessoal "
				+ "de título já existente.";
		
		String challengeName = "Desafio2";
		
		this.challengeController.addPersonalChallenge("Desafio1", "teste");
		this.challengeController.addPersonalChallenge(challengeName, "teste");
		this.challengeController.addPersonalChallenge("Desafio3", "teste");
		
		assertThrows(
				IllegalArgumentException.class,
				() -> this.challengeController
				.addPersonalChallenge(challengeName, "teste"),
				msg
				);
	}
	
	@Test
	void addNoDescriptionPersonalChallengeTest() {
		String msg = "Espera-se que seja adicionado um desafio pessoal sem descrição ao controller, "
				+ "retornando o valor do índice do elemento 1.";
		int expectedValue = 1;
		
		int result = this.challengeController.addPersonalChallenge("Desafio teste");
		
		assertEquals(expectedValue, result, msg);
	}
	
	@Test
	void addAlreadyExistentNoDescriptionPersonalChallengeTest() {
		String msg = "Espera-se que não seja possível adicionar um desafio pessoal sem descrição "
				+ "de título já existente.";
		
		String challengeName = "Desafio2";
		
		this.challengeController.addPersonalChallenge("Desafio1");
		this.challengeController.addPersonalChallenge(challengeName);
		this.challengeController.addPersonalChallenge("Desafio3");
		
		assertThrows(
				IllegalArgumentException.class,
				() -> this.challengeController
				.addPersonalChallenge(challengeName),
				msg
				);
	}
	
	@Test
	void addMaterialChallengeTest() {
		String msg = "Espera-se que seja adicionado um desafio material ao controller, "
				+ "retornando o valor do índice do elemento 1.";
		int expectedValue = 1;
		
		int result = this.challengeController.addMaterialChallenge("Desafio teste", "teste", 5000);
		
		assertEquals(expectedValue, result, msg);
	}
	
	@Test
	void addAlreadyExistentMaterialChallengeTest() {
		String msg = "Espera-se que não seja possível adicionar um desafio material "
				+ "de título já existente.";
		
		String challengeName = "Desafio2";
		
		this.challengeController.addMaterialChallenge("Desafio1", "teste", 5000);
		this.challengeController.addMaterialChallenge(challengeName, "teste", 6000);
		this.challengeController.addMaterialChallenge("Desafio3", "teste", 4500);
		
		assertThrows(
				IllegalArgumentException.class,
				() -> this.challengeController
				.addMaterialChallenge(challengeName, "teste", 1000),
				msg
				);
	}
	
	@Test
	void addNoDescriptionMaterialChallengeTest() {
		String msg = "Espera-se que seja adicionado um desafio material sem descrição ao controller, "
				+ "retornando o valor do índice do elemento 1.";
		int expectedValue = 1;
		
		int result = this.challengeController.addMaterialChallenge("Desafio teste", 4000);
		
		assertEquals(expectedValue, result, msg);
	}
	
	@Test
	void addAlreadyExistentNoDescriptionMaterialChallengeTest() {
		String msg = "Espera-se que não seja possível adicionar um desafio material sem descrição "
				+ "de título já existente.";
		
		String challengeName = "Desafio2";
		
		this.challengeController.addMaterialChallenge("Desafio1", 4000);
		this.challengeController.addMaterialChallenge(challengeName, 5000);
		this.challengeController.addMaterialChallenge("Desafio3", 6000);
		
		assertThrows(
				IllegalArgumentException.class,
				() -> this.challengeController
				.addMaterialChallenge(challengeName, 5000),
				msg
				);
	}
	
	@Test
	void addSocialChallengeTest() {
		String msg = "Espera-se que seja adicionado um desafio social ao controller, "
				+ "retornando o valor do índice do elemento 1.";
		int expectedValue = 1;
		
		int result = this.challengeController.addSocialChallenge("Desafio teste", "teste", 1);
		
		assertEquals(expectedValue, result, msg);
	}
	
	@Test
	void addAlreadyExistentSocialChallengeTest() {
		String msg = "Espera-se que não seja possível adicionar um desafio social "
				+ "de título já existente.";
		
		String challengeName = "Desafio2";
		
		this.challengeController.addSocialChallenge("Desafio1", "teste", 1);
		this.challengeController.addSocialChallenge(challengeName, "teste", 1);
		this.challengeController.addSocialChallenge("Desafio3", "teste", 1);
		
		assertThrows(
				IllegalArgumentException.class,
				() -> this.challengeController
				.addPersonalChallenge(challengeName, "teste"),
				msg
				);
	}
	
	@Test
	void addNoDescriptionSocialChallengeTest() {
		String msg = "Espera-se que seja adicionado um desafio social sem descrição ao controller, "
				+ "retornando o valor do índice do elemento 1.";
		int expectedValue = 1;
		
		int result = this.challengeController.addSocialChallenge("Desafio teste", 1);
		
		assertEquals(expectedValue, result, msg);
	}
	
	@Test
	void addAlreadyExistentNoDescriptionSocialChallengeTest() {
		String msg = "Espera-se que não seja possível adicionar um desafio social sem descrição "
				+ "de título já existente.";
		
		String challengeName = "Desafio2";
		
		this.challengeController.addSocialChallenge("Desafio1", 1);
		this.challengeController.addSocialChallenge(challengeName, 1);
		this.challengeController.addSocialChallenge("Desafio3", 1);
		
		assertThrows(
				IllegalArgumentException.class,
				() -> this.challengeController
				.addSocialChallenge(challengeName, 1),
				msg
				);
	}
	
	@Test
	void showChallengeTest() {
		String msg = "Espera-se que ao mostrar mostrar um desafio, "
				+ "seja retornado o valor no formato esperado";
		String expectedValue = "Título: Desafio teste (pessoal)\n0 execuções\n";
		
		this.challengeController.addPersonalChallenge("Desafio teste", "teste");
		
		String result = this.challengeController.showChallenge(1);
		
		assertEquals(expectedValue, result, msg);
	}
	
	@Test
	void showInexistentChallengeTest() {
		String msg = "Espera-se que ao mostrar um desafio inexistente o valor "
				+ "seja lançada a exceção IndexOutOfBoundsException.";
		
		assertThrows(
				IndexOutOfBoundsException.class,
				() -> this.challengeController.showChallenge(47),
				msg
				);
	}
}
