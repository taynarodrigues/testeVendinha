package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VendaPerdidaPage {

	WebDriver navegador;
	WebDriverWait e;

	public VendaPerdidaPage(WebDriver navegador) {
		this.navegador = navegador;
	}

	public void vendaPerdida(String posicaoElemento) {

		navegador.findElement(By.xpath(
				"/html[1]/body[1]/main[1]/div[2]/div[1]/search-container[1]/div[1]/md-sidenav-container[1]/div[4]/div[2]/div[1]/div[1]/found[1]/div[1]/div[2]/carousel[1]/div[1]/div[1]/div[1]/div[ "
						+ posicaoElemento + " ]/div[1]/card-found[1]/div[1]/div[4]/div[3]/div[2]/div[1]/i[2]"))
				.click();
	}

	public void recomendadosVendaPerdida(String posicaoElemento) {

		navegador.findElement(By.xpath(
				"/html[1]/body[1]/main[1]/div[2]/div[1]/search-container[1]/div[1]/md-sidenav-container[1]/div[4]/div[2]/div[1]/div[2]/recommended[1]/div[1]/div[2]/carousel[1]/div[1]/div[1]/div[1]/div[ "
						+ posicaoElemento + " ]/div[1]/custom-card-horiz[1]/md-card[1]/div[2]/div[2]/i[2]"))
				.click();
	}

	public void opcaoVendaPerdida(String qtdPerdida, String qtdAtendida, String obs) {
		
		navegador.findElement(By.xpath("//li[contains(text(),'Venda Perdida')]")).click();

		WebElement perdida = navegador.findElement(By.xpath("//input[@id='quantidadePerdida']"));
		perdida.clear();
		perdida.sendKeys(qtdPerdida);

		navegador.findElement(By.xpath("//input[@id='quantidadeAtendida']")).sendKeys(qtdAtendida);
		navegador.findElement(By.xpath("//input[@id='observacao']")).sendKeys(obs);
	}

	public void confirmaVendaPerdida() {
		navegador.findElement(By.xpath("//i[contains(text(),'done')]")).click();
	}

	public void sairVendaPerdida() {
		navegador
				.findElement(
						By.xpath("//div[@id='addItemMain']//i[@class='material-icons'][contains(text(),'arrow_back')]"))
				.click();
	}
}
