package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MeuPerfilPage {
	private WebDriver navegador;
	private Actions act;

	public MeuPerfilPage(WebDriver navegador) {

		this.navegador = navegador;
		this.act = new Actions(navegador);
	}

	private void sleep() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void irParaMeuPerfil() {
		sleep();
		WebElement perfil = navegador.findElement(By.xpath("//i[contains(text(),'person')]"));
		act.moveToElement(perfil).click().build().perform();
	}

	public void abaPedidosEmAbertos() {
		sleep();
		navegador.findElement(By.xpath(
				"/html[1]/body[1]/main[1]/div[2]/div[1]/sales-manager[1]/div[1]/header[1]/div[1]/div[1]/md-tab-group[1]/md-tab-header[1]/div[2]/div[1]/div[1]/div[1]"))
				.click();
	}

	public void finalizarPedidoEmAberto(String posicao) {
		sleep();
		navegador.findElement(By.xpath(
				"/html[1]/body[1]/main[1]/div[2]/div[1]/sales-manager[1]/div[1]/header[1]/div[1]/div[1]/md-tab-group[1]/div[1]/md-tab-body[1]/div[1]/order-open[1]/div[1]/div[1]/table[1]/tbody[1]/tr[ "
						+ posicao + " ]/td[6]/div[1]/button[1]/span[1]"))
				.click();
	}

	public void abaPendencia() {
		sleep();
		navegador.findElement(By.xpath(
				"/html[1]/body[1]/main[1]/div[2]/div[1]/sales-manager[1]/div[1]/header[1]/div[1]/div[1]/md-tab-group[1]/md-tab-header[1]/div[2]/div[1]/div[1]/div[2]"))
				.click();
	}

	public void finalizarPendencia(String posicao) {
		sleep();
		navegador.findElement(By.xpath(
				"/html[1]/body[1]/main[1]/div[2]/div[1]/sales-manager[1]/div[1]/header[1]/div[1]/div[1]/md-tab-group[1]/div[1]/md-tab-body[2]/div[1]/pendencies[1]/div[1]/div[1]/table[1]/tbody[1]/tr[ "
						+ posicao + " ]/td[7]/button[1]/span[1]"))
				.click();
	}

	public void abaCompraSucata() {
		sleep();
		WebElement compraSucata = navegador.findElement(By.xpath(
				"/html[1]/body[1]/main[1]/div[2]/div[1]/sales-manager[1]/div[1]/header[1]/div[1]/div[1]/md-tab-group[1]/md-tab-header[1]/div[2]/div[1]/div[1]/div[3]"));
		act.moveToElement(compraSucata).click().perform();
	}
}
