package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PagamentosOutrosPage {

	private WebDriver navegador;
	private Actions act;

	public PagamentosOutrosPage(WebDriver navegador) {

		this.navegador = navegador;
		act = new Actions(navegador);
	}

	private void sleep() throws InterruptedException {

		Thread.sleep(2000);
	}

	public void PagamentosOutrosDebito() throws InterruptedException {

		sleep();
		navegador.findElement(By.id("condAVista")).click();

		sleep();
		navegador.findElement(By.xpath("//md-option[contains(.,' Outros ')]")).click();

		sleep();
		WebElement outros = navegador
				.findElement(By.cssSelector("#condicoes-C2A > label > div.mat-radio-label-content"));
		Actions act = new Actions(navegador);
		act.moveToElement(outros).click().perform();

		sleep();
		navegador.findElement(By.id("done")).click();
	}

	public void addLinha() throws InterruptedException {

		sleep();
		navegador.findElement(By.xpath("//i[@id='addLine']")).click();
	}

	public void selecionarFormaPagamento(String id, String tipoPagamento, String valorReais, String adm)
			throws InterruptedException {

		sleep();
		navegador.findElement(By.xpath("//input[@id='line-" + id + "']")).click();

		sleep();
		WebElement devCredito = navegador.findElement(By.xpath("//span[contains(text(),'" + tipoPagamento + "')]"));
		act.moveToElement(devCredito).click().perform();

		sleep();
		navegador.findElement(By.xpath("//input[@id='valor-" + id + "']")).sendKeys(valorReais);

		sleep();
		navegador.findElement(By.xpath("//md-select[@id='selectAdm-" + id + "']")).click();

		sleep();
		WebElement admCartao = navegador.findElement(By.xpath("//md-option[contains(.,'" + adm + "')]"));
		act.moveToElement(admCartao).click().perform();

		sleep();
		navegador.findElement(By.xpath("//i[@id='validateValue-" + id + "']")).click();
	}

	public void selecionarFormaPagamento(String id, String tipoPagamento, String valorReais)
			throws InterruptedException {
		sleep();
		navegador.findElement(By.xpath("//input[@id='line-" + id + "']")).click();

		sleep();
		WebElement vCheque = navegador.findElement(By.xpath("//span[contains(text(),'" + tipoPagamento + "')]"));
		act.moveToElement(vCheque).click().perform();

		sleep();
		navegador.findElement(By.xpath("//input[@id='valor-" + id + "']")).sendKeys(valorReais);

		sleep();
		navegador.findElement(By.xpath("//i[@id='validateValue-" + id + "']")).click();
	}
}
