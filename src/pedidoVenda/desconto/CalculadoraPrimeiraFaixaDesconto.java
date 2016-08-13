package pedidoVenda.desconto;

public class CalculadoraPrimeiraFaixaDesconto extends CalculadoraFaixaDesconto {

	public CalculadoraPrimeiraFaixaDesconto(CalculadoraFaixaDesconto proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		if(valorTotal > 300 && valorTotal <= 800)
			return valorTotal *0.04;
		return -1;
	}

}
