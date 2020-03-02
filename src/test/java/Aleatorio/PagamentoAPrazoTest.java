package Aleatorio;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.MasterPage;
import suporte.Web;

public class PagamentoAPrazoTest {
	
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
	public void deveFinalizarVendaAPrazoAutorizacaoGerente() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("7741");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("7743");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("562");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().buscarCliente("JOSE CARLOS DE SENA FERREIRA JUNIOR");
		masterPage.getFormaPagamentoPage().condicaoPagamento();
		masterPage.getFormaPagamentoPage().pagamentoAPrazo("1", "7");
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().AutorizacaoGerente("500", "123");
		assertEquals("Pagamento Autorizado", masterPage.getValidaPage().validaMensagem());
		masterPage.getPagamentoPage().irParaCaixa();
	}
	
	@Ignore
	@Test
	public void naoDeveFinalizarVendaAPrazoClienteBloqueado() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("7743");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().buscarCliente("63801523268");
		masterPage.getFormaPagamentoPage().condicaoPagamento();
		masterPage.getFormaPagamentoPage().pagamentoAPrazo("5", "1");
		masterPage.getCarrinhoPage().finalizaVenda();
		assertEquals("Cliente/Grupo Bloqueado, Verifique com o gerente", masterPage.getValidaPage().validaMensagem());
		masterPage.getPagamentoPage().irParaCaixa();	
	}
}

