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
		
		navegador = Web.createChrome("http://192.168.151.89");
		masterpage = new MasterPage(navegador);
		masterpage.getLoginPage().fazLogin("v9437", "v9437");
	}
	
	@After
	public void setup() {
		navegador.quit();
	}
	
	@Test
	public void verificaPendencia() throws InterruptedException {
		
		masterpage.getMeuPerfilPage().irParaMeuPerfil();
		masterpage.getMeuPerfilPage().abaPendencia();
		masterpage.getMeuPerfilPage().finalizarPendencia("1");
		masterpage.getCarrinhoPage().finalizaVenda();
		masterpage.getPagamentoPage().irParaCaixa();
	}

}
