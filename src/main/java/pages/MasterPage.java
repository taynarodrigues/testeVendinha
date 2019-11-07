package pages;

import org.openqa.selenium.WebDriver;

public class MasterPage {

	private LoginPage loginPage;
	private BuscarItemPage buscaItem;
	private AdicionaItemPage adicionaItem;
	private CarrinhoPage carrinho;
	private PagamentoPage pagamento;

	public MasterPage(WebDriver navegador) {

		this.loginPage = new LoginPage(navegador);
		this.buscaItem = new BuscarItemPage(navegador);
		this.adicionaItem = new AdicionaItemPage(navegador);
		this.carrinho = new CarrinhoPage(navegador);
		this.pagamento = new PagamentoPage(navegador);
		
	}

	public LoginPage getLoginPage() {
		return loginPage;
	}
	
	public BuscarItemPage getBuscaItem() {
		return buscaItem;
	}
	
	public AdicionaItemPage getAdicionaItemPage() {
		return adicionaItem;
	}
	
	public CarrinhoPage getCarrinhoPage() {
		return carrinho;
	}
	
	public PagamentoPage getPagamentoPage() {
		return pagamento;
	}
}
