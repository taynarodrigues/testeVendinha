package pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.TransporteUtil;

public class TransportePage {

	WebDriver navegador;

	public TransportePage(WebDriver navegador) {
		this.navegador = navegador;
	}

	private void sleep() {

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void abaTransporte(String transporte, String idReceptor) {

		sleep();
		navegador.findElement(By.xpath("//small[contains(text(),'Próprio')]")).click();

		sleep();
		navegador.findElement(By.xpath("//input[@id='transporte']")).click();

		sleep();
		WebElement trans = navegador.findElement(By.cssSelector("#transporte"));
		trans.clear();
		trans.sendKeys(transporte);
		trans.sendKeys(Keys.ARROW_DOWN);
		trans.sendKeys(Keys.ENTER);

		sleep();
		navegador.findElement(By.xpath("//md-select[@id='frete']//div[@class='mat-select-trigger']")).click();

		sleep();
		WebElement recept = navegador
				.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/md-option[" + idReceptor + "]"));
		recept.sendKeys(idReceptor);
		recept.sendKeys(Keys.ARROW_DOWN);
		recept.sendKeys(Keys.ENTER);
	}

	public void preencheCamposTransporte() {
		
		Map<String, String> map = TransporteUtil.getTransporte();
		
		for (String xpath: map.keySet()) {
			sleep();
			navegador.findElement(By.xpath("//input[@id='" + xpath + "']")).sendKeys(map.get(xpath));
		}
		
	}
}
