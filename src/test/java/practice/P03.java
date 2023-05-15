package practice;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class P03 {
    WebDriver driver;
    public void mahserin4Atlisi(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test03(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement anasayfa=driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        if(anasayfa.isDisplayed()){
            System.out.println("Gozukuyor, PASSED");
        }else{
            System.out.println("Gozukmuyor,FAILED");
        }
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        //5. Verify 'Login to your account' is visible
        //6. Enter correct email address and password
        driver.findElement(By.xpath("//input[@type='email'])[1]")).click();
        driver.findElement(By.xpath("//*[@type='password']")).click();

        WebElement myAccount=driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/b"));
        if(myAccount.isDisplayed()){
            System.out.println("Test has PASSED");
        }else{
            System.out.println("Test has FAILED");
        }
        //7. Click 'login' button
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        //8. Verify that 'Logged in as username' is visible
        //9. Click 'Logout' button
        driver.findElement(By.xpath("(//a[@style='color:brown;'])[1]")).click();
        //10. Verify that user is navigated to login page
    }
}
