package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.MasterPage;
import suporte.Web;

public class DescontoPedidoTest {
	
	private WebDriver navegador;
	private MasterPage masterPage;

	@Before
	public void setUp() {
		
		navegador = Web.createChrome("http://192.168.151.17");
		
		masterPage = new MasterPage(navegador);
		
		masterPage.getLoginPage().fazLogin("v9437", "v9437");
	}
	
//	@After
	public void tearDown() {
		
		navegador.quit();
	}
	
	@Test
	public void deveAplicarDescontoPedido() throws InterruptedException {
		
		masterPage.getBuscaItem().buscaItem("GP30126");
		masterPage.getAdicionaItemPage().inserirItem();
		masterPage.getBuscaItem().buscaItem("GBL1119");
		masterPage.getAdicionaItemPage().inserirItem();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getbBuscarClientePage().buscarCliente("FILIPE CELA");
		masterPage.getDescontoPedidoPage().botaoDescontoPedido("1923");
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().irParaCaixa();
	}
	
	
}
