package Practice._ExtractMultipleObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CnnListing {

    public static void main(String[] args) throws InterruptedException {
        //when we extract multiple objects  from a page we put them in a list of type Webelement
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("https://cnn.com");
        driver.manage().window().maximize();
       //all the links in a webpage has a common anchor tag //a
       // findelements means find more than one element on a webpage
        List<WebElement> allLinks = driver.findElements(By.tagName("a")); //or use driver.findElements(By.xpath("//a"));
        System.out.println("The size of the list is: "+allLinks.size());
        WebElement ninthlink= allLinks.get(9); // webelement = 10th link
        System.out.println(ninthlink.getText());
        System.out.println(ninthlink.getAttribute("href"));  //attribute wi;; have tag href
        //href is the link
        //ninthlink.click();
        Thread.sleep(5000);

        //to click all the elements in the link use a for loop
        for(int i=0; i<=allLinks.size(); i++){
            WebElement link= allLinks.get(i);
            System.out.println("The name of all the links: "+link.getText() +"------"+link.isDisplayed());
            //isDispayed is used to know whether thel ink is hidden or not
            // output display s true but its blank meansit can be an image
            //print name of some link and others are blank
            //Selenium cannot interact with the hidden component
            //those hidden links are included in the total count but cannot print the name
            //we have to make it visible to interact


            //to extract link from a specific area of a webpage we have build our xpath accordingly

        }

        driver.quit();


    }
    }


