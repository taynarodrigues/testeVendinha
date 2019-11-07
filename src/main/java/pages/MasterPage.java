package pages;

import org.openqa.selenium.WebDriver;

public class MasterPage {

	private LoginPage loginPage;
	private BuscarItemPage buscaItem;

	public MasterPage(WebDriver navegador) {

		this.loginPage = new LoginPage(navegador);
		this.buscaItem = new BuscarItemPage(navegador);
	}

	public LoginPage getLoginPage() {
		return loginPage;
	}
	
	public BuscarItemPage getBuscaItem() {
		return buscaItem;
	}
}
