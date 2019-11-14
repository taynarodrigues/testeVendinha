package pages;

import org.openqa.selenium.WebDriver;

public class MasterPage {

	private LoginPage loginPage;
	private BuscarItemPage buscaItem;
	private AdicionaItemPage adicionaItem;
	private CarrinhoPage carrinho;
	private PagamentoPage pagamento;
	private PagamentoCartaoCreditoPage pagamentoCredito;
	private AdministradoraCartaoCreditoPage administradoraCartao;
	private DescontoPedidoPage descontoPedido;
	private AcrescimoPedidoPage acrescimoPedido;
	private FretePedidoPage fretePedido;
	private TermoDeGarantiaPage termoGarantia;

	public MasterPage(WebDriver navegador) {

		this.loginPage = new LoginPage(navegador);
		this.buscaItem = new BuscarItemPage(navegador);
		this.adicionaItem = new AdicionaItemPage(navegador);
		this.carrinho = new CarrinhoPage(navegador);
		this.pagamento = new PagamentoPage(navegador);
		this.pagamentoCredito = new PagamentoCartaoCreditoPage(navegador);
		this.administradoraCartao = new AdministradoraCartaoCreditoPage(navegador);
		this.descontoPedido = new DescontoPedidoPage(navegador);
		this.acrescimoPedido = new AcrescimoPedidoPage(navegador);
		this.fretePedido = new FretePedidoPage(navegador);
		this.termoGarantia = new TermoDeGarantiaPage(navegador);
		
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
	
	public PagamentoCartaoCreditoPage getPagamentoCartaoCreditoPage() {
		return pagamentoCredito;
	}
	
	public AdministradoraCartaoCreditoPage getAdministradoraCartaoCreditoPage() {
		return administradoraCartao;
	}
	
	public DescontoPedidoPage getDescontoPedidoPage() {
		return descontoPedido;
	}
	
	public AcrescimoPedidoPage getAcrescimoPedidoPage() {
		return acrescimoPedido;
	}
	
	public FretePedidoPage getFretePedidoPage() {
		return fretePedido;
	}
	
	public TermoDeGarantiaPage getTermoDeGarantiaPage() {
		return termoGarantia;
	}
}
