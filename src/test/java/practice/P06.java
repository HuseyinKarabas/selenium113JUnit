package practice;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class P06 {
    static WebDriver driver;
    WebElement searchbox;
    //     Exercise-1:
    //BeforeClass ile driver'i oluşturun ve class icinde static yapin
    //Maximize edin ve 10 sn bekletin
    //http://www.qooqle.com adresine gidin
    //1- arama kutusuna "12 Angry Men" yaz ip, cikan sonuc şayisini yazdinin
    //2-arama kutusuna "Vizontele" yaz ip, cikan sonuc şayisini yazdirin
    //3-arama kutusuna "Saving Private Ryan" yaz4p, cikan sonuc şayisini yazdirin
    //AfterClass ile kapatin.

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }
    @Before
    public void before() throws InterruptedException {
        driver.get("http://www.google.com");
        driver.findElement(By.xpath("//div[text()='Tümünü reddet']")).click(); // Cookie den kurtulduk

        searchbox=driver.findElement(By.xpath("//*[@title='Ara']"));
        Thread.sleep(2000);
    }
    @Test
    public void test01() throws InterruptedException {

        searchbox.sendKeys("12 Angry Men"+ Keys.ENTER);
        WebElement sonucSayisi= driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonucSayisi.getText());
        Thread.sleep(2000);
    }
    @Test
    public void test02() throws InterruptedException {
        searchbox.sendKeys("Vizontele"+ Keys.ENTER);
        Thread.sleep(2000);
    }
    @Test
    public void test03() throws InterruptedException {
        searchbox.sendKeys("Saving Private Ryan"+ Keys.ENTER);
        Thread.sleep(2000);
    }
    @After
    public void after(){
        WebElement sonucSayisi= driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonucSayisi.getText());
    }


    @AfterClass
    public static void tearDown(){
        driver.close();
    }

}
