package Aleatorio;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.MasterPage;
import suporte.Web;

public class RemoverItemTest {
	
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
	public void deveFinalizarVendaAdicionarItensRemoverItens() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("GP30126");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("mp30088");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("b47061");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("gbl1119");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().excluirItem("1");
		masterPage.getCarrinhoPage().excluirItem("2");
		masterPage.getCatalogoPage().buscaItem("KSC04202S");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("MB 4011");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().excluirItem("0");
		masterPage.getCarrinhoPage().excluirItem("2");
		masterPage.getCarrinhoPage().excluirItem("1");
		masterPage.getCarrinhoPage().excluirItem("0");
		
		
		
	}

}
