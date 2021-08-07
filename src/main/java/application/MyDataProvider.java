package application;

import models.Car;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object[]> validRegDataClassDP(){
        List<Object[]> list = new ArrayList<>();
        int i = (int) (System.currentTimeMillis()/1000)%3600;
        list.add(new Object[]{"Sony", "Low", "noa+8@gmail.com" + i, "Nnoa12345$"});
        list.add(new Object[]{"Sony", "Low", "noa+9@gmail.com" + i, "Nnoa12345$"});
        list.add(new Object[]{"Sony", "Low", "sonya+10@gmail.com" + i, "Ss12345$"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> registCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/reg.csv")));
        String line = reader.readLine();
        while(line != null) {
            String[] split = line.split(";");
            list.add(new Object[]{new User()
                    .withFName(split[0]).withLName(split[1])
                    .withEmail(split[2] + (System.currentTimeMillis()/1000)%3600)
                    .withPassword(split[3])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public  Iterator<Object[]> validCarData() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/carData.csv")));
        String line = reader.readLine();
        while(line != null){
            String[] split = line.split(";");
            list.add(new Object[]{Car.builder()
                    .address(split[0])
                    .make(split[1])
                    .model(split[2])
                    .year(split[3])
                    .engine(split[4])
                    .fuel(split[5])
                    .gear(split[6])
                    .wD(split[7])
                    .doors(split[8])
                    .seats(split[9])
                    .clasS(split[10])
                    .fuelConsumption(split[11])
                    .carRegNumber(split[12] + (System.currentTimeMillis()/1000)%3600)
                    .price(split[13])
                    .distanceIncluded(split[14])
                    .typeFeature(split[15])
                    .about(split[16])
                    .photoPath(split[17])
                    .build()});
            line = reader.readLine();
        }
        return list.iterator();
    }
}
