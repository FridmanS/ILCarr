import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        if(!app.userHelper().isLogged()){
            app.userHelper().logOut();
        }
    }

    @Test(groups = {"web"})
    public void registrationTestPositive(){
        int i = (int) ((System.currentTimeMillis()/1000)%3600);
        app.userHelper().openRegistrationForm();
        User u1 = new User().withFName("Albert").withLName("Einstein")
                .withEmail("emc2@gmail.com" + i).withPassword("Hb14031879$");
        logger.info(String.format("Registration with Name: %s, LastName: %s, Email: %s, Password: %s",
                u1.getFName(), u1.getLName(), u1.getEmail(), u1.getPassword()));
        app.userHelper().fillRegistrationForm(u1);
        app.userHelper().submitForm();
        Assert.assertEquals(app.userHelper().getTextRegResult(), "Registered");
        logger.info("Test passed");
    }

    @AfterMethod(alwaysRun = true)
    public void postCondition(){
        app.userHelper().clickOKButton();
    }

}
