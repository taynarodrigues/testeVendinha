package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PagamentoAntecipadoPage {
	
	WebDriver navegador;
	
	public PagamentoAntecipadoPage(WebDriver navegador) {
		this.navegador = navegador;
	}
	
	private void sleep() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void pagamentoAntecipado() {
		
		sleep();
		navegador.findElement(By.xpath("//md-select[@id='condAVista']")).click();
		

		sleep();
		WebElement antecipado = navegador.findElement(By.xpath("//md-option[contains(.,'Antecipado')]"));
		Actions act = new Actions(navegador);
		act.moveToElement(antecipado).click().perform();
		
		sleep();
		navegador.findElement(By.xpath("//i[contains(text(),'done')]")).click();
				
	}
}
