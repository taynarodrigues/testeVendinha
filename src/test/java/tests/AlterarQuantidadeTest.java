package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.MasterPage;
import suporte.Web;

public class AlterarQuantidadeTest {
	
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
	public void deveAlterarQuantidade() throws InterruptedException {
		
		masterPage.getBuscaItem().buscaItem("562");
		masterPage.getAdicionaItemPage().inserirItem();
		masterPage.getBuscaItem().buscaItem("7743");
		masterPage.getAdicionaItemPage().inserirItem();
		masterPage.getBuscaItem().buscaItem("7741");
		masterPage.getAdicionaItemPage().inserirItemComQuantidade("10");
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getAlterarQuantidadePage().aumentaQuantidade(10, "1");
		masterPage.getAlterarQuantidadePage().diminuiQuantidade(5, "2");
		masterPage.getAlterarQuantidadePage().aumentaQuantidade(3, "3");
		
		
	}
}
