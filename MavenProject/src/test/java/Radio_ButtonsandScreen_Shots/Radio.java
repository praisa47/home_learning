package Radio_ButtonsandScreen_Shots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Radio {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.automationtesting.in/Register.html");
        //driver.get("https://www.keynotesupport.com/internet/web-contact-form-example-radio-buttons.shtml");
        driver.manage().window().maximize();

    }

    @Test
    public void actualMethod() throws InterruptedException {
        List<WebElement> radio = driver.findElements(By.name("radiooptions"));

        System.out.println("Total radio buttons: "+radio.size() );
        radio.get(1).getAttribute("checked"); // will tell if the attributed is checked or not
        radio.get(1).click();
       // Thread.sleep(4000);
        radio.get(1).getAttribute("checked"); // will tell if the attributed is checked or not

       // driver.findElements(By.)

    }

    @AfterMethod
    public void lastStep(){
        driver.quit();
    }
}
