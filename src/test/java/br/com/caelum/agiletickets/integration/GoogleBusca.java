package br.com.caelum.agiletickets.integration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleBusca {

	public static void main(String[] args) throws InterruptedException {
		WebDriver browser = new FirefoxDriver();
		browser.get("http://www.google.com/search?q=Caelum");
		browser.findElement(By.cssSelector("h3.r a")).click();
		Thread.sleep(2000);
		browser.close();
	}

}
