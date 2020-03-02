package Aleatorio;

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
		
		navegador = Web.createChrome("http://192.168.151.89");
		masterPage = new MasterPage(navegador);
		masterPage.getLoginPage().fazLogin("v9437", "v9437");
	}
	@After
	public void tearDown() {
		
		navegador.quit();
	}

	@Test
	public void deveAlterarQuantidade() throws InterruptedException {
	
		masterPage.getCatalogoPage().buscaItem("7741");
		masterPage.getCatalogoPage().inserirItemComQuantidade("4");
		masterPage.getCatalogoPage().buscaItem("562");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("7743");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().aumentaQuantidade(4, "1");
		masterPage.getCarrinhoPage().diminuiQuantidade(2, "2");
		masterPage.getCarrinhoPage().aumentaQuantidade(4, "3");
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().irParaCaixa();
		
		
	}
}
