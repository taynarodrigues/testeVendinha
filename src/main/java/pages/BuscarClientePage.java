package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuscarClientePage {
	
	WebDriver navegador;
	
	public BuscarClientePage(WebDriver navegador) {
		this.navegador = navegador;
	}
	
	private void sleep() {
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void buscarCliente(String cpfCnpjNome) {
		
		sleep();
		navegador.findElement(By.xpath("//body//div[@class='row']//div[@class='row']//div[1]//i[1]//img[1]")).click();
		
		sleep();
		WebElement cliente = navegador.findElement(By.xpath("//input[@id='cpfCnpj']"));
		cliente.sendKeys(cpfCnpjNome);
		cliente.sendKeys(Keys.ARROW_DOWN);
		cliente.sendKeys(Keys.ENTER);
		
		sleep();
		navegador.findElement(By.xpath("//i[@class='custom-icon material-icons padding-i'][contains(text(),'done')]")).click();
	}
	
	public void removerCliente() {
		
		navegador.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/cart[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/i[1]")).click();
	}

}
