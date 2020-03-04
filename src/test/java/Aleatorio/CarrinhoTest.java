package Aleatorio;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.MasterPage;
import suporte.Web;

public class CarrinhoTest {
	
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
	public void deveIrParaCarrinho() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("SE30829");
		masterPage.getCatalogoPage().inserirItemComQuantidade("5");
		masterPage.getCatalogoPage().buscaItem("044840");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("NK0405");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("0441487");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().buscarCliente("REAL CAR LOCADORA DE VEICULOS LTDA");
		masterPage.getFormaPagamentoPage().condicaoPagamento();
		masterPage.getFormaPagamentoPage().pagamentoAntecipado();
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getTransportePage().abaTransporte("Transporte", "1");
		masterPage.getTransportePage().preencheCamposTransporte();
		masterPage.getPagamentoPage().irParaCaixa();		
	}

}
