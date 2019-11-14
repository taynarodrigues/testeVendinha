package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdministradoraCartaoCreditoPage {
	
	private WebDriver navegador;
	
	public AdministradoraCartaoCreditoPage(WebDriver navegador) {
		
		this.navegador = navegador;
	}
	
	private void sleep() {
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void administradoraCartao(String adm) {
		
		navegador.findElement(By.id("administradora")).click();
		navegador.findElement(By.xpath(
				"//md-option[contains(.,'"+adm+"')]"))
				.click();
	}
}
