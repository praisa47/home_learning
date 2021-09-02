package Practice._UsingswitchTo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/*
Requirements:
go to the website
Enter 100
Click submit
click cancel
200
click submit
click OK
click OK
 */


public class AlertHandle {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/test/delete_customer.php");
    }

    @Test
    public void testMethodAlertDismiss()  {
        driver.findElement(By.name("cusid")).sendKeys("100");
        driver.findElement(By.name("submit")).click();

        wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert al= driver.switchTo().alert();
        String text = driver.switchTo().alert().getText();
        System.out.println("The alert text is :"+text);
        al.dismiss(); // cancels the alert
        //al.accept();  // Accepts the alert

    }

    @Test
    public void testMethodAlertAccept() throws InterruptedException {
        driver.findElement(By.name("cusid")).sendKeys("200");
        driver.findElement(By.name("submit")).click();

        wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert al = driver.switchTo().alert();
        String alertText= driver.switchTo().alert().getText();
        System.out.println("The alert text is :"+alertText);
        //Thread.sleep(3000);
        al.accept();

        Thread.sleep(3000);
        wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String Text= driver.switchTo().alert().getText();
        System.out.println("The alert text is :"+Text);
        //Thread.sleep(3000);
        alert.accept();

    }

    @AfterMethod
    public void finalStep(){
        driver.quit();
    }

}
