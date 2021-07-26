import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends TestBase {

    @Test
    public void searchTestPositive(){
        //with concatenate String
        app.searchHelper().typeSearchCurrentMonth("Haifa", "07/26/2021", "07/30/2021");
        app.userHelper().submitForm();
        Assert.assertTrue(app.carHelper().isListOfCarAppeared());
    }

    @Test
    public void searchTestNegative(){
        //with concatenate String
        app.searchHelper().typeSearchCurrentMonth("Haifa", "06/26/2021", "06/30/2021");
        Assert.assertTrue(app.searchHelper().isDataInPath());
        Assert.assertTrue(app.searchHelper().buttonYallaInactive());
    }

    @Test
    public void selectPeriodCurrentMonth(){
        app.searchHelper().fillSearchFormCurrentMonth("Haifa", "07/26/2021", "07/30/2021");
        app.userHelper().submitForm();
        Assert.assertTrue(app.carHelper().isListOfCarAppeared());
    }

    @Test
    public void selectPeriodInFuture(){
        app.searchHelper().fillSearchFormInFuture("Haifa", "08/26/2021", "10/30/2021");
        app.userHelper().submitForm();

    }


}
