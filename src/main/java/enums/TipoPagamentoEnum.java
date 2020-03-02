package enums;

public enum TipoPagamentoEnum {

	DINHEIRO, CHEQUE, DEVOLUCAO, DEBITO, DEPOSITO, REDECARD, CIELO, FITCARD;

	public String getPagamento() {
		switch (this) {
		case DINHEIRO:
			return "Venda Dinheiro";

		case CHEQUE:
			return "Venda De Cheque";
		case DEBITO:
			return "Venda A Cartao Debito";
		case DEPOSITO:
			return "Venda A Deposito Bancario.";

		case DEVOLUCAO:
			return "Venda Paga Por Devolucao Cartao Credito";
		default:
			return null;
		}
	}

	public String getAdministradora() {

		switch (this) {
		case CIELO:
			return "Redecard";
		case FITCARD:
			return "Fitcard";
		default:
			return null;
		}
	}
}
