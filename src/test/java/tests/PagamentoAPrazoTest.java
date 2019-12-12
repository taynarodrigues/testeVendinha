package tests;

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
		
		masterPage.getBuscaItem().buscaItem("7741");
		masterPage.getAdicionaItemPage().inserirItem();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getbBuscarClientePage().buscarCliente("JOSE CARLOS DE SENA FERREIRA JUNIOR");
		masterPage.getCarrinhoPage().condicaoPagamento();
		masterPage.getPagamentoAPrazoPage().pagamentoAPrazo("1", "7");
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoAPrazoPage().AutorizacaoGerente("500", "123");
		assertEquals("Pagamento Autorizado", masterPage.getPagamentoAPrazoPage().mensagem());
		masterPage.getPagamentoPage().irParaCaixa();
	}
	
//	@Ignore
	@Test
	public void naoDeveFinalizarVendaAPrazoClienteBloqueado() throws InterruptedException {
		
		masterPage.getBuscaItem().buscaItem("7743");
		masterPage.getAdicionaItemPage().inserirItem();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getbBuscarClientePage().buscarCliente("63801523268");
		masterPage.getCarrinhoPage().condicaoPagamento();
		masterPage.getPagamentoAPrazoPage().pagamentoAPrazo("5", "1");
		masterPage.getCarrinhoPage().finalizaVenda();
		assertEquals("Cliente/Grupo Bloqueado, Verifique com o gerente", masterPage.getPagamentoAPrazoPage().mensagem());
		masterPage.getPagamentoPage().irParaCaixa();
		
	}
}

