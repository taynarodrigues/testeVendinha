package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdicionaItemPage {

	private WebDriver navegador;

	public AdicionaItemPage(WebDriver navegador) {

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

	public void inserirItem() {

		navegador.findElement(By.xpath("//i[@class='material-icons shopping-cart-icon']")).click();
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

}
