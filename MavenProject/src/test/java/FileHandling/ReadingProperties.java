package FileHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class ReadingProperties {
    public static void main(String[] args) throws IOException {
        //System.out.println(System.getProperty("user.dir")); gives the directory
        //String path ="C:\\Users\\dragon\\ITSutra\\MavenProject\\src\\test\\java\\FileHandling\\project.properties";
        // System is a class, getProperty is a static function inside the class, user.dir always give the path to the current project

        Properties prop = new Properties(); //create an object of properties file
        String path =System.getProperty("user.dir") +"\\src\\test\\java\\FileHandling\\project.properties";
        FileInputStream fs = new FileInputStream(path); // connect to the file using FileInputStream, the object
                        // FileInputStream is connecting to the path
        prop.load(fs); //from this fs object we load everything inside the prop object
                    // these are the four lines important line 15,16,17,19

        System.out.println(prop.getProperty("username")); //if we have 2 username in properties file, the first one is overridden
        System.out.println(prop.getProperty("URL"));
        System.out.println(prop.getProperty("Address"));  //if no key value in the file it prints null

        /*Date d =new Date();
        System.out.println(d)*/ //due to the presence of jar files

    }
}
