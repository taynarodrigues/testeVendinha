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
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void botaoDescontoPedido() {
		sleep();
		navegador.findElement(By.id("btnDropdownTotal")).click();
	}

	public void adicionarDescontoPedido(String valorDesconto) {
		sleep();
		navegador.findElement(By.id("valorDescontoTotal")).sendKeys(valorDesconto);
	}
	
	public void adicionaDescontoItem(String posicao, String valorDesconto) {
		
		sleep();
		navegador.findElement(By.xpath("//tr["+ posicao +"]//td[13]//button[1]")).click();
		
		sleep();
		navegador.findElement(By.id("valorDescontoTotal")).sendKeys(valorDesconto);
		
		sleep();
		navegador.findElement(By.id("discApply")).click();
		
		
	}

	public void aplicarDesconto() {
		sleep();
		navegador.findElement(By.id("btndiscountTotal")).click();
	}

	public void adicionaAcrescimoPedido(String valorAcrescimo) {

		sleep();
		WebElement aba = navegador.findElement(By.xpath(
				"/html[1]/body[1]/main[1]/div[2]/div[1]/cart[1]/div[1]/cart-footer[1]/section[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/cart-discount-total[1]/md-tab-group[1]/md-tab-header[1]/div[2]/div[1]/div[1]/div[2]"));
		act.moveToElement(aba).click().perform();

		sleep();
		navegador.findElement(By.id("valorAcrescimo")).sendKeys(valorAcrescimo);
	}

	public void aplicarAcrescimo() {
		sleep();
		navegador.findElement(By.id("btnAcrescTotal")).click();
	}

	public void adicionaAcrescimoItem(String posicao) {
		sleep();
		WebElement abaItem = navegador.findElement(
				By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/cart[1]/div[1]/section[1]/table[1]/tbody[1]/tr["
						+ posicao + "]/td[13]/button[1]"));
		act.moveToElement(abaItem).click().perform();

	}

	public void aplicarAcrescimoItem(String posicao, String valorAcrescimo) {

		sleep();
		navegador.findElement(By.xpath(
				"/html[1]/body[1]/main[1]/div[2]/div[1]/cart[1]/div[1]/section[1]/table[1]/tbody[1]/tr[" + posicao
						+ "]/td[13]/div[1]/div[1]/cart-item-desc[1]/md-tab-group[1]/md-tab-header[1]/div[2]/div[1]/div[1]/div[2]"))
				.click();

		sleep();
		navegador.findElement(By.id("valorAcrescimoTota")).sendKeys(valorAcrescimo);

		sleep();
		navegador.findElement(By.xpath("//a[contains(text(),'Aplicar')]")).click();
	}

	public void adicionaFretePedido(String valorFrete) {
		sleep();
		WebElement abaAcrescimo = navegador.findElement(By.xpath(
				"/html[1]/body[1]/main[1]/div[2]/div[1]/cart[1]/div[1]/cart-footer[1]/section[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/cart-discount-total[1]/md-tab-group[1]/md-tab-header[1]/div[2]/div[1]/div[1]/div[2]"));
		act.moveToElement(abaAcrescimo).click().perform();

		navegador.findElement(By.id("valorFrete")).sendKeys(valorFrete);
	}
}
