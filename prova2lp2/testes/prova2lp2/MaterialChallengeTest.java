package prova2lp2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Test Caste das challenges materiais.
 * 
 * @author Dhouglas Bandeira
 *
 */
class MaterialChallengeTest {
	
	private MaterialChallenge materialChallenge;

	@BeforeEach
	void setUp() throws Exception {
		this.materialChallenge = new MaterialChallenge("Desafio teste", 5000);
	}

	@Test
	void performChallengeTest() {
		String msg = "Espera-se que ao realizar o desafio 3 vezes, o desafio "
				+ "tenha sido executado 3 vezes.";
		int expectedValue = 3;
		
		this.materialChallenge.performChallenge();
		this.materialChallenge.performChallenge();
		this.materialChallenge.performChallenge();
		
		int result = this.materialChallenge.getPerformedTimes();
		
		assertEquals(expectedValue, result, msg);
	}

	@Test
	void toStringTest() {
		String msg = "Espera-se que o resultado do toString"
				+ " esteja no formato esperado.";
		String expectedValue = "Título: " + this.materialChallenge.getTitle() + " (material)\n"
				+ this.materialChallenge.getPerformedTimes() + " execuções\n";
		
		String result = this.materialChallenge.toString();
		
		assertEquals(expectedValue, result, msg);
	}
	
	@Test
	void calculateSatisfactionTest() {
		String msg = "Espera-se que o resultado do cálculo seja exatamente 500.";
		int expectedValue = 500;
		
		this.materialChallenge.performChallenge();
		int result = this.materialChallenge.getSatisfaction();
		
		assertEquals(expectedValue, result, msg);
	}
}
