package Practico12Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class spotifyTestWithParameters {

    public static final String SALESFORCE_URL_EU = "https://login.salesforce.com/?locale=eu";
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(SALESFORCE_URL_EU);
    }

    @Test
    public void spotifyTags(){

        System.out.println("Elementos h1: \n");

        List<WebElement> ListadeH1s  = driver.findElements(By.tagName("h1"));
        System.out.println("Se encontraron " + ListadeH1s.size() + " elementos\n");

        System.out.println("Elementos h2: \n");

        List<WebElement> ListadeH2s  = driver.findElements(By.tagName("h2"));
        System.out.println("Se encontraron " + ListadeH1s.size() + " elementos\n");

        System.out.println("Elementos h3: \n");

        List<WebElement> ListadeH3s  = driver.findElements(By.tagName("h3"));
        System.out.println("Se encontraron " + ListadeH3s.size() + " elementos\n");
    }
}
