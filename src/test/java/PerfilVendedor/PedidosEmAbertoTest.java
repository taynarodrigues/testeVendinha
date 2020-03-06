package PerfilVendedor;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.MasterPage;
import query.QueryVendas;
import suporte.Web;

public class PedidosEmAbertoTest {
	
	private WebDriver navegador;
	private MasterPage masterpage;
	
	@Before
	public void setUp() {
		
		navegador = Web.createChrome("http://192.168.151.89");
		masterpage = new MasterPage(navegador);
		masterpage.getLoginPage().fazLogin("v9437", "v9437");
	}
	
	@After
	public void tearDown() throws ClassNotFoundException, SQLException {
		
		masterpage.getMobilePage().realizaSeparacao(QueryVendas.buscaControlePedido());
		navegador.quit();
	}
	
	@Ignore
	@Test
	public void deveAddItensVerificarValorSalvarOrcamentoFinalizarVenda() throws InterruptedException {
		
		masterpage.getCatalogoPage().buscaItem("562");
		masterpage.getCatalogoPage().inserirItemPaginacao(1);
		masterpage.getCatalogoPage().inserirItemPaginacao(2);
		masterpage.getCatalogoPage().inserirItemPaginacao(3);
		masterpage.getCarrinhoPage().irParaCarrinho();
		masterpage.getCarrinhoPage().salvarOrcamento();
		masterpage.getMeuPerfilPage().irParaMeuPerfil();
		masterpage.getMeuPerfilPage().abaPedidosEmAbertos();
		masterpage.getMeuPerfilPage().finalizarPedidoEmAberto("1");
		masterpage.getCarrinhoPage().finalizaVenda();
		masterpage.getPagamentoPage().irParaCaixa();
		masterpage.getLoginPage().validaTelaLogin();
	}
	
	@Ignore
	@Test
	public void deveAddItensAddDescontoPedidoVerificarValorSalvarOrcamentoFinalizarVenda() throws InterruptedException {
		
		masterpage.getCatalogoPage().buscaItem("VELA");
		masterpage.getCatalogoPage().inserirItemPaginacao(1);
		masterpage.getCatalogoPage().inserirItemPaginacao(2);
		masterpage.getCatalogoPage().inserirItemPaginacao(3);
		masterpage.getCatalogoPage().inserirItemPaginacao(4);
		masterpage.getCarrinhoPage().irParaCarrinho();
		masterpage.getDescontoAcrescimoPage().botaoDescontoPedido();
		masterpage.getDescontoAcrescimoPage().adicionarDescontoPedido("99");
		masterpage.getDescontoAcrescimoPage().aplicarDesconto();
		masterpage.getCarrinhoPage().salvarOrcamento();
		masterpage.getMeuPerfilPage().irParaMeuPerfil();
		masterpage.getMeuPerfilPage().finalizarPedidoEmAberto("1");
		masterpage.getCarrinhoPage().finalizaVenda();
		masterpage.getPagamentoPage().irParaCaixa();
		masterpage.getLoginPage().validaTelaLogin();
	}
	
	@Ignore
	@Test
	public void deveAddItensAddDescontoItensVerificarValorSalvarOrcamentoFinalizarVenda() throws InterruptedException {
		
		masterpage.getCatalogoPage().buscaItem("VELA");
		masterpage.getCatalogoPage().inserirItemPaginacao(1);
		masterpage.getCatalogoPage().inserirItemPaginacao(2);
		masterpage.getCatalogoPage().inserirItemPaginacao(3);
		masterpage.getCatalogoPage().inserirItemPaginacao(4);
		masterpage.getCarrinhoPage().irParaCarrinho();
		masterpage.getDescontoAcrescimoPage().adicionaDescontoItem("1", "199");
		masterpage.getDescontoAcrescimoPage().adicionaDescontoItem("2", "152");
		masterpage.getDescontoAcrescimoPage().adicionaDescontoItem("3", "142");
		masterpage.getDescontoAcrescimoPage().adicionaDescontoItem("4", "045");
		masterpage.getCarrinhoPage().finalizaVenda();
		masterpage.getPagamentoPage().irParaCaixa();
		masterpage.getLoginPage().validaTelaLogin();
	}
	
