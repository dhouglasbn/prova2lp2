package prova2lp2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChallengeControllerTest {
	
	private ChallengeController challengeController;

	@BeforeEach
	void setUp() throws Exception {
		this.challengeController = new ChallengeController();
	}
	
	@Test
	void addChallengeTest() {
		String msg = "Espera-se que seja adicionado um desafio ao controller, "
				+ "retornando o valor do índice do elemento 1.";
		int expectedValue = 1;
		
		int result = this.challengeController.addChallenge("Desafio teste", "teste");
		
		assertEquals(expectedValue, result, msg);
	}
	
	@Test
	void addAlreadyExistentChallengeTest() {
		String msg = "Espera-se que não seja possível adicionar um desafio "
				+ "de título já existente.";
		
		String challengeName = "Desafio2";
		
		this.challengeController.addChallenge("Desafio1", "teste");
		this.challengeController.addChallenge(challengeName, "teste");
		this.challengeController.addChallenge("Desafio3", "teste");
		
		assertThrows(
				IllegalArgumentException.class,
				() -> this.challengeController
				.addChallenge(challengeName, "teste"),
				msg
				);
	}
	
	@Test
	void showChallengeTest() {
		String msg = "Espera-se que ao mostrar mostrar um desafio, "
				+ "seja retornado o valor no formato esperado";
		String expectedValue = "Título: Desafio teste\n0 execuções\n";
		
		this.challengeController.addChallenge("Desafio teste", "teste");
		
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
