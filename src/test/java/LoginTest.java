import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void loginTestPositive(){
        click(By.xpath("//*[.=' Log in ']"));
        type(By.id("email"), "noa@gmail.com");
        type(By.id("password"), "Nnoa12345$");
        click(By.xpath("//*[@type='submit']"));
        pause(3000);
        String loginS = getText(By.xpath("//*[.='Logged in success']"));
        click(By.xpath("//button[.='Ok']"));
        Assert.assertEquals(loginS, "Logged in success");

    }
}
