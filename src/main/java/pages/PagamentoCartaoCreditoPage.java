package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PagamentoCartaoCreditoPage {

	private WebDriver navegador;

	public PagamentoCartaoCreditoPage(WebDriver navegador) {

		this.navegador = navegador;
	}

	private void sleep() {

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void pagamentoCredito(String qtdVezes) {

		sleep();
		navegador.findElement(By.id("condAVista")).click();

		sleep();
		WebElement cartao = navegador
				.findElement(By.xpath("//md-option[contains(.,' \n" + "                      Cartao   ')]"));
		Actions act = new Actions(navegador);
		act.moveToElement(cartao).click().perform();


		navegador.findElement(By.id("condicoes-C" + qtdVezes + "")).click();

		navegador.findElement(By.id("done")).click();
	}

}
