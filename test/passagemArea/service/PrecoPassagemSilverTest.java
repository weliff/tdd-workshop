package passagemArea.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import passagemArea.model.Voo;

public class PrecoPassagemSilverTest {
	
private PrecoPassagemSilver precoPassagem;
	
	@Before
	public void setup(){
		precoPassagem = new PrecoPassagemSilver();
	}
	private void assertValorPassagem( Voo voo, double esperado) {
		double valor = precoPassagem.calcular(voo);
		assertEquals(esperado, valor,0.0001);
	}
	@Test
	public void deveCalcularPrecoPassagemSilver_ComValorAbaixoDoLimite() throws Exception {
		Voo voo = new Voo("Sao paulo", "Rio de Janeiro", 100.0);
		assertValorPassagem(voo, 94.0);
	}
	
	@Test
	public void deveCalcularValorPassagemSilver_ComValorAcimaDoLimite() throws Exception {
		Voo voo = new Voo("Sao paulo", "Rio de Janeiro", 800.0);
		assertValorPassagem(voo, 720.0);
	}
}
