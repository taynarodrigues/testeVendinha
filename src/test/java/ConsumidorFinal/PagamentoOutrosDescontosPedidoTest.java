package ConsumidorFinal;

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

public class PagamentoOutrosDescontosPedidoTest {

	private WebDriver navegador;
	private MasterPage masterPage;

	@Before
	public void setUp() {

		navegador = Web.createChrome("http://192.168.151.89");
		masterPage = new MasterPage(navegador);
		masterPage.getLoginPage().fazLogin("v9437", "v9437");
	}

//	@After
	public void tearDown() throws ClassNotFoundException, SQLException {

		masterPage.getMobilePage().realizaSeparacao(QueryVendas.buscaControlePedido());
		navegador.quit();
	}

//	@Ignore
	@Test
	public void deveFinalizarVendaDescontoPedidoOutrosDebito() throws InterruptedException {
		
		masterPage.getCatalogoPage().buscaItem("GP30126");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("mp30088");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("b47061");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCatalogoPage().buscaItem("gbl1119");
		masterPage.getCatalogoPage().inserirItem();
		masterPage.getCarrinhoPage().irParaCarrinho();
		masterPage.getFormaPagamentoPage().condicaoPagamento();
		masterPage.getPagamentosOutrosPage().PagamentosOutrosDebito();
		masterPage.getCarrinhoPage().aumentaQuantidade(2, "1");
		masterPage.getCarrinhoPage().aumentaQuantidade(3, "2");
		masterPage.getCarrinhoPage().aumentaQuantidade(2, "3");
		masterPage.getDescontoAcrescimoPage().botaoDescontoPedido();
		masterPage.getDescontoAcrescimoPage().adicionarDescontoPedido("5001");
		masterPage.getDescontoAcrescimoPage().aplicarDesconto();
		masterPage.getCarrinhoPage().finalizaVenda();
		masterPage.getPagamentosOutrosPage().addLinha();
		masterPage.getPagamentosOutrosPage().selecionarFormaPagamento("0", TipoPagamentoEnum.DINHEIRO.getPagamento(), "80644");
		masterPage.getPagamentosOutrosPage().selecionarFormaPagamento("1", TipoPagamentoEnum.DEBITO.getPagamento(), "56000", TipoPagamentoEnum.FITCARD.getAdministradora());
		masterPage.getPagamentosOutrosPage().selecionarFormaPagamento("2", TipoPagamentoEnum.DEVOLUCAO.getPagamento(), "655", TipoPagamentoEnum.CIELO.getAdministradora());
		masterPage.getPagamentosOutrosPage().selecionarFormaPagamento("3", TipoPagamentoEnum.DEPOSITO.getPagamento(), "500");
		masterPage.getPagamentosOutrosPage().selecionarFormaPagamento("4", TipoPagamentoEnum.CHEQUE.getPagamento(), "500");
		masterPage.getPagamentoPage().irParaCaixa();
	}
	
}
