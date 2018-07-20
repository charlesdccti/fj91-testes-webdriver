package br.com.caelum.fj91.rh.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaDeCargos {

	private WebDriver driver;

	public PaginaDeCargos(WebDriver driver) {
		this.driver = driver;
		driver.navigate().to(driver.getCurrentUrl() + "/cargos");
	}

	public void clicaNoBotaoNovoCargo() {
		driver.findElement(By.className("webdriver_btn-novo")).click();
	}

	public void preencheFormulario(String nome, String salarioMinimo, String salarioMaximo) {
		driver.findElement(By.className("webdriver_campo-nome")).sendKeys(nome);
		driver.findElement(By.className("webdriver_campo-salario-minimo")).sendKeys(salarioMinimo);
		driver.findElement(By.className("webdriver_campo-salario-maximo")).sendKeys(salarioMaximo);
	}

	public void clicaNoBotaoGravar() {
		driver.findElement(By.className("webdriver_btn-gravar")).click();
	}

	public boolean temMensagem(String mensagem) {
		return driver.getPageSource().contains(mensagem);
	}

}
