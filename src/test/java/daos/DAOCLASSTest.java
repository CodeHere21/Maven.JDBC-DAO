package daos;

import junit.framework.TestCase;
import models.Car;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOCLASSTest {
    @Test
    public void testFindById() throws SQLException {
        //Given
        DAOCLASS daoObject=new DAOCLASS();

        //When
        Car actualCar=daoObject.findById(2);
        //Then
        Assert.assertEquals("Corsa",actualCar.getCar_model());
    }

    @Test
    public void testFindAll() throws SQLException, ClassNotFoundException {
        //Given
        DAOCLASS daoObject=new DAOCLASS();
        //When
        List<Car> listOfCars=new ArrayList<Car>();
        listOfCars=daoObject.findAll();
        //Then
        Assert.assertEquals("Corsa",listOfCars.get(1).getCar_model());

    }

    @Test
    public void testUpdate() throws ClassNotFoundException {
        //Given
        DAOCLASS daoObject=new DAOCLASS();
        Car newFord=new Car(1, "Ford", "Focus", 2021, "Black");
        //When

        //Then
        Assert.assertTrue(daoObject.update(newFord));
    }

    @Test
    public void testCreate() throws ClassNotFoundException, SQLException {
        //Given
        DAOCLASS daoObject=new DAOCLASS();
        Car testCar=new Car(6,"Septa","Bus",2010,"Grey");
        //When
        daoObject.create(testCar);
        List<Car> cars = daoObject.findAll();
        //Then
        Assert.assertEquals("Septa", cars.get(cars.size()-1).getCar_make());
    }

    @Test
    public void testDelete() throws ClassNotFoundException {
        //Given
        DAOCLASS daoObject=new DAOCLASS();
        //When

        //Then
        Assert.assertTrue(  daoObject.delete(0));
    }
}