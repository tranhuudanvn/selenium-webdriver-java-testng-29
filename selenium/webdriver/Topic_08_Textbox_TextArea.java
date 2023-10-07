package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_08_Textbox_TextArea {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterClass
    public void afterClass() {
        ///driver.quit();
    }

    @Test
    public void Login_01_Empty_Email_And_Password() {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.cssSelector(".footer a[title='My Account']")).click();
        sleepInseconds(2);

        driver.findElement(By.id("send2")).click();

        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email")).getText(), "This is a required field.");
        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(), "This is a required field.");
    }

    @Test
    public void Login_02_Invalid_Email() {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.cssSelector(".footer a[title='My Account']")).click();
        sleepInseconds(2);

        driver.findElement(By.id("email")).sendKeys("123@345.567");
        driver.findElement(By.id("pass")).sendKeys("123456");

        driver.findElement(By.id("send2")).click();

        Assert.assertEquals(driver.findElement(By.id("advice-validate-email-email")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");
    }

    @Test
    public void Login_03_Invalid_Password() {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.cssSelector(".footer a[title='My Account']")).click();
        sleepInseconds(2);

        driver.findElement(By.id("email")).sendKeys("automationfc@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("123");

        driver.findElement(By.id("send2")).click();

        Assert.assertEquals(driver.findElement(By.id("advice-validate-password-pass")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");

    }

    @Test
    public void Login_04_Incorrect_Email_Or_Password() {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.cssSelector(".footer a[title='My Account']")).click();
        sleepInseconds(2);

        driver.findElement(By.id("email")).sendKeys("automationfc@gmail.net");
        driver.findElement(By.id("pass")).sendKeys("123456789");

        driver.findElement(By.id("send2")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector(".error-msg span")).getText(), "Invalid login or password.");
    }
    @Test
    public void Login_05_Success() {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.cssSelector(".footer a[title='My Account']")).click();
        sleepInseconds(2);

        //Register
        driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
        sleepInseconds(2);

        String firstName = "dan", lastName = "tran", fullName = firstName + " " + lastName, email = getEmailAddress(), passWord = "123456";
        driver.findElement(By.id("firstname")).sendKeys(firstName);
        driver.findElement(By.id("lastname")).sendKeys(lastName);
        driver.findElement(By.id("email_address")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(passWord);
        driver.findElement(By.id("confirmation")).sendKeys(passWord);
        driver.findElement(By.cssSelector("button[title='Register']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector(".success-msg span")).getText(), "Thank you for registering with Main Website Store.");

        String textContactInfo = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
        Assert.assertTrue(textContactInfo.contains(lastName));
        Assert.assertTrue(textContactInfo.contains(email));

        //Log Out
        driver.findElement(By.cssSelector(".skip-account span[class='label']")).click();
        driver.findElement(By.cssSelector("a[title='Log Out']")).click();

        //Log In
        driver.findElement(By.cssSelector(".skip-account span[class='label']")).click();
        driver.findElement(By.cssSelector("a[title='Log In']")).click();

        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("pass")).sendKeys(passWord);
        driver.findElement(By.id("send2")).click();

        Assert.assertEquals(driver.findElement(By.className("hello")).getText(), "Hello, " + fullName + "!");

        //Verify Account Information
        driver.findElement(By.xpath("//a[text()='Account Information']")).click();
        Assert.assertEquals(driver.findElement(By.id("firstname")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.id("lastname")).getAttribute("value"), lastName);
        Assert.assertEquals(driver.findElement(By.id("email")).getAttribute("value"), email);
    }

    public void sleepInseconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getEmailAddress() {
        return "huudan" + new Random().nextInt(99999) + "@gmail.com";
    }

}
