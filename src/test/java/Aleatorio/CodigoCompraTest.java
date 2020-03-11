package Aleatorio;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.MasterPage;
import query.QueryVendas;
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
	public void tearDown() throws ClassNotFoundException, SQLException {

		masterPage.getMobilePage().realizaSeparacao(QueryVendas.buscaControlePedido());
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
		masterPage.getCarrinhoPage().codigoCompra("RETH53432");
		masterPage.getCarrinhoPage().codigoItem("1", "10");
		masterPage.getCarrinhoPage().codigoItem("2", "11");
		masterPage.getCarrinhoPage().codigoItem("3", "12");
		masterPage.getCarrinhoPage().codigoItem("4", "13");
		masterPage.getCarrinhoPage().codigoItem("5", "14");
		masterPage.getCarrinhoPage().codigoItem("6", "15");
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().irParaCaixa();
		masterPage.getLoginPage().validaTelaLogin();
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
		masterPage.getCarrinhoPage().codigoCompra("RETH53432");
		masterPage.getCarrinhoPage().codigoItem("1", "10");
		masterPage.getCarrinhoPage().codigoItem("2", "11");
		masterPage.getCarrinhoPage().codigoItem("3", "");
		masterPage.getCarrinhoPage().codigoItem("4", "12");
		masterPage.getCarrinhoPage().removerCliente();
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().irParaCaixa();
		masterPage.getLoginPage().validaTelaLogin();
	}
	

}
