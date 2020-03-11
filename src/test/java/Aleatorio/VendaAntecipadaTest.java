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

public class VendaAntecipadaTest {
	
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
	public void deveAddItensAddClienteVerificarPagamentoAntecipadoFinalizarVenda() throws InterruptedException{
		
		masterPage.getCatalogoPage().buscaItem("562");
		masterPage.getCatalogoPage().inserirItemPaginacao(1);
		masterPage.getCatalogoPage().inserirItemPaginacao(2);
		masterPage.getCatalogoPage().inserirItemPaginacao(3);
		masterPage.getCatalogoPage().buscaItem("7741");
		masterPage.getCatalogoPage().inserirItemPaginacao(1);
		masterPage.getCatalogoPage().inserirItemPaginacao(2);
		masterPage.getCatalogoPage().buscaItem("7743");
		masterPage.getCatalogoPage().inserirItemPaginacao(3);
		masterPage.getCatalogoPage().inserirItemPaginacao(4);	
		masterPage.getCatalogoPage().buscaItem("7730");
		masterPage.getCatalogoPage().inserirItemPaginacao(1);
		masterPage.getCatalogoPage().inserirItemPaginacao(2);
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().aumentaQuantidade(3, "2");
		masterPage.getCarrinhoPage().aumentaQuantidade(11, "3");
		masterPage.getCarrinhoPage().aumentaQuantidade(5, "4");
		masterPage.getCarrinhoPage().aumentaQuantidade(4, "5");
		masterPage.getCarrinhoPage().aumentaQuantidade(3, "6");
		masterPage.getCarrinhoPage().aumentaQuantidade(7, "7");
		masterPage.getCarrinhoPage().aumentaQuantidade(9, "8");
		masterPage.getCarrinhoPage().buscarCliente("MARGARETH NOGUEIRA RODERIGUES");
		masterPage.getFormaPagamentoPage().condicaoPagamento();
		masterPage.getFormaPagamentoPage().pagamentoAntecipado();
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().irParaCaixa();
		masterPage.getLoginPage().validaTelaLogin();
		
	}
	
	@Ignore
	@Test
	public void deveAddItensAddClienteVerificarPagamentoAntecipadoFinalizarVenda2() throws InterruptedException {
		
	
		masterPage.getCatalogoPage().buscaItem("7741");
		masterPage.getCatalogoPage().inserirItemPaginacao(2);
		masterPage.getCatalogoPage().buscaItem("7743");
		masterPage.getCatalogoPage().inserirItemPaginacao(4);
		masterPage.getCatalogoPage().buscaItem("7730");
		masterPage.getCatalogoPage().inserirItemPaginacao(1);
		masterPage.getCatalogoPage().buscaItem("562");
		masterPage.getCatalogoPage().inserirItemPaginacao(1);
		masterPage.getCatalogoPage().inserirItemPaginacao(3);
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().aumentaQuantidade(2, "1");
		masterPage.getCarrinhoPage().aumentaQuantidade(4, "2");
		masterPage.getCarrinhoPage().aumentaQuantidade(5, "3");
		masterPage.getCarrinhoPage().buscarCliente("MARGARETH NOGUEIRA RODERIGUES");
		masterPage.getFormaPagamentoPage().condicaoPagamento();
		masterPage.getFormaPagamentoPage().pagamentoAntecipado();
		masterPage.getCompraSucataPage().adicionarSucata();
		masterPage.getCompraSucataPage().preencherCampoSucata("32", "1", "5000");
		masterPage.getCompraSucataPage().finalizarCompraSucata();
		masterPage.getCompraSucataPage().adicionarSucata();
		masterPage.getCompraSucataPage().preencherCampoSucata("50", "2", "2000");
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().irParaCaixa();
		masterPage.getLoginPage().validaTelaLogin();
		

	}
}
