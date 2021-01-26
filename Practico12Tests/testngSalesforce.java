package Practico12Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testngSalesforce {

    public static final String SALEFORCE_URL = "https://login.salesforce.com/";
    public static final String SALESFORCE_URL_EU = "https://login.salesforce.com/?locale=eu";

    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(SALEFORCE_URL);
    }


    @Test (priority = 1)
    public void validateSalesforceLogoTest(){
        WebElement logo = driver.findElement(By.id("logo"));
        //El test debe mostrar el tagName del id logo en pantalla y su atributo “alt’
        System.out.println(logo.getTagName());
        System.out.println(logo.getAttribute("alt"));
    }


    @Test (priority=4)
    public void RememberMeIsSelected(){
        driver.get(SALESFORCE_URL_EU);

        WebElement checkboxSelection = driver.findElement(By.name("rememberUn"));
        if(checkboxSelection.isSelected()==false){
            checkboxSelection.click();
        }
        //Validar que el checkbox está seleccionado
        Assert.assertTrue(checkboxSelection.isSelected());
    }

    @Test (priority = 2) //(enabled = false)
    public void footerIsValid(){
        driver.get(SALESFORCE_URL_EU);
        //Validar que el footer tenga “All rights reserved”
        WebElement footerMessage = driver.findElement(By.id("footer"));
        Assert.assertTrue(footerMessage.getText().contains("All rights reserved"));
    }
}
