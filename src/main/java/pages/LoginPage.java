package pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver navegador;
	WebDriverWait espera;

	public LoginPage(WebDriver navegador) {

		this.navegador = navegador;
		espera = new WebDriverWait(navegador, 10);
	}

	public void fazLogin(String usuario, String senha) {

		inserirUsuario(usuario);
		inserirSenha(senha);
		btnLogin();
	}

	private LoginPage inserirUsuario(String usuario) {

		WebElement login = navegador.findElement(By.id("userLogin"));
		login.sendKeys(usuario);
		login.sendKeys(Keys.ENTER);
		return new LoginPage(navegador);
	}

	private LoginPage inserirSenha(String senha) {

		WebElement login = navegador.findElement(By.id("passwordLogin"));
		login.sendKeys(senha);
		login.sendKeys(Keys.ENTER);
		return new LoginPage(navegador);
	}

	private void btnLogin() {

		navegador.findElement(By.id("next")).click();
	}

	public void lookOpen() throws InterruptedException {

		Thread.sleep(1000);
		navegador.findElement(By.id("navbar_lock")).click();
		validaTelaLogin();
	}
	
	public void validaTelaLogin() throws InterruptedException {
		
//		navegador.findElement(By.id("appLogin"));
		assertTrue(espera.until(ExpectedConditions.visibilityOfElementLocated(By.id("appLogin"))) != null);
		assertTrue(espera
				.until(ExpectedConditions.textToBePresentInElementLocated(By.id("appLogin"), "Início da sessão")));
		
	}

}
