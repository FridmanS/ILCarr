package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase{


    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.xpath("//*[.=' Log in ']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.id("email"), email);
        type(By.id("password"), password);
    }

    public void submitLogin() {
        click(By.xpath("//button[@type='submit']"));
    }

    public void clickOKButton() {
        click(By.xpath("//button[.='Ok']"));
    }

    public boolean isLogged() {
        return wd.findElements(By.xpath("//*[.=' Log in ']")).size() > 0;
    }

    public void logOut() {
        click(By.xpath("//a[.=' Logout ']"));
    }
}
