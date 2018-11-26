package Jenkins.SimpleTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertTrue;

public class SimpleTest {

    private WebDriver driver;
    @Before
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
    }
    @After
    public void TearDown(){
        driver.quit();
    }

    @Test
    public void getTitle() throws InterruptedException{
        driver.navigate().to("https://www.pravda.com.ua/");
        Thread.sleep(2000);
        String title = driver.getTitle();
        assertTrue(title.contains("Українська правда"));
    }
}
