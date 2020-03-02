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
		navegador.findElement(By.xpath("//i[@id='addDiscountWaste']")).click();
	}

	public void preencherCampoSucata(String sucataAmperes, String id, String valorPeso) {
		sleep();
		navegador.findElement(By.xpath("//input[@id='fornecedor-" + id + "']")).click();
		navegador.findElement(By.xpath("//span[contains(text(),'Compra Sucata De Baterias')]")).click();

		sleep();
		navegador.findElement(By.xpath("//input[@id='sucata-" + id + "']")).click();
		WebElement sucat = navegador.findElement(By.xpath(
				"//span[contains(text(),'" + sucataAmperes + "A-SUCATA BATERIA - - " + sucataAmperes + " AMPERES')]"));

		act.moveToElement(sucat).click().build().perform();

		sleep();
		navegador.findElement(By.cssSelector("#peso-" + id + "")).sendKeys(valorPeso);
	}                                       

	public void finalizarCompraSucata() {
		sleep();
		navegador.findElement(By.xpath("//a[@id='btnFinalSales']")).click();
	}

	public void doacaoSucata() {
		sleep();
		navegador.findElement(By.xpath("//label[contains(text(),'Sucata para doação')]")).click();
	}

}
