package passagemArea.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import passagemArea.model.Passageiro;
import passagemArea.model.TipoPassageiro;
import passagemArea.model.Voo;
/**
 * Teste refeito por conta da criação das classes  @CalculadoraPrecoPassagem, @PrecoPassagemGold, @PrecoPassagemSilver
 * Que faz o calculo da passagem e que @PrecoPassagemService apenas delega a chamada para as classes especialistas
 * @author Weliff
 * @see PrecoPassagemGold
 * 
 */
public class PrecoPassagemServiceTest {
	
	private PrecoPassagemService precoPassagemService;
	
	@Before
	public void setup() {
		precoPassagemService = new PrecoPassagemService();
	}
	
	private void assertValorPassagem(Passageiro passageiro, Voo voo, double esperado) {
		double valor = precoPassagemService.calcular(passageiro, voo);
		assertEquals(esperado, valor,0.0001);
	}
	@Test
	public void deveCalcularPrecoPassagemGold_ComValorAbaixoDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("Joao", TipoPassageiro.GOLD);
		Voo voo = new Voo("Sao paulo", "Rio de Janeiro", 100.0);
		assertValorPassagem(passageiro, voo, 90.0);
	}

	
	@Test
	public void deveCalcularPrecoPassagemGold_ComValorAcimaDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("Joao", TipoPassageiro.GOLD);
		Voo voo = new Voo("Sao paulo", "Rio de Janeiro", 600.0);
		assertValorPassagem(passageiro, voo, 510.0);
	}
	
	@Test
	public void deveCalcularPrecoPassagemSilver_ComValorAbaixoDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("Joao", TipoPassageiro.SILVER);
		Voo voo = new Voo("Sao paulo", "Rio de Janeiro", 100.0);
		assertValorPassagem(passageiro, voo, 94.0);
	}
	
	@Test
	public void deveCalcularValorPassagemSilver_ComValorAcimaDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("Joao", TipoPassageiro.SILVER);
		Voo voo = new Voo("Sao paulo", "Rio de Janeiro", 800.0);
		assertValorPassagem(passageiro, voo, 720.0);
	}
}
