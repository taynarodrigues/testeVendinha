package ConsumidorFinal;

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
		
		navegador = Web.createChrome("http://192.168.151.89");
		
		masterPage = new MasterPage(navegador);
		
		masterPage.getLoginPage().fazLogin("v9437", "v9437");
	}
	
	@After
	public void tearDown() {
		
		navegador.quit();
	}
	
	@Test
	public void deveFinalizarVendaCartaoCredito3x() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("044840");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("NK0405");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getFormaPagamentoPage().condicaoPagamento();
		masterPage.getFormaPagamentoPage().pagamentoCredito("3");
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().administradoraCartao("Cielo");
		masterPage.getPagamentoPage().cancelarPagamento();
		masterPage.getCatalogoPage().buscaItem("044842");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().administradoraCartao("Redecard");
		masterPage.getPagamentoPage().irParaCaixa();
	}
}
