import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void preCondition(){
        if(!app.userHelper().isLogged()){
            app.userHelper().logOut();
        }
    }

    @Test
    public void loginTestPositive(){

        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm("noa@gmail.com", "Nnoa12345$");
        app.userHelper().submitLogin();
        app.userHelper().pause(3000);
        String loginS = app.userHelper().getText(By.xpath("//*[.='Logged in success']"));
        app.userHelper().clickOKButton();
        Assert.assertEquals(loginS, "Logged in success");

    }
}