	@Ignore
	@Test
	public void deveAddItensAddClienteSalvarVerificarValorOrcamentoFinalizarVenda() throws InterruptedException {
		
		masterpage.getCatalogoPage().buscaItem("VELA");
		masterpage.getCatalogoPage().inserirItemPaginacao(1);
		masterpage.getCatalogoPage().inserirItemPaginacao(2);
		masterpage.getCatalogoPage().inserirItemPaginacao(3);
		masterpage.getCatalogoPage().inserirItemPaginacao(4);
		masterpage.getCarrinhoPage().irParaCarrinho();
		masterpage.getCarrinhoPage().buscarCliente("MARGARETH NOGUEIRA RODERIGUES");
		masterpage.getCarrinhoPage().salvarOrcamento();
		masterpage.getMeuPerfilPage().irParaMeuPerfil();
		masterpage.getMeuPerfilPage().finalizarPedidoEmAberto("1");
		masterpage.getCarrinhoPage().finalizaVenda();
		masterpage.getPagamentoPage().irParaCaixa();
		masterpage.getLoginPage().validaTelaLogin();
	}
	
	@Ignore
	@Test
	public void deveAddItensAddClienteSalvarAddDescontoSucataVerificarValorNaoDeveSalvarOrcamentoFinalizarVenda() throws InterruptedException {
		
		masterpage.getCatalogoPage().buscaItem("VELA");
		masterpage.getCatalogoPage().inserirItemPaginacao(1);
		masterpage.getCatalogoPage().inserirItemPaginacao(2);
		masterpage.getCatalogoPage().inserirItemPaginacao(3);
		masterpage.getCatalogoPage().inserirItemPaginacao(4);
		masterpage.getCatalogoPage().buscaItem("562");
		masterpage.getCatalogoPage().inserirItemPaginacao(1);
		masterpage.getCatalogoPage().inserirItemPaginacao(2);
		masterpage.getCatalogoPage().inserirItemPaginacao(3);
		masterpage.getCarrinhoPage().irParaCarrinho();
		masterpage.getCarrinhoPage().buscarCliente("MARGARETH NOGUEIRA RODERIGUES");
		masterpage.getCompraSucataPage().adicionarSucata();
		masterpage.getCompraSucataPage().preencherCampoSucata("32", "1", "2000");
		masterpage.getCompraSucataPage().preencherCampoSucata("50", "2", "5000");
		masterpage.getCompraSucataPage().preencherCampoSucata("60", "3", "6000");
		masterpage.getCompraSucataPage().finalizarCompraSucata();
		masterpage.getCarrinhoPage().salvarOrcamento();
		masterpage.getCarrinhoPage().finalizaVenda();
		masterpage.getPagamentoPage().irParaCaixa();
		masterpage.getLoginPage().validaTelaLogin();
	}
	
	@Ignore
	@Test
	public void deveAddItensAddClienteAddOrdemCompraVerificaValorSalvarOrcamentoFinalizarVenda() throws InterruptedException {
		
		masterpage.getCatalogoPage().buscaItem("VELA");
		masterpage.getCatalogoPage().inserirItemComQuantidade("2");
		masterpage.getCatalogoPage().inserirItemPaginacao(2);
		masterpage.getCatalogoPage().inserirItemPaginacao(3);
		masterpage.getCatalogoPage().buscaItem("562");
		masterpage.getCatalogoPage().inserirItemComQuantidade("3");
		masterpage.getCatalogoPage().inserirItemPaginacao(2);
		masterpage.getCatalogoPage().inserirItemPaginacao(3);
		masterpage.getCarrinhoPage().irParaCarrinho();
		masterpage.getCarrinhoPage().buscarCliente("MARGARETH NOGUEIRA RODERIGUES");
		masterpage.getCarrinhoPage().codigoCompra("RETH53432");
		masterpage.getCarrinhoPage().codigoItem("1", "10");
		masterpage.getCarrinhoPage().codigoItem("2", "11");
		masterpage.getCarrinhoPage().codigoItem("3", "12");
		masterpage.getCarrinhoPage().salvarOrcamento();
		masterpage.getMeuPerfilPage().irParaMeuPerfil();
		masterpage.getMeuPerfilPage().finalizarPedidoEmAberto("1");
		masterpage.getCarrinhoPage().finalizaVenda();
		masterpage.getPagamentoPage().irParaCaixa();
		masterpage.getLoginPage().validaTelaLogin();
	}
	
