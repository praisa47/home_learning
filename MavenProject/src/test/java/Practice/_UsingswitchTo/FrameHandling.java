package Practice._UsingswitchTo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FrameHandling {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //implicit wait is for all the find elements command
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //pageloadtimeout is for all the to wait for the page to load
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.get("https://www.freecrm.com/");
        Thread.sleep(5000);

        //login using username and password
        driver.findElement(By.xpath("/html/body/div[1]/header/div/nav/div[2]/div/div[2]/ul/a/span[2]")).click();
        driver.findElement(By.name("email")).sendKeys("praizas47@hotmail.com");
        driver.findElement(By.name("password")).sendKeys("Accept@10");
        //Thread.sleep(5000);
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);

        driver.switchTo().frame("rufous-sandbox");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
        //*[@id="main-nav"]/a[3]/span
        driver.switchTo().frame("downloadFrame");
        driver.findElement(By.id("dashboard-toolbar")).click();
        ////*[@id="dashboard-toolbar"]/div[2]/div/button[1]
        //click on contact using customized xpath
        //this is a link so xpath starts with //a
       // driver.switchTo().frame("downloadFrame");
        Thread.sleep(3000);
        try{
            driver.findElement(By.id("main-nav")).click();
            // driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
        }
        catch (Exception p) {
            p.printStackTrace();
            System.out.println(p.getMessage());
        }

       // Thread.sleep(3000);


        /*
        //click on logout
       // driver.findElement(By.id("ui")).click();
        driver.findElement(By.xpath("//*[@id='top-header-menu']/div[3]/div[2]/div/i")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='top-header-menu']/div[3]/div[2]/div/div/a[5]/span")).click();
        Thread.sleep(2000);
        */
        Thread.sleep(3000);
        driver.quit();
    }
}
