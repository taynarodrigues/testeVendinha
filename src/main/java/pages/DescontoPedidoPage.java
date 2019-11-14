package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DescontoPedidoPage {
	
	WebDriver navegador;
	
	public DescontoPedidoPage(WebDriver navegador) {
		
		this.navegador = navegador;
	}
	
	private void sleep() {
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void botaoDescontoPedido(String valorDesconto) {
		
		sleep();
		navegador.findElement(By.xpath("//a[@id='btnDropdownTotal']")).click();
		
		WebElement desconto = navegador.findElement(By.xpath("//input[@id='valorDescontoTotal']"));
		desconto.sendKeys(valorDesconto);
		
		sleep();
		navegador.findElement(By.xpath("//a[@id='btndiscountTotal']")).click();
	}

}
