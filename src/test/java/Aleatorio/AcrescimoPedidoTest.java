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

public class AcrescimoPedidoTest {
	
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
	public void deveAplicarAcrescimoPedidoConsumidorFinal() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("GBL1119");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("GP30126");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("SK356S");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("SK894S");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("SK836S");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getDescontoAcrescimoPage().botaoDescontoPedido();
		masterPage.getDescontoAcrescimoPage().adicionaAcrescimoPedido("952");
		masterPage.getDescontoAcrescimoPage().aplicarAcrescimo();	
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().irParaCaixa();	
		masterPage.getLoginPage().validaTelaLogin();
	}
	
	@Ignore
	@Test
	public void deveAplicarAcrescimoPedidoAddCliente() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("GBL1119");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("GP30126");
		masterPage.getCatalogoPage().inserirItemComQuantidade("2");
		masterPage.getCatalogoPage().buscaItem("SK356S");
		masterPage.getCatalogoPage().inserirItemComQuantidade("3");
		masterPage.getCatalogoPage().buscaItem("SK894S");
		masterPage.getCatalogoPage().inserirItemComQuantidade("4");
		masterPage.getCatalogoPage().buscaItem("SK836S");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getDescontoAcrescimoPage().botaoDescontoPedido();
		masterPage.getDescontoAcrescimoPage().adicionaAcrescimoPedido("952");
		masterPage.getDescontoAcrescimoPage().aplicarAcrescimo();	
		masterPage.getCarrinhoPage().buscarCliente("MARGARETH NOGUEIRA RODERIGUES");	
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().irParaCaixa();	
		masterPage.getLoginPage().validaTelaLogin();
	}
	
	@Ignore
	@Test
	public void deveAplicarAcrescimoPedidoAddClienteAddVendaDebito() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("562");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("GP30126");
		masterPage.getCatalogoPage().inserirItemComQuantidade("3");
		masterPage.getCatalogoPage().buscaItem("SK356S");
		masterPage.getCatalogoPage().inserirItemComQuantidade("3");
		masterPage.getCatalogoPage().buscaItem("SK894S");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("SK836S");
		masterPage.getCatalogoPage().inserirItemComQuantidade("2");
		masterPage.getCatalogoPage().buscaItem("7741");
		masterPage.getCatalogoPage().inserirItemComQuantidade("2");
		masterPage.getCarrinhoPage().irParaCarrinho();	
		masterPage.getDescontoAcrescimoPage().botaoDescontoPedido();
		masterPage.getDescontoAcrescimoPage().adicionaAcrescimoPedido("342");
		masterPage.getDescontoAcrescimoPage().aplicarAcrescimo();
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
	public void deveAplicarAcrescimoPedidoItem() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("GBL1119");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("GP30126");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("vela");
		masterPage.getCatalogoPage().inserirItemComQuantidade("3");
		masterPage.getCatalogoPage().buscaItem("NK0424");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("SK356S");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("SK894S");
		masterPage.getCatalogoPage().inserirItemComQuantidade("2");
		masterPage.getCatalogoPage().buscaItem("SK836S");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getDescontoAcrescimoPage().adicionaAcrescimoItem("1");
		masterPage.getDescontoAcrescimoPage().aplicarAcrescimoItem("1","250");
		masterPage.getDescontoAcrescimoPage().adicionaAcrescimoItem("2");
		masterPage.getDescontoAcrescimoPage().aplicarAcrescimoItem("2","103");
		masterPage.getDescontoAcrescimoPage().adicionaAcrescimoItem("3");
		masterPage.getDescontoAcrescimoPage().aplicarAcrescimoItem("3","207");
		masterPage.getDescontoAcrescimoPage().adicionaAcrescimoItem("4");
		masterPage.getDescontoAcrescimoPage().aplicarAcrescimoItem("4","209");
		masterPage.getDescontoAcrescimoPage().adicionaAcrescimoItem("5");
		masterPage.getDescontoAcrescimoPage().aplicarAcrescimoItem("5","358");
		masterPage.getDescontoAcrescimoPage().adicionaAcrescimoItem("6");
		masterPage.getDescontoAcrescimoPage().aplicarAcrescimoItem("6","098");
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().irParaCaixa();	
		masterPage.getLoginPage().validaTelaLogin();
	}
	
	@Ignore
	@Test
	public void deveAplicarAcrescimoPedidoItemAddCliente() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("GBL1119");
		masterPage.getCatalogoPage().inserirItemComQuantidade("2");
		masterPage.getCatalogoPage().buscaItem("GP30126");
		masterPage.getCatalogoPage().inserirItemComQuantidade("3");
		masterPage.getCatalogoPage().buscaItem("vela");
		masterPage.getCatalogoPage().inserirItemComQuantidade("3");
		masterPage.getCatalogoPage().buscaItem("NK0424");
		masterPage.getCatalogoPage().inserirItemComQuantidade("2");
		masterPage.getCatalogoPage().buscaItem("SK356S");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("SK894S");
		masterPage.getCatalogoPage().inserirItemComQuantidade("2");
		masterPage.getCatalogoPage().buscaItem("SK836S");
		masterPage.getCatalogoPage().inserirItemComQuantidade("4");
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getDescontoAcrescimoPage().adicionaAcrescimoItem("1");
		masterPage.getDescontoAcrescimoPage().aplicarAcrescimoItem("1","230");
		masterPage.getDescontoAcrescimoPage().adicionaAcrescimoItem("2");
		masterPage.getDescontoAcrescimoPage().aplicarAcrescimoItem("2","703");
		masterPage.getDescontoAcrescimoPage().adicionaAcrescimoItem("3");
		masterPage.getDescontoAcrescimoPage().aplicarAcrescimoItem("3","207");
		masterPage.getDescontoAcrescimoPage().adicionaAcrescimoItem("4");
		masterPage.getDescontoAcrescimoPage().aplicarAcrescimoItem("4","489");
		masterPage.getDescontoAcrescimoPage().adicionaAcrescimoItem("5");
		masterPage.getDescontoAcrescimoPage().aplicarAcrescimoItem("5","258");
		masterPage.getDescontoAcrescimoPage().adicionaAcrescimoItem("6");
		masterPage.getDescontoAcrescimoPage().aplicarAcrescimoItem("6","598");
		masterPage.getCarrinhoPage().buscarCliente("MARGARETH NOGUEIRA RODERIGUES");
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().irParaCaixa();	
		masterPage.getLoginPage().validaTelaLogin();
	}
}
