package application;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class HelperBase {

    WebDriver wd;

    public HelperBase(WebDriver wd){
        this.wd = wd;
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

    public void select(By locator, String options){
        new Select(wd.findElement(locator)).selectByValue(options);
    }

    public void waitForElementPresent(By locator, int i) {
        new WebDriverWait(wd, i).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public boolean elementIsPresent(By locator) {

        return wd.findElements(locator).size() > 0;
    }

    public void takeScreenshot(String pathToFile){
        File tmp = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);

        File screenshot = new File(pathToFile);
        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
