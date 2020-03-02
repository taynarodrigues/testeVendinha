package domain;

import java.io.Serializable;

public class CodigoBarra implements Serializable {

	private static final long serialVersionUID = -3039280858302656983L;

	private String barras;
	private String quantidade;

	public String getBarras() {
		return barras;
	}

	public void setBarras(String barras) {
		this.barras = barras;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "CodigoBarra [barras=" + barras + ", quantidade=" + quantidade + "]";
	}
}
