package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q01 {

    WebDriver driver;


    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test(){
        // 1-https://www.amazon.com/ sayfasinagidelim
        driver.get("https://www.amazon.com/");
        // 2-arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        // 3-“Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones" + Keys.ENTER);
        // 4-Bulunan sonuc sayisini yazdiralim
        WebElement sonucYazisiElementi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonucYazisiElementi.getText());
        // 5-Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
        // 6-Sayfadaki tum basliklari yazdiralim
        System.out.println(driver.getTitle());

    }

}
