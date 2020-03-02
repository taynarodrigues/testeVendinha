package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SeparacaoItem implements Serializable {

	private static final long serialVersionUID = 4379329625089509867L;

	private List<LoteItem> itens = new ArrayList<LoteItem>();

	private int cod;

	public List<LoteItem> getItens() {
		return itens;
	}

	public void setItens(List<LoteItem> itens) {
		this.itens = itens;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}
}
