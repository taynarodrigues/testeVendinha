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

public class VendaPerdidaTest {
	
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

	@Ignore
	@Test
	public void deveAddItensAddClienteAddVendaPerdidaAddVendaDebitoVerificaValorFinalizarVenda() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("VELA");
		masterPage.getCatalogoPage().inserirItemComQuantidade("4");
		masterPage.getVendaPerdidaPage().vendaPerdida("1");
		masterPage.getVendaPerdidaPage().opcaoVendaPerdida("4", "8", "okTester1");
		masterPage.getVendaPerdidaPage().confirmaVendaPerdida();
		masterPage.getVendaPerdidaPage().sairVendaPerdida();
		masterPage.getCatalogoPage().buscaItem("7741");	
		masterPage.getCatalogoPage().inserirItemComQuantidade("3");
		masterPage.getVendaPerdidaPage().vendaPerdida("1");
		masterPage.getVendaPerdidaPage().opcaoVendaPerdida("7", "5", "okTester2");
		masterPage.getVendaPerdidaPage().confirmaVendaPerdida();
		masterPage.getVendaPerdidaPage().sairVendaPerdida();	
		masterPage.getCatalogoPage().buscaItem("562");
		masterPage.getCatalogoPage().inserirItemComQuantidade("9");
		masterPage.getVendaPerdidaPage().vendaPerdida("1");
		masterPage.getVendaPerdidaPage().opcaoVendaPerdida("5", "3", "okTester3");
		masterPage.getVendaPerdidaPage().confirmaVendaPerdida();
		masterPage.getVendaPerdidaPage().sairVendaPerdida();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().buscarCliente("FILIPE CELA DE MORAES");
		masterPage.getFormaPagamentoPage().condicaoPagamento();
		masterPage.getFormaPagamentoPage().pagamentoCartaoDebito();
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getFormaPagamentoPage().administradoraCartao("Redecard");
		masterPage.getPagamentoPage().irParaCaixa();
		masterPage.getLoginPage().validaTelaLogin();
	}
	
	@Ignore
	@Test
	public void deveAddItensAddClienteAddVendaPerdidaAddVerificaValorFinalizarVenda2() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("VELA");
		masterPage.getCatalogoPage().inserirItemComQuantidade("6");
		masterPage.getVendaPerdidaPage().vendaPerdida("1");
		masterPage.getVendaPerdidaPage().opcaoVendaPerdida("7", "15", "Tester1");
		masterPage.getVendaPerdidaPage().confirmaVendaPerdida();
		masterPage.getVendaPerdidaPage().sairVendaPerdida();
		masterPage.getCatalogoPage().buscaItem("7741");	
		masterPage.getCatalogoPage().inserirItemComQuantidade("7");
		masterPage.getVendaPerdidaPage().vendaPerdida("1");
		masterPage.getVendaPerdidaPage().opcaoVendaPerdida("1", "9", "Tester2");
		masterPage.getVendaPerdidaPage().confirmaVendaPerdida();
		masterPage.getVendaPerdidaPage().sairVendaPerdida();	
		masterPage.getCatalogoPage().buscaItem("123");
		masterPage.getCatalogoPage().inserirItemComQuantidade("9");
		masterPage.getVendaPerdidaPage().vendaPerdida("1");
		masterPage.getVendaPerdidaPage().opcaoVendaPerdida("5", "3", "Tester3");
		masterPage.getVendaPerdidaPage().confirmaVendaPerdida();
		masterPage.getVendaPerdidaPage().sairVendaPerdida();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().buscarCliente("FILIPE CELA DE MORAES");
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().irParaCaixa();
		masterPage.getLoginPage().validaTelaLogin();
	}
	
	@Ignore
	@Test
	public void deveAddItensAddClienteAddVendaPerdidaAddVerificaValorFinalizarVenda3() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("Amortecedor");
		masterPage.getCatalogoPage().inserirItemComQuantidade("3");
		masterPage.getVendaPerdidaPage().vendaPerdida("1");
		masterPage.getVendaPerdidaPage().opcaoVendaPerdida("3", "3", "Tester4");
		masterPage.getVendaPerdidaPage().confirmaVendaPerdida();
		masterPage.getVendaPerdidaPage().sairVendaPerdida();
		masterPage.getCatalogoPage().buscaItem("562");	
		masterPage.getCatalogoPage().inserirItemComQuantidade("3");
		masterPage.getVendaPerdidaPage().vendaPerdida("1");
		masterPage.getVendaPerdidaPage().opcaoVendaPerdida("11", "13", "Tester5");
		masterPage.getVendaPerdidaPage().confirmaVendaPerdida();
		masterPage.getVendaPerdidaPage().sairVendaPerdida();	
		masterPage.getCatalogoPage().buscaItem("7741");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getVendaPerdidaPage().vendaPerdida("1");
		masterPage.getVendaPerdidaPage().opcaoVendaPerdida("9", "20", "Tester6");
		masterPage.getVendaPerdidaPage().confirmaVendaPerdida();
		masterPage.getVendaPerdidaPage().sairVendaPerdida();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().buscarCliente("FILIPE CELA DE MORAES");
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().irParaCaixa();
		masterPage.getLoginPage().validaTelaLogin();
	}
	
	@Ignore
	@Test
	public void deveAddItensAddClienteAddVendaPerdidaAddVerificaValorFinalizarVenda4() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("Amortecedor");
		masterPage.getCatalogoPage().inserirItemComQuantidade("2");
		masterPage.getVendaPerdidaPage().vendaPerdida("1");
		masterPage.getVendaPerdidaPage().opcaoVendaPerdida("3", "3", "Tester9");
		masterPage.getVendaPerdidaPage().confirmaVendaPerdida();
		masterPage.getVendaPerdidaPage().sairVendaPerdida();	
		masterPage.getCatalogoPage().buscaItem("7741");
		masterPage.getCatalogoPage().inserirItemPaginacao(2);
		masterPage.getVendaPerdidaPage().vendaPerdida("1");
		masterPage.getVendaPerdidaPage().opcaoVendaPerdida("6", "7", "Tester7");
		masterPage.getVendaPerdidaPage().confirmaVendaPerdida();
		masterPage.getVendaPerdidaPage().sairVendaPerdida();
		masterPage.getCatalogoPage().buscaItem("562");	
		masterPage.getCatalogoPage().inserirItemComQuantidade("3");
		masterPage.getVendaPerdidaPage().vendaPerdida("1");
		masterPage.getVendaPerdidaPage().opcaoVendaPerdida("11", "13", "Tester8");
		masterPage.getVendaPerdidaPage().confirmaVendaPerdida();
		masterPage.getVendaPerdidaPage().sairVendaPerdida();	
		masterPage.getCatalogoPage().buscaItem("123");
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().buscarCliente("VALDIR GOMES BEZERRA");
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().irParaCaixa();
		masterPage.getLoginPage().validaTelaLogin();
	}
}
