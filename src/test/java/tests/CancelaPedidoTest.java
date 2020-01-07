package tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.MasterPage;
import suporte.Web;

public class CancelaPedidoTest {
	
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
	public void deveExcluirPedido() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("amort");
		masterPage.getVendaPerdidaPage().vendaPerdida("1");
		masterPage.getVendaPerdidaPage().opcaoVendaPerdida("4", "5", "562 - IGPECOGRAPH - PARALAMA DIREITO IGPECOGRAPH");
		masterPage.getVendaPerdidaPage().confirmaVendaPerdida();
		assertEquals("Venda perdida realizada!", masterPage.getValidaPage().validaMensagem());
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().excluirCarrinho();
	}
	
	@Ignore
	@Test
	public void deveRealizarVendaRecomendada() throws InterruptedException {

		masterPage.getCatalogoPage().buscaItem("suporte");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getVendaPerdidaPage().recomendadosVendaPerdida("1");
		masterPage.getVendaPerdidaPage().opcaoVendaPerdida("1", "6", "observação em teste");
		masterPage.getVendaPerdidaPage().confirmaVendaPerdida();
		assertEquals("Venda perdida realizada!", masterPage.getValidaPage().validaMensagem());
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().irParaCaixa();

	}
	
	@Ignore
	@Test
	public void deveSelecionarTipoEntrega() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("7730");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("7741");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().buscarCliente("REAL CAR LOCADORA DE VEICULOS LTDA");
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getFormaPagamentoPage().tipoEntregaPresencial("2");
		masterPage.getFormaPagamentoPage().condicaoFiscal("6", "Observação em teste");
		assertEquals("6", "Observação em teste", masterPage.getValidaPage().validaObservacao());
	}
}
