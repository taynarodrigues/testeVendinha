package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CodigoCompraPage {

	private WebDriver navegador;
	private Actions act;

	public CodigoCompraPage(WebDriver navegador) {

		this.navegador = navegador;
		this.act = new Actions(navegador);
	}

	private void sleep() throws InterruptedException {

		Thread.sleep(1000);
	}

	public void codigoCompra(String codigo) throws InterruptedException {

		sleep();
		WebElement ordemCompra = navegador.findElement(By.name("orderCompra"));
		ordemCompra.clear();
		ordemCompra.sendKeys(codigo);

		sleep();
		navegador.findElement(By.xpath("//th[2]")).click();
	}

	public void codigoItem(String posicao, String valor) throws InterruptedException {

		sleep();
		WebElement codItem = navegador
				.findElement(By
						.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/cart[1]/div[1]/section[1]/table[1]/tbody[1]/tr[ "+ posicao +" ]/td[5]/div[1]/md-input-container[1]/div[1]/div[1]/div[1]/input[1]"));
		
		codItem.sendKeys(valor);
		

		navegador.findElement(By.xpath("//th[2]")).click();
	}
}
