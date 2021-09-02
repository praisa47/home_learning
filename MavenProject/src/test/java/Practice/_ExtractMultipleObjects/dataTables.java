package Practice._ExtractMultipleObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class dataTables {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        driver.get("https://www.datatables.net/examples/data_sources/dom");
        driver.manage().window().maximize();
    }

    @Test
    public void actualMethod(){
       /* List<Integer> salaryvalues= new ArrayList<Integer>();
        List<String> rowTexts = new ArrayList<String>();
        while(true){
            String toClick="//*"
        }*/
    }



    @AfterMethod
    public void laststep(){
        driver.quit();

    }


}
