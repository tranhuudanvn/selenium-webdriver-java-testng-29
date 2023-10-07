package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.sound.midi.SysexMessage;
import java.util.concurrent.TimeUnit;

public class Topic_02_Selenium_Locator {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/register");
    }
//    HTML element : <tagname attribute_name="attribute_value" ...>
    @Test
    public void TC_01_ID() {
        driver.findElement(By.id("FirstName")).sendKeys("keane");
//        System.out.println(driver.findElement(By.id("FirstName")));
    }

    @Test
    public void TC_02_ClassName() {
        driver.findElement(By.className("header-logo"));



    }

    @Test
    public void TC_03_Name() {
        driver.findElement(By.name("DateOfBirthDay"));
    }

    @Test
    public void TC_04_Tagname() {
        driver.findElement(By.tagName("input"));
    }

    @Test
    public void TC_05_Link_Text() {
        driver.findElement(By.linkText("Shipping & returns"));
    }

    @Test
    public void TC_06_Partial_LinhText() {
        driver.findElement(By.partialLinkText("vendor account"));
    }

    @Test
    public void TC_07_Css() {
        // css vs id
        driver.findElement(By.cssSelector("input[id='FirstName']"));
        driver.findElement(By.cssSelector("input#FirstName"));
        driver.findElement(By.cssSelector("#FirstName"));

        // css vs class
        driver.findElement(By.cssSelector("div[class='page-title']"));
        driver.findElement(By.cssSelector("div.page-title"));
        driver.findElement(By.cssSelector(".page-title"));

        // css vs name
        driver.findElement(By.cssSelector("input[name='FirstName']"));

        // css vs tagname
        driver.findElement(By.cssSelector("input"));

        // css vs link
        driver.findElement(By.cssSelector("a[href='/customer/addresses']"));

        // css vs partial link
        driver.findElement(By.cssSelector("a[href*='/addresses']"));
//        driver.findElement(By.cssSelector("a[href^='/addresses']"));
//        driver.findElement(By.cssSelector("a[href$='/addresses']"));
    }

    @Test
    public void TC_08_Xpath() {
        // Xpath vs id
        driver.findElement(By.xpath("//input[@id='FirstName']"));

        // Xpath vs class
        driver.findElement(By.xpath("//div[@class='page-title']"));

        // Xpath vs name
        driver.findElement(By.xpath("//input[@name='FirstName']"));

        // Xpath vs tagname
        driver.findElement(By.xpath("//input"));

        // Xpath vs link
        driver.findElement(By.xpath("//a[@href='/customer/addresses']"));
        driver.findElement(By.xpath("//a[text()='Addresses']"));
        // Xpath vs partial link
        driver.findElement(By.xpath("//a[contains(@href,'addresses')]"));
        driver.findElement(By.xpath("//a[contains(text(),'Addresses')]"));


    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }


}
