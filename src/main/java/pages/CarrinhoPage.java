package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarrinhoPage {
	private WebDriver navegador;

	public CarrinhoPage(WebDriver navegador) {

		this.navegador = navegador;
	}

	private void sleep() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void irParaCarrinho() {
		sleep();
		navegador.findElement(By.xpath("//i[@class='material-icons center-align'][contains(text(),'shopping_cart')]"))
				.click();
	}

	public void finalizaVenda() {
		sleep();
		navegador.findElement(By.xpath("//p[contains(text(),'Finalizar Venda')]")).click();
	}

	public void salvarOrcamento() {	
		navegador.findElement(By.xpath("//p[contains(text(),'Salvar orçamento')]")).click();
		sleep();

	}

	public void excluirCarrinho() {
		sleep();
		navegador.findElement(By.xpath(
				"/html[1]/body[1]/main[1]/div[2]/div[1]/cart[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/i[1]/img[1]"))
				.click();
	}

	public void buscarCliente(String cpfCnpjNome) {
		sleep();
		navegador.findElement(By.xpath("//body//div[@class='row']//div[@class='row']//div[1]//i[1]//img[1]")).click();

		sleep();
		WebElement cliente = navegador.findElement(By.xpath("//input[@id='cpfCnpj']"));
		cliente.sendKeys(cpfCnpjNome);
		cliente.sendKeys(Keys.ARROW_DOWN);
		cliente.sendKeys(Keys.ENTER);

		sleep();
		navegador.findElement(By.xpath("//i[@class='custom-icon material-icons padding-i'][contains(text(),'done')]"))
				.click();
		
		WebDriverWait e = new WebDriverWait(navegador, 10);
		e.until(ExpectedConditions.invisibilityOfElementLocated(By.className("general-loading")));
	}

	public void removerCliente() {
		navegador.findElement(By.xpath(
				"/html[1]/body[1]/main[1]/div[2]/div[1]/cart[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/i[1]"))
				.click();
	}

	public void aumentaQuantidade(int qtd, String posicao) {
		for (int i = 0; i < qtd; i++) {

			sleep();
			navegador.findElement(
					By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/cart[1]/div[1]/section[1]/table[1]/tbody[1]/tr["
							+ posicao + "]/td[7]/app-add-quantidade[1]/div[1]/span[1]/a[2]/i[1]"))
					.click();
		}
	}

	public void diminuiQuantidade(int qtd, String posicao) {
		for (int i = 0; i < qtd; i++) {

			sleep();
			navegador.findElement(
					By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/cart[1]/div[1]/section[1]/table[1]/tbody[1]/tr["
							+ posicao + "]/td[7]/app-add-quantidade[1]/div[1]/span[1]/a[1]/i[1]"))
					.click();
		}
	}
}
