package domain;

import java.io.Serializable;

public class UserMobile implements Serializable {

	private static final long serialVersionUID = 6765769442479085335L;

	private int cod;
	private String chave;
	private String usuario_nome;
	private String usuario_codigo;
	private String filial;
	private String msg;

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getUsuario_nome() {
		return usuario_nome;
	}

	public void setUsuario_nome(String usuario_nome) {
		this.usuario_nome = usuario_nome;
	}

	public String getUsuario_codigo() {
		return usuario_codigo;
	}

	public void setUsuario_codigo(String usuario_codigo) {
		this.usuario_codigo = usuario_codigo;
	}

	public String getFilial() {
		return filial;
	}

	public void setFilial(String filial) {
		this.filial = filial;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Usuario: " + usuario_nome;
	}
}
