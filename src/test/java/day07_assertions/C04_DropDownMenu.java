package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropDownMenu {
    /*
    amazona gidip
    dropdown'dan books secenegini secip
    Java aratalim
    ve arama sonuclarinin java icerdigini test edin
     */

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");

        // dropdown'dan bir option secmek icin 3 adim vardir
        // 1- dropdown'u locate edelim
        WebElement dropdownMenu = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        // 2- bir select objesi olusturup
        //    parametre olarak bir onceki adimda locate ettigimiz ddm'yi girelim

        Select select = new Select(dropdownMenu);

        // 3- dropdown'da varolan optionlardan istedigimiz bir taneyi secelim

           select.selectByVisibleText("Books");
        // select.selectByIndex(5);
        // select.selectByValue("search-alias=aps");

        // arama kutusuna Java yazdiralim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java" + Keys.ENTER);

        WebElement sonucYazisiElementi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String sonucYazisiStr = sonucYazisiElementi.getText();
        String arananKelime = "Java";

        Assert.assertTrue(sonucYazisiStr.contains(arananKelime));

        Thread.sleep(5000);


    }


}
