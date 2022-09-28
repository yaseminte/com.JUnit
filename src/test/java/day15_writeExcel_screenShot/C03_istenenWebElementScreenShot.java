package day15_writeExcel_screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_istenenWebElementScreenShot extends TestBase {

    @Test
    public void webElementScreenShot() throws IOException {
        // amazona gidip Nutella aratalim
        // ve sonuc sayisinin oldugu web elementin fotografini cekelim

        driver.get("https://www.amazon.com");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        WebElement sonucYazisiElementi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        File sonucYazisiElementSS = new File("target/ekranGoruntuleri/sonucYazisiSS.jpeg");
        File temp = sonucYazisiElementi.getScreenshotAs(OutputType.FILE);
        // 27.satir temp dosyasini asil dosyaya kopyaliyor
        FileUtils.copyFile(temp,sonucYazisiElementSS);


    }
}
