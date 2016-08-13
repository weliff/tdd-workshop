package pedido_venda_mock.service;

import java.util.List;

import pedido_venda_mock.model.Pedido;
import pedido_venda_mock.model.StatusPedido;
import pedido_venda_mock.repository.Pedidos;

public class PedidoService {
	
	private Pedidos pedidos;
	private List<AcaoLancamentoPedido> acoes;
	
	public PedidoService(Pedidos pedidos, List<AcaoLancamentoPedido> acoes){
		this.pedidos = pedidos;
		this.acoes = acoes;
	}

	public double lancar(Pedido pedido) {
		double imposto = pedido.getValor() * 0.1;
		pedidos.salvar(pedido);
		acoes.forEach(acao -> acao.executar(pedido));
		return imposto;
	}
	
	public Pedido pagar(Long codigo){
		Pedido pedido = pedidos.buscarPeloCodigo(codigo);
		if(!pedido.getStatusPedido().equals(StatusPedido.PENDENTE))
			throw new StatusPedidoInvalidoException();
		
		pedido.setStatusPedido(StatusPedido.PAGO);
		return pedido;
	}

}
