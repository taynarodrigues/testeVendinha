package ConsumidorFinal;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.MasterPage;
import query.QueryVendas;
import suporte.Web;

public class PagamentoDinheiroTest {
	
	private WebDriver navegador;
	private MasterPage masterPage;
	
	@Before
	public void setUp() {
		
		navegador = Web.createChrome("http://192.168.151.89");
		masterPage = new MasterPage(navegador);
		masterPage.getLoginPage().fazLogin("v9437", "v9437");
	}
	
	@After
	public void tearDown() throws ClassNotFoundException, SQLException {
		
		masterPage.getMobilePage().realizaSeparacao(QueryVendas.buscaControlePedido());
		navegador.quit();
	}
	
	@Ignore
	@Test
	public void deveFinalizarVendaSemDesconto() throws InterruptedException{
		
		masterPage.getCatalogoPage().buscaItem("GP30126");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("mp30088");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("562");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("b47061");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().aumentaQuantidade(3, "1");
		masterPage.getCarrinhoPage().aumentaQuantidade(4, "2");
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().irParaCaixa();
		masterPage.getLoginPage().validaTelaLogin();
	}
	
	@Ignore
	@Test
	public void deveFinalizarVendaComDescontoNoPedido() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("GP30126");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("562");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("mp30088");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("b47061");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("gbl1119");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().aumentaQuantidade(2, "1");
		masterPage.getCarrinhoPage().aumentaQuantidade(3, "2");
		masterPage.getCarrinhoPage().aumentaQuantidade(3, "3");
		masterPage.getDescontoAcrescimoPage().botaoDescontoPedido();
		masterPage.getDescontoAcrescimoPage().adicionarDescontoPedido("130");
		masterPage.getDescontoAcrescimoPage().aplicarDesconto();
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().irParaCaixa();
		masterPage.getLoginPage().validaTelaLogin();
	}
	
	@Ignore
	@Test
	public void deveFinalizarVendaComDescontoNoItem() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("GP30126");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("7743");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("mp30088");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("b47061");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("MB 4011");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getDescontoAcrescimoPage().adicionaAcrescimoItem("1");
		masterPage.getDescontoAcrescimoPage().aplicarAcrescimoItem("1", "511");
		masterPage.getDescontoAcrescimoPage().adicionaAcrescimoItem("2");
		masterPage.getDescontoAcrescimoPage().aplicarAcrescimoItem("2", "510");
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().irParaCaixa();
		masterPage.getLoginPage().validaTelaLogin();	
	}

}

