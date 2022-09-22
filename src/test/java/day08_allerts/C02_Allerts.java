package day08_allerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Allerts {

    // Bir class olusturun:Alerts


    // ●Bir metod olusturun:sendKeysAlert
    // ○3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OKbutonuna
    // tıklayın ve result mesajında isminizin görüntülendiğinidoğrulayın

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // ●https://the-internet.herokuapp.com/javascript_alerts adresinegidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void acceptAlert() {

        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        String expectedResultYazisi = "You successfully clicked an alert";
        WebElement sonucYazisiElementi = driver.findElement(By.xpath("//*[text()='You successfully clicked an alert']"));
        String actualResultYazisi = sonucYazisiElementi.getText();

        Assert.assertEquals(expectedResultYazisi, actualResultYazisi);

    }

    @Test
    public void dismissAlert() {
// ●Bir metod olusturun:dismissAlert
        // ○2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        // “successfuly” icermedigini testedin.

        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        String istenmeyenKelime = "successfuly";
        WebElement sonucYazisiElementi = driver.findElement(By.xpath("//p[@id='result']"));
        String actualSonucYazisi = sonucYazisiElementi.getText();

        Assert.assertFalse(actualSonucYazisi.contains(istenmeyenKelime));


    }

    @Test
    public void sendKeysAlert() {
        // ●Bir metod olusturun:acceptAlert
        //          ○1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        //          “You successfully clicked an alert” oldugunu testedin.

        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("Emre Ensaroglu");
        driver.switchTo().alert().accept();

        WebElement sonucYazisiElementi = driver.findElement(By.xpath("//p[@id='result']"));
        String sonucYazisiStr = sonucYazisiElementi.getText();
        String girilenISim = "Emre Ensaroglu";

        Assert.assertTrue(sonucYazisiStr.contains(girilenISim));

    }
}
