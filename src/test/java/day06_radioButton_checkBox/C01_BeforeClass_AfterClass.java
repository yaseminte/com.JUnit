package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeClass_AfterClass {

    /*
    @BeforeClass ve @AfterClass methodlari sadece static methodlar icin calisir.
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test1(){
        driver.get("https://www.amazon.com");
    }
    @Test
    public void test2(){
        driver.get("https://www.techproeducation.com");
    }
    @Test
    public void test3(){
        driver.get("https://www.facebook.com");
    }


}
