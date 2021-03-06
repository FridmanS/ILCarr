package application;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CarHelper extends HelperBase{
    public CarHelper(WebDriver wd) {
        super(wd);
    }


    public void openCarForm() {
        click(By.id("1"));
    }



    public void fillCarForm(Car car) {
        if(isCarFormPresent()){
            typeLocation(car.getAddress());
            type(By.id("make"), car.getAddress());
            type(By.id("model"), car.getModel());
            type(By.id("year"), car.getYear());
            type(By.id("engine"), car.getEngine());

            select(By.id("fuel"), car.getFuel());
            select(By.id("gear"), car.getGear());
            select(By.id("wheelsDrive"), car.getWD());

            type(By.id("doors"), car.getDoors());
            type(By.id("seats"), car.getSeats());
            type(By.id("class"), car.getClasS());
            type(By.id("fuelConsumption"), car.getFuelConsumption());
            type(By.id("serialNumber"), car.getCarRegNumber() + (System.currentTimeMillis()/1000)%3600);
            type(By.id("price"), car.getPrice());
            type(By.id("distance"), car.getDistanceIncluded());
            type(By.cssSelector(".feature-input"), car.getTypeFeature());
            type(By.id("about"), car.getAbout());



            pause(7000);
        }

    }

    private void typeLocation(String address) {
        WebElement el = wd.findElement(By.id("pickUpPlace"));
        el.click();
        el.clear();
        el.sendKeys(address);
        pause(2000);
        click(By.cssSelector("div.pac-item"));
        pause(2000);
    }

    private boolean isCarFormPresent() {
        return wd.findElements(By.xpath("//h1")).size()>0;
    }

    public void attachPhoto() {
        wd.findElement(By.id("photos")).sendKeys("G:\\Download\\bmw.jpeg");
        pause(10000);
    }
    public void attachPhoto(Car car) {
        wd.findElement(By.id("photos")).sendKeys(car.getPhotoPath());
        pause(10000);
    }
    public String getTextAddCarResult() {
        waitForElementPresent(By.xpath("//*[.='Car added']"), 10);
        return getText(By.xpath("//*[.='Car added']"));
    }

    public void submitCar() {
        click(By.xpath("//*[.='Submit']"));
    }

    public boolean isListOfCarAppeared() {
        return elementIsPresent(By.cssSelector("div.search-results"));
    }


    public void closeMessage() {
        click(By.xpath("//button[.='Search cars']"));
    }


}
