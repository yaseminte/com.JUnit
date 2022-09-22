package day08_allerts;

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

public class C04_Iframe {
    // ● Bir class olusturun:IframeTest

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
    public void test01() throws InterruptedException {
        // ● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        // ● Bir metod olusturun:iframeTest
        //      ○“An IFrame containing….” textinin erisilebilir oldugunu test edin
        //      ve konsolda yazdirin.
        WebElement baslikElementi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslikElementi.isEnabled());
        System.out.println(baslikElementi.getText());

        //      ○Text Box’a “Merhaba Dunya!”yazin.
        // TexyBox'i dogru olarak locate etmemize ragmen driver bulamadi
        // Bunun uzerine HTML kodlarini inceleyince
        // textbox'in aslinda bir IFrame icerisinde oldugunu gorduk
        // bu durumda once IFrame'i locate edip
        // switchTo() ile IFrame'e gecmeliyiz

        WebElement iframeElementi = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframeElementi);

        WebElement textKutusu = driver.findElement(By.xpath("//body[@id='tinymce']"));
        textKutusu.clear();
        textKutusu.sendKeys("Merhaba Dunya");

        //      ○TextBox’in altinda bulunan “Elemental Selenium”
        //      linkini textinin gorunur oldugunu dogrulayin ve konsoldayazdirin.

        // link yazi elementini dogru locate etmemize ragmen yazdirmadi
        // cunku yukarida iframe'e gecis yapmistik
        // once oradan cikmamiz lazim

        driver.switchTo().defaultContent();
        WebElement linkYaziElementi = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(linkYaziElementi.isDisplayed());
        System.out.println(linkYaziElementi.getText());

        Thread.sleep(5000);

    }


}
