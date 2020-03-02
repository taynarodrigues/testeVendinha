package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AplicacoesPage {

	private WebDriver navegador;

	public AplicacoesPage(WebDriver navegador) {

		this.navegador = navegador;
	}

	private void sleep() throws InterruptedException {

		Thread.sleep(1000);
	}

	// tayna
	public void aplicacoes(String palavra) throws InterruptedException {
		
		botaoAplicacoes();
		filtro(palavra);
	}

	public void similaresAplicacoes(String palavra) throws InterruptedException {

		filtro(palavra);

	}
	
	private void botaoAplicacoes() throws InterruptedException {

		sleep();
		navegador.findElement(By.xpath("//*[@id=\"custom-card\"]/card-found/div/div[4]/div[1]/div[2]/i")).click();
	}

	private void filtro(String palavra) throws InterruptedException {

		sleep();
		navegador.findElement(By.xpath("//input[@placeholder='Filtro']")).sendKeys(palavra);
		sleep();
		navegador.findElement(By.xpath("//i[@class='col s2 setaIcon material-icons more-horiz-icon']")).click();
		sleep();
		navegador.findElement(By.xpath("//view-models//i[@class='material-icons'][contains(text(),'arrow_back')]"))
				.click();
	}

}
