package TestingWidgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SliderTest {

    @Test
    public static void sliderTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/slider");

        WebElement slider = driver.findElement(By.xpath("//*[@id='sliderContainer']/div[1]/span/input"));
        WebElement sliderValue = driver.findElement(By.xpath("//*[@id='sliderValue']"));
        Assert.assertEquals(sliderValue.getAttribute("Value"),"25");

        Actions action = new Actions(driver);
        action.dragAndDrop()


    }
}
