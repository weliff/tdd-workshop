package pedido_venda_mock.builder;

import pedido_venda_mock.model.Cliente;
import pedido_venda_mock.model.Pedido;

public class PedidoBuilder {
	
	private Pedido instancia;
	
	public PedidoBuilder() {
		instancia = new Pedido();
	}
	
	public Pedido contruir(){
		return instancia;
	}
	
	public PedidoBuilder comValor(double valor){
		instancia.setValor(valor);
		return this;
	}
	public PedidoBuilder para(String nome, String email, String telefone){
		Cliente cliente = new Cliente(nome, email, telefone);
		instancia.setCliente(cliente);
		return this;
	}

}
