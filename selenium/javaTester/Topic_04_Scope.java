package javaTester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_04_Scope {
    WebDriver driver;

    String homePageUrl;

    String fullname = "Automation FC";

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

    }

    @Test
    public void TC_01_Url() {
//        String homePageUrl = "https://www.facebook.com/";
//        driver.get(homePageUrl);
//        driver.get(this.homePageUrl);
        driver.get("https://www.messenger.com/");
        Assert.assertTrue(driver.getPageSource().contains("The Apple and Google Play logos are trademarks of their respective owners."));

    }

    @Test
    public void TC_02_Url() {

    }

    @Test
    public void TC_03_Url() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
