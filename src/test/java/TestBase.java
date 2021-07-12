import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver wd;

    @BeforeClass
    public void init(){
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://ilcarro.xyz/search");
    }

    public void click(By locator){
        wd.findElement(locator).click();
    }

    public void type(By locator, String text){
        if(text != null) {
            WebElement el = wd.findElement(locator);
            el.click();
            el.clear();
            el.sendKeys(text);
        }
    }

    public String getText(By locator){
        return wd.findElement(locator).getText();
    }

    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown(){
        wd.quit();
    }
}
