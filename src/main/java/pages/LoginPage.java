package pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver navegador;

	public LoginPage(WebDriver navegador) {

		this.navegador = navegador;
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
	}
	
	public void validaTelaLogin() {
		
		navegador.findElement(By.id("appLogin"));
		
	}
}
