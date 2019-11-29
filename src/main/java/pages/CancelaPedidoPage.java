package pages;


import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CancelaPedidoPage {
	
	WebDriver navegador;

	public CancelaPedidoPage(WebDriver navegador) {
		
		this.navegador = navegador;
	}
	

	private void sleep() {
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void excluirCarrinho() {
		
		sleep();
		navegador.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/cart[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/i[1]/img[1]")).click();
		validaCarrinhoLimpo();
	}
	
	public void validaCarrinhoLimpo() {
		
		sleep();
		WebElement validaCarrinho = navegador.findElement(By.xpath("//p[contains(text(),'Carrinho vazio')]"));
		String texto = validaCarrinho.getText();
		assertEquals("Carrinho vazio", texto);
	}
}
