package PracticeFriday;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/*Requirements
        google.com
        in the seatch box type panda
        will give a list
        get all list with pipe (|)
        get 2nd item after the pipe sign

        output
        a fast casual chinese resturant
        species
        national geographic
        smithsonians national zoo
*/

public class PandaPipe {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void actual() throws InterruptedException {
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys(("Panda"));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        List<WebElement> links=driver.findElements(By.cssSelector(".LC20lb.DKV0Md"));
        for (WebElement w: links) {
            //System.out.println(w.getText()+"\n");
            if(w.getText().contains("|")) {  //filtersout and adds to arraylist
                String[] s=w.getText().split("\\|"); //ref to | , array create
                System.out.println(s[1]); //after first |
                if(s[1].contains("Zoo"))
                    System.out.println("1");
                else
                    System.out.println("0");
            }
        }
    }

    @AfterTest
    public void finalStep(){
        driver.quit();
    }
}
