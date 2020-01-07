package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginacaoCarrinhoPage {
	
	WebDriver navegador;
	
	public PaginacaoCarrinhoPage(WebDriver navegador) {
		this.navegador = navegador;
	}
	
	private void sleep() {
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void paginacaoPrincipalRight(int qtd ) {
		for(int i = 0; i < qtd; i++) {
			sleep();
			navegador.findElement(By.xpath("//div[@class='row']//i[@class='material-icons custom-seta'][contains(text(),'keyboard_arrow_right')]")).click();
		}
	}
	
	public void paginacaoPrincipalLeft(int qtd) {
		for(int i = 0; i < qtd; i++) {
			sleep();
			navegador.findElement(By.xpath("//div[@class='row']//i[@class='material-icons custom-seta'][contains(text(),'keyboard_arrow_left')]")).click();
		}
	}
	
	public void paginacaoRecomendadosRight(int qtd) {
		for(int i = 0; i < qtd; i++) {
			sleep();
			navegador.findElement(By.xpath("//div[@class='row margin-zero']//i[@class='material-icons custom-seta'][contains(text(),'keyboard_arrow_right')]")).click();
		}
	}
	
	public void paginacaoRecomendadosLeft(int qtd) {
		for(int i = 0; i < qtd; i ++) {
			sleep();
			navegador.findElement(By.xpath("//div[@class='row margin-zero']//i[@class='material-icons custom-seta'][contains(text(),'keyboard_arrow_left')]")).click();
		}
	}
	
	public void paginacaoCarrinhoRigth(int qtd) {
		sleep();
		for(int i = 0; i < qtd; i++) {
			sleep();
			navegador.findElement(By.xpath("//i[contains(text(),'chevron_right')]")).click();
		}
	}
	
	public void paginacaoCarrinholeft(int qtd) {
		for(int i = 0; i < qtd; i++) {
			sleep();
			navegador.findElement(By.xpath("//i[contains(text(),'chevron_left')]")).click();
		}
	}
	
	public void paginacaoTags(String posicao) {
		
		sleep();
		navegador.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/search-container[1]/div[1]/md-sidenav-container[1]/div[4]/div[1]/div[2]/filter[1]/div[1]/div[2]/div[1]/div[1]/filter-tag[ "+ posicao +" ]/div[1]")).click();
	}
	

}
