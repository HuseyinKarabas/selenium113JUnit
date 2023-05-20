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
import java.time.Duration;
public class P08 {
static WebDriver driver;
    @Before
    public void setUp(){
        // ilgili kurulumlari tamamlayalim
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void paraKarsilastir() throws InterruptedException {

        //Kullanici https://www.google.com adresine gider
        driver.get("https://www.google.com");
        Thread.sleep(2000);

        //Çıkıyorsa Kullanici cookies i kabul eder
        driver.findElement(By.xpath("//button[@id='L2AGLb']")).click();
        Thread.sleep(2000);

        //Arama Kutusuna karşilastirma yapmak istedigi para birimlerini girer
        WebElement aramaKutusu= driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        aramaKutusu.sendKeys("USD TO Euro"+ Keys.ENTER);
        Thread.sleep(2000);

        //Para birimlerinin karsilastirmasini alin
        WebElement resultElement=driver.findElement(By.xpath("//span[@class='DFlfde SwHCTb']"));
        String result= resultElement.getText().replaceAll(",",".");
        System.out.println(result);
        double resultDouble=Double.parseDouble(result);

        //Karsilastirilacak olan para biriminin 25 den kUCUk oldygu test edilir
        Assert.assertTrue(resultDouble<1.5);
        Thread.sleep(2000);
        if(resultDouble<25){
            System.out.println("Şükür hala 25'in altında");
        }else{
            System.out.println("Dolar aldi başini gidiyor");
        }
    }
}
