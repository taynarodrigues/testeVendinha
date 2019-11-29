package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.MasterPage;
import suporte.Web;

public class PendenciaTest {
	
	private WebDriver navegador;
	private MasterPage masterpage;
	
	@Before
	public void setUp() {
		
		navegador = Web.createChrome("http://192.168.151.17");
		masterpage = new MasterPage(navegador);
		masterpage.getLoginPage().fazLogin("v422", "v422");
	}
	
//	@After
	public void setup() {
		navegador.quit();
	}
	
	@Test
	public void verificaPendencia() throws InterruptedException {
		
		masterpage.getPendenciaPage().abaPendencia("1");
		masterpage.getCarrinhoPage().finalizaVenda();
		masterpage.getPagamentoPage().irParaCaixa();
	}

}
