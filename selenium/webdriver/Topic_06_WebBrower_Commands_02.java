package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_06_WebBrower_Commands_02 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    @Test
    public void TC_01_Page_Url() {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.cssSelector(".footer a[title='My Account']")).click();
        sleepInseconds(3);

        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        sleepInseconds(3);

        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");
        //
    }

    @Test
    public void Login_02_Invalid_Email() {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.cssSelector(".footer a[title='My Account']")).click();
        sleepInseconds(3);

        Assert.assertEquals(driver.getTitle(), "Customer Login");

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        sleepInseconds(3);

        Assert.assertEquals(driver.getTitle(), "Create New Customer Account");

    }

    @Test
    public void Login_03_Invalid_Password() {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.cssSelector(".footer a[title='My Account']")).click();
        sleepInseconds(3);

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        sleepInseconds(3);

        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");

        driver.navigate().back();

        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");

        driver.navigate().forward();

        Assert.assertEquals(driver.getTitle(), "Create New Customer Account");

    }

    @Test
    public void Login_04_Incorrect_Email_Or_Password() {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.cssSelector(".footer a[title='My Account']")).click();
        sleepInseconds(3);

        Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        sleepInseconds(3);

        Assert.assertTrue(driver.getPageSource().contains("Create an Account"));

    }
    @Test
    public void Login_05_Success() {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.cssSelector(".footer a[title='My Account']")).click();
        sleepInseconds(3);

        Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        sleepInseconds(3);

        Assert.assertTrue(driver.getPageSource().contains("Create an Account"));

    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }

    public void sleepInseconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
