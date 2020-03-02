package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogoPage {
	private WebDriver navegador;

	public CatalogoPage(WebDriver navegador) {

		this.navegador = navegador;
	}

	private void sleep() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void buscaItem(String busca) throws InterruptedException {

		sleep();
		WebElement buscar = navegador.findElement(By.id("search-top-search"));
		buscar.sendKeys(busca);
		buscar.sendKeys(Keys.ENTER);
		buscar.clear();
		sleep();
	}

	public void inserirItem() {
		sleep();
		navegador.findElement(By.xpath("//i[@class='material-icons shopping-cart-icon']")).click();
	}

	public void inserirItemPaginacao(int posicao) {
		sleep();
		navegador.findElement(By.xpath(
				"/html[1]/body[1]/main[1]/div[2]/div[1]/search-container[1]/div[1]/md-sidenav-container[1]/div[4]/div[2]/div[1]/div[1]/found[1]/div[1]/div[2]/carousel[1]/div[1]/div[1]/div[1]/div[ "
						+ posicao + " ]/div[1]/card-found[1]/div[1]/div[4]/div[3]/div[2]/div[1]/i[1]"))
				.click();
	}

	public void inserirItemComQuantidade(String quant) {
		sleep();
		navegador.findElement(By.cssSelector(
				"#custom-card > card-found > div > div:nth-child(5) > div.card-controls > div.buttons-container > div > i.material-icons.more-horiz-icon"))
				.click();

		sleep();
		navegador.findElement(By.xpath("//li[contains(text(),'Adicionar ao carrinho')]")).click();
		sleep();

		WebElement quantidade = navegador.findElement(By.xpath("//input[@id='quantidade']"));
		quantidade.clear();
		quantidade.sendKeys(quant);

		navegador.findElement(By.id("add-in-cart-detail-done")).click();
	}
	//Tester12

	public boolean validaVariosItensAdicionados(int numero) {
		
		WebDriverWait espera = new WebDriverWait(navegador, 10);
		boolean resultado = false;
		
		sleep();
		for(int i =1; i <= numero; i++) {
			resultado = espera.until(ExpectedConditions
					.visibilityOfElementLocated(By.cssSelector("#itemList > tr:nth-child(" + i + ")")))
			.isDisplayed();
		}
		sleep();
		return resultado;
	}
}
