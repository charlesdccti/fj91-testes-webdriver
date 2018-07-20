package br.com.caelum.fj91.testes.pages;

import org.openqa.selenium.WebDriver;

import br.com.caelum.fj91.testes.util.Ambiente;

public class Sistema {
	
	private final String URL_SISTEMA = "http://localhost:8080/testes";
	private final Ambiente ambiente = Ambiente.FIREFOX_MACOS;
	private final WebDriver driver;
	
	public Sistema() {
		System.setProperty(ambiente.getNomeDriver(), ambiente.getCaminhoDriver());
		this.driver = ambiente.getDriver();
		this.driver.navigate().to(URL_SISTEMA);
	}

	public void encerrrar() {
		driver.quit();
	}
	
	public PaginaDeCargos acessaPaginaDeCargos() {
		return new PaginaDeCargos(driver);
	}

}
