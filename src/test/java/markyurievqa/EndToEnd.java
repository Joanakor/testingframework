package markyurievqa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class EndToEnd {
    @Test
    public void oneBigTest() throws InterruptedException {
        String email = "mark2222@gmail.com";
        String password = "Minecraft158!";

        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


        driver.get("https://rahulshettyacademy.com/client");

        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.id("userPassword")).sendKeys(password);
        driver.findElement(By.id("login")).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".card-body b")));

        List<WebElement> products = driver.findElements(By.cssSelector(".card"));

        WebElement product = products.stream().filter(x -> x.findElement(By.cssSelector(".card-body b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);

        js.executeScript("arguments[0].scrollIntoView();", product.findElement(By.cssSelector("button:nth-of-type(2)")));

        product.findElement(By.cssSelector("button:nth-of-type(2)")).click();
    }

}
