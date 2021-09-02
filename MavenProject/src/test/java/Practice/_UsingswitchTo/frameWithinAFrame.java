package Practice._UsingswitchTo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class frameWithinAFrame {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("http://demo.automationtesting.in/Frames.html");
        driver.manage().window().maximize();
    }

    @Test
        public void singleFrameMethod(){

        //driver.findElement(By.id("btn2")).click();
        //driver.findElement(By.xpath("//*[@id='header']/nav/div/div[2]/ul/li[4]/a")).click();
        //driver.switchTo().frame(0);
        driver.switchTo().frame("singleframe");
        driver.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("Praisa");
        driver. switchTo().defaultContent();  //go to main window
        driver.findElement(By.xpath("/html/body/section/div[1]/div/div/div/div[1]/div/ul/li[2]/a")).click();

    }

    @Test
        public void frameWithinFrameMethod(){
        driver.findElement(By.xpath("/html/body/section/div[1]/div/div/div/div[1]/div/ul/li[2]/a")).click();
        driver.switchTo().frame(1);
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("Devbhandari");
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("/html/body/section/div[1]/div/div/div/div[1]/div/ul/li[1]/a")).click();
    }

    @AfterMethod
    public void endStep() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
