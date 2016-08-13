package pedidoVenda;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PedidoVendaTest {
	private PedidoBuilder pedido;
	@Before
	public void setUp(){
		pedido = new PedidoBuilder();
	}
	
	private void assertResumoDoPedido(double valorTotal, double desconto){
		ResumoPedido resumo = pedido.construir().resumo();
//		assertEquals(valorTotal, resumo.getValorTotal(), 0.0001);
//		assertEquals(desconto, resumo.getDesconto(), 0.0001);
		assertEquals(new ResumoPedido(valorTotal, desconto), resumo);
	}
	
/*	@Test
	public void devePermetirUmItemNoPedido() throws Exception {
		pedido.comItem(3.0, 10);
	}
	*/
	@Test
	public void deveCalcularValorTotalEDescontoParaPedidoVazio() throws Exception {
		assertResumoDoPedido(0.0, 0.0);
	}
	
	@Test
	public void deveCalcularResumoParaUmItemSemDesconto() throws Exception {
		pedido.comItem(5.0, 5);
		assertResumoDoPedido(25, 0.0);
	}
	
	@Test
	public void deveCalcularResumoParaDoisPedidosSemDesconto() throws Exception {
		pedido.comItem(3.0, 3).comItem(7.0, 3);
		assertResumoDoPedido(30.0, 0.0);
	}
	
	@Test
	public void deveAplicarDescontoNaPrimeiraFaixa() throws Exception {
		pedido.comItem(20.0, 20);
		assertResumoDoPedido(400.0, 16.0);
	}
	@Test
	public void deveAplicarDescontoNaSegundaFaixa() throws Exception {
		pedido.comItem(15.0, 30).comItem(15.0, 30);
		assertResumoDoPedido(900.0, 54.0);
	}
	
	@Test
	public void deveAplicarDescontoNaTerceiraFaixa() throws Exception {
		pedido.comItem(15.0, 30).comItem(15.0, 30).comItem(10.0, 30);
		assertResumoDoPedido(1200.0, 96.0);
		
	}
	@Test(expected = QuantidadeDeItensInvalidaException.class)//testa a exception(deve ser lançada para passar
	public void naoAceitarPedidosComQuantidadeDeItensNegativo(){
		pedido.comItem(0, -10);
	}
}
