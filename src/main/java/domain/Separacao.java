package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Separacao implements Serializable {

	private static final long serialVersionUID = -2074170314883418803L;

	private List<Pedido> pedido = new ArrayList<Pedido>();
	private int cod;

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	@Override
	public String toString() {
		return pedido.toString();
	}
}
