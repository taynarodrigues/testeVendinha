package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CompraDeSucataPage {

	private WebDriver navegador;
	private Actions act;

	public CompraDeSucataPage(WebDriver navegador) {
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

	public void adicionarSucata() {
		sleep();
		navegador.findElement(By.id("btnDescontoSucata")).click();
	}

	public void preencherCampoSucata(String sucataAmperes, String id, String valorPeso) {

		sleep();
		navegador.findElement(By.id("addDiscountWaste")).click();

		sleep();
//		navegador.findElement(By.cssSelector("div[class='mat-input-infix'] input[placeholder='Fornecedor']")).click();
		navegador.findElement(By.xpath(
				"/html[1]/body[1]/main[1]/div[3]/cart-discount-waste[1]/div[1]/div[2]/div[1]/div[1]/add-multi-discount-waste-refact["
						+ id + "]/div[1]/div[1]/div[1]/md-input-container[1]/div[1]/div[1]/div[1]/input[1]"))
				.click();

		sleep();
		navegador.findElement(By.xpath("//span[contains(text(),'Compra Sucata De Baterias')]")).click();

		sleep();
		navegador.findElement(By.xpath(
				"/html[1]/body[1]/main[1]/div[3]/cart-discount-waste[1]/div[1]/div[2]/div[1]/div[1]/add-multi-discount-waste-refact["
						+ id + "]/div[1]/div[1]/div[2]/md-input-container[1]/div[1]/div[1]/div[1]/input[1]"))
				.click();

		sleep();
		WebElement sucat = navegador.findElement(By.xpath(
				"//span[contains(text(),'" + sucataAmperes + "A-SUCATA BATERIA - - " + sucataAmperes + " AMPERES')]"));
		act.moveToElement(sucat).click().build().perform();

		sleep();
		navegador.findElement(By.xpath(
				"/html[1]/body[1]/main[1]/div[3]/cart-discount-waste[1]/div[1]/div[2]/div[1]/div[1]/add-multi-discount-waste-refact["
						+ id + "]/div[1]/div[1]/div[4]/md-input-container[1]/div[1]/div[1]/div[1]/input[1]"))
				.sendKeys(valorPeso);
	}

	public void finalizarCompraSucata() {
		sleep();
		navegador.findElement(By.xpath("//i[contains(text(),'done')]")).click();
	}

	public void doacaoSucata() {
		sleep();
		navegador.findElement(By.xpath("//label[contains(text(),'Sucata para doação')]")).click();
	}

}
