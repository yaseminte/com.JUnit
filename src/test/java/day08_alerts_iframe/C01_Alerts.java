package day08_alerts_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alerts {

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.close();
    }
    @Test
    public void test01() {
        /*
        Herhangi bir websitesine gidince veya
        bir web sitesine herhangi bir islem yaptigimizda ortaya cikan uyarilara alert diyoruz

        Eger bir allert inspect yapilabiliyorsa, o allert otomasyon ile kullanilabilir,
        Bu tur allertlere HTML alert denir ve bunlar icin ekstra bir islem yapmaya gerek yoktur
        tum webelementler gibi locate edip istedigimiz islemleri yapabiliriz
         driver.get("https://www.teknosa.com/"); da cikan allert vb..

         Ancak web uygulamalarinda HTML alert yaninda java script alert da bulunabilir
         java script alertler locate edilemez
         Selenium'da java script alertlar icin cok ozel bir yontem gelistirilmistir
         */

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        // alert'te ok tusuna basin ve
        driver.switchTo().alert().accept();

        // result kisminda "You successfully clicked an alert" yazdigini test edin

        String expectedResult = "You successfully clicked an alert";
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//p[@id='result']"));
        String actualResultYazisi = sonucYaziElementi.getText();

        Assert.assertEquals(expectedResult,actualResultYazisi);


    }
}
