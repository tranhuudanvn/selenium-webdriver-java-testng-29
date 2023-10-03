package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_07_WebElement_Commands_02 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    @Test
    public void TC_01_Displayed() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        if (driver.findElement(By.cssSelector("#mail")).isDisplayed()) {
            driver.findElement(By.cssSelector("#mail")).sendKeys("Automation Testing");
            System.out.println("Email Textbox is displayed");
        } else {
            System.out.println("Email Textbox is not displayed");
        }

        if (driver.findElement(By.cssSelector("#under_18")).isDisplayed()) {
            driver.findElement(By.cssSelector("#under_18")).click();
            System.out.println("Under 18 Radio is displayed");
        } else {
            System.out.println("Under 18 Radio is not displayed");
        }

        if (driver.findElement(By.cssSelector("#edu")).isDisplayed()) {
            driver.findElement(By.cssSelector("#edu")).sendKeys("Automation Testing");
            System.out.println("Education TextArea is displayed");
        } else {
            System.out.println("Education TextArea is not displayed");
        }

        if (driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed()) {
            System.out.println("Name User5 Text is displayed");
        } else {
            System.out.println("Name User5 Text is not displayed");
        }

    }

    @Test
    public void TC_02_Enabled() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        if (driver.findElement(By.cssSelector("#mail")).isEnabled()) {
            System.out.println("Email Textbox is enabled");
        } else {
            System.out.println("Email Textbox is disabled");
        }

        if (driver.findElement(By.cssSelector("#radio-disabled")).isEnabled()) {
            System.out.println("Radio Button is enabled");
        } else {
            System.out.println("Radio Button is disabled");
        }

        if (driver.findElement(By.cssSelector("#check-disbaled")).isEnabled()) {
            System.out.println("Checkbox is enabled");
        } else {
            System.out.println("Checkbox is disabled");
        }
    }

    @Test
    public void TC_03_Selected() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.findElement(By.cssSelector("#under_18")).click();
        driver.findElement(By.cssSelector("#java")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("#under_18")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("#java")).isSelected());

        driver.findElement(By.cssSelector("#java")).click();
        Assert.assertFalse(driver.findElement(By.cssSelector("#java")).isSelected());
    }

    @Test
    public void TC_04_MailChimp() {
        driver.get("https://login.mailchimp.com/signup/");

        driver.findElement(By.id("email")).sendKeys("tranhuudan@gmail.com");
        // Case 1 - Number Char
        driver.findElement(By.id("new_password")).sendKeys("123");
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='number-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());

        // Case 2 - Lowercase Char
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("dan");
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='lowercase-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='number-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());

        // Case 3 - Uppercase Char
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("DAN");
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='uppercase-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='number-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());

        // Case 4 - Special Char
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("!@$%");
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='number-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='special-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());

        // Case 5 - 8 Chars Minimum
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("tranhuudan");
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='lowercase-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='number-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char completed']")).isDisplayed());

        // Case 6 - Valid
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("Tranhuudan96@gmail.com");
        Assert.assertFalse(driver.findElement(By.cssSelector("li[class='lowercase-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li[class='uppercase-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li[class='number-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li[class='special-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li[class='8-char completed']")).isDisplayed());
    }
}
