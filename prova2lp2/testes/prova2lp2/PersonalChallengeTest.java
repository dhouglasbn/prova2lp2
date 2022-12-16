package prova2lp2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Test Caste das challenges pessoais.
 * 
 * @author Dhouglas Bandeira
 *
 */
class PersonalChallengeTest {
	
	private PersonalChallenge personalChallenge;

	@BeforeEach
	void setUp() throws Exception {
		this.personalChallenge = new PersonalChallenge("Desafio teste", "testar");
	}

	@Test
	void performChallengeTest() {
		String msg = "Espera-se que ao realizar o desafio 3 vezes, o desafio "
				+ "tenha sido executado 3 vezes.";
		int expectedValue = 3;
		
		this.personalChallenge.performChallenge();
		this.personalChallenge.performChallenge();
		this.personalChallenge.performChallenge();
		
		int result = this.personalChallenge.getPerformedTimes();
		
		assertEquals(expectedValue, result, msg);
	}

	@Test
	void toStringTest() {
		String msg = "Espera-se que o resultado do toString"
				+ " esteja no formato esperado.";
		String expectedValue = "Título: " + this.personalChallenge.getTitle() + " (pessoal)\n"
				+ this.personalChallenge.getPerformedTimes() + " execuções\n";
		
		String result = this.personalChallenge.toString();
		
		assertEquals(expectedValue, result, msg);
	}
	
	@Test
	void calculateSatisfactionTest() {
		String msg = "Espera-se que o resultado do cálculo seja exatamente 10.";
		int expectedValue = 10;
		
		this.personalChallenge.performChallenge();
		int result = this.personalChallenge.getSatisfaction();
		
		assertEquals(expectedValue, result, msg);
	}
}
