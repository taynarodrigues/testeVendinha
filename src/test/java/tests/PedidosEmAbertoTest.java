package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.MasterPage;
import suporte.Web;

public class PedidosEmAbertoTest {
	
	private WebDriver navegador;
	private MasterPage masterPage;
	
	@Before
	public void setUp() {
		navegador = Web.createChrome("http://192.168.151.17");
		masterPage = new MasterPage(navegador);
		masterPage.getLoginPage().fazLogin("v299", "v299");
	}
//	@After
	public void tearDown() {
		navegador.quit();
	}
	
	@Ignore
	@Test
	public void deveVerificarOsPedidosEmAberto() {
		
		masterPage.getCarrinhoPage().meuPerfil();
		masterPage.getPedidosEmAbertoPage().pedidosEmAbertos("1");
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().irParaCaixa();
		
	}
	
	
	@Ignore
	@Test
	public void deveAddItensVerificarValorSalvarOrcamentoFinalizarVenda() throws InterruptedException {
		
		masterPage.getBuscaItem().buscaItem("pneu");
		masterPage.getAdicionaItemPage().inserirItemPaginacao(1);
		masterPage.getAdicionaItemPage().inserirItemPaginacao(2);
		masterPage.getAdicionaItemPage().inserirItemPaginacao(3);
		masterPage.getAdicionaItemPage().inserirItemPaginacao(4);
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().salvarOrcamento();
		masterPage.getPedidosEmAbertoPage().pedidosEmAbertos("1");
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().irParaCaixa();
	}
	
	@Ignore
	@Test
	public void deveAddItensAddDescontoPedidoVerificarValorSalvarOrcamentoFinalizarVenda() throws InterruptedException {
		
		masterPage.getBuscaItem().buscaItem("pneu");
		masterPage.getAdicionaItemPage().inserirItemPaginacao(1);
		masterPage.getAdicionaItemPage().inserirItemPaginacao(2);
		masterPage.getAdicionaItemPage().inserirItemPaginacao(3);
		masterPage.getAdicionaItemPage().inserirItemPaginacao(4);
		masterPage.getCarrinhoPage().irParaCarrinho();
		
		masterPage.getDescontoPedidoPage().botaoDescontoPedido("1400");
		masterPage.getCarrinhoPage().salvarOrcamento();
		masterPage.getPedidosEmAbertoPage().pedidosEmAbertos("1");
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().irParaCaixa();
		
		
	
		
	}
	
}
