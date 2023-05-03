import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverClass {
    public static Properties prop;
    public static void main(String[] args)
    {


       try {
           File fis = new File("config.properties");
           FileInputStream file = new FileInputStream(fis);
           prop = new Properties();
           prop.load(file);


       }
       catch (Exception e)
       {
           e.getMessage();
       }
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get(prop.getProperty("BASEURL"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        System.out.println(driver.getTitle());
        driver.close();
    }

}
