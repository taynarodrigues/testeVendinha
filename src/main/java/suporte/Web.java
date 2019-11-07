package suporte;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Web {

	private static WebDriver navegador;
	private static RemoteWebDriver driver;

	public static void browser() {

		navegador.manage().deleteAllCookies();
		navegador.manage().window().maximize();
		navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		navegador.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
	}

	public static WebDriver createChrome() {

		return createChrome("http://192.168.151.93");
	}

	public static WebDriver createChrome(String ip) {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

		navegador = new ChromeDriver();
		navegador.get(ip);
		browser();

		return navegador;
	}

	public static WebDriver createFirefox(String ip) {

		navegador = new FirefoxDriver();
		System.setProperty("webdriver.gecko.driver", "/web-vendas-test/drivers/geckodriver");
		navegador.get(ip);
		browser();

		return navegador;
	}

	public static WebDriver createChromeHeadless(String ip) {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1920x1080");

		WebDriver navegador = new ChromeDriver(options);
		navegador.get(ip);

		return navegador;
	}

	public static WebDriver createChromeHeadlessInscricaoEstadual() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1920x1080");

		WebDriver navegador = new ChromeDriver(options);
		navegador.get("https://www.4devs.com.br/gerador_de_inscricao_estadual");

		return navegador;
	}
}
