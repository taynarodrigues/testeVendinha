package Similares;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.MasterPage;
import suporte.Web;

public class AdicionarItemSimilaresTest {
	
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
	public void deveAdicionarItemSimilares() throws InterruptedException {
		
	
		masterPage.getCatalogoPage().buscaItem("GP30126");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getSimilaresPage().similaresAdicionaItem("1");
		masterPage.getCatalogoPage().buscaItem("GBL1119");
		masterPage.getSimilaresPage().similaresAdicionaItem("1");
		masterPage.getCatalogoPage().buscaItem("MB 6705");
		masterPage.getSimilaresPage().similaresAdicionaItem("1");
		masterPage.getCatalogoPage().inserirItem(); //Item ja cadastrado no pedido inserido.
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().irParaCaixa();
	}
	
	@Ignore
	@Test
	public void deveAdicionarAoCarrinhoComQuantidadeSimilares() throws InterruptedException {
		
		
		masterPage.getCatalogoPage().buscaItem("GP30126");
		masterPage.getSimilaresPage().similaresAdicionarQuantidade("1");
		masterPage.getSimilaresPage().inserirItemComQuantidade("11");
		masterPage.getCatalogoPage().buscaItem("GBL1119");
		masterPage.getSimilaresPage().similaresAdicionarQuantidade("1");
		masterPage.getSimilaresPage().inserirItemComQuantidade("12");
		masterPage.getCatalogoPage().buscaItem("MB 6705");
		masterPage.getSimilaresPage().similaresAdicionarQuantidade("1");
		masterPage.getSimilaresPage().inserirItemComQuantidade("13");
		masterPage.getCarrinhoPage().irParaCarrinho();
		assertTrue(masterPage.getCatalogoPage().validaVariosItensAdicionados(3));
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().irParaCaixa();
	}
	
	@Ignore
	@Test
	public void deveAdicionarAoCarrinhoItemDemonstracao() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("BKR7ESB");
		masterPage.getSimilaresPage().similaresAdicionaDemonstracao("3");
		masterPage.getCatalogoPage().buscaItem("GP30126");
		masterPage.getSimilaresPage().similaresAdicionarQuantidade("1");
		masterPage.getSimilaresPage().inserirItemComQuantidade("11");
		masterPage.getCatalogoPage().buscaItem("GBL1119");
		masterPage.getSimilaresPage().similaresAdicionarQuantidade("1");
		masterPage.getSimilaresPage().inserirItemComQuantidade("12");
		masterPage.getCatalogoPage().buscaItem("MB 6705");
		masterPage.getSimilaresPage().similaresAdicionarQuantidade("1");
		masterPage.getSimilaresPage().inserirItemComQuantidade("13");
		masterPage.getCarrinhoPage().irParaCarrinho();
		assertTrue(masterPage.getCatalogoPage().validaVariosItensAdicionados(3));
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().irParaCaixa();
	}
}
