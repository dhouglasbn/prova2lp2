package prova2lp2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Test case do controller de actions.
 * 
 * @author Dhouglas Bandeira
 *
 */
class ActionControllerTest {
	
	private ChallengeController challengeController;
	
	private ActionController actionController;

	@BeforeEach
	void setUp() throws Exception {
		this.challengeController = new ChallengeController();
		this.actionController = new ActionController(challengeController);
	}

	@Test
	void addActionTest() {
		String msg = "Espera-se que a adição da ação seja bem sucedida.";
		
		this.challengeController.addChallenge("Desafio teste", "teste");
		
		boolean result = this.actionController.addAction(1, "00/00/0000", "11");
		
		assertTrue(result, msg);
	}
	
	@Test
	void addAlreadyExistentActionTest() {
		String msg = "Espera-se que na adição de uma ação já"
				+ " existente lance a exceção IllegalArgumentException.";
		
		this.challengeController.addChallenge("Desafio teste", "teste");
		this.actionController.addAction(1, "00/00/0000", "11");
		
		assertThrows(
				IllegalArgumentException.class,
				() -> this.actionController.addAction(1, "00/00/0000", "11"),
				msg
				);
	}
	
	@Test
	void addActionOnInexistentChallenge() {
		String msg = "Espera-se que na adição de uma ação em um desafio"
				+ " inexistente lance a exceção IndexOutOfBoundsException.";
		
		this.challengeController.addChallenge("Desafio teste", "teste");
		
		assertThrows(
				IndexOutOfBoundsException.class,
				() -> this.actionController.addAction(47, "00/00/0000", "11"),
				msg
				);
	}
	
	@Test
	void addNoValueActionProgress () {
		String msg = "Espera-se que ao adicionar progresso sem valor em "
				+ "uma ação, o valor 10 seja adicionado ao progresso.";
		int expectedValue = 10;
		
		this.challengeController.addChallenge("Desafio teste", "teste");
		this.actionController.addAction(1, "00/00/0000", "11");
		this.actionController.addActionProgress("11");
		int result = this.actionController.getAction("11").getProgress();
		
		assertEquals(expectedValue, result, msg);
	}
	
	@Test
	void addNoValueOnInexistentActionProgress() {
		String msg = "Espera-se que ao adicionar progresso sem valor em "
				+ "uma ação inexistente, seja lançada a exceção "
				+ "IllegalArgumentException.";
		
		this.challengeController.addChallenge("Desafio teste", "teste");
		this.actionController.addAction(1, "00/00/0000", "11");
		
		assertThrows(
				IllegalArgumentException.class,
				() -> this.actionController.addActionProgress("22"),
				msg
				);
	}
	
	@Test
	void addNoValueOnFinishedActionProgress() {
		String msg = "Espera-se que ao adicionar progresso sem valor em "
				+ "uma ação que já foi finalizada(progresso 100), "
				+ "seja lançada a exceção IllegalStateException.";
		
		this.challengeController.addChallenge("Desafio teste", "teste");
		this.actionController.addAction(1, "00/00/0000", "11");
		this.actionController.addActionProgress("11", 100);
		
		assertThrows(
				IllegalStateException.class,
				() -> this.actionController.addActionProgress("11"),
				msg
				);
	}
	
	@Test
	void addActionProgress() {
		String msg = "Espera-se que ao adicionar progresso em "
				+ "uma ação, o valor dado seja adicionado ao progresso.";
		int expectedValue = 75;
		
		this.challengeController.addChallenge("Desafio teste", "teste");
		this.actionController.addAction(1, "00/00/0000", "11");
		this.actionController.addActionProgress("11", 75);
		int result = this.actionController.getAction("11").getProgress();
		
		assertEquals(expectedValue, result, msg);
	}
	
	@Test
	void addInexistentActionProgress() {
		String msg = "Espera-se que ao adicionar progresso em "
				+ "uma ação inexistente, seja lançada a exceção "
				+ "IllegalArgumentException.";
		
		this.challengeController.addChallenge("Desafio teste", "teste");
		this.actionController.addAction(1, "00/00/0000", "11");
		
		assertThrows(
				IllegalArgumentException.class,
				() -> this.actionController.addActionProgress("22", 20),
				msg
				);
	}
		
	
	@Test
	void addFinishedActionProgress() {
		String msg = "Espera-se que ao adicionar progresso em "
				+ "uma ação que já foi finalizada(progresso 100), "
				+ "seja lançada a exceção IllegalStateException.";
		
		this.challengeController.addChallenge("Desafio teste", "teste");
		this.actionController.addAction(1, "00/00/0000", "11");
		this.actionController.addActionProgress("11", 110);
		
		assertThrows(
				IllegalStateException.class,
				() -> this.actionController.addActionProgress("11", 30),
				msg
				);
	}
	
	@Test
	void displayActionsByProgress() {
		String msg = "Espera-se que seja listado as ações ordenadas pelo "
				+ "status de progresso.";
		String expectedResult = "Acao 33 - 00/00/0000 - "
				+ "Desafio teste2 - Progresso 20\n"
				+ "Acao 22 - 00/00/0000 - "
				+ "Desafio teste - Progresso 40\n"
				+ "Acao 44 - 00/00/0000 - "
				+ "Desafio teste2 - Progresso 50\n"
				+ "Acao 11 - 00/00/0000 - "
				+ "Desafio teste - Progresso 80\n";
		
		this.challengeController.addChallenge("Desafio teste", "teste");
		this.challengeController.addChallenge("Desafio teste2", "teste");
		this.actionController.addAction(1, "00/00/0000", "11");
		this.actionController.addAction(1, "00/00/0000", "22");
		this.actionController.addAction(2, "00/00/0000", "33");
		this.actionController.addAction(2, "00/00/0000", "44");
		
		this.actionController.addActionProgress("11", 80);
		this.actionController.addActionProgress("22", 40);
		this.actionController.addActionProgress("33", 20);
		this.actionController.addActionProgress("44", 50);
		
		String result = this.actionController.displayActionsByProgress();
		
		assertEquals(expectedResult, result, msg);
	}

}
