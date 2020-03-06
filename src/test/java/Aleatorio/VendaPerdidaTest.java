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
	private MasterPage masterpage;
	
	@Before
	public void setUp() {
		
		navegador = Web.createChrome("http://192.168.151.89");
		masterpage = new MasterPage(navegador);
		masterpage.getLoginPage().fazLogin("v9437", "v9437");
	}
	
	@After
	public void tearDown() throws ClassNotFoundException, SQLException {
		
		masterpage.getMobilePage().realizaSeparacao(QueryVendas.buscaControlePedido());
		navegador.quit();
	}

	@Ignore
	@Test
	public void deveAddItensAddClienteAddVendaPerdidaAddVendaDebitoVerificaValorFinalizarVenda() throws InterruptedException {
		
		masterpage.getCatalogoPage().buscaItem("VELA");
		masterpage.getCatalogoPage().inserirItemComQuantidade("4");
		masterpage.getVendaPerdidaPage().vendaPerdida("1");
		masterpage.getVendaPerdidaPage().opcaoVendaPerdida("4", "8", "okTester1");
		masterpage.getVendaPerdidaPage().confirmaVendaPerdida();
		masterpage.getVendaPerdidaPage().sairVendaPerdida();
		masterpage.getCatalogoPage().buscaItem("7741");	
		masterpage.getCatalogoPage().inserirItemComQuantidade("3");
		masterpage.getVendaPerdidaPage().vendaPerdida("1");
		masterpage.getVendaPerdidaPage().opcaoVendaPerdida("7", "5", "okTester2");
		masterpage.getVendaPerdidaPage().confirmaVendaPerdida();
		masterpage.getVendaPerdidaPage().sairVendaPerdida();	
		masterpage.getCatalogoPage().buscaItem("562");
		masterpage.getCatalogoPage().inserirItemComQuantidade("9");
		masterpage.getVendaPerdidaPage().vendaPerdida("1");
		masterpage.getVendaPerdidaPage().opcaoVendaPerdida("5", "3", "okTester3");
		masterpage.getVendaPerdidaPage().confirmaVendaPerdida();
		masterpage.getVendaPerdidaPage().sairVendaPerdida();
		masterpage.getCarrinhoPage().irParaCarrinho();
		masterpage.getCarrinhoPage().buscarCliente("FILIPE CELA DE MORAES");
		masterpage.getFormaPagamentoPage().condicaoPagamento();
		masterpage.getFormaPagamentoPage().pagamentoDebito();
		masterpage.getCarrinhoPage().finalizaVenda();
		masterpage.getFormaPagamentoPage().administradoraCartao("Redecard");
		masterpage.getPagamentoPage().irParaCaixa();
		masterpage.getLoginPage().validaTelaLogin();
	}
	
	@Ignore
	@Test
	public void deveAddItensAddClienteAddVendaPerdidaAddVerificaValorFinalizarVenda2() throws InterruptedException {
		
		masterpage.getCatalogoPage().buscaItem("VELA");
		masterpage.getCatalogoPage().inserirItemComQuantidade("6");
		masterpage.getVendaPerdidaPage().vendaPerdida("1");
		masterpage.getVendaPerdidaPage().opcaoVendaPerdida("7", "15", "Tester1");
		masterpage.getVendaPerdidaPage().confirmaVendaPerdida();
		masterpage.getVendaPerdidaPage().sairVendaPerdida();
		masterpage.getCatalogoPage().buscaItem("7741");	
		masterpage.getCatalogoPage().inserirItemComQuantidade("7");
		masterpage.getVendaPerdidaPage().vendaPerdida("1");
		masterpage.getVendaPerdidaPage().opcaoVendaPerdida("1", "9", "Tester2");
		masterpage.getVendaPerdidaPage().confirmaVendaPerdida();
		masterpage.getVendaPerdidaPage().sairVendaPerdida();	
		masterpage.getCatalogoPage().buscaItem("123");
		masterpage.getCatalogoPage().inserirItemComQuantidade("9");
		masterpage.getVendaPerdidaPage().vendaPerdida("1");
		masterpage.getVendaPerdidaPage().opcaoVendaPerdida("5", "3", "Tester3");
		masterpage.getVendaPerdidaPage().confirmaVendaPerdida();
		masterpage.getVendaPerdidaPage().sairVendaPerdida();
		masterpage.getCarrinhoPage().irParaCarrinho();
		masterpage.getCarrinhoPage().buscarCliente("FILIPE CELA DE MORAES");
		masterpage.getCarrinhoPage().finalizaVenda();
		masterpage.getPagamentoPage().irParaCaixa();
		masterpage.getLoginPage().validaTelaLogin();
	}
	
	@Ignore
	@Test
	public void deveAddItensAddClienteAddVendaPerdidaAddVerificaValorFinalizarVenda3() throws InterruptedException {
		
		masterpage.getCatalogoPage().buscaItem("Amortecedor");
		masterpage.getCatalogoPage().inserirItemComQuantidade("3");
		masterpage.getVendaPerdidaPage().vendaPerdida("1");
		masterpage.getVendaPerdidaPage().opcaoVendaPerdida("3", "3", "Tester4");
		masterpage.getVendaPerdidaPage().confirmaVendaPerdida();
		masterpage.getVendaPerdidaPage().sairVendaPerdida();
		masterpage.getCatalogoPage().buscaItem("562");	
		masterpage.getCatalogoPage().inserirItemComQuantidade("3");
		masterpage.getVendaPerdidaPage().vendaPerdida("1");
		masterpage.getVendaPerdidaPage().opcaoVendaPerdida("11", "13", "Tester5");
		masterpage.getVendaPerdidaPage().confirmaVendaPerdida();
		masterpage.getVendaPerdidaPage().sairVendaPerdida();	
		masterpage.getCatalogoPage().buscaItem("7741");
		masterpage.getCatalogoPage().inserirItem();
		masterpage.getVendaPerdidaPage().vendaPerdida("1");
		masterpage.getVendaPerdidaPage().opcaoVendaPerdida("9", "20", "Tester6");
		masterpage.getVendaPerdidaPage().confirmaVendaPerdida();
		masterpage.getVendaPerdidaPage().sairVendaPerdida();
		masterpage.getCarrinhoPage().irParaCarrinho();
		masterpage.getCarrinhoPage().buscarCliente("FILIPE CELA DE MORAES");
		masterpage.getCarrinhoPage().finalizaVenda();
		masterpage.getPagamentoPage().irParaCaixa();
		masterpage.getLoginPage().validaTelaLogin();
	}
	
	@Ignore
	@Test
	public void deveAddItensAddClienteAddVendaPerdidaAddVerificaValorFinalizarVenda4() throws InterruptedException {
		
		masterpage.getCatalogoPage().buscaItem("Amortecedor");
		masterpage.getCatalogoPage().inserirItemComQuantidade("2");
		masterpage.getVendaPerdidaPage().vendaPerdida("1");
		masterpage.getVendaPerdidaPage().opcaoVendaPerdida("3", "3", "Tester9");
		masterpage.getVendaPerdidaPage().confirmaVendaPerdida();
		masterpage.getVendaPerdidaPage().sairVendaPerdida();	
		masterpage.getCatalogoPage().buscaItem("7741");
		masterpage.getCatalogoPage().inserirItemPaginacao(2);
		masterpage.getVendaPerdidaPage().vendaPerdida("1");
		masterpage.getVendaPerdidaPage().opcaoVendaPerdida("6", "7", "Tester7");
		masterpage.getVendaPerdidaPage().confirmaVendaPerdida();
		masterpage.getVendaPerdidaPage().sairVendaPerdida();
		masterpage.getCatalogoPage().buscaItem("562");	
		masterpage.getCatalogoPage().inserirItemComQuantidade("3");
		masterpage.getVendaPerdidaPage().vendaPerdida("1");
		masterpage.getVendaPerdidaPage().opcaoVendaPerdida("11", "13", "Tester8");
		masterpage.getVendaPerdidaPage().confirmaVendaPerdida();
		masterpage.getVendaPerdidaPage().sairVendaPerdida();	
		masterpage.getCatalogoPage().buscaItem("123");
		masterpage.getCarrinhoPage().irParaCarrinho();
		masterpage.getCarrinhoPage().buscarCliente("VALDIR GOMES BEZERRA");
		masterpage.getCarrinhoPage().finalizaVenda();
		masterpage.getPagamentoPage().irParaCaixa();
		masterpage.getLoginPage().validaTelaLogin();
	}
}
