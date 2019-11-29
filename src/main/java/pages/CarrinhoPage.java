package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarrinhoPage {

	private WebDriver navegador;
	private WebDriverWait espera;

	public CarrinhoPage(WebDriver navegador) {

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

	public void irParaCarrinho() {
		sleep();
		navegador.findElement(By.xpath("//i[@class='material-icons center-align'][contains(text(),'shopping_cart')]"))
				.click();
	}
	
	public void meuPerfil() {
		
		sleep();
		WebElement perfil = navegador.findElement(By.xpath("//i[contains(text(),'person')]"));
		Actions act = new Actions(navegador);
		act.moveToElement(perfil).click().build().perform();
	}

	public void condicaoPagamento() {

		sleep();
		navegador.findElement(By.xpath("//p[contains(text(),'Condição de Pagamento')]")).click();
	}

	public void finalizaVenda() {

		sleep();
		navegador.findElement(By.xpath("//p[contains(text(),'Finalizar Venda')]")).click();
	}
	
	public void salvarOrcamento() {
		
		sleep();
		sleep();
		navegador.findElement(By.xpath("//p[contains(text(),'Salvar orçamento')]")).click();
		
		sleep();
		meuPerfil();
	}

}
