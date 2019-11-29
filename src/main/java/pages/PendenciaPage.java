package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PendenciaPage {
	
	WebDriver navegador;
	
	public PendenciaPage(WebDriver navegador) {
		this.navegador = navegador;
	}
	
	private void sleep() {
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void abaPendencia(String posicao) {
		
		sleep();
		navegador.findElement(By.xpath("//i[contains(text(),'person')]")).click();
		
		sleep();
		navegador.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/sales-manager[1]/div[1]/header[1]/div[1]/div[1]/md-tab-group[1]/md-tab-header[1]/div[2]/div[1]/div[1]/div[2]")).click();
		
		sleep();
		navegador.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/sales-manager[1]/div[1]/header[1]/div[1]/div[1]/md-tab-group[1]/div[1]/md-tab-body[2]/div[1]/pendencies[1]/div[1]/div[1]/table[1]/tbody[1]/tr[ "+ posicao +" ]/td[7]/button[1]/span[1]")).click();
	}

}
