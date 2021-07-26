import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewCarTest extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(app.userHelper().isLogged()){
            User u = new User().withEmail("noa@gmail.com")
                    .withPassword("Nnoa12345$");
            app.userHelper().login(u);
        }
    }

    @Test
    public void createNewCar() {
        int i = (int) (System.currentTimeMillis()/1000)%3600;

        Car car1 = Car.builder()
                .address("Tel Aviv, Israel")
                .make("BMW")
                .model("2828")
                .engine("2.0")
                .year("2020")
                .fuel("Petrol")
                .gear("MT")
                .wD("AWD")
                .doors("5")
                .seats("4")
                .clasS("C")
                .fuelConsumption("6.5")
                .carRegNumber("12-" + i)
                .price("65")
                .distanceIncluded("500")
                .typeFeature("type of")
                .about("Very good car")
                .build();

        app.carHelper().openCarForm();
        app.carHelper().fillCarForm(car1);
        app.carHelper().attachPhoto();
        app.carHelper().submitCar();

        Assert.assertEquals(app.carHelper().getTextAddCarResult(), "Car added");
    }
}
