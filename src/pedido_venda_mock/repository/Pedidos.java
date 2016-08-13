package pedido_venda_mock.repository;

import pedido_venda_mock.model.Pedido;

public interface Pedidos {
	
	public void salvar(Pedido pedido);

	public Pedido buscarPeloCodigo(Long codigo);

}
