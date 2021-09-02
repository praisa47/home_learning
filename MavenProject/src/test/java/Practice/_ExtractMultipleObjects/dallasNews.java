package Practice._ExtractMultipleObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class dallasNews {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        driver.get("https://www.dallasnews.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void actualMethod(){
       List <WebElement> alllinks= driver.findElements(By.xpath("//a"));
       System.out.println("The total number of links are: "+alllinks.size());

       //WebElement tenthlink =alllinks.get(10);
       System.out.println("The tenth link is: "+ alllinks.get(10).getText());
       //System.out.println("The Attribute of tenth link is: "+tenthlink.getAttribute("href"));
        System.out.println("The Attribute of tenth link is: "+alllinks.get(10).getAttribute("href"));




        //to print the names of all the link we use for loop
    for(int i=0; i <alllinks.size(); i++) {
       //WebElement link = alllinks.get(i);
       //System.out.println("The name of all the links displayed are: "+ link.getText());
        System.out.println("The name of all the links are: " + alllinks.get(i).getText());

    }


    }



    @AfterMethod
    public void laststep(){
    driver.quit();

    }

}
