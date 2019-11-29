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
		navegador = Web.createChrome("http://192.168.151.17");
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
		
		masterPage.getBuscaItem().buscaItem("Amortecedor");
		masterPage.getAdicionaItemPage().inserirItemPaginacao(1);
		masterPage.getAdicionaItemPage().inserirItemPaginacao(2);
		masterPage.getAdicionaItemPage().inserirItemPaginacao(3);
		masterPage.getAdicionaItemPage().inserirItemPaginacao(4);
		
		masterPage.getBuscaItem().buscaItem("Pneu");
		masterPage.getAdicionaItemPage().inserirItemPaginacao(1);
		masterPage.getAdicionaItemPage().inserirItemPaginacao(2);
		masterPage.getAdicionaItemPage().inserirItemPaginacao(3);
		masterPage.getAdicionaItemPage().inserirItemPaginacao(4);
		
		masterPage.getBuscaItem().buscaItem("Vela");
		masterPage.getAdicionaItemPage().inserirItemPaginacao(1);
		masterPage.getAdicionaItemPage().inserirItemPaginacao(2);
		masterPage.getAdicionaItemPage().inserirItemPaginacao(3);
		masterPage.getAdicionaItemPage().inserirItemPaginacao(4);
		
		masterPage.getBuscaItem().buscaItem("rolamento");
		masterPage.getAdicionaItemPage().inserirItemPaginacao(1);
		masterPage.getAdicionaItemPage().inserirItemPaginacao(2);
		masterPage.getAdicionaItemPage().inserirItemPaginacao(3);
		masterPage.getAdicionaItemPage().inserirItemPaginacao(4);
	
		
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getPaginacaoCarrinhoPage().paginacaoCarrinhoRigth(2);
		masterPage.getPaginacaoCarrinhoPage().paginacaoCarrinholeft(2);
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().irParaCaixa();
	}
	
	@Test
	public void deveFinalizarVendaCarrinhoAddQuantidade() throws InterruptedException {
		masterPage.getBuscaItem().buscaItem("vela");
		masterPage.getAdicionaItemPage().inserirItemPaginacao(1);
		masterPage.getAdicionaItemPage().inserirItemPaginacao(2);
		masterPage.getAdicionaItemPage().inserirItemPaginacao(3);
		masterPage.getAdicionaItemPage().inserirItemPaginacao(4);
		
		masterPage.getBuscaItem().buscaItem("amortecedor");
		masterPage.getAdicionaItemPage().inserirItemPaginacao(1);
		masterPage.getCarrinhoPage().irParaCarrinho();
		
		masterPage.getAlterarQuantidadePage().aumentaQuantidade(5, "1");
		masterPage.getAlterarQuantidadePage().aumentaQuantidade(10, "4");
		masterPage.getAlterarQuantidadePage().aumentaQuantidade(6, "5");
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().irParaCaixa();
		
	}

}
