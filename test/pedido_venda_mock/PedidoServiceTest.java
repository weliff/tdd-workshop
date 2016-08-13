package pedido_venda_mock;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import pedido_venda_mock.builder.PedidoBuilder;
import pedido_venda_mock.email.NotificadorEmail;
import pedido_venda_mock.model.Pedido;
import pedido_venda_mock.model.StatusPedido;
import pedido_venda_mock.repository.Pedidos;
import pedido_venda_mock.service.AcaoLancamentoPedido;
import pedido_venda_mock.service.PedidoService;
import pedido_venda_mock.service.StatusPedidoInvalidoException;
import pedido_venda_mock.sms.NotificadorSms;

public class PedidoServiceTest {
	
	private Pedido pedido;
	private PedidoService pedidoService;
	
	@Mock
	private Pedidos pedidos;
	
	@Mock
	private NotificadorEmail notificadorEmail;
	
	@Mock
	private NotificadorSms notificadorSms;
	
	@Before
	public void setup(){
//		Pedidos pedidos = Mockito.mock(Pedidos.class);//cria um objeto falso
		MockitoAnnotations.initMocks(this);
		List<AcaoLancamentoPedido> acoes  = Arrays.asList(notificadorEmail, notificadorSms);
		pedidoService = new PedidoService(pedidos, acoes);
		pedido = new PedidoBuilder()
			.comValor(100.0)
			.para("João", "joao@joao.com", "9999-0000")
			.contruir();
	}
	
	@Test
	public void deveCalcularImposto() throws Exception {
		double imposto = pedidoService.lancar(pedido);
		assertEquals(10.0, imposto,0.0001);
	}
	
	@Test
	public void deveSalvarPedidoNoBancoDeDados() throws Exception {
		double imposto = pedidoService.lancar(pedido);
		assertEquals(10.0, imposto,0.0001);
		Mockito.verify(pedidos).salvar(pedido);//verifica se o metodo salvar foi chamado dessa forma
	}
	
	@Test
	public void deveNotificarPorEmail() throws Exception {
		pedidoService.lancar(pedido);
		Mockito.verify(notificadorEmail).executar(pedido);
	}
	
	@Test
	public void deveNotificarPorSms() throws Exception {
		pedidoService.lancar(pedido);
		Mockito.verify(notificadorSms).executar(pedido);
	}
	
	@Test
	public void devePagarPedidoPendente() throws Exception {
		Long codigo = 15L;
		Pedido pedidoPedente = new Pedido();
		pedidoPedente.setStatusPedido(StatusPedido.PENDENTE);
		Mockito.when(pedidos.buscarPeloCodigo(codigo)).thenReturn(pedidoPedente);
		Pedido pedido = pedidoService.pagar(codigo);
		assertEquals(StatusPedido.PAGO, pedido.getStatusPedido());
	}
	
	@Test(expected=StatusPedidoInvalidoException.class)
	public void deveNegarPagamento() throws Exception {
		Long codigo = 15L;
		Pedido pedidoPedente = new Pedido();
		pedidoPedente.setStatusPedido(StatusPedido.PAGO);
		Mockito.when(pedidos.buscarPeloCodigo(codigo)).thenReturn(pedidoPedente);
		Pedido pedido = pedidoService.pagar(codigo);
		Mockito.verify(pedidos).buscarPeloCodigo(codigo);
		assertEquals(StatusPedido.PAGO, pedido.getStatusPedido());
		
	}
}
