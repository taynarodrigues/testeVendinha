package Aleatorio;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.MasterPage;
import suporte.Web;

public class FretePedidoTest {
	
	private WebDriver navegador;
	private MasterPage masterPage;
	
	@Before
	public void setUp() {
		
		navegador = Web.createChrome("http://192.168.151.89");
		
		masterPage = new MasterPage(navegador);
		
		masterPage.getLoginPage().fazLogin("v9437", "v9437");
	}
	
	@After
	public void tearDown() {
		
		navegador.quit();
	}
	
	@Test
	public void deveAplicarFretePedido() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("GP30126");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("GBL1119");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().buscarCliente("SERGIO CAMPOS");
		masterPage.getDescontoAcrescimoPage().botaoDescontoPedido();
		masterPage.getDescontoAcrescimoPage().adicionaFretePedido("599");
		masterPage.getDescontoAcrescimoPage().aplicarAcrescimo();
		
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().irParaCaixa();
	}

}
