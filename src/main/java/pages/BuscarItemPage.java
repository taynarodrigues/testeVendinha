package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuscarItemPage {
	
	private WebDriver navegador;
	
	public BuscarItemPage(WebDriver navegador) {
		
		this.navegador = navegador;
	}
	
	private void sleep() throws InterruptedException {
		
		Thread.sleep(1000);
	}
	
	public void buscaItem(String busca) throws InterruptedException {
		
		sleep();
		WebElement buscar = navegador.findElement(By.id("search-top-search"));
		buscar.clear();
		buscar.sendKeys(busca);
		buscar.sendKeys(Keys.ENTER);
		buscar.clear();
		sleep();	
	}

}
