package day10_actionsClass_Faker_FileTestleri;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
public class C07_FileUploadTesti extends TestBase {
    @Test
    public void test01() throws InterruptedException {
     //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
     //chooseFile butonunu kullanarak
     // projemizdeki deneme.txt dosyasini secelim.

        WebElement chooseFileButonu= driver.findElement(By.xpath("//input[@id='file-upload']"));

        String herkesteFarkliOlan=System.getProperty("user.dir");
        String herkesteAyniOlan="/src/test/java/day10_actionsClass_Faker_FileTestleri/deneme.txt";
        String dosyaYolu=herkesteFarkliOlan+herkesteAyniOlan;

        chooseFileButonu.sendKeys(dosyaYolu);

     //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

     //"File Uploaded!" textinin goruntulendigini test edelim.
        WebElement fileUploadedElementi= driver.findElement(By.tagName("h3"));

        Assert.assertTrue(fileUploadedElementi.isDisplayed());
        Thread.sleep(3000);
    }
}
