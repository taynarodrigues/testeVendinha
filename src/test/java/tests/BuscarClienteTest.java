package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.MasterPage;
import suporte.Web;

public class BuscarClienteTest {
	
	private WebDriver navegador;
	private MasterPage masterPage;

	
	@Before
	public void setUp() {
		
		navegador = Web.createChrome("http://192.168.151.17");
		masterPage = new MasterPage(navegador);
		masterPage.getLoginPage().fazLogin("v9437", "v9437");
	}
	
	@After
	public void tearDown() {
		
		navegador.quit();
	}
	
	@Test
	public void deveBuscarClienteCpfCnpjNome() throws InterruptedException {
		
		masterPage.getBuscaItem().buscaItem("7741");
		masterPage.getAdicionaItemPage().inserirItem();
		masterPage.getBuscaItem().buscaItem("7743");
		masterPage.getAdicionaItemPage().inserirItem();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getAlterarQuantidadePage().aumentaQuantidade(5, "1");
		masterPage.getbBuscarClientePage().buscarCliente("MARGARETH NOGUEIRA RODERIGUES");
		masterPage.getBuscaItem().buscaItem("562");
		masterPage.getAdicionaItemPage().inserirItem();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getbBuscarClientePage().removerCliente();
		masterPage.getbBuscarClientePage().buscarCliente("REAL CAR LOCADORA DE VEICULOS LTDA");
		masterPage.getCarrinhoPage().condicaoPagamento();
		masterPage.getPagamentoAntecipadoPage().pagamentoAntecipado();
		masterPage.getCarrinhoPage().finalizaVenda();
	}
}
