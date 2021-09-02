package TestNG._Intro;

import org.testng.annotations.*;

public class TestNgIntro {


    @BeforeTest
    public void setup(){
        System.out.println("Before the Test");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before each Method");
    }
    @Test
    public void test1(){
        System.out.println("Hello");
    }

    @Test
    public void test2(){
        System.out.println("World");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After each Method");
    }

    @AfterTest
    public void laststep(){
        System.out.println("After the Test");
    }


}
