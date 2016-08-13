package primeiroTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CamelCaseConverterTest {
	private CamelCaseConverter camelCase;
	@Before
	public void seUp() {
		System.out.println("setUp rodou");
		camelCase = new CamelCaseConverter();
	}
	
	@Test
	public void deveConverterNomeSimples() throws Exception {
		assertEquals("Lionel", camelCase.converter("lionel"));
	}
	
	@Test
	public void deveConverterNomeMisturadoMaiusculoEMinusculo() throws Exception {
		assertEquals("Lionel", camelCase.converter("lIOnEl"));
	}
}
