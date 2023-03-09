package TestingForm;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;


public class FormTest {
    @Test
    public static void myFirstTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().setSize(new Dimension(390, 844));

        WebElement firstname = driver.findElement(By.xpath("//*[@id='firstName']"));
        firstname.sendKeys("A");
        WebElement lastname = driver.findElement(By.xpath("//*[@id='lastName']"));
        lastname.sendKeys("B");
        WebElement mail = driver.findElement(By.xpath("//*[@id='userEmail']"));
        mail.sendKeys("bla-bla@example.com");
        WebElement gender = driver.findElement(By.xpath("//*[@id='genterWrapper']/div[2]/div[1]/label"));
        gender.click();
        WebElement phone = driver.findElement(By.xpath("//*[@id='userNumber']"));
        phone.sendKeys("8063222222");
        WebElement adress = driver.findElement(By.xpath("//*[@id='currentAddress']"));
        adress.sendKeys("test");

        WebElement submit = driver.findElement(By.xpath("//button[normalize-space(.)='Submit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", submit);
        submit.click();

        Assert.assertEquals(driver.findElement(By.xpath("//tr[1]/td[2]")).getText(), "A B");
        Assert.assertEquals(driver.findElement(By.xpath("//tr[2]/td[2]")).getText(), "bla-bla@example.com");
        Assert.assertEquals(driver.findElement(By.xpath("//tr[3]/td[2]")).getText(), "Male");
        Assert.assertEquals(driver.findElement(By.xpath("//tr[4]/td[2]")).getText(), "8063222222");
        Assert.assertEquals(driver.findElement(By.xpath("//tr[9]/td[2]")).getText(), "test");

        driver.quit();

    }

}
