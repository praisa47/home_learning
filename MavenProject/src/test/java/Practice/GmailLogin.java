package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GmailLogin {

    //public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.gmail.com");
        //Thread.sleep(3000);
        driver.findElement(By.id("identifierId")).sendKeys("happyojus");
        //driver.findElement(By.id("identifierId")).sendKeys(Keys.ENTER);

        //driver.findElement(By.id("password")).sendKeys("towel@24");
        //driver.findElement(By.id("password")).sendKeys(Keys.ENTER);

        //Thread.sleep(3000);
        driver.quit();

        }
    }

