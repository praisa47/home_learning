package TestNG._GroupTCsWithSettingXML;

import org.testng.annotations.Test;

public class TestNGwithsettingXMLFinal {

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

    @Test (groups ={"Smoke","Regression"})
    public void smoke1regression1(){
        System.out.println("Running smoke1 or regression1");
    }

    @Test (groups ={"Smoke","Regression"})
    public void smoke2regression2(){
        System.out.println("Running smoke2 or regression2");
    }

}
