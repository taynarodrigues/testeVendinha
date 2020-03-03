package ConsumidorFinal;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.MasterPage;
import suporte.Web;

public class PedidosEmAbertoTest {

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
	public void deveVerificarOsPedidosEmAberto() throws InterruptedException {

		masterPage.getMeuPerfilPage().irParaMeuPerfil();
		masterPage.getMeuPerfilPage().abaPedidosEmAbertos();
		masterPage.getMeuPerfilPage().finalizarPedidoEmAberto("1");
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().irParaCaixa();
	}

	@Ignore
	@Test
	public void deveAddItensVerificarValorSalvarOrcamentoFinalizarVenda() throws InterruptedException {

		masterPage.getCatalogoPage().buscaItem("amortecedor");
		masterPage.getCatalogoPage().inserirItemPaginacao(1);
		masterPage.getCatalogoPage().inserirItemPaginacao(2);
		masterPage.getCatalogoPage().inserirItemPaginacao(3);
		masterPage.getCatalogoPage().inserirItemPaginacao(4);
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getCarrinhoPage().salvarOrcamento();
		masterPage.getMeuPerfilPage().irParaMeuPerfil();
		masterPage.getMeuPerfilPage().abaPedidosEmAbertos();
		masterPage.getMeuPerfilPage().finalizarPedidoEmAberto("1");
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().irParaCaixa();
		
	}

	@Ignore
	@Test
	public void deveAddItensAddDescontoPedidoVerificarValorSalvarOrcamentoFinalizarVenda() throws InterruptedException {

		masterPage.getCatalogoPage().buscaItem("amort");
		masterPage.getCatalogoPage().inserirItemPaginacao(1);
		masterPage.getCatalogoPage().inserirItemPaginacao(2);
		masterPage.getCatalogoPage().inserirItemPaginacao(3);
		masterPage.getCatalogoPage().inserirItemPaginacao(4);
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getDescontoAcrescimoPage().botaoDescontoPedido();
		masterPage.getDescontoAcrescimoPage().adicionarDescontoPedido("1400");
		masterPage.getDescontoAcrescimoPage().aplicarDesconto();
		masterPage.getCarrinhoPage().salvarOrcamento();
		masterPage.getMeuPerfilPage().irParaMeuPerfil();
		masterPage.getMeuPerfilPage().abaPedidosEmAbertos();
		masterPage.getMeuPerfilPage().finalizarPedidoEmAberto("1");
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentoPage().irParaCaixa();
	}

}
