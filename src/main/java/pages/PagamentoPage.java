package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PagamentoPage {

	private WebDriver navegador;
	private Actions act;

	public PagamentoPage(WebDriver navegador) {

		this.navegador = navegador;
		this.act = new Actions(navegador);
	}

	private void sleep() {

		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void irParaCaixa() {

		sleep();
		navegador.findElement(By.xpath("//a[contains(text(),'Ir para caixa')]")).click();
	}

	public void cancelarPagamento() {

		sleep();
		navegador.findElement(By.xpath("//a[contains(text(),'Cancelar')]")).click();
	}

	public void administradoraCartao(String adm) {

		sleep();
		navegador.findElement(By.id("administradora")).click();
		sleep();
		navegador.findElement(By.xpath("//md-option[contains(.,'" + adm + "')]")).click();
	}

	public void AutorizacaoGerente(String codigo, String senha) {

		sleep();
		navegador.findElement(By.xpath("//small[contains(text(),'Faturamento')]")).click();

		sleep();
		WebElement cod = navegador.findElement(By.xpath("//input[@id='codGerente']"));
		cod.sendKeys(codigo);
		cod.sendKeys(Keys.ARROW_RIGHT);

		sleep();
		WebElement sen = navegador.findElement(By.xpath("//input[@id='senhaGerente']"));
		sen.sendKeys(senha);
		sen.sendKeys(Keys.ARROW_RIGHT);

		sleep();
		navegador.findElement(By.xpath("//i[@class='custom-icon material-icons padding-i']")).click();

	}
}
