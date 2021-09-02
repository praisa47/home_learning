package TestNG._Intro;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNgParameters {

    @Test
    @Parameters({"id","name"})
    public void getIDName(int id, String name){

        System.out.println("Getting values from xml file " +id +" " +name );
    }
}
