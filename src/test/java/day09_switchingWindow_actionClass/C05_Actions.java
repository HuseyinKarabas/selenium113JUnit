package day09_switchingWindow_actionClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;
public class C05_Actions extends TestBase {
    @Test
    public void test01() throws InterruptedException {
  //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        Thread.sleep(3000);

  //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        Actions actions=new Actions(driver);
        WebElement accountElementi=driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
        actions.moveToElement(accountElementi).perform();
        Thread.sleep(3000);

   //3- “Create a list” butonuna basin
        WebElement createListElementi=driver.findElement(By.xpath("//*[text()='Create a List']"));
        createListElementi.click();
        Thread.sleep(3000);

  //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        WebElement yourListElementi=driver.findElement(By.xpath("//div[@role='heading']"));

        String expectedYazi="Your Lists";
        String actualYazi= yourListElementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);
        Thread.sleep(3000);
    }
}
