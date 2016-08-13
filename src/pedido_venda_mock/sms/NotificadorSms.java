package pedido_venda_mock.sms;

import pedido_venda_mock.model.Pedido;
import pedido_venda_mock.service.AcaoLancamentoPedido;

public class NotificadorSms implements AcaoLancamentoPedido{

	public void executar(Pedido pedido){
		System.out.println("Enviando sms...");
	}
}
