package ConsumidorFinal;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MasterPage;
import query.QueryVendas;
import suporte.Web;

public class PagamentoAntecipadoTest {

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
	public void deveAplicarPagamentoAntecipado() throws InterruptedException {
		
	
		masterPage.getCatalogoPage().buscaItem("SE30829");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("AC30728");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().buscarCliente("REAL CAR LOCADORA DE VEICULOS LTDA");
		masterPage.getFormaPagamentoPage().condicaoPagamento();
		masterPage.getFormaPagamentoPage().pagamentoAntecipado();
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getTransportePage().abaTransporte("TRANSPORTE", "1");
		masterPage.getTransportePage().preencheCamposTransporte();
		masterPage.getPagamentoPage().irParaCaixa();
	
	}
	
	@Ignore
	@Test
	public void naoDeveAplicarPagamentoAntecipado() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("GP30126");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("GBL1119");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().buscarCliente("REAL CAR LOCADORA DE VEICULOS LTDA");
		masterPage.getFormaPagamentoPage().condicaoPagamento();
		masterPage.getFormaPagamentoPage().pagamentoAntecipado();
		masterPage.getCarrinhoPage().finalizaVenda();
		assertEquals("Saldo antecipado insuficiente", masterPage.getValidaPage().validaMensagem());
	}
}
