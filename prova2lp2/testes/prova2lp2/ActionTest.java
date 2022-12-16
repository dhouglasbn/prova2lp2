package prova2lp2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ActionTest {

	private Action action;
	
	@BeforeEach
	void setUp() throws Exception {
		Challenge challenge = new Challenge("Desafio teste", "teste");
		this.action = new Action(challenge, "00/00/0000", "11");
	}
	
	@Test
	void incrementProgressTest() {
		String msg = "Espera-se que ao incrementar o progresso, "
				+ "o progresso esteja com mais 10.";
		int expectedResult = 10;
		
		this.action.incrementProgress();
		int result = this.action.getProgress();
		
		assertEquals(expectedResult, result, msg);
	}
	
	@Test
	void incrementValueProgressTest() {
		String msg = "Espera-se que ao incrementar o progresso, "
				+ "o progresso esteja com mais 75.";
		int expectedResult = 75;
		
		this.action.incrementProgress(75);
		int result = this.action.getProgress();
		
		assertEquals(expectedResult, result, msg);
	}
	
	@Test
	void incrementOver100ProgressTest() {
		String msg1 = "Espera-se que o progresso esteja exatamente com 100 de valor.";
		String msg2 = "Espera-se que o desafio seja incrementado em 1.";
		String msg3 = "Espera-se que a ação esteja finalizada (true).";
		int expectedResult1 = 100;
		int expectedResult2 = 1;
		
		this.action.incrementProgress(175);
		
		int result = this.action.getProgress();
		int challengesPerformed = this.action
				.getChallenge()
				.getPerformedTimes();
		boolean isActionFinished = this.action.isActionFinished();
		
		assertEquals(expectedResult1, result, msg1);
		assertEquals(expectedResult2, challengesPerformed, msg2);
		assertTrue(isActionFinished, msg3);
	}

	@Test
	void isActionProgressHigher() {
		String msg = "Espera-se que a ação de teste seja maior que a ação "
				+ "comparada, pois seu progresso é maior. (resultado > 0)";
		
		Challenge challenge = new Challenge("Desafio teste!", "teeste");
		Action action2 = new Action(challenge, "00/00/000", "22");
		
		this.action.incrementProgress(80);
		action2.incrementProgress(40);
		boolean result = this.action.compareTo(action2) > 0;
		
		assertTrue(result, msg);
	}
	
	@Test
	void isActionProgressLower() {
		String msg = "Espera-se que a ação de teste seja menor que a ação "
				+ "comparada, pois seu progresso é maior. (resultado < 0)";
		
		Challenge challenge = new Challenge("Desafio teste!", "teeste");
		Action action2 = new Action(challenge, "00/00/000", "22");
		
		this.action.incrementProgress(50);
		action2.incrementProgress(77);
		boolean result = this.action.compareTo(action2) < 0;
		
		assertTrue(result, msg);
	}
	
	@Test
	void isActionProgressEquals() {
		String msg = "Espera-se que a ação de teste seja igual que a ação "
				+ "comparada, pois seu progresso é maior. (resultado == 0)";
		
		Challenge challenge = new Challenge("Desafio teste!", "teeste");
		Action action2 = new Action(challenge, "00/00/000", "22");
		
		this.action.incrementProgress(90);
		action2.incrementProgress(90);
		boolean result = this.action.compareTo(action2) == 0;
		
		assertTrue(result, msg);
	}
}
