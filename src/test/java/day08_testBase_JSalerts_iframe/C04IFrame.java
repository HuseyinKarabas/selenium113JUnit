package day08_testBase_JSalerts_iframe;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
public class C04IFrame extends TestBase {
    @Test
    public void test01() throws InterruptedException {
    // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        Thread.sleep(3000);
    // 2 ) Bir metod olusturun: iframeTest
    //    - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
        WebElement iFrameYaziElementi= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(iFrameYaziElementi.isDisplayed());
        System.out.println(iFrameYaziElementi.getText());
        Thread.sleep(3000);
        //    - Text Box’a “Merhaba Dunya!” yazin.
        WebElement frameElementi= driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(frameElementi);
        WebElement textBoxElementi=driver.findElement(By.xpath("//body[@class='mce-content-body ']"));
        Thread.sleep(3000);
        textBoxElementi.clear();
        textBoxElementi.sendKeys("Merhaba Dunya!");
        Thread.sleep(3000);
    //    - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.
        /*
        iframe'e gecis yapilinca driver'i oradan cikis yaptirana kadar driver iframe'in icinde kalir.

        driver.switchTo().parentFrame() : ic ice birden fazla iframe varsa, bir uste cikar.
        driver.switchTo().defaultContent() : direk anasayfaya cikar.
         */
        driver.switchTo().defaultContent();
        WebElement elementalSeleniumLinki= driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elementalSeleniumLinki.isDisplayed());
        System.out.println(elementalSeleniumLinki.getText());
        Thread.sleep(3000);
    }

}
