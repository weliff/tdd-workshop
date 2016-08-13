package pedidoVenda;

import pedidoVenda.desconto.CalculadoraFaixaDesconto;
import pedidoVenda.desconto.CalculadoraPrimeiraFaixaDesconto;
import pedidoVenda.desconto.CalculadoraSegundaFaixaDesconto;
import pedidoVenda.desconto.CalculadoraTerceiraFaixaDesconto;
import pedidoVenda.desconto.SemDesconto;

public class PedidoBuilder {
	
	private Pedido instancia;
	
	public PedidoBuilder(){
		//PADRÃO CHAIN OF RESPOSABILITY
		CalculadoraFaixaDesconto calculadora = new CalculadoraTerceiraFaixaDesconto(
				new CalculadoraSegundaFaixaDesconto(
						new CalculadoraPrimeiraFaixaDesconto(
							new SemDesconto(null))));
			
			instancia = new Pedido(calculadora);
	}
	
	public PedidoBuilder comItem(double valorUnitario, int qtd){
		instancia.adicionar(new ItemPedido("Gerado", valorUnitario, qtd));
		return this;
	}
	public PedidoBuilder comItem(String descricao, double valorUnitario, int qtd){
		construir().adicionar(new ItemPedido("Gerado", valorUnitario, qtd));
		return this;
	}

	public Pedido construir() {
		return instancia;
	}

}
