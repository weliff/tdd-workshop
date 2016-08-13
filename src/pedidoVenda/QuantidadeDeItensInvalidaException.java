package pedidoVenda;

public class QuantidadeDeItensInvalidaException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public QuantidadeDeItensInvalidaException(String msg) {
		super(msg);
		
	}
}
