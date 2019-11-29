package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlterarQuantidadePage {
	
	WebDriver navegador;
	
	public AlterarQuantidadePage(WebDriver navegador) {
		
		this.navegador = navegador;
	}
	
	private void sleep() {
		 try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void aumentaQuantidade(int qtd, String posicao) {
		
		for(int i = 0; i < qtd; i++) {
			
			sleep();
			navegador.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/cart[1]/div[1]/section[1]/table[1]/tbody[1]/tr["+posicao+"]/td[7]/app-add-quantidade[1]/div[1]/span[1]/a[2]/i[1]")).click();
		}
	}
	
	public void diminuiQuantidade(int qtd, String posicao) {
		
		for(int i = 0; i < qtd; i++) {
			
			sleep();
			navegador.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/cart[1]/div[1]/section[1]/table[1]/tbody[1]/tr["+posicao+"]/td[7]/app-add-quantidade[1]/div[1]/span[1]/a[1]/i[1]")).click();
		}
	}

}
