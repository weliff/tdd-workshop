package pedido_venda_mock.email;

import pedido_venda_mock.model.Pedido;
import pedido_venda_mock.service.AcaoLancamentoPedido;

public class NotificadorEmail implements AcaoLancamentoPedido{
	
	public void executar(Pedido pedido){
		System.out.println("Enviando email...");
	}

}
