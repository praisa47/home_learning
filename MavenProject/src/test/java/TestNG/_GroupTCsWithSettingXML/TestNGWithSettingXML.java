package TestNG._GroupTCsWithSettingXML;

import org.testng.annotations.Test;

public class TestNGWithSettingXML {
    @Test
    public void test1(){
        System.out.println("Running normal test1");
    }

    @Test
    public void test2(){
        System.out.println("Running normal test2");
    }

    @Test (groups ={"Regression"})
    public void regression1(){
        System.out.println("Running normal regression1");
    }

    @Test (groups ={"Regression"})
    public void regression2(){
        System.out.println("Running regression2");
    }

    @Test (groups ={"Smoke"})
    public void smoke1(){
        System.out.println("Running smoke1");
    }

    @Test (groups ={"Smoke"})
    public void smoke2(){
        System.out.println("Running smoke2");
    }


}
