package application;

import models.User;
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

    public void fillLoginForm(User u) {
        type(By.id("email"), u.getEmail());
        type(By.id("password"), u.getPassword());
    }

    public void openRegistrationForm() {
        click(By.xpath("//*[.=' Sign up ']"));
    }

    public void fillRegistrationForm(User u) {
        type(By.cssSelector("input#name"), u.getFName());
        type(By.cssSelector("input#lastName"), u.getLName());
        type(By.cssSelector("input#email"), u.getEmail());
        type(By.cssSelector("input#password"), u.getPassword());
        click(By.xpath("//label[@class='checkbox-label terms-label']"));
    }

    public void submitRegistration() {
        click(By.xpath("//button[@*='submit']"));
    }

    public String textResult() {
        return getText(By.xpath("//*[.='Registered']"));
    }
}
