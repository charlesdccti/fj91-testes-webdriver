package br.com.caelum.fj91.rh.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum Ambiente {
	
	FIREFOX_LINUX("webdriver.gecko.driver", "src/test/resources/drivers/firefox/linux/geckodriver") {
		@Override
		public WebDriver getDriver() {
			return new FirefoxDriver();
		}
	},
	FIREFOX_MACOS("webdriver.gecko.driver", "src/test/resources/drivers/firefox/macos/geckodriver") {
		@Override
		public WebDriver getDriver() {
			return new FirefoxDriver();
		}
	},
	FIREFOX_WINDOWS("webdriver.gecko.driver", "src/test/resources/drivers/firefox/windows/geckodriver.exe") {
		@Override
		public WebDriver getDriver() {
			return new FirefoxDriver();
		}
	},
	CHROME_LINUX("webdriver.chrome.driver", "src/test/resources/drivers/chrome/chromedriver") {
		@Override
		public WebDriver getDriver() {
			return new ChromeDriver();
		}
	},
	CHROME_MACOS("webdriver.chrome.driver", "src/test/resources/drivers/chrome/chromedriver") {
		@Override
		public WebDriver getDriver() {
			return new ChromeDriver();
		}
	},
	CHROME_WINDOWS("webdriver.chrome.driver", "src/test/resources/drivers/chrome/chromedriver.exe") {
		@Override
		public WebDriver getDriver() {
			return new ChromeDriver();
		}
	};
	
	private final String nomeDriver;
	private final String caminhoDriver;

	private Ambiente(String nomeDriver, String caminhoDriver) {
		this.nomeDriver = nomeDriver;
		this.caminhoDriver = caminhoDriver;
	}
	
	public abstract WebDriver getDriver();

	public String getNomeDriver() {
		return nomeDriver;
	}
	public String getCaminhoDriver() {
		return caminhoDriver;
	}

}
