package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Topic_07_WebElement_Commands_01 {
    WebDriver driver;

    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().minimize();
        driver.get("");
    }

    public void TC_01_Element() {
        //HTML Elements: Textbox/ TextArea/ DropDown/ Checkbox/ Links/ Button/...
        //Tim va tra ve 1 element - chua tuong tac len
        driver.findElement(By.id(""));
        //Tim va tuong tac len
        driver.findElement(By.id("")).click();  //**
        driver.findElement(By.id("")).sendKeys();   //**

        //Dung de xoa du lieu trong 1 field cho phep nhap (Editable - cho phep nhap) # (selectable - ko cho phep nhap)
        // Textbox/TextArea/Dropdown (editable)
        //su dung truoc khi sendkeys
        driver.findElement(By.id("")).clear();  //*

        //dung de nhap lieu vao cac field ben tren
        driver.findElement(By.id("")).sendKeys();

        //dung de click len element
        driver.findElement(By.id("")).click();

        //tim tu not cha vao not con - cha can, phuc tap hoa len
        driver.findElement(By.id("")).findElement(By.id(""));
        driver.findElement(By.cssSelector("form#form-validate input#firstname")); //hay hon

        //tra ve nhiu element khop voi dk
        List<WebElement> textboxes = driver.findElements(By.id(""));

        //dung de verify xac minh 1 checkbox/ radio/ dropdown da dc chon hay chua
        Assert.assertTrue(driver.findElement(By.id("")).isSelected()); //*
        Assert.assertFalse(driver.findElement(By.id("")).isSelected());

        //dung de verify 1 element bat ki co hien thi hay ko
        Assert.assertTrue(driver.findElement(By.id("")).isDisplayed()); //**

        //dropdown (default/ custom) - isSelected ko dung cho dropdown dc
        Select select = new Select(driver.findElement(By.id("")));

        //dung de verify 1 element co dc thao tac len hay ko (ko phai read-only)
        Assert.assertTrue(driver.findElement(By.id("")).isEnabled());   //*

        //HTML Element
        driver.findElement(By.id("")).getAttribute("Title"); //tham so la "thuoc tinh"  //*

        //Tab Accesiblility/ Properties trong Element - Accesibility it dung    //*
        driver.findElement(By.id("")).getAccessibleName();
        driver.findElement(By.id("")).getDomAttribute("checked");
        driver.findElement(By.id("")).getDomProperty("baseURI");

        //*
        //Tab Styles trong Elements
        //Font/ Size/ Color/ Background/...
        //Test giao dien giong setSize voi position
        driver.findElement(By.id("")).getCssValue("background-color"); // ra dc rgb(46, 138, 184)
        driver.findElement(By.id("")).getCssValue("font-size"); // ten cua properties

        //Vi tri cua element so voi do phan giai man hinh - test giao dien
        Point nameTextboxLocation = driver.findElement(By.id("")).getLocation();
        nameTextboxLocation.getX();
        nameTextboxLocation.getY();

        //Kich thuoc cua element: chieu rong - chieu cao
        Dimension nameSize = driver.findElement(By.id("")).getSize();

        //Location + Point
        Rectangle nameTextboxRect = driver.findElement(By.id("")).getRect();
        //Location
        Point namePoint = nameTextboxRect.getPoint();
        //Size
        Dimension nameDimension = nameTextboxRect.getDimension();

        //Shadow element (JavascriptExecutor)
        driver.findElement(By.id("")).getShadowRoot();

        //Tu id/ class/ name/ css/ xpath co the truy nguoc lai tagname HTML
        driver.findElement(By.id("firstname")).getTagName();    // input
        driver.findElement(By.className("form-instructions")).getTagName();     // p
        driver.findElement(By.cssSelector("#firstname")).getTagName();      // input
        driver.findElement(By.xpath("//*[@class='form-list']")).getTagName();   // ul

        //Element A -  dau ra cua no la tagname cua element A
        String formListTag = driver.findElement(By.xpath("//*[@class='form-list']")).getTagName();
        //Dau vao cua Element B se nhan tagname cua element A la tham so
        driver.findElement(By.xpath("//div[@class='remember-me-pop']/preceding::" + formListTag));

        //Textx bi an ko getText dc
        driver.findElement(By.cssSelector("address.copyright")).getText(); //**

        //Templates tang toc do viet code

        //Chup hinh bi loi va luu duoi dang nao -
        // FILE (luu thanh 1 hinh co kich thuoc o trong o cung: .png/ .jpg/...)
        // BASE64 (hinh dang text) - dc ma hoa
        // BYTE
        driver.findElement(By.cssSelector("address.copyright")).getScreenshotAs(OutputType.FILE);   //*
        driver.findElement(By.cssSelector("address.copyright")).getScreenshotAs(OutputType.BASE64);
        driver.findElement(By.cssSelector("address.copyright")).getScreenshotAs(OutputType.FILE);

        //FORM (element nao la form hoac nam trong the form)
        //Hanh vi giong nhu phim Enter
        //Register/ Login/ Search/...
        driver.findElement(By.cssSelector("address.copyright")).submit();
    }
}
