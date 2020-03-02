package domain;

public class Pedido implements java.io.Serializable {

	private static final long serialVersionUID = 449084720605510397L;

	private Long id;

	private String recnum;

	private String codigo;

	private String orcamento;

	private String vendedor;

	private String data;

	private String status;

	private String pedsenha;

	private String desc_tipo;

	private String es;

	private String volume;

	private String cor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRecnum() {
		return recnum;
	}

	public void setRecnum(String recnum) {
		this.recnum = recnum;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(String orcamento) {
		this.orcamento = orcamento;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPedsenha() {
		return pedsenha;
	}

	public void setPedsenha(String pedsenha) {
		this.pedsenha = pedsenha;
	}

	public String getDesc_tipo() {
		return desc_tipo;
	}

	public void setDesc_tipo(String desc_tipo) {
		this.desc_tipo = desc_tipo;
	}

	public String getEs() {
		return es;
	}

	public void setEs(String es) {
		this.es = es;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
}