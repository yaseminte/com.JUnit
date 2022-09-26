package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C02_Actions extends TestBase {


    @Test
    public void test01() throws InterruptedException {
        // amazon anasayfaya gidip
        // account menusunden liste olustutun menusune tiklayalim

        driver.get("https://www.amazon.com");
        Actions actions = new Actions(driver);
        WebElement hesapLinki = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
        actions.moveToElement(hesapLinki).perform();

        driver.findElement(By.xpath("(//span[@class='nav-text'])[1]")).click();

        Thread.sleep(5000);

    }
}
