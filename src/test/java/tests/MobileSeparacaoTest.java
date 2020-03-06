package tests;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.MobilePage;
import suporte.Web;

public class MobileSeparacaoTest {

	private WebDriver navegador;
	public MobilePage mp;

	@Before
	public void setUp() {

		navegador = Web.createChrome("http://192.168.150.116");
		mp = new MobilePage(navegador);
	}

	@After
	public void tearDown() throws ClassNotFoundException, SQLException {

//		mp.realizaSeparacao(QueryVendas.buscaControlePedido());
		navegador.quit();
	}

	@Test
	public void mobile() {

		mp.realizaSeparacao("3200192019");
	}
}