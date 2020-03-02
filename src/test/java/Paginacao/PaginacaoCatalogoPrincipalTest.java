package Paginacao;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.MasterPage;
import suporte.Web;

public class PaginacaoCatalogoPrincipalTest {
	
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
	public void deveFazerPaginacaoPrincipalTags() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("amortecedor");
		masterPage.getPaginacaoCarrinhoPage().paginacaoPrincipalRight(3);
		masterPage.getCatalogoPage().buscaItem("Vela");
		masterPage.getPaginacaoCarrinhoPage().paginacaoPrincipalRight(2);
		masterPage.getPaginacaoCarrinhoPage().paginacaoPrincipalLeft(1);
		
		masterPage.getLoginPage().lookOpen();
	}
	
	@Ignore
	@Test
	public void deveFazerPaginacaoRecomendados() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("amortecedor");
		masterPage.getPaginacaoCarrinhoPage().paginacaoPrincipalRight(3);
		masterPage.getPaginacaoCarrinhoPage().paginacaoRecomendadosRight(2);
		
		masterPage.getLoginPage().lookOpen();
	}

}
