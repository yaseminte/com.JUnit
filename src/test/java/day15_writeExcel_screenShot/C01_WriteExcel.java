package day15_writeExcel_screenShot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C01_WriteExcel {

      /*
        Excel dosyasi acikken dosyaya ekleme yaparsak excel bozulabilir
         */
    @Test
    public void writeExcelTest() throws IOException {

        // 1) Yeni bir class olusturalim WriteExcel
        // 2) Yeni bir test method olusturalim writeExcelTest()
        // 3) Adimlari takip ederek 1.satira kadar gidelim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        // 4) 4.hucreye yeni bir cell olusturalim
        // 5) Olusturdugumuz hucreye "Nufus" yazdiralim
        workbook
                .getSheet("Sayfa1")
                .getRow(0)
                .createCell(4)
                .setCellValue("Nufus");

        // 6) 2.satir nufus kolonuna 1500000 yazdiralim
        workbook
                .getSheet("Sayfa1")
                .getRow(1)
                .createCell(4)
                .setCellValue("1500000");
        // 7) 10.satir nufus kolonuna 250000 yazdiralim
        workbook
                .getSheet("Sayfa1")
                .getRow(9)
                .createCell(4)
                .setCellValue(250000);

        // 8) 15.satir nufus kolonuna 54000 yazdiralim
        workbook
                .getSheet("Sayfa1")
                .getRow(14)
                .createCell(4)
                .setCellValue(54000);
        // 9) Dosyayi kaydedelim
        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        workbook.write(fos);

        // 10)Dosyayi kapatalim
        workbook.close();
        fis.close();
        fos.close();


    }
}
