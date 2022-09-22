package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_HandleWindows {
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void test01(){
        // 1-amazon anasayfaya girin

        driver.get("https://www.amazon.com");
        String ilkSayfaHandleDegeri = driver.getWindowHandle();

        // 2- Nutella icin arama yaptirin

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);

        /*
        CDwindow-77AD86C98D0A6E14897859E4B8AF2E5F
        Bu kod acilan sayfanin unique hash kodudur.
        Selenium sayfalar arasi geciste bu window handle degerini kullanir

        Eger sayfalar arasinda driverimizi gezdiriyorsak ve herhangi bir sayfadan
        su anda bulundugumuz sayfaya gecmek istiyorsak
        driver.switchTo().window("CDwindow-77AD86C98D0A6E14897859E4B8AF2E5F");
        Bu sayfanin window handle degerini girerek bu sayfaya gecisi saglayabiliriz
         */

        // 3- ilk urunun resmini tiklayarak farkli bir tab olarak acin
        WebElement ilkUrunResmi = driver.findElement(By.xpath("//div[@class='a-section aok-relative s-image-square-aspect']"));
        driver.switchTo().newWindow(WindowType.TAB);
        /*
        Bu komutu kullandigimizde driver otomatik olarak olusturulan
         new tab'a gecer
        yeni tab'da gorevi gerceklestirmke icin
        adimlari bastan almamiz gerekir
         */

        System.out.println("driver'in URL'i : " + driver.getCurrentUrl());
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        driver.findElement(By.xpath("//div[@class='a-section aok-relative s-image-square-aspect']")).click();


        // 4- yeni tab'da acilan urunun title'ini yazdirin
        WebElement urunTitleElementi = driver.findElement(By.xpath("//span[@id='productTitle']"));
        System.out.println(urunTitleElementi.getText());
        System.out.println(driver.getTitle());

        // ilk sayfaya gecip Url'i yazdiralim
        driver.switchTo().window(ilkSayfaHandleDegeri);
        System.out.println(driver.getTitle());




    }
}
