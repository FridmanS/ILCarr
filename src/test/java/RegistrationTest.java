import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    @BeforeMethod
    public void preCondition(){
        if(!app.userHelper().isLogged()){
            app.userHelper().logOut();
        }
    }

    @Test
    public void registrationTestPositive(){
        app.userHelper().openRegistrationForm();
        User u1 = new User().withFName("Albert").withLName("Einstein")
                .withEmail("emc2@gmail.com").withPassword("Hb14031879$");
        app.userHelper().fillRegistrationForm(u1);
        app.userHelper().submitForm();
        Assert.assertEquals(app.userHelper().getTextRegResult(), "Registered");
    }

}
