package Aleatorio;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.MasterPage;
import suporte.Web;

public class TermoDeGarantiaTest {

	private WebDriver navegador;
	private MasterPage masterPage;
	
	@Before
	public void setUp() {
		navegador = Web.createChrome("http://192.168.151.89");
		
		masterPage = new MasterPage(navegador);
		
		masterPage.getLoginPage().fazLogin("v420", "v420");
	}
	
	@After
	public void tearDown() {
		navegador.quit();
	}
	
	@Test
	public void deveApresentarTermoGarantiaPage() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("GP30126");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("GBL1119");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getTermoDeGarantiaPage().botaoTermoDeGarantia();
		masterPage.getCatalogoPage().buscaItem("7741");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getTermoDeGarantiaPage().botaoTermoDeGarantia();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getTermoDeGarantiaPage().botaoTermoDeGarantia();
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getTermoDeGarantiaPage().botaoTermoDeGarantia();
		masterPage.getPagamentoPage().irParaCaixa();
	}
}
