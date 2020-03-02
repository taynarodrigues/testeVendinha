package domain;

import java.io.Serializable;
import java.util.List;

public class LoteItem implements Serializable {

	private static final long serialVersionUID = 3915335249185081189L;

	private long codigo;
	private int item;
	private String produto;
	private List<CodigoBarra> codbarra;
	private String qtd_sep;
	private String qtd_ped;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getQtd_sep() {
		return qtd_sep;
	}

	public void setQtd_sep(String qtd_sep) {
		this.qtd_sep = qtd_sep;
	}

	public String getQtd_ped() {
		return qtd_ped;
	}

	public void setQtd_ped(String qtd_ped) {
		this.qtd_ped = qtd_ped;
	}

	public List<CodigoBarra> getCodBarra() {
		return codbarra;
	}

	public void setCodBarra(List<CodigoBarra> codBarra) {
		this.codbarra = codBarra;
	}

	@Override
	public String toString() {
		return "LoteItem [codigo=" + codigo + ", item=" + item + ", produto=" + produto + ", codBarra=" + codbarra
				+ ", qtd_sep=" + qtd_sep + ", qtd_ped=" + qtd_ped + "]";
	}
}
