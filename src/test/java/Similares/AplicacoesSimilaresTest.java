package Similares;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.MasterPage;
import suporte.Web;

public class AplicacoesSimilaresTest {

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
	

	@Ignore
	@Test
	public void deveVerificarAplicacao() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("GP30126");
		masterPage.getSimilaresPage().similaresAplicacoes("1");
		masterPage.getAplicacoesPage().similaresAplicacoes("PALIO ECONOMY");
		masterPage.getSimilaresPage().sairSimilares();
		masterPage.getCatalogoPage().buscaItem("B47061");
		masterPage.getSimilaresPage().similaresAplicacoes("1");
		masterPage.getAplicacoesPage().similaresAplicacoes("ADVANTAGE");
		masterPage.getSimilaresPage().sairSimilares();
		
		masterPage.getCatalogoPage().buscaItem("0442618");
		masterPage.getAplicacoesPage().aplicacoes("FURGAO");
		masterPage.getCatalogoPage().buscaItem("335074");
		masterPage.getAplicacoesPage().aplicacoes("WAGON");
		masterPage.getLoginPage().lookOpen();
		masterPage.getLoginPage().validaTelaLogin();
		
		
	
		
	
	}
}
