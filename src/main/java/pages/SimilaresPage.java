package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SimilaresPage {

	private WebDriver navegador;

	public SimilaresPage(WebDriver navegador) {

		this.navegador = navegador;
	}

	private void sleep() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void similares() {

		moreVert();

	}

	public void similaresAdicionaItem(String posicao) {

		moreVert();
		similaresAdicionaAoCarrinho(posicao);

	}
	
	public void similaresAdicionaDemonstracao(String posicao) {
		moreVert();
		adicionaDemonstracao(posicao);
		sairSimilares();	
	}
	
	public void similaresAplicacoes(String posicao) {
		
		moreVert();
		verificaAplicacoes(posicao);
		
	}
	
	public void similaresAdicionaDemostracao(String posicao) {

		moreVert();
		similaresAdicionaAoCarrinho(posicao);
		sairSimilares();
	}
//tayna
	private void moreVert() {

		sleep();
		navegador.findElement(By.xpath("//i[@class='material-icons more-horiz-icon']")).click();

		sleep();
		navegador.findElement(By.xpath("//li[contains(text(),'Similares')]")).click();

	}
	
	private void verificaAplicacoes(String posicao){

		sleep();
		navegador.findElement(By.xpath(
				"/html[1]/body[1]/main[1]/div[2]/div[1]/search-container[1]/div[1]/md-sidenav-container[1]/div[4]/view-similar[1]/div[1]/div[2]/div[ "
						+ posicao + " ]/card-similar[1]/div[1]/div[2]/div[1]/i[1]"))
				.click();
	}


	public void similaresAdicionaAoCarrinho(String posicao) {

		sleep();
		navegador.findElement(By.xpath(
				"/html[1]/body[1]/main[1]/div[2]/div[1]/search-container[1]/div[1]/md-sidenav-container[1]/div[4]/view-similar[1]/div[1]/div[2]/div[ "
						+ posicao + " ]/card-similar[1]/div[1]/div[4]/div[1]/i[1]"))
				.click();

		sleep();
		navegador.findElement(By.xpath("//li[contains(text(),'Adicionar ao carrinho')]")).click();
	}
	

	public void similaresAdicionarQuantidade(String posicao) {

		moreVert();
		sleep();
		navegador.findElement(By.xpath(
				"/html[1]/body[1]/main[1]/div[2]/div[1]/search-container[1]/div[1]/md-sidenav-container[1]/div[4]/view-similar[1]/div[1]/div[2]/div[ "
						+ posicao + " ]/card-similar[1]/div[1]/div[4]/div[1]/i[1]"))
				.click();

		sleep();
		navegador.findElement(By.xpath("//li[contains(text(),'Adicionar ao carrinho')]")).click();
	}
	
	
	public void inserirItemComQuantidade(String quant) {

		WebElement quantidade = navegador.findElement(By.xpath("//input[@id='quantidade']"));
		quantidade.clear();
		quantidade.sendKeys(quant);

		navegador.findElement(By.id("add-in-cart-detail-done")).click();
	}

	public void sairSimilares() {

		sleep();
		navegador.findElement(By.xpath("//view-similar//i[@class='material-icons'][contains(text(),'arrow_back')]"))
				.click();
	}

	private void adicionaDemonstracao(String posicao) {

		sleep();
		navegador.findElement(By.xpath(
				"/html[1]/body[1]/main[1]/div[2]/div[1]/search-container[1]/div[1]/md-sidenav-container[1]/div[4]/view-similar[1]/div[1]/div[2]/div[ "
						+ posicao + " ]/card-similar[1]/div[1]/div[4]/div[1]/i[1]"))
				.click();
		navegador
				.findElement(By.xpath(
						"//div[@class='more-options']//li[@class='valign-wrapper'][contains(text(),'Demonstração')]"))
				.click();
	}	
}
