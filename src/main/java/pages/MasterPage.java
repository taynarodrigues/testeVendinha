package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MasterPage {

	private LoginPage loginPage;
	private BuscarItemPage buscaItem;

	public MasterPage(WebDriver navegador) {

		this.loginPage = new LoginPage(navegador);
	}

	public LoginPage getLoginPage() {
		return loginPage;
	}
	
	public BuscarItemPage getBuscaItem() {
		return buscaItem;
	}
}
