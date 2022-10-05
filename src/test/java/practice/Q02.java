package practice;

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

import java.time.Duration;

public class Q02 {


    WebDriver driver;

    @Before
    public void setUp() {
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
    public void test() {
        // 1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        // 2.Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        // 3.Login alanina “username”yazdirin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");

        // 4.Password alanine “password”yazdirin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");

        // 5.Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.navigate().back();

        // 6.Online-Banking'e tiklayin
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();

        // 7.Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

        // 8.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//input[@id='sp_amount']")).sendKeys("500" + Keys.ENTER);

        // 9.tarih kismina “2020-09-10”yazdirin
        driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2020-09-10" + Keys.ENTER);

        // 10.Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();

        // 11.“The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement sonucYazisi = driver.findElement(By.xpath("//span[text()='The payment was successfully submitted.']"));
        Assert.assertTrue(sonucYazisi.isDisplayed());

    }

}
