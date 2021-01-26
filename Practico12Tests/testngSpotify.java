package Practico12Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testngSpotify{

   public WebDriver driver;

   @BeforeMethod
   public void setup(){
       System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
       driver = new ChromeDriver();
       driver.get("https://www.spotify.com");
   }

    @Test (priority=0)
    public void verifySpotifyTitle(){
        System.out.println("Title -> "+ driver.getTitle());
        String title = driver.getTitle();
        Assert.assertEquals(title, "Escuchar es todo - Spotify");
    }

    @Test (priority = 1)
    public void verifySignUpURL(){
       System.out.println("URL actual: " + driver.getCurrentUrl());
       driver.findElement(By.xpath("//*[@href='https://www.spotify.com/ar/signup/']")).click();
       System.out.println("URL nueva: " + driver.getCurrentUrl());
       Assert.assertTrue(driver.getCurrentUrl().contains("signup"));
    }

    @Test (priority = 5)
    //NO FUNCIONA
    public void invalidEmailTest() throws InterruptedException {
       driver.findElement(By.xpath("//*[@href='https://www.spotify.com/ar/signup/']")).click();
       driver.findElement(By.id("email")).sendKeys("test.com");
       driver.findElement(By.id("confirm")).sendKeys("test.com");

       Thread.sleep(3000);
       WebElement errorMessage = driver.findElement(By.xpath("//*[contains(text(),'Este correo electrónico no es válido.')]"));
       Assert.assertNotEquals(errorMessage.getText(),"La dirección de email que proporcionaste no es válida.");
    }

    @Test (priority = 4)
    public void validateExistingEmail() throws InterruptedException {
        driver.findElement(By.xpath("//*[@href='https://www.spotify.com/ar/signup/']")).click();
        driver.findElement(By.id("email")).sendKeys("test@test.com");
        driver.findElement(By.id("confirm")).sendKeys("test@test.com");

        Thread.sleep(3000);
        WebElement errorMessage = driver.findElement(By.xpath("//*[contains(text(),'Este correo electrónico ya está conectado a una cuenta.')]"));
        Assert.assertNotEquals(errorMessage.getText(),"Lo sentimos, este correo ya está registrado.");

    }

    @Test (priority = 3)
    public void checkEqualEmailsError() throws InterruptedException {
        driver.findElement(By.xpath("//*[@href='https://www.spotify.com/ar/signup/']")).click();
        driver.findElement(By.id("email")).sendKeys("test999@test.com");
        driver.findElement(By.id("confirm")).sendKeys("hola@hola.com");
        driver.findElement(By.id("password")).sendKeys("Password1$");

        Thread.sleep(3000);
        WebElement errorMessage = driver.findElement(By.xpath("//*[contains(text(),'Las direcciones de correo electrónico no coinciden.')]"));
        Assert.assertEquals(errorMessage.getText(),"Las direcciones de correo electrónico no coinciden.");

    }


    private static final String EMAIL_ERROR = "Es necesario que introduzcas tu correo electrónico.";
    private static final String EMAIL_CONFIRMATION = "Es necesario que confirmes tu correo electrónico.";
    private static final String PASSWORD = "Debes introducir una contraseña.";
    private static final String NOMBRE_PERFIL = "Introduce un nombre para tu perfil.";
    private static final String DIA_VALIDO = "Indica un día del mes válido.";
    private static final String MES_NACIMIENTO = "Selecciona tu mes de nacimiento.";
    private static final String AÑO = "Indica un año válido.";
    private static final String SEXO = "Selecciona tu sexo.";
    private static final String MESSAGE_ROBOT = "Confirma que no eres un robot.";

    @Test (priority = 2)
    public void checkErrorMessages() {
        driver.findElement(By.xpath("//*[@href='https://www.spotify.com/ar/signup/']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement errorMessageEmail = driver.findElement(By.xpath("//*[contains(text(),'Es necesario que introduzcas tu correo electrónico.')]"));
        WebElement errorMessageConfirmation = driver.findElement(By.xpath("//*[contains(text(),'Es necesario que confirmes tu correo electrónico.')]"));
        WebElement errorMessagePassword = driver.findElement(By.xpath("//*[contains(text(),'Debes introducir una contraseña.')]"));
        WebElement errorMessageNombrePerfil = driver.findElement(By.xpath("//*[contains(text(),'Introduce un nombre para tu perfil.')]"));
        WebElement errorMessageDiaValido = driver.findElement(By.xpath("//*[contains(text(),'Indica un día del mes válido.')]"));
        WebElement errorMessageMesNacimiento = driver.findElement(By.xpath("//*[contains(text(),'Selecciona tu mes de nacimiento.')]"));
        WebElement errorMessageAño = driver.findElement(By.xpath("//*[contains(text(),'Indica un año válido.')]"));
        WebElement errorMessageSexo = driver.findElement(By.xpath("//*[contains(text(),'Selecciona tu sexo.')]"));
        WebElement errorMessageRobot = driver.findElement(By.xpath("//*[contains(text(),'Confirma que no eres un robot.')]"));


        //assertions
        Assert.assertEquals(errorMessageEmail.getText(),EMAIL_ERROR);
        Assert.assertEquals(errorMessageConfirmation.getText(),EMAIL_CONFIRMATION);
        Assert.assertEquals(errorMessagePassword.getText(),PASSWORD);
        Assert.assertEquals(errorMessageNombrePerfil.getText(),NOMBRE_PERFIL);
        Assert.assertEquals(errorMessageDiaValido.getText(),DIA_VALIDO);
        Assert.assertEquals(errorMessageMesNacimiento.getText(),MES_NACIMIENTO);
        Assert.assertEquals(errorMessageAño.getText(),AÑO);
        Assert.assertEquals(errorMessageSexo.getText(),SEXO);
        Assert.assertEquals(errorMessageRobot.getText(),MESSAGE_ROBOT);
   }






}

