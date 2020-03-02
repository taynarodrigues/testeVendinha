package Aleatorio;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.MasterPage;
import suporte.Web;

public class LoginTest {

	private WebDriver navegador;
	private MasterPage masterPage;

	@Before
	public void setUp() {

		navegador = Web.createChrome("http://192.168.151.84/pemaza/login.php?msg=deslogado");
		
		masterPage = new MasterPage(navegador);

	}

	@After
	public void tearDown() {

		navegador.quit();
	}

	@Test
	public void LoginCaixa() throws InterruptedException {

		
	}

}
