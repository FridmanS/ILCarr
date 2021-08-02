import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        app.userHelper().openMainPage();
    }

    @Test
    public void searchTestPositive(){
        //with concatenate String
        logger.info("\"Haifa\", \"08/26/2021\", \"08/30/2021\"");
        app.searchHelper().typeSearchCurrentMonth("Haifa", "08/26/2021", "08/30/2021");
        app.userHelper().submitForm();
        Assert.assertTrue(app.carHelper().isListOfCarAppeared());
    }

    @Test(groups = {"web"})
    public void searchTestNegative(){
        //with concatenate String
        app.searchHelper().typeSearchCurrentMonth("Haifa", "06/26/2021", "06/30/2021");
        Assert.assertTrue(app.searchHelper().isDataInPath());
        Assert.assertTrue(app.searchHelper().buttonYallaInactive());
    }

    @Test(groups = {"web"})
    public void selectPeriodCurrentMonth(){
        app.searchHelper().fillSearchFormCurrentMonth("Haifa", "08/26/2021", "08/30/2021");
        app.userHelper().submitForm();
        Assert.assertTrue(app.carHelper().isListOfCarAppeared());
    }

    @Test(groups = {"web"})
    public void selectPeriodInFuture(){
        app.searchHelper().fillSearchFormInFuture("Haifa", "08/26/2021", "08/30/2021");
        app.userHelper().submitForm();
        Assert.assertTrue(app.carHelper().isListOfCarAppeared());
    }


}
