package prova2lp2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Test Caste das challenges.
 * 
 * @author Dhouglas Bandeira
 *
 */
class ChallengeTest {
	
	private Challenge challenge;

	@BeforeEach
	void setUp() throws Exception {
		this.challenge = new Challenge("Desafio teste", "testar");
	}

	@Test
	void performChallengeTest() {
		String msg = "Espera-se que ao realizar o desafio 3 vezes, o desafio "
				+ "tenha sido executado 3 vezes.";
		int expectedValue = 3;
		
		this.challenge.performChallenge();
		this.challenge.performChallenge();
		this.challenge.performChallenge();
		
		int result = this.challenge.getPerformedTimes();
		
		assertEquals(expectedValue, result, msg);
	}

	@Test
	void toStringTest() {
		String msg = "Espera-se que o resultado do toString"
				+ " esteja no formato esperado.";
		String expectedValue = "Título: " + this.challenge.getTitle() + "\n"
				+ this.challenge.getPerformedTimes() + " execuções\n";
		
		String result = this.challenge.toString();
		
		assertEquals(expectedValue, result, msg);
	}
}
