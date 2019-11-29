package pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CompraDoacaoDeSucataPage {
	
	WebDriver navegador;
	
	public CompraDoacaoDeSucataPage(WebDriver navegador) {
		this.navegador  = navegador;
	}
	
	private void sleep() {
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void compraDoacaoSucata() {
		sleep();
		navegador.findElement(By.xpath("//i[contains(text(),'person')]")).click();
		
		sleep();
		WebElement compraSucata = navegador.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/sales-manager[1]/div[1]/header[1]/div[1]/div[1]/md-tab-group[1]/md-tab-header[1]/div[2]/div[1]/div[1]/div[3]"));
		Actions act = new Actions(navegador);
		act.moveToElement(compraSucata).click().perform();
	}
	
	public void adicionarSucata( String sucataAmperes, String id, String valorPeso) {
		sleep();
		navegador.findElement(By.xpath("//i[@id='addDiscountWaste']")).click();
		
		sleep();
		navegador.findElement(By.xpath("//input[@id='fornecedor-"+ id +"']")).click();
		navegador.findElement(By.xpath("//span[contains(text(),'Compra Sucata De Baterias')]")).click();
		
		sleep();
		navegador.findElement(By.xpath("//input[@id='sucata-"+ id +"']")).click();
		WebElement sucat = navegador.findElement(By.xpath("//span[contains(text(),'"+ sucataAmperes +"A-SUCATA BATERIA - - "+ sucataAmperes +" AMPERES')]"));
		Actions act = new Actions(navegador);
		act.moveToElement(sucat).click().build().perform();
		
		sleep();
		navegador.findElement(By.cssSelector("#peso-"+ id +"")).sendKeys(valorPeso);
	}
	
	public void finalizarCompra() {
		
		sleep();
		navegador.findElement(By.xpath("//a[@id='btnFinalSales']")).click();
		validarMensagemSucata();
	}
	
	public void validarMensagemSucata() {
		
		sleep();
		WebElement mensagemPopUp = navegador.findElement(By.xpath("//p[@class='message']"));
		String mensagem = mensagemPopUp.getText();
		assertEquals("Compra de Sucata realizado com sucesso!", mensagem);
	}
	
	public void doacaoSucata() {
		
		sleep();
		navegador.findElement(By.xpath("//label[contains(text(),'Sucata para doação')]")).click();
	}

}
