package Aleatorio;


import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import enums.TipoPagamentoEnum;
import pages.MasterPage;
import query.QueryVendas;
import suporte.Web;

public class TransporteFreteTest {
	
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
	public void devePreencherTransporteCampoFreteProprio() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("562");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getTransportePage().abaTransporte("Transporte Proprio", "2");
		masterPage.getTransportePage().preencheCamposTransporte();
		masterPage.getPagamentoPage().irParaCaixa();
		masterPage.getLoginPage().validaTelaLogin();
		
	}
	
	@Ignore
	@Test
	public void devePreencherTransporteCampoFreteEmitente() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("562");
		masterPage.getCatalogoPage().inserirItemComQuantidade("5");
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getTransportePage().abaTransporte("Transporte Proprio", "1");
		masterPage.getTransportePage().preencheCamposTransporte();
		masterPage.getPagamentoPage().irParaCaixa();
		masterPage.getLoginPage().validaTelaLogin();
	}
	
	@Ignore
	@Test
	public void devePreencherTransporteCampoFreteSemFrete() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("562");
		masterPage.getCatalogoPage().inserirItemComQuantidade("2");
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getTransportePage().abaTransporte("Transporte Proprio", "3");
		masterPage.getTransportePage().preencheCamposTransporte();
		masterPage.getPagamentoPage().irParaCaixa();
		masterPage.getLoginPage().validaTelaLogin();
	}
	
	
	@Ignore
	@Test
	public void devePreencherTransporteCampoEmitenteEPagamentoAntecipado() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("7741");
		masterPage.getCatalogoPage().inserirItemComQuantidade("1");
		masterPage.getCatalogoPage().buscaItem("562");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("NK0405");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("0441487");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().buscarCliente("REAL CAR LOCADORA DE VEICULOS LTDA");
		masterPage.getFormaPagamentoPage().condicaoPagamento();
		masterPage.getFormaPagamentoPage().pagamentoAntecipado();
		masterPage.getFormaPagamentoPage().formaDePagamentoAntecipado("7");
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getTransportePage().abaTransporte("Transporte", "1");
		masterPage.getTransportePage().preencheCamposTransporte();
		masterPage.getPagamentoPage().irParaCaixa();
		masterPage.getLoginPage().validaTelaLogin();

	}
	
	@Ignore
	@Test
	public void devePreencherTransporteCampoSemFretePagamentoAvista() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("7741");
		masterPage.getCatalogoPage().inserirItemComQuantidade("2");
		masterPage.getCatalogoPage().buscaItem("562");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().buscarCliente("MARGARETH NOGUEIRA RODERIGUES");
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getTransportePage().abaTransporte("Transporte", "3");
		masterPage.getTransportePage().preencheCamposTransporte();
		masterPage.getPagamentoPage().irParaCaixa();
		masterPage.getLoginPage().validaTelaLogin();
	}
	
	@Ignore
	@Test
	public void devePreencherTransporteCampoFretePagamentoAPrazo() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("7741");
		masterPage.getCatalogoPage().inserirItemComQuantidade("3");
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().buscarCliente("MARGARETH NOGUEIRA RODERIGUES");
		masterPage.getFormaPagamentoPage().condicaoPagamento();
		masterPage.getFormaPagamentoPage().pagamentoAPrazo("1", "2");
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().AutorizacaoGerente("500", "123");
		masterPage.getTransportePage().abaTransporte("Transporte", "3");
		masterPage.getTransportePage().preencheCamposTransporte();
		masterPage.getPagamentoPage().irParaCaixa();
		masterPage.getLoginPage().validaTelaLogin();	
	}
	
	
	@Ignore
	@Test
	public void devePreencherTransporteCampoSemFreteAddClienteAddPagamentoDebito() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("7741");
		masterPage.getCatalogoPage().inserirItemComQuantidade("3");
		masterPage.getCatalogoPage().buscaItem("562");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().buscarCliente("FILIPE CELA DE MORAES");
		masterPage.getFormaPagamentoPage().condicaoPagamento();
		masterPage.getFormaPagamentoPage().pagamentoCartaoDebito();
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getFormaPagamentoPage().administradoraCartao("Cielo");
		masterPage.getPagamentoPage().irParaCaixa();
		masterPage.getLoginPage().validaTelaLogin();
	}
	
	@Ignore
	@Test
	public void devePrencherTransporteCampoEmitenteAddClienteAddPagamentoOutros() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("7741");
		masterPage.getCatalogoPage().inserirItemComQuantidade("4");
		masterPage.getCatalogoPage().buscaItem("562");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().buscarCliente("FILIPE CELA DE MORAES");
		masterPage.getFormaPagamentoPage().condicaoPagamento();
		masterPage.getPagamentosOutrosPage().PagamentosOutrosDebito();
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentosOutrosPage().addLinha();
		masterPage.getPagamentosOutrosPage().selecionarFormaPagamento("0", TipoPagamentoEnum.DEBITO.getPagamento(), "60106", TipoPagamentoEnum.CIELO.getAdministradora());
		masterPage.getPagamentosOutrosPage().selecionarFormaPagamento("1", TipoPagamentoEnum.DEVOLUCAO.getPagamento(), "1054", TipoPagamentoEnum.FITCARD.getAdministradora());
		masterPage.getPagamentoPage().irParaCaixa();
		masterPage.getLoginPage().validaTelaLogin();
	}
	
	
	@Ignore
	@Test
	public void deveFinalizarVendaCartaoCredito() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("562");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getFormaPagamentoPage().condicaoPagamento();
		masterPage.getFormaPagamentoPage().pagamentoCredito("3");
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().administradoraCartao("Cielo");
		masterPage.getPagamentoPage().irParaCaixa();
		masterPage.getLoginPage().validaTelaLogin();
	}
	

}