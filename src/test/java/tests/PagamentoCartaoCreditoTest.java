package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.MasterPage;
import suporte.Web;

public class PagamentoCartaoCreditoTest {
	
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
	
	@Test
	public void deveFinalizarVendaCartaoCredito3x() throws InterruptedException {
		
		masterPage.getBuscaItem().buscaItem("044840");
		masterPage.getAdicionaItemPage().inserirItem();
		masterPage.getBuscaItem().buscaItem("NK0405");
		masterPage.getAdicionaItemPage().inserirItem();
		masterPage.getBuscaItem().buscaItem("0441487");
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().condicaoPagamento();
		masterPage.getPagamentoCartaoCreditoPage().pagamentoCredito("3");
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getAdministradoraCartaoCreditoPage().administradoraCartao("Cielo");
		masterPage.getPagamentoPage().cancelarPagamento();
		
		masterPage.getBuscaItem().buscaItem("044842");
		masterPage.getAdicionaItemPage().inserirItemComQuantidade("3");
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getAdministradoraCartaoCreditoPage().administradoraCartao("Redecard");
		masterPage.getPagamentoPage().irParaCaixa();
	}
}
