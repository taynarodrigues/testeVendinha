package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TermoDeGarantiaPage {
	
	WebDriver navegador;
	
	public TermoDeGarantiaPage(WebDriver navegador) {
		this.navegador = navegador;
	}
	
	private void sleep() {
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void botaoTermoDeGarantia() {
		
		sleep();
		navegador.findElement(By.xpath("//i[contains(text(),'chrome_reader_mode')]")).click();
		
		
		WebElement msg = navegador.findElement(By.xpath("//b[contains(text(),'Termos de Garantia')]"));
		String texto = msg.getText();
		
		sleep();
		navegador.findElement(By.xpath("//a[@class='close']//i[@class='material-icons center-align'][contains(text(),'close')]")).click();
	}

}
