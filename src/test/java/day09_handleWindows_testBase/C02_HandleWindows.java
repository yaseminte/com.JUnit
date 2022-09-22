package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_HandleWindows {
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
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
        // 1- amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");
        String ilkSayfaWindowHandle = driver.getWindowHandle();

        // 2- url'in amazon icerdigini test edelim
        String istenenKelime = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(istenenKelime));

        // 3- yeni bir pencere acip bestbuy anasayfaya gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String ikinciSayfaWindowHandle = driver.getWindowHandle();

        // 4- title'in Best buy icerdigini test edelim
        String actualTitle = driver.getTitle();
        String arananKelime = "Best Buy";
        Assert.assertTrue(actualTitle.contains(arananKelime));

        // 5- ilk sayfaya donup sayfada java aratalim
        driver.switchTo().window(ilkSayfaWindowHandle);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java" + Keys.ENTER);

        // 6- arama sonuclarinin Java icerdigini test edelim
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucYazisiStr = sonucYaziElementi.getText();
        String aradigimizKelime = "Java";
        Assert.assertTrue(sonucYazisiStr.contains(aradigimizKelime));

        // 7- yeniden bestbuy'in acik oldugu sayfaya gidelim
        driver.switchTo().window(ikinciSayfaWindowHandle);

        // 8- logonun gordugunu test edelim
        WebElement logoElementi = driver.findElement(By.xpath("//img[@class='logo']"));
        Assert.assertTrue(logoElementi.isDisplayed());

        Thread.sleep(5000);

    }
}
