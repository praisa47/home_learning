package Practice._UsingswitchTo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class handlingWindows {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("http://demo.automationtesting.in/Windows.html");
        driver.manage().window().maximize();

    }
    @Test
    public void actualMethod() throws InterruptedException {
        System.out.println("The title of the main window is: " +driver.getTitle());
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id='Seperate']/button")).click();

      Set<String> window =driver.getWindowHandles();
        Iterator<String> it = window.iterator();

       String mainWindow = it.next();
       String newWindow = it.next();

       driver.switchTo().window(newWindow);



        System.out.println("The title of the new window is: " +driver.getTitle());
        Thread.sleep(5000);

        driver.close();

        driver.switchTo().window(mainWindow);
        System.out.println("The title of the window again is: " +driver.getTitle());
    }

    @AfterMethod
    public void lastStep(){
        driver.quit();
    }
}
