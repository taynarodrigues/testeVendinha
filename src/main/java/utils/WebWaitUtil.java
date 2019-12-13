package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebWaitUtil {
	
	private static WebDriver navegador;
	private static WebDriverWait e;
	
	public WebWaitUtil(WebDriver navegador) {
		this.navegador = navegador;
		e = new WebDriverWait(navegador, 10);
	}
	
	public static void esperaLoading() {
		e.until(ExpectedConditions.invisibilityOfElementLocated(By.className("general-loading")));
	}
}
