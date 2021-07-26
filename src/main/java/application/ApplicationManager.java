package application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    UserHelper userHelper;
    CarHelper carHelper;
    SearchHelper searchHelper;

    public void init(){
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://ilcarro.xyz/search");
        userHelper = new UserHelper(wd);
        carHelper = new CarHelper(wd);
        searchHelper = new SearchHelper(wd);
    }

    public void stop(){
        wd.quit();
    }

    public UserHelper userHelper(){
        return userHelper;
    }

    public CarHelper carHelper() { return carHelper;}
    public SearchHelper searchHelper(){ return searchHelper; }
}
