import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.sql.Driver;
import java.time.Duration;
import java.util.ArrayList;

public class HepsiBuradaTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.hepsiburada.com/");

        WebElement acceptCookies = driver.findElement(By.xpath("//button[@id=\"onetrust-accept-btn-handler\"]"));
        acceptCookies.click();

        Thread.sleep(2000);

        WebElement electronic = driver.findElement(By.xpath("//span[contains(text(),\"Elektronik\")]"));
        electronic.click();
        driver.findElement(By.xpath("//a[contains(text(),'Telefon & Telefon Aksesuarları')]")).click();


        WebElement iphone13 = driver.findElement(By.xpath("//h3[normalize-space()=\"iPhone 13 128 GB\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(iphone13).click().build().perform();

        ArrayList <String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(1000);
        WebElement color = driver.findElement(By.cssSelector("label[for=\"Renk4\"]"));
        color.click();
        Thread.sleep(2000);

        WebElement offeringPrice = driver.findElement(By.cssSelector("#offering-price"));
        String price = offeringPrice.getText();
        System.out.println("Price: " + price);
        Thread.sleep(1000);

        WebElement comments = driver.findElement(By.xpath("//div[@id=\"comments-container\"]"));
        comments.click();
        Thread.sleep(1000);

        WebElement allRate = driver.findElement(By.cssSelector(".hermes-AverageRateBox-module-g3di4HmmxfHjT7Q81WvH"));
        String rate = allRate.getText();
        System.out.println("Rate : " +rate);



    }
}
