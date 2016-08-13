package pedidoVenda.desconto;

public class CalculadoraSegundaFaixaDesconto extends CalculadoraFaixaDesconto {

	public CalculadoraSegundaFaixaDesconto(CalculadoraFaixaDesconto proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		if(valorTotal > 800 && valorTotal <= 1000)
			return valorTotal * 0.06;
		return -1;
	}

}
