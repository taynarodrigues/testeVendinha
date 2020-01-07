package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ValidaPage {

	private WebDriver navegador;

	public ValidaPage(WebDriver navegador) {
		this.navegador = navegador;
	}

	private void sleep() {

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public String validaMensagem() {

		sleep();
		return navegador.findElement(By.xpath("//p[@class='message']")).getText();
	}

	public String validaCarrinhoLimpo() {
		sleep();
		return navegador.findElement(By.xpath("//p[contains(text(),'Carrinho vazio')]")).getText();
	}
	
	public String validaObservacao() {
		sleep();
		return navegador.findElement(By.xpath("//textarea[@id='observacoes']")).getAttribute("value");
	}
}
