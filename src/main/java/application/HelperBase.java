package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
}
