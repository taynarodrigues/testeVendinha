package pages;

import org.openqa.selenium.WebDriver;

public class MasterPage {

	private LoginPage loginPage;
	private CarrinhoPage carrinhoPage;
	private PagamentoPage pagamento;
	private TermoDeGarantiaPage termoGarantia;
	private PaginacaoCarrinhoPage paginacaoCarrinho;
	private CompraDeSucataPage compraSucata;
	private TransportePage abaTransporte;
	private MeuPerfilPage meuPerfilPage;
	private DescontosEAcrescimosPage descontoAcrescimoPage;
	private CatalogoPage catalogoPage;
	private ValidaPage validaPage;
	private FormaDePagamentoPage formaPagamentoPage;
	private VendaPerdidaPage vendaPerdida;
	private SimilaresPage similaresPage;
	private AplicacoesPage aplicacoesPage;
	private MobilePage mobilePage;
	private PagamentosOutrosPage pagamentosOutros;

	public MasterPage(WebDriver navegador) {

		this.loginPage = new LoginPage(navegador);
		this.pagamento = new PagamentoPage(navegador);
		this.termoGarantia = new TermoDeGarantiaPage(navegador);
		this.paginacaoCarrinho = new PaginacaoCarrinhoPage(navegador);
		this.compraSucata = new CompraDeSucataPage(navegador);
		this.abaTransporte = new TransportePage(navegador);
		this.meuPerfilPage = new MeuPerfilPage(navegador);
		this.catalogoPage = new CatalogoPage(navegador);
		this.descontoAcrescimoPage = new DescontosEAcrescimosPage(navegador);
		this.validaPage = new ValidaPage(navegador);
		this.carrinhoPage = new CarrinhoPage(navegador);
		this.formaPagamentoPage = new FormaDePagamentoPage(navegador);
		this.vendaPerdida = new VendaPerdidaPage(navegador);
		this.similaresPage = new SimilaresPage(navegador);
		this.aplicacoesPage = new AplicacoesPage(navegador);
		this.mobilePage = new MobilePage(navegador);
		this.pagamentosOutros = new PagamentosOutrosPage(navegador);

	}

	public FormaDePagamentoPage getFormaPagamentoPage() {
		return formaPagamentoPage;
	}
	
	public MobilePage getMobilePage() {
		return mobilePage;
	}

	public ValidaPage getValidaPage() {
		return validaPage;
	}

	public LoginPage getLoginPage() {
		return loginPage;
	}

	public CatalogoPage getCatalogoPage() {
		return catalogoPage;
	}

	public CarrinhoPage getCarrinhoPage() {
		return carrinhoPage;
	}

	public PagamentoPage getPagamentoPage() {
		return pagamento;
	}

	public DescontosEAcrescimosPage getDescontoAcrescimoPage() {
		return descontoAcrescimoPage;
	}

	public TermoDeGarantiaPage getTermoDeGarantiaPage() {
		return termoGarantia;
	}

	public PaginacaoCarrinhoPage getPaginacaoCarrinhoPage() {
		return paginacaoCarrinho;
	}

	public CompraDeSucataPage getCompraSucataPage() {
		return compraSucata;
	}

	public TransportePage getTransportePage() {
		return abaTransporte;
	}

	public MeuPerfilPage getMeuPerfilPage() {
		return meuPerfilPage;
	}
	
	public VendaPerdidaPage getVendaPerdidaPage() {
		return vendaPerdida;
	}
	
	public SimilaresPage getSimilaresPage() {
		return similaresPage;
	}
	
	public AplicacoesPage getAplicacoesPage() {
		return aplicacoesPage;
	}
	
	public PagamentosOutrosPage getPagamentosOutrosPage() {
		return pagamentosOutros;
	}
}
