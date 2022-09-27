package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {

    @Test
    public void webTable() {

        // ● login(login() metodun oluşturun ve oturum acin
        girisYap();


        // ● table(table() metodu oluşturun
        //      ○ Tüm table body’sinin boyutunu(s utun sayisi ) bulun. /tbody
        List<WebElement> sutunBasliklariList = driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("Sutun sayisi " + sutunBasliklariList.size());
        //      ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        // Tum body'i bir String olarak yazdirmak isterseniz
        // body webElement'ini locate edip, getText() methodu ile yazdirabilirsiniz
        WebElement tumBody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());

        // ● printRows(printRows() metodu oluşturun //tr
        //      ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirlarListesi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("satir sayisi : " + satirlarListesi.size());
        //      ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement each:satirlarListesi
             ) {
            System.out.println(each.getText());
        }
        //      ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        List<WebElement> cellList = driver.findElements(By.xpath("tbody//tr[4]//td"));
        for (WebElement each:cellList
             ) {
            System.out.println(each.getText());
        }
        //      ○ Email basligindakitum elementleri(sutun) konsolda yazdırın.
        // once email basliginin kacinci satirda oldugunu bulalim
        List<WebElement> basliklarListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));
        int emailSutunNo = 0;
        for (int i = 0; i < basliklarListesi.size(); i++) {
            if (basliklarListesi.get(i).getText().equals("Email")){
                emailSutunNo = i;
            }
        }
        List<WebElement> emailSutunListesi =
                driver.findElements(By.xpath("//tbody//td["+(emailSutunNo+1)+"]"));
        //                                                   //tbody//td[3]
        for (WebElement each:emailSutunListesi
             ) {
            System.out.println(each.getText());
        }

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
