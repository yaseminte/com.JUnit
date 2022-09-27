package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_WebTables extends TestBase {

    @Test
    public void dinamikYazici() {

        // onceki clas'daki adrese gidip
        // girisYap method'unu kullanarak sayfaya giris yapin
        // input olarak verilen satir sayisi ve sutun sayisina sahip
        // cell'deki text'i yazdirin

        int satir = 3;
        int sutun = 3;
        girisYap();


        WebElement arananCell = driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));

        System.out.println(arananCell.getText());


    }
    public void girisYap() {
        driver.get("https://hotelmycamp.com");
        driver.findElement(By.linkText("Log in")).click();
        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.id("UserName"));
        actions.click(userName).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();

    }
}
