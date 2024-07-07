import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.ArrayList;

public class HepsiBuradaTest {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Faker faker = new Faker();
        String fakeEmail = faker.internet().emailAddress();

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


        WebElement comments = driver.findElement(By.xpath("//div[@id=\"comments-container\"]"));
        comments.click();
        Thread.sleep(1000);

        WebElement addToCart = driver.findElement(By.xpath("//span[normalize-space()=\"Sepete ekle\"]"));
        addToCart.click();
        Thread.sleep(1000);

        WebElement shoppingCart = driver.findElement(By.xpath("//a[normalize-space()=\"Sepete git\"]"));
        shoppingCart.click();
        Thread.sleep(2000);

        WebElement continueShopping = driver.findElement(By.cssSelector("#continue_step_btn"));
        continueShopping.click();
        Thread.sleep(2000);

        WebElement continueWithoutRegister = driver.findElement(By.cssSelector("._1mCdWR7afWBEU4zMRu13zb"));
        continueWithoutRegister.click();
        Thread.sleep(2000);

        WebElement email = driver.findElement(By.cssSelector("#txtEmail"));
        email.sendKeys(fakeEmail);
        Thread.sleep(2000);

        WebElement continueWithEmail = driver.findElement(By.cssSelector("#btnWithoutMemberShip"));
        continueWithEmail.click();
        Thread.sleep(4000);

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile,new File("CheckoutPage.png"));

    }
}
