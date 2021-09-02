package Practice._UsingswitchTo;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class w3SchoolFrame_Alert {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //driver.get("https://www.w3schools.com/js/js_popup.asp");
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");
        //driver.findElement(By.xpath("//*[@id='main']/div[4]/a")).click();
        //Thread.sleep(10000);
       /* WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div[5]/div/a[3]"))));
       */
        driver.switchTo().frame("iframeResult");
        driver.findElement(By.xpath("/html/body/button")).click();
        Alert al= driver.switchTo().alert();
        al.accept();

        Thread.sleep(3000);
        driver.quit();

    }
}
