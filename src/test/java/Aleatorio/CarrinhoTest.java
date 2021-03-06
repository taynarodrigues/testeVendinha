package Aleatorio;


import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.MasterPage;
import query.QueryVendas;
import suporte.Web;

public class CarrinhoTest {
	
	private WebDriver navegador;
	private MasterPage masterPage;
	
	@Before
	public void setUp() {
		
		navegador = Web.createChrome("http://192.168.151.89");
		
		masterPage = new MasterPage(navegador);
		
		masterPage.getLoginPage().fazLogin("v420", "v420");
	}
	
	@After
	public void tearDown() throws ClassNotFoundException, SQLException {
		
		masterPage.getMobilePage().realizaSeparacao(QueryVendas.buscaControlePedido());
		navegador.quit();
	}
	
	@Test
	public void deveIrParaCarrinho() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("7741");
		masterPage.getCatalogoPage().inserirItemComQuantidade("15");
		masterPage.getCatalogoPage().buscaItem("562");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("NK0405");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("0441487");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().buscarCliente("MARGARETH NOGUEIRA RODERIGUES");
		masterPage.getFormaPagamentoPage().condicaoPagamento();
		masterPage.getFormaPagamentoPage().pagamentoAntecipadoAtacado();
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getTransportePage().abaTransporte("Transporte", "1");
		masterPage.getTransportePage().preencheCamposTransporte();
		masterPage.getPagamentoPage().irParaCaixa();
		masterPage.getLoginPage().validaTelaLogin();
		masterPage.getLoginPage().validaTelaLogin();
	}

}
