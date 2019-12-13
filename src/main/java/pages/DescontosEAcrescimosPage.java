package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DescontosEAcrescimosPage {
	private WebDriver navegador;
	private Actions act;

	public DescontosEAcrescimosPage(WebDriver navegador) {
		this.navegador = navegador;
		this.act = new Actions(navegador);
	}

	private void sleep() {

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void botaoDescontoPedido() {
		sleep();
		navegador.findElement(By.xpath("//a[@id='btnDropdownTotal']")).click();
	}

	public void adicionarDescontoPedido(String valorDesconto) {
		sleep();
		navegador.findElement(By.xpath("//input[@id='valorDescontoTotal']")).sendKeys(valorDesconto);
	}

	public void aplicarDesconto() {
		sleep();
		navegador.findElement(By.xpath("//a[@id='btndiscountTotal']")).click();
	}

	public void adicionaAcrescimoPedido(String valorAcrescimo) {
		sleep();
		WebElement aba = navegador.findElement(By.xpath(
				"/html[1]/body[1]/main[1]/div[2]/div[1]/cart[1]/div[1]/cart-footer[1]/section[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/cart-discount-total[1]/md-tab-group[1]/md-tab-header[1]/div[2]/div[1]/div[1]/div[2]"));
		act.moveToElement(aba).click().perform();

		sleep();
		navegador.findElement(By.xpath("//input[@id='valorAcrescimo']")).sendKeys(valorAcrescimo);
	}

	public void aplicarAcrescimo() {
		sleep();
		navegador.findElement(By.xpath("//a[@id='btnAcrescTotal']")).click();
	}

	public void adicionaFretePedido(String valorFrete) {
		sleep();
		WebElement abaAcrescimo = navegador.findElement(By.xpath(
				"/html[1]/body[1]/main[1]/div[2]/div[1]/cart[1]/div[1]/cart-footer[1]/section[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/cart-discount-total[1]/md-tab-group[1]/md-tab-header[1]/div[2]/div[1]/div[1]/div[2]"));
		act.moveToElement(abaAcrescimo).click().perform();

		navegador.findElement(By.xpath("//input[@id='valorFrete']")).sendKeys(valorFrete);
	}
}
