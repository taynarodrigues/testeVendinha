package ConsumidorFinal;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.MasterPage;
import query.QueryVendas;
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
	public void tearDown() throws ClassNotFoundException, SQLException {
		masterPage.getMobilePage().realizaSeparacao(QueryVendas.buscaControlePedido());
		navegador.quit();
	}
	
	@Ignore
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
	
	@Ignore
	@Test
	public void deveFinalizarCartao1XCreditoPedido() throws InterruptedException {
		

		masterPage.getCatalogoPage().buscaItem("GP30126");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("KSC04202S");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("MB 4011");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getFormaPagamentoPage().condicaoPagamento();
		masterPage.getFormaPagamentoPage().pagamentoCredito("1");
		masterPage.getDescontoAcrescimoPage().botaoDescontoPedido();
		masterPage.getDescontoAcrescimoPage().adicionarDescontoPedido("430");
		masterPage.getDescontoAcrescimoPage().aplicarDesconto();
		
		masterPage.getCarrinhoPage().aumentaQuantidade(21, "1");
		masterPage.getCarrinhoPage().aumentaQuantidade(4, "2");
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().administradoraCartao("Cielo");
		masterPage.getPagamentoPage().irParaCaixa();
	}
	
	@Ignore
	@Test
	public void deveFinalizarVendaCartaoCreditoSemDescontoCF() throws InterruptedException {

		masterPage.getCatalogoPage().buscaItem("GP30126");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("KSC03202S");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getFormaPagamentoPage().condicaoPagamento();
		masterPage.getFormaPagamentoPage().pagamentoCredito("2");
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().irParaCaixa();
		masterPage.getLoginPage().validaTelaLogin();
	}
}
