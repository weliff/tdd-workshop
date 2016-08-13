package pedido_venda_mock.service;

import pedido_venda_mock.model.Pedido;

public interface AcaoLancamentoPedido {
	
	public void executar(Pedido pedido);

}
