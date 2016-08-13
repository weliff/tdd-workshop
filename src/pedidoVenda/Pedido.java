package pedidoVenda;

import java.util.ArrayList;
import java.util.List;

import pedidoVenda.desconto.CalculadoraFaixaDesconto;

public class Pedido {
	
	private CalculadoraFaixaDesconto calculadoraFaixaDesconto;
	private List<ItemPedido> itens = new ArrayList<ItemPedido>();

	public Pedido(CalculadoraFaixaDesconto calculadoraFaixaDesconto) {
		this.calculadoraFaixaDesconto = calculadoraFaixaDesconto;
	}
	
	public void adicionar(ItemPedido itemPedido) {
		if(itemPedido.getQtd() < 0)
			throw new QuantidadeDeItensInvalidaException("A quantidade de itens nao pode ser menor que 0.");
		itens.add(itemPedido);
	}
	

	public ResumoPedido resumo(){
		double valorTotal = itens.stream().mapToDouble(i -> i.getValorUnitario() * i.getQtd()).sum();
		double desconto = calculadoraFaixaDesconto.desconto(valorTotal);
		return new ResumoPedido(valorTotal, desconto);
	}

}
