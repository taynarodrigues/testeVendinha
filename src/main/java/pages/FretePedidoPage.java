package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FretePedidoPage {
	
	WebDriver navegador;
	private Actions act;
	
	public FretePedidoPage(WebDriver navegador) {
		this.navegador = navegador;
		act = new Actions(navegador);
	}
	
	private void sleep() {
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void inserirFretePedido(String valorFrete) {
		
		sleep();
		navegador.findElement(By.xpath("//a[@id='btnDropdownTotal']")).click();
		
		sleep();
		WebElement abaAcrescimo = navegador.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/cart[1]/div[1]/cart-footer[1]/section[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/cart-discount-total[1]/md-tab-group[1]/md-tab-header[1]/div[2]/div[1]/div[1]/div[2]"));
		act.moveToElement(abaAcrescimo).click().perform();
		
		sleep();
		WebElement frete = navegador.findElement(By.xpath("//input[@id='valorFrete']"));
		frete.sendKeys(valorFrete);
		
		sleep();
		navegador.findElement(By.xpath("//a[@id='btnAcrescTotal']")).click();
	}

}
