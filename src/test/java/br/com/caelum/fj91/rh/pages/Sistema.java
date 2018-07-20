package br.com.caelum.fj91.rh.pages;

import org.openqa.selenium.WebDriver;

import br.com.caelum.fj91.rh.util.Ambiente;

public class Sistema {
	
	private final String URL_SISTEMA = "http://localhost:8080/rh";
	private WebDriver driver;
	
	public Sistema(Ambiente ambiente) {
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
