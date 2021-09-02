package Practice._ExtractMultipleObjects;

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

public class FlipKart {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

        //driver.get("https://www.flipkart.com/");
        driver.get("https://www.flipkart.com/clothing-and-accessories/topwear/tshirt/men-tshirt/pr?sid=clo,ash,ank,edy&otracker=categorytree&otracker=nmenu_sub_Men_0_T-Shirts");
        driver.manage().window().maximize();

    }
    @Test
    public void actualMethod(){
       List<WebElement> Tshirtname = driver.findElements(By.xpath("//a[@class='IRpwTa']"));
        //System.out.println("The total number of Tshirts displayed are: "+ Tshirtname.size());

        WebElement name= Tshirtname.get(10);
        System.out.println("The name of tenth Tshirt is: "+name.getText());

        for (int i =0; i< Tshirtname.size(); i++) {
            WebElement loop = Tshirtname.get(i);
            System.out.println("Names of all the Tshirt's are: " + loop.getText());
        }
           /*for (WebElement e: Tshirtname){
            System.out.println(e.getText());
            }*/




    }
    @AfterMethod
    public void laststep(){
        driver.quit();
    }
}
