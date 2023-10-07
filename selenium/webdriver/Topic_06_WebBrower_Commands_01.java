package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_06_WebBrower_Commands_01 {
    WebDriver driver;

    WebElement element;

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver(); // - trong 1 du an dung chi duy nhat 1 lan
//        driver = new ChromeDriver();
//        driver = new EdgeDriver();
//        System.out.println(driver.toString());

        //Selenium ver 3/2/1 (deprecated)
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
        //Selenium ver 4
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //**

    }

    @Test
    public void TC_01_Browser() {
        // 1 - set truc tiep vao
        System.out.println(driver);
        driver.get("https://www.facebook.com/");; // mo ra 1 page Url bat ki //**
        // 2 - khai bao bien roi gan vao
        // neu nhu bien nay chi dung duy nhat 1 lan thi khong nen tao bien
//        String homePageUrl = "https://www.facebook.com/";
//        driver.get(homePageUrl);
//        driver.findElement();
        driver.close(); //*
        driver.quit();  //**
        driver.getPageSource();
        WebElement emailAddressTextbox = driver.findElement(By.id("email")); //**
        List<WebElement> checkboxes = driver.findElements(By.xpath("/input[@type='checkbox']")); //**

        driver.getCurrentUrl(); //*
        driver.getTitle();
        //Lay id cua cua so/ tab hien tai
        //Handle Window/tab
        driver.getWindowHandle(); //*
        driver.getWindowHandles();  //*
        // Cookies - Frameworks
        driver.manage().getCookies();   //*

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));  //**
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

        driver.manage().window().maximize();
        driver.manage().window().minimize();    //**
        driver.manage().window().fullscreen();

        //Test GUI (giao dien)
        //Test Reponsive (Resolution)
        driver.manage().window().setSize(new Dimension(1366, 768));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().window().setSize(new Dimension(2560, 1440));
        driver.manage().window().getSize();
        //Set cho browser o vi  tri nao so voi do phan giai man hinh
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().getPosition();

        // Điều hướng, chuyển hướng trang web - gia lap tinh nang cua brower chu ko phai cua app
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        // thao tac voi history cua web page (back/forward)
        driver.navigate().to("https://www.facebook.com/");

        // Alert/ Window(tab)/ Frame(iFrame)    //*
        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().getText();
        driver.switchTo().alert().sendKeys("Test");
        //Lay ra 10 cua so/tab hien tai //*
        String homePageWindowID = driver.getWindowHandle();
        driver.switchTo().window(homePageWindowID);
        //Switch/ handle frame (iFrame)     //*
        driver.switchTo().frame(0);
        driver.switchTo().frame("123456789");
        driver.switchTo().frame(driver.findElement(By.id("")));
        //Switch ve html chua frame truoc do
        driver.switchTo().defaultContent();
        //tu cai frame trong di ra cai frame ngoai chua npo
        driver.switchTo().parentFrame();
    }

    @Test
    public void TC_02_Url() {
        driver.get("https://www.facebook.com/");
        driver.get("https://www.youtube.com/");
        driver.get("https://www.google.com/");

        driver.quit();
    }

    @Test
    public void TC_03_Url() {

    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }
}
