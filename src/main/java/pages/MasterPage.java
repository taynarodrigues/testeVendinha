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
	private PagamentoAntecipadoPage pagamentoAntecipado;
	private BuscarClientePage buscarCliente;
	private AlterarQuantidadePage aumentaQuantidade;
	private CancelaPedidoPage excluiPedido;
	private PendenciaPage pendencia;
	private PaginacaoCarrinhoPage paginacaoCarrinho;
	private CompraDoacaoDeSucataPage compraSucata;
	private PedidosEmAbertoPage pedidosEmAberto;


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
		this.pagamentoAntecipado = new PagamentoAntecipadoPage(navegador);
		this.buscarCliente = new BuscarClientePage(navegador);
		this.aumentaQuantidade = new AlterarQuantidadePage(navegador);
		this.excluiPedido = new CancelaPedidoPage(navegador);
		this.pendencia = new PendenciaPage(navegador);
		this.paginacaoCarrinho = new PaginacaoCarrinhoPage(navegador);
		this.compraSucata = new CompraDoacaoDeSucataPage(navegador);
		this.pedidosEmAberto = new PedidosEmAbertoPage(navegador);
		
		
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
	
	public PagamentoAntecipadoPage getPagamentoAntecipadoPage() {
		return pagamentoAntecipado;
	}
	
	public BuscarClientePage getbBuscarClientePage() {
		return buscarCliente;
	}
	
	public AlterarQuantidadePage getAlterarQuantidadePage() {
		return aumentaQuantidade;
	}
	
	public CancelaPedidoPage getCancelaPedidoPage() {
		return excluiPedido;
	}
	
	public PendenciaPage getPendenciaPage() {
		return pendencia;
	}
	
	public PaginacaoCarrinhoPage getPaginacaoCarrinhoPage() {
		return paginacaoCarrinho;
	}
	
	public CompraDoacaoDeSucataPage getCompraDoacaoDeSucataPage() {
		return compraSucata;
	}
	
	public PedidosEmAbertoPage getPedidosEmAbertoPage() {
		return pedidosEmAberto;
	}
	
}
