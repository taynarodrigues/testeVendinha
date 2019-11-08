package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarrinhoPage {
	
	private WebDriver navegador;
	private WebDriverWait espera;
	
	public CarrinhoPage(WebDriver navegador) {
		
		this.navegador = navegador;
	}
	
	private void sleep() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void irParaCarrinho() {
		sleep();
		navegador.findElement(By.xpath("//i[@class='material-icons center-align'][contains(text(),'shopping_cart')]")).click();
	}
	
	public void finalizaVenda() {
		
		sleep();
		navegador.findElement(By.xpath("//p[contains(text(),'Finalizar Venda')]")).click();
	}
	
	public void condicaoPagamento() {
		
		navegador.findElement(By.xpath("//p[contains(text(),'Condição de Pagamento')]")).click();
	}
	
	

}
