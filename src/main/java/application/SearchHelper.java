package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;

public class SearchHelper extends HelperBase{
    public SearchHelper(WebDriver wd) {
        super(wd);
    }

    public void typeSearchCurrentMonth(String city, String dateFrom, String dateTo) {
        fillInputCity(city);
        fillInputPeriod(dateFrom, dateTo);
    }

    private void fillInputPeriod(String dateFrom, String dateTo) {
        type(By.id("dates"), dateFrom + " - " + dateTo);
        //int i = (int)(System.currentTimeMillis()/1000)%3600;
        //String screenshot = "src/test/screenshots/screen-" + i + ".png";
        //takeScreenshot(screenshot);
        click(By.cssSelector("div.cdk-overlay-container"));
    }

    private void fillInputCity(String city) {
        type(By.id("city"), city);
        pause(500);
        click(By.xpath("//div[@class='pac-item']"));
    }

    public boolean isDataInPath() {
        WebElement warrning = wd.findElement(By.xpath("//div[@class = 'ng-star-inserted']"));
        String warrningTxt = warrning.getText();
        new WebDriverWait(wd, 10).until(ExpectedConditions.textToBePresentInElement(warrning, warrningTxt));
        return warrningTxt.contains("before today");
    }

    public boolean buttonYallaInactive() {
        WebElement yallaBtn = wd.findElement(By.xpath("//button[@type='submit']"));
        return !yallaBtn.isEnabled();
    }

    public void fillSearchFormCurrentMonth(String city , String dateFrom, String dateTo) {
        fillInputCity(city);
        selectPeriodCurrentMonth(dateFrom, dateTo);
    }

    private void selectPeriodCurrentMonth(String dateFrom, String dateTo) {
        click(By.id("dates"));

        String[] dateF = dateFrom.split("/");
        String[] dateT = dateTo.split("/");

        String dateLocatorFrom = String.format("//div[text() = ' %s ']", dateF[1]);
        String dateLocatorTo = String.format("//div[text() = ' %s ']", dateT[1]);

        click(By.xpath(dateLocatorFrom));
        click(By.xpath(dateLocatorTo));
    }

    public void fillSearchFormInFuture(String city, String dateFrom, String dateTo) {
        fillInputCity(city);
        click(By.id("dates"));

        String[] dateF = dateFrom.split("/");
        String[] dateT = dateTo.split("/");

        int diffStart = 0;
        if(LocalDate.now().getMonthValue() != Integer.parseInt(dateF[0])){
            diffStart = Integer.parseInt(dateF[0]) - LocalDate.now().getMonthValue();
        }
        for (int i = 0; i < diffStart; i++) {
            click(By.xpath("//button[@aria-label='Next month']"));
        }
        String dateLocatorFrom = String.format("//div[text() = ' %s ']", dateF[1]);
        click(By.xpath(dateLocatorFrom));

    }
}
