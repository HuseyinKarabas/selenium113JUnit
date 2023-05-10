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
import org.openqa.selenium.support.ui.Select;

import java.security.Key;
import java.time.Duration;

public class P02 {

    //1. http://zero.webappsecurity.com/ Adresine gidin
    //2. Sign in butonuna basin
    //3. Login kutusuna “username” yazin
    //4. Password kutusuna “password.” yazin
    //5. Sign in tusuna basin
    //6. Pay Bills sayfasina gidin
    //7. “Purchase Foreign Currency” tusuna basin
    //8. “Currency” drop down menusunden Eurozone’u secin
    //9. “amount” kutusuna bir sayi girin
    //10. “US Dollars” in secilmedigini test edin
    //11. “Selected currency” butonunu secin
    //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
    //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
    //kontrol edin
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://zero.webappsecurity.com/");
    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
        //2. Sign in butonuna basin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        //3. Login kutusuna “username” yazin
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("username");
        Thread.sleep(2000);
        //4. Password kutusuna “password.” yazin
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("password");
        //5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();

        //6. Pay Bills sayfasina gidin
        driver.findElement(By.id("pay_bills_link")).click();
        Thread.sleep(2000);

        //8. “Currency” drop down menusunden Eurozone’u secin
        driver.findElement(By.xpath("//a[normalize-space()='Purchase Foreign Currency']")).click();
        Thread.sleep(2000);

       WebElement dropDown=driver.findElement(By.xpath("//select[@id='pc_currency']"));
       Select select=new Select(dropDown);
       select.selectByVisibleText("Eurozone (euro)");
       Thread.sleep(2000);

        //9. “amount” kutusuna bir sayi girin
        driver.findElement(By.id("pc_amount")).sendKeys("2500");
        Thread.sleep(2000);

        //10. “US Dollars” in secilmedigini test edin
        WebElement dolarButton=driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        Assert.assertFalse(dolarButton.isSelected());
        Thread.sleep(2000);

        //11. “Selected currency” butonunu secin
        WebElement selectedCurrency=driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        selectedCurrency.click();
        Thread.sleep(2000);

        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.xpath("//input[@id='pc_calculate_costs']")).click();
        driver.findElement(By.xpath("(//input[@class='btn btn-primary'])[2]")).click();
        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigin kontrol edin
        WebElement foreingKey=driver.findElement(By.xpath("//*[@id='alert_content']"));
        Assert.assertTrue(foreingKey.isDisplayed());
        Thread.sleep(2000);
    }
}
