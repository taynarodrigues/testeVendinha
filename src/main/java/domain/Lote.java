package domain;

public class Lote {

	private Long id;

	private String registro;

	private String rotina;

	private Integer retorno;

	private String mensagem;

	public Lote(Long id, String registro, String rotina) {
		this.id = id;
		this.registro = registro;
		this.rotina = rotina;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getRotina() {
		return rotina;
	}

	public void setRotina(String rotina) {
		this.rotina = rotina;
	}

	public Integer getRetorno() {
		return retorno;
	}

	public void setRetorno(Integer retorno) {
		this.retorno = retorno;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String toString() {
		return registro + "|" + rotina + "|" + retorno + "|" + mensagem;
	}
}
