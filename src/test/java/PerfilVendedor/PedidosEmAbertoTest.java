package PerfilVendedor;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.MasterPage;
import suporte.Web;

public class PedidosEmAbertoTest {
	
	private WebDriver navegador;
	private MasterPage masterpage;
	
	@Before
	public void setUp() {
		
		navegador = Web.createChrome("http://192.168.151.17");
		masterpage = new MasterPage(navegador);
		masterpage.getLoginPage().fazLogin("v9437", "v9437");
	}
	
	@After
	public void tearDown() {
		
		navegador.quit();
	}
	
	@Ignore
	@Test
	public void deveAddItensVerificarValorSalvarOrcamentoFinalizarVenda() throws InterruptedException {
		
		masterpage.getCatalogoPage().buscaItem("562");
		masterpage.getCatalogoPage().inserirItemPaginacao(1);
		masterpage.getCatalogoPage().inserirItemPaginacao(2);
		masterpage.getCatalogoPage().inserirItemPaginacao(3);
		masterpage.getCarrinhoPage().irParaCarrinho();
		
		masterpage.getCarrinhoPage().salvarOrcamento();
		masterpage.getMeuPerfilPage().irParaMeuPerfil();
		masterpage.getMeuPerfilPage().abaPedidosEmAbertos();
		masterpage.getMeuPerfilPage().finalizarPedidoEmAberto("1");
		masterpage.getCarrinhoPage().finalizaVenda();
		masterpage.getPagamentoPage().irParaCaixa();
	}
	
	

}
