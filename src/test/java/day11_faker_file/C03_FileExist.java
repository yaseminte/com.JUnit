package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {
    @Test
    public void test01() {
        System.out.println(System.getProperty("user.dir"));
        // bana icinde oldugum projenin dosya yolunu(path) verir

        System.out.println(System.getProperty("user.home"));
        // C:\Users\yturk  yani benim bilgisayarimin bana ozel kismini verdi

        // C:\Users\yturk\Downloads
        // C:\Users\yturk\OneDrive\Masaüstü

        // homePath + "/Downloads"

        // Masaustumuzdeki text dosyasinin varligini test edelim
        // "C:\Users\yturk\OneDrive\Masaüstü\text.txt"

        String dosyaYolu = System.getProperty("user.home") + "\\Desktop\\text.txt";
        System.out.println(dosyaYolu); // C:\Users\yturk\Desktop\text.txt

        /*
        Bilgisayarimizdaki bir dosyanin varligini test etmek icin
        once o dosyaya ulasmamiz gerekir
        Java'da dosyaya erisim icin dosya yoluna (path) ihtiyac vardir
        HEr bilgisayarin kullanici adi farkli olacagindan
        masaustu dosya yolu da birbirinden farkli olacaktir.
        Testlerimizin tum bilgisayarlarda calismasi icin  dosya yolunu DINAMIK yapmak zorundayiz.

        Bunun icin
        her bilgisayarin birbirinden farkli olan yolunu bulmak icin
        */
        String farkliKisim = System.getProperty("user.home");
        String onedrive = "\\OneDrive\\";

        // herkesin bilgisayarinda ortak olan kisim ise
        String ortakKisim ="\\Downloads\\file.txt";
        // mac icin "/Desktop/text"

        String masaustuDosyaYolu = farkliKisim + ortakKisim ;

        System.out.println(Files.exists(Paths.get(masaustuDosyaYolu)));

        Assert.assertTrue(Files.exists(Paths.get(masaustuDosyaYolu)));




    }
}
