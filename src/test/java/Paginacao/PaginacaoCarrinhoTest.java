package Paginacao;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.MasterPage;
import suporte.Web;

public class PaginacaoCarrinhoTest {
	
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
	public void deveFinalizarVendaPaginacaoCarrinho() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("Amorte");
		masterPage.getCatalogoPage().inserirItemPaginacao(1);
		masterPage.getCatalogoPage().inserirItemPaginacao(2);
		masterPage.getCatalogoPage().inserirItemPaginacao(3);
		masterPage.getCatalogoPage().inserirItemPaginacao(4);
		
		masterPage.getCatalogoPage().buscaItem("7741");
		masterPage.getCatalogoPage().inserirItem();
		
		masterPage.getCatalogoPage().buscaItem("562");
		masterPage.getCatalogoPage().inserirItemPaginacao(1);
		masterPage.getCatalogoPage().inserirItemPaginacao(2);
		
		masterPage.getCatalogoPage().buscaItem("rolamento");
		masterPage.getCatalogoPage().inserirItemPaginacao(1);
		masterPage.getCatalogoPage().inserirItemPaginacao(4);
	
		
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getPaginacaoCarrinhoPage().paginacaoCarrinhoRigth(2);
		masterPage.getPaginacaoCarrinhoPage().paginacaoCarrinholeft(2);
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().irParaCaixa();
	}
	
	@Ignore
	@Test
	public void deveFinalizarVendaCarrinhoAddQuantidade() throws InterruptedException {
		masterPage.getCatalogoPage().buscaItem("Amorte");
		masterPage.getCatalogoPage().inserirItemPaginacao(1);
		masterPage.getCatalogoPage().inserirItemPaginacao(2);
		masterPage.getCatalogoPage().inserirItemPaginacao(3);
		masterPage.getCatalogoPage().inserirItemPaginacao(4);
		
		masterPage.getCatalogoPage().buscaItem("562");
		masterPage.getCatalogoPage().inserirItemPaginacao(1);
		masterPage.getCarrinhoPage().irParaCarrinho();
		
		masterPage.getCarrinhoPage().aumentaQuantidade(6, "4");
		masterPage.getCarrinhoPage().aumentaQuantidade(6, "5");
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().irParaCaixa();
	}

}
