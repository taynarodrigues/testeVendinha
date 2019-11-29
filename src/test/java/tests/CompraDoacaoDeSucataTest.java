package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.MasterPage;
import suporte.Web;

public class CompraDoacaoDeSucataTest {
	
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
	
	@Ignore
	@Test
	public void compraDoacaoSucata() throws InterruptedException {
		
		masterPage.getCompraDoacaoDeSucataPage().compraDoacaoSucata();
		masterPage.getCompraDoacaoDeSucataPage().adicionarSucata("50", "0", "6000");
		masterPage.getCompraDoacaoDeSucataPage().adicionarSucata("105", "1", "6000");
		masterPage.getCompraDoacaoDeSucataPage().adicionarSucata("60", "2", "5000");
		masterPage.getCompraDoacaoDeSucataPage().finalizarCompra();
		masterPage.getLoginPage().lookOpen();
	}
	
	@Test
	public void sucataDoacao() throws InterruptedException {
		
		masterPage.getCompraDoacaoDeSucataPage().compraDoacaoSucata();
		masterPage.getCompraDoacaoDeSucataPage().adicionarSucata("50", "0", "6000");
		masterPage.getCompraDoacaoDeSucataPage().doacaoSucata();
		masterPage.getCompraDoacaoDeSucataPage().finalizarCompra();
		masterPage.getLoginPage().lookOpen();		
	}
	

}
