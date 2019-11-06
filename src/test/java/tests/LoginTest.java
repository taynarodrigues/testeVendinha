package tests;

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

		navegador = Web.createChrome("http://192.168.151.89");
		
		masterPage = new MasterPage(navegador);
		
		masterPage.getLoginPage().fazLogin("v9437", "v9437");
	}

	@After
	public void tearDown() {

		navegador.quit();
	}

	@Test
	public void deveFazeLoginUsuario() throws InterruptedException {

		masterPage.getLoginPage().lookOpen();
	}

}
