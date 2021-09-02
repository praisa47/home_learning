package Radio_ButtonsandScreen_Shots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TakeScreenshots {
    WebDriver driver;

    //@BeforeMethod
    @Test
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.guru99.com");
        driver.manage().window().maximize();

        screenShot("D:\\sample.jpg");

        WebElement element = driver.findElement(By.xpath ("//*[@id=\"g-mainbar\"]/div[1]/div/div/div/div/div/div[1]/h1"));



    }




    //function screenshot will take a screenshot and store it in a path
    public void screenShot(String filePath) {


        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        //Call getScreenshotAs method to create image file
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File DestFile = new File(filePath);
        //Copy file at destination
        try {
            FileUtils.copyFile(srcFile, DestFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void lastStep(){
    driver.quit();
}
}
