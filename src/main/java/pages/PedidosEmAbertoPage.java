package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PedidosEmAbertoPage {
	
	private WebDriver navegador;
	
	public PedidosEmAbertoPage(WebDriver navegador) {
		this.navegador = navegador;
	}
	
	private void sleep() {
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void pedidosEmAbertos(String posicao) {

		sleep();
		sleep();
		navegador.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/sales-manager[1]/div[1]/header[1]/div[1]/div[1]/md-tab-group[1]/md-tab-header[1]/div[2]/div[1]/div[1]/div[1]")).click();
		
		sleep();
		navegador.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/sales-manager[1]/div[1]/header[1]/div[1]/div[1]/md-tab-group[1]/div[1]/md-tab-body[1]/div[1]/order-open[1]/div[1]/div[1]/table[1]/tbody[1]/tr[ "+ posicao +" ]/td[6]/div[1]/button[1]/span[1]")).click();
	}

}
