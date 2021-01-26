package Practico12Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class groupTests {

    public static final String SALEFORCE_URL = "https://login.salesforce.com/";
    public WebDriver driver;

    @Test(groups = {"successtests","failedtests"})

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(SALEFORCE_URL);
    }

    @Test (priority = 1, groups = "failedtests")
    public void primerTest(){
        System.out.println("Este es el primer Test!!!");
    }

    @Test(groups = {"failedtests"})
    public void segundoTest(){
        System.out.println("Este es el segundo Test!!!");
    }

    @Test(groups = {"successtests"})
    public void tercerTest(){
        System.out.println("Este es el tercer Test!!!");
    }

    @Test(groups = {"failestests"})
    public void cuartoTest(){
        System.out.println("Este es el cuarto Test!!!");
    }

    @Test(groups = {"successtests"})
    public void quintoTest(){
        System.out.println("Este es el quinto Test!!!");
    }

}
