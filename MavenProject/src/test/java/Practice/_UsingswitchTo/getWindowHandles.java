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

public class getWindowHandles {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("http://demo.automationtesting.in/Windows.html");
        System.out.println("The title of main window: " +driver.getTitle()); // to print the title
        // prints the title as same for main window and new window which means it is not switching to the new window.
        //Hence we use getwindowHandles which returns set of string
        driver.manage().window().maximize();

    }
    @Test
    public void actualMethod() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//*[@id='Tabbed']/a/button")).click();

        //Krishna Sakinala (Youtube)
        //if we skip line 41-48 // prints the title as same for main window and new window
        // which means it is not switching to the new window.
        //Hence we use getwindowHandles which returns set of string

        Set<String> window= driver.getWindowHandles(); //as this is a set we need to iterate
        Iterator<String> it = window.iterator();

        // Set holds a set of string. It points outside the set. For eg 0,1,2,3,4 is a set
        //need to find where the main and child widow is
        // So it.next will move it to the first index(main window) String mainWindow = holds the value
        //it.next again will move it to the second item on the set which is the child window


        String mainWindow= it.next(); //iterate over the next window
        String newWindow= it.next();

        driver.switchTo().window(newWindow);

        // prints the title as same for main window and new window which means it is not switching to the new window.
        //Hence we use getwindowHandles which returns set of string
        System.out.println("The title of new window: " +driver.getTitle());
        Thread.sleep(5000);

        driver.close();// will close the new window
        Thread.sleep(3000);
        driver.switchTo().window(mainWindow);
        System.out.println("The title of window: " +driver.getTitle());
    }

    @AfterMethod
    public void lastStep(){
        driver.quit();
    }
}
