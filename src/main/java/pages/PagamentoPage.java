package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PagamentoPage {
	
	private WebDriver navegador;
	
	public PagamentoPage(WebDriver navegador) {
		
		this.navegador = navegador;
	}
	
	private void sleep() {
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void irParaCaixa() {
		
		sleep();
		navegador.findElement(By.xpath("//a[contains(text(),'Ir para caixa')]")).click();
	}

}
