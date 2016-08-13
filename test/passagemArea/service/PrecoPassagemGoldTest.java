package passagemArea.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import passagemArea.model.Voo;

public class PrecoPassagemGoldTest {
	
	private PrecoPassagemGold precoPassagem;
	
	@Before
	public void setup(){
		precoPassagem = new PrecoPassagemGold();
	}
	
	private void assertValorPassagem( Voo voo, double esperado) {
		double valor = precoPassagem.calcular(voo);
		assertEquals(esperado, valor,0.0001);
	}
	@Test
	public void deveCalcularPrecoPassagemGold_ComValorAbaixoDoLimite() throws Exception {
		Voo voo = new Voo("Sao paulo", "Rio de Janeiro", 100.0);
		assertValorPassagem(voo, 90.0);
	}

	
	@Test
	public void deveCalcularPrecoPassagemGold_ComValorAcimaDoLimite() throws Exception {
		Voo voo = new Voo("Sao paulo", "Rio de Janeiro", 600.0);
		assertValorPassagem(voo, 510.0);
	}
}
