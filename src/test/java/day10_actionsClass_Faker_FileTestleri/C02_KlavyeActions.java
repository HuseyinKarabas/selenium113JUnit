package day10_actionsClass_Faker_FileTestleri;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_KlavyeActions extends TestBase {

    @Test
    public void test01() throws InterruptedException {
    //1- https://www.facebook.com adresine gidelim ve cookies'i kabul edelim
        driver.get("https://www.facebook.com ");
        driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _al65 _4jy3 _4jy1 selected _51sy']")).click();

    //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//a[@* = '_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

    //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        Actions actions=new Actions(driver);
        WebElement isimKutusu= driver.findElement(By.xpath("//*[@name='firstname']"));
        Thread.sleep(3000);

        actions.click(isimKutusu)
                .sendKeys("Ali")
                .sendKeys(Keys.TAB)
                .sendKeys("Karahan")
                .sendKeys(Keys.TAB)
                .sendKeys("a1234321@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("a1234321@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("Malatya44")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("13")
                .sendKeys(Keys.TAB)
                .sendKeys("Mar")
                .sendKeys(Keys.TAB)
                .sendKeys("1987")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

    //4- Kaydol tusuna basalim

        Thread.sleep(3000);

    }
}

