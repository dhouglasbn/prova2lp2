package prova2lp2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Test Caste das challenges sociais.
 * 
 * @author Dhouglas Bandeira
 *
 */
class SocialChallengeTest {
	
	private SocialChallenge socialChallenge;

	@BeforeEach
	void setUp() throws Exception {
		this.socialChallenge = new SocialChallenge("Desafio teste", 9);
	}

	@Test
	void performChallengeTest() {
		String msg = "Espera-se que ao realizar o desafio 3 vezes, o desafio "
				+ "tenha sido executado 3 vezes.";
		int expectedValue = 3;
		
		this.socialChallenge.performChallenge();
		this.socialChallenge.performChallenge();
		this.socialChallenge.performChallenge();
		
		int result = this.socialChallenge.getPerformedTimes();
		
		assertEquals(expectedValue, result, msg);
	}

	@Test
	void toStringTest() {
		String msg = "Espera-se que o resultado do toString"
				+ " esteja no formato esperado.";
		String expectedValue = "Título: " + this.socialChallenge.getTitle() + " (social)\n"
				+ this.socialChallenge.getPerformedTimes() + " execuções\n";
		
		String result = this.socialChallenge.toString();
		
		assertEquals(expectedValue, result, msg);
	}
	
	@Test
	void calculateUnder10PersonsSatisfaction() {
		String msg = "Espera-se que o resultado do cálculo de satisfação com menos de "
				+ "10 pessoas resulte em 0.";
		int expectedValue = 0;
		
		this.socialChallenge.performChallenge();
		int result = this.socialChallenge.getSatisfaction();
		
		assertEquals(expectedValue, result, msg);
	}
	
	@Test
	void calculate10PersonsSatisfaction() {
		String msg = "Espera-se que o resultado do cálculo de satisfação a partir de "
				+ "10 pessoas resulte em 20.";
		int expectedValue = 20;
		
		SocialChallenge newChallenge = new SocialChallenge("Desafio teste", 10);
		newChallenge.performChallenge();
		int result = newChallenge.getSatisfaction();
		
		assertEquals(expectedValue, result, msg);
	}
	
	@Test
	void calculate50PersonsSatisfaction() {
		String msg = "Espera-se que o resultado do cálculo de satisfação com até "
				+ "50 pessoas resulte em 20.";
		int expectedValue = 20;
		
		SocialChallenge newChallenge = new SocialChallenge("Desafio teste", 50);
		newChallenge.performChallenge();
		int result = newChallenge.getSatisfaction();
		
		assertEquals(expectedValue, result, msg);
	}
	
	@Test
	void calculate51PersonsSatisfaction() {
		String msg = "Espera-se que o resultado do cálculo de satisfação a partir de "
				+ "51 pessoas resulte em 50.";
		int expectedValue = 50;
		
		SocialChallenge newChallenge = new SocialChallenge("Desafio teste", 51);
		newChallenge.performChallenge();
		int result = newChallenge.getSatisfaction();
		
		assertEquals(expectedValue, result, msg);
	}
	
	@Test
	void calculate100PersonsSatisfaction() {
		String msg = "Espera-se que o resultado do cálculo de satisfação com até "
				+ "100 pessoas resulte em 50.";
		int expectedValue = 50;
		
		SocialChallenge newChallenge = new SocialChallenge("Desafio teste", 100);
		newChallenge.performChallenge();
		int result = newChallenge.getSatisfaction();
		
		assertEquals(expectedValue, result, msg);
	}
	
	@Test
	void calculateOver100PersonsSatisfaction() {
		String msg = "Espera-se que o resultado do cálculo de satisfação a partir de "
				+ "101 pessoas resulte em 1 para cada pessoa.";
		int expectedValue = 101;
		
		SocialChallenge newChallenge = new SocialChallenge("Desafio teste", 101);
		newChallenge.performChallenge();
		int result = newChallenge.getSatisfaction();
		
		assertEquals(expectedValue, result, msg);
	}
}
