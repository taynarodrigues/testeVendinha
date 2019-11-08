package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdiministradoraCartaoCreditoPage {
	
	private WebDriver navegador;
	
	public AdiministradoraCartaoCreditoPage(WebDriver navegador) {
		
		this.navegador = navegador;
	}
	
	private void sleep() {
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void adiministradoraCartao() {
		
		sleep();
		navegador.findElement(By.id("administradora")).click();
		navegador.findElement(By.xpath(
				"//md-option[contains(.,' \n" + "                          Cielo\n" + "                           ')]"))
				.click();
	}
}
