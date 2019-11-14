package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AcrescimoPedidoPage {
	
	WebDriver navegador;
	private Actions act;
	
	public AcrescimoPedidoPage(WebDriver navegador) {
		this.navegador = navegador;
		act = new Actions(navegador);
	}
	
	private void sleep() {
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void abaAcrescimoPedido(String valorAcrescimo) {
		
		sleep();
		navegador.findElement(By.xpath("//a[@id='btnDropdownTotal']")).click();
		
		sleep();
		WebElement aba = navegador.findElement(By.xpath(
				"/html[1]/body[1]/main[1]/div[2]/div[1]/cart[1]/div[1]/cart-footer[1]/section[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/cart-discount-total[1]/md-tab-group[1]/md-tab-header[1]/div[2]/div[1]/div[1]/div[2]"));
		act.moveToElement(aba).click().perform();
		
		sleep();
		WebElement acrescimo = navegador.findElement(By.xpath("//input[@id='valorAcrescimo']"));
		acrescimo.sendKeys(valorAcrescimo);
		
		sleep();
		navegador.findElement(By.xpath("//a[@id='btnAcrescTotal']")).click();
	}

}
