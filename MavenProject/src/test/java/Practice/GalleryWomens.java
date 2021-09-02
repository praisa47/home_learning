package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GalleryWomens {
    public WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }
    @Test
    public void actual() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");

        //click on dresses
        driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/a")).click();
        Thread.sleep(3000);

        //driver.findElement(By.className("icon-th-large")).click();
       // Thread.sleep(5000);
        //driver.findElement(By.cssSelector(".replace-2x.img-responsive")).get(4).click();
        //Thread.sleep(5000);

        //click on summer dresses
        driver.findElement(By.xpath("//*[@id=\'categories_block_left\']/div/ul/li[3]/a")).click();
        Thread.sleep(3000);

        //click on first image
        driver.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[1]/div/a[1]/img")).click();
        Thread.sleep(3000);

       /* //switch to frame
        driver.switchTo().frame(0);
        //again click on first image
        driver.findElement(By.id("bigpic")).click();
        Thread.sleep(3000);
        //Int size = driver.findElements(By.tagName("iframe")).size();
        //driver.switchTo().frame(0)
        driver.findElement(By.xpath("//*[@id='product']/div[2]/div/div[1]/a[2]/span")).click();
        driver.findElement(By.xpath("//*[@id='product']/div[2]/div/div/div[1]/a[2]/span")).click();
         */



       // SWITCH TO 1ST FRAME
       //when used # id , use cssSelector
            driver.switchTo().frame(0);
            int noIcons=driver.findElements(By.cssSelector("#thumbs_list_frame>li")).size();
            //List<WebElement> webElements=wd.findElements(By.cssSelector("#thumbs_list_frame>li"));
            Thread.sleep(5000);
            driver.findElement(By.id("bigpic")).click(); // question is why big pic twice?
            driver.findElement(By.id("bigpic")).click();
            //wd.switchTo().defaultContent();
            Thread.sleep(3000);
             // wd.switchTo().frame(0);
        for (int i=1;i<noIcons;i++) {
                WebElement nextArrow=driver.findElement(By.cssSelector(".fancybox-nav.fancybox-next"));
                nextArrow.click();
                Thread.sleep(5000);
            }
            driver.switchTo().defaultContent(); //cancel is on the main frame ac to design.
            //wd.findElement(By.xpath("//*[@id=\"category\"]/div[2]/div/div/a")).click();
        Thread.sleep(3000);




    }
    @After
    public void last(){

        driver.quit();
    }

}
