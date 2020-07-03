package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormaDePagamentoPage {
	private WebDriver navegador;
	private Actions act;

	public FormaDePagamentoPage(WebDriver navegador) {
		this.navegador = navegador;
		this.act = new Actions(navegador);
	}

	private void sleep() {

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void condicaoPagamento() {
		WebDriverWait e = new WebDriverWait(navegador, 10);
		e.until(ExpectedConditions.invisibilityOfElementLocated(By.className("general-loading")));

		navegador.findElement(By.xpath("//p[contains(text(),'Condição de Pagamento')]")).click();
	}
	

	public void pagamentoAPrazo(String parcela, String opcao) {
		sleep();
		navegador.findElement(By.xpath("//div[text()=\"À prazo\"]")).click();
		sleep();
		navegador.findElement(By.id("condAPrazo")).click();
		sleep();
		navegador.findElement(By.xpath("//md-option[contains(.,'" + parcela + " parcela')]")).click();
		sleep();
		navegador.findElement(By.xpath(
				"/html[1]/body[1]/main[1]/div[3]/cart-simulate-condition[1]/div[1]/div[2]/form[1]/div[1]/div[1]/md-tab-group[1]/div[1]/md-tab-body[2]/div[1]/div[2]/div[1]/md-radio-group[1]/div[ "
						+ opcao + " ]/div[1]/md-radio-button[1]/label[1]/div[1]/div[1]"))
				.click();
		sleep();
		navegador.findElement(By.xpath("//div[@id='done']")).click();
	}

	public void pagamentoCartaoDebito() {

		sleep();
		navegador.findElement(By.id("condAVista")).click();

		sleep();
		WebElement cartao = navegador
				.findElement(By.xpath("//md-option[contains(.,' Cartao ')]"));
		Actions act = new Actions(navegador);
		act.moveToElement(cartao).click().perform();

		sleep();
		navegador.findElement(By.id("condicoes-CD")).click();

		sleep();
		navegador.findElement(By.id("done")).click();
	}

	
	public void pagamentoAntecipadoAtacado() {
		
		navegador.findElement(By.xpath("//md-select[@id='condAVista']")).click();

		sleep();
		WebElement antecipado = navegador.findElement(By.xpath("//md-option[contains(.,'Antecipado')]"));
		act.moveToElement(antecipado).click().perform();
		
		sleep();
		navegador.findElement(By.xpath("//i[contains(text(),'done')]")).click();
	}
	
	public void pagamentoAntecipado() {
		sleep();
		navegador.findElement(By.xpath("//md-select[@id='condAVista']")).click();

		sleep();
		WebElement antecipado = navegador.findElement(By.xpath("//md-option[contains(.,'Antecipado')]"));
		act.moveToElement(antecipado).click().perform();

	}
	
	public void formaDePagamentoAntecipado(String opcao) {
		sleep();
		pagamentoAntecipado();
		
		sleep();
		navegador.findElement(By.xpath("//body/main/div/cart-simulate-condition/div/div/form/div/div/md-tab-group/div/md-tab-body/div/div/div/md-radio-group/div["+ opcao +"]/div[1]/md-radio-button[1]/label[1]/div[2]")).click();
		
		sleep();
		navegador.findElement(By.xpath("//i[contains(text(),'done')]")).click();
	}

	public void pagamentoCredito(String qtdVezes) {
		sleep();
		navegador.findElement(By.id("condAVista")).click();

		sleep();
		WebElement cartao = navegador.findElement(By.xpath("//md-option[contains(.,'Cartao')]"));

		act.moveToElement(cartao).click().perform();

		navegador.findElement(By.id("condicoes-C" + qtdVezes + "")).click();
		navegador.findElement(By.id("done")).click();
	}

	public void administradoraCartao(String adm) {

		sleep();
		navegador.findElement(By.id("administradora")).click();
		sleep();
		navegador.findElement(By.xpath("//md-option[contains(.,'" + adm + "')]")).click();
	}

	public void tipoEntregaPresencial(String tipoEntrega) throws InterruptedException {

		sleep();
		navegador.findElement(By.xpath("//small[contains(text(),'Presencial')]")).click();

		sleep();
		navegador.findElement(By.xpath("//md-select[@id='tipoEntrega']//span[@class='mat-select-arrow']")).click();

		
		sleep();
		WebElement presencial = navegador
				.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/md-option[1]"));
		act.moveToElement(presencial).click().build().perform();
		
	}

	
	public void tipoEntregaEntega(String tipoEntrega) {
		
		sleep();
		navegador.findElement(By.xpath("//small[contains(text(),'Presencial')]")).click();

		sleep();
		navegador.findElement(By.xpath("//md-select[@id='tipoEntrega']//span[@class='mat-select-arrow']")).click();

		sleep();
		WebElement entrega = navegador
				.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/md-option[2]"));
		act.moveToElement(entrega).click().build().perform();
	}
	

	public void condicaoFiscal(String codigoOperacaoFiscal, String texto) {

		navegador.findElement(By.xpath("//small[contains(text(),'Venda Cliente')]")).click();
		navegador.findElement(By.xpath("//md-select[@id='fiscal']//span[@class='mat-select-arrow']")).click();
		WebElement idCodOperacaoFiscal = navegador.findElement(
				By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/md-option[ " + codigoOperacaoFiscal + " ]"));
		idCodOperacaoFiscal.sendKeys(codigoOperacaoFiscal);
		idCodOperacaoFiscal.sendKeys(Keys.ARROW_DOWN);
		idCodOperacaoFiscal.sendKeys(Keys.ENTER);
		navegador.findElement(By.xpath("//textarea[@id='observacoes']")).sendKeys(texto);
	}
}
