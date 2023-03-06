package AlertOnPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Set;

    public class TestingAlerts {
        WebDriver driver = new ChromeDriver();
        private String windowHandle;
        private Set<String> allWindowHandles;

        @Test
        public void alert() {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://demoqa.com/browser-windows");
            driver.findElement(By.xpath("//button[@id='tabButton']")).click();
            windowHandle = driver.getWindowHandle();

            switchToSecondWindow();

            Assert.assertEquals(driver.findElement(By.xpath("//*[@id='sampleHeading']")).getText(),
                    "This is a sample page");
            close(allWindowHandles);
        }

        public void close(Set<String> windowHandle) {
            for (String handle : allWindowHandles) {
                driver.switchTo().window(handle);
                driver.close();
            }
        }
        public void switchToSecondWindow() {
            allWindowHandles = driver.getWindowHandles();
            for (String handle : allWindowHandles) {
                if (!handle.equals(windowHandle)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }
        }

    }