package Jenkins.SimpleTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class SimpleTest {

    private WebDriver driver;
    @Before
    public void SetUp(){
        System.setProperty("webdriver.edge.driver", "msedgedriver");
        driver = new ChromeDriver();
    }
    @After
    public void TearDown(){
        driver.quit();
    }

    @Test
    public void getTitle() throws InterruptedException {
        driver.get("https://www.pravda.com.ua/");
        Thread.sleep(2000);
        String title = driver.getTitle();
        assertTrue(title.contains("Українська правда"));

    }
    @Test
    public void loginForum() throws InterruptedException {
        driver.get("https://www.pravda.com.ua");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("body > nav.container_top_nav > ul > li:nth-child(5) > a")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#user-info-nl > a:nth-child(1)")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#frmLogin > div.generic.login_mobile > table > tbody > tr > td:nth-child(1) > input[type=text]:nth-child(3)")).sendKeys("Lt. Colombo");
        driver.findElement(By.cssSelector("#frmLogin > div.generic.login_mobile > table > tbody > tr > td:nth-child(1) > input[type=password]:nth-child(7)")).sendKeys("pena");
        driver.findElement(By.cssSelector("#frmLogin > div.generic.login_mobile > table > tbody > tr > td:nth-child(1) > input[type=submit]:nth-child(11)")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#main > tbody > tr:nth-child(2) > td.td_name > h3 > a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"phorum\"]/div[5]/div[2]/a[1]/span[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"body\"]")).sendKeys("хочу что то написать....");
        Thread.sleep(6000);
        driver.findElement(By.xpath("//*[@id=\"body\"]")).sendKeys("я передумал...");
        Thread.sleep(6000);
        driver.findElement(By.xpath("//*[@id=\"breadcrumb\"]/a[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"user-info\"]/span/small/a")).click();
        Thread.sleep(2000);
        driver.get("https://www.facebook.com");
        Thread.sleep(6000);
    }
}
