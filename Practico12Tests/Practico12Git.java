package Practico12Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Practico12Git {

    public static final String SALESFORCE_URL_EU = "https://login.salesforce.com/?locale=eu";
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test (priority=3)
    public void LoginFailureTest(){
        driver.get(SALESFORCE_URL_EU);
        WebElement logoLocation = driver.findElement(By.id("logo"));
        Assert.assertTrue(logoLocation.isDisplayed());

        //Completar el username con “ test@test.com ”
        driver.findElement(By.id("username")).sendKeys("test@test.com");
        //Completar el campo Password con “123466”
        driver.findElement(By.id("password")).sendKeys("123466");
        //Hacer click en el botón Login
        driver.findElement(By.name("Login")).click();

        //imprimir en pantalla el mensaje de error
        WebElement errorMessage = driver.findElement(By.xpath("//*[contains(text(),'Your access to salesforce.com has been disabled by your system administrator. Please contact your Administrator for more information.')]"));
        System.out.println("Mensaje de error: " + errorMessage.getText());
    }


}

