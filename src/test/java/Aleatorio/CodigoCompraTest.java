package Aleatorio;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.MasterPage;
import suporte.Web;

public class CodigoCompraTest {
	
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
	public void deveInserirCodigoDeCompra() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("GBL1119");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("GP30126");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("vela");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("NK0424");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("SK356S");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("SK894S");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("SK836S");
		masterPage.getCatalogoPage().inserirItem();
		
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().buscarCliente("MARGARETH NOGUEIRA RODERIGUES");
		masterPage.getCodigoCompraPage().codigoCompra("RETH53432");
		masterPage.getCodigoCompraPage().codigoItem("1", "10");
		masterPage.getCodigoCompraPage().codigoItem("2", "11");
		masterPage.getCodigoCompraPage().codigoItem("3", "12");
		masterPage.getCodigoCompraPage().codigoItem("4", "13");
		masterPage.getCodigoCompraPage().codigoItem("5", "14");
		masterPage.getCodigoCompraPage().codigoItem("6", "15");
		
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().irParaCaixa();
	}
	
	@Ignore
	@Test
	public void deveLimparCodigoDeCompraAoRemoverCliente() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("GBL1119");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("GP30126");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("vela");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("NK0424");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().buscarCliente("MARGARETH NOGUEIRA RODERIGUES");
		masterPage.getCodigoCompraPage().codigoCompra("RETH53432");
		masterPage.getCodigoCompraPage().codigoItem("1", "10");
		masterPage.getCodigoCompraPage().codigoItem("2", "11");
		masterPage.getCodigoCompraPage().codigoItem("3", "");
		masterPage.getCodigoCompraPage().codigoItem("4", "12");
		masterPage.getCarrinhoPage().removerCliente();
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().irParaCaixa();
	}
	

}
