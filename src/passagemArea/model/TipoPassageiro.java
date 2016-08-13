package passagemArea.model;

import passagemArea.service.CalculadoraPrecoPassagem;
import passagemArea.service.PrecoPassagemGold;
import passagemArea.service.PrecoPassagemSilver;

public enum TipoPassageiro {
	
	GOLD(new PrecoPassagemGold()), SILVER(new PrecoPassagemSilver());
	
	private CalculadoraPrecoPassagem calculadoraPrecoPassagem;
	
	private TipoPassageiro(CalculadoraPrecoPassagem calculadoraPrecoPassagem){
		this.calculadoraPrecoPassagem = calculadoraPrecoPassagem;
	}
	
	public CalculadoraPrecoPassagem getCalculadoraPrecoPassagem() {
		return calculadoraPrecoPassagem;
	}
}