	@Ignore
	@Test
	public void deveAddItensAlterarQuantidadeVerificarValorSalvarOrcamentoFinalizarVenda() throws InterruptedException {
		
		masterpage.getCatalogoPage().buscaItem("VELA");
		masterpage.getCatalogoPage().inserirItemComQuantidade("3");
		masterpage.getCatalogoPage().buscaItem("562");
		masterpage.getCatalogoPage().inserirItemComQuantidade("4");
		masterpage.getCatalogoPage().buscaItem("7741");
		masterpage.getCatalogoPage().inserirItemComQuantidade("5");
		masterpage.getCarrinhoPage().irParaCarrinho();
		masterpage.getCarrinhoPage().aumentaQuantidade(4, "1");
		masterpage.getCarrinhoPage().aumentaQuantidade(2, "2");
		masterpage.getCarrinhoPage().salvarOrcamento();
		masterpage.getMeuPerfilPage().irParaMeuPerfil();
		masterpage.getMeuPerfilPage().finalizarPedidoEmAberto("1");
		masterpage.getCarrinhoPage().finalizaVenda();
		masterpage.getPagamentoPage().irParaCaixa();
		masterpage.getLoginPage().validaTelaLogin();
	}
	
	@Ignore
	@Test
	public void deveAddItensAlterarFormaPagamentoVerificarValorSalvarOrcamentoFinalizarVenda() throws InterruptedException {
		
		masterpage.getCatalogoPage().buscaItem("VELA");
		masterpage.getCatalogoPage().inserirItem();
		masterpage.getCatalogoPage().buscaItem("562");
		masterpage.getCatalogoPage().inserirItem();
		masterpage.getCarrinhoPage().irParaCarrinho();
		masterpage.getFormaPagamentoPage().condicaoPagamento();
		masterpage.getFormaPagamentoPage().pagamentoDebito();
		masterpage.getCarrinhoPage().salvarOrcamento();
		masterpage.getMeuPerfilPage().irParaMeuPerfil();
		masterpage.getMeuPerfilPage().finalizarPedidoEmAberto("1");
		masterpage.getCarrinhoPage().finalizaVenda();
		masterpage.getFormaPagamentoPage().administradoraCartao("Redecard");
		masterpage.getPagamentoPage().irParaCaixa();
		masterpage.getLoginPage().validaTelaLogin();	
	}
	
	@Ignore
	@Test
	public void deveAddItensAddClienteAddVendaPedidaAddOrdemCompraVerificaValorFinalizarVenda() throws InterruptedException {
		
		masterpage.getCatalogoPage().buscaItem("VELA");
		masterpage.getCatalogoPage().inserirItemComQuantidade("2");
		masterpage.getCatalogoPage().buscaItem("7741");
		masterpage.getCatalogoPage().inserirItemPaginacao(2);
		masterpage.getCatalogoPage().inserirItemComQuantidade("3");
		masterpage.getCatalogoPage().buscaItem("562");
		masterpage.getCatalogoPage().inserirItemComQuantidade("3");
		masterpage.getCatalogoPage().buscaItem("123");
		masterpage.getCatalogoPage().inserirItemComQuantidade("3");
		masterpage.getCarrinhoPage().irParaCarrinho();
		masterpage.getCarrinhoPage().buscarCliente("MARGARETH NOGUEIRA RODERIGUES");
		masterpage.getCarrinhoPage().codigoCompra("RETH53432");
		masterpage.getCarrinhoPage().codigoItem("1", "10");
		masterpage.getCarrinhoPage().codigoItem("2", "11");
		masterpage.getCarrinhoPage().codigoItem("3", "12");
		masterpage.getCarrinhoPage().finalizaVenda();
		masterpage.getPagamentoPage().irParaCaixa();
		masterpage.getLoginPage().validaTelaLogin();
	}
}
