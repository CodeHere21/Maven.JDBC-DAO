package daos;

import models.Car;

import java.sql.*;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public class DAOCLASS implements DAO<Car> {


    public Car findById(int id) throws SQLException {
    Connection connection =RUNNER.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from car where car_id=" + id);

            if (rs.next()) {
               return extractCarFromResultSet(rs);

            }
        } catch (SQLException ex){
            System.out.println("Find book by id failed");
            ex.printStackTrace();
            connection.close();
            }
        return null;
        }

    public List<Car> findAll() throws SQLException {
        Connection connection=RUNNER.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from car");

            List cars= new ArrayList();

            while (rs.next()) {
                Car car = new Car();
                car.setCar_id(rs.getInt("car_id"));
                car.setCar_make(rs.getString("car_make"));
                car.setCar_model(rs.getString("car_model"));
                car.setCar_year(rs.getInt("car_year"));
                car.setCar_color(rs.getString("car_color"));

                cars.add(car);

                return cars;
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return null;
    }



    public boolean update(Car car) {
        return false;
    }

    public boolean create(Car car) {
        return true;
    }

    public void delete(int id) {

    }

    private Car extractCarFromResultSet(ResultSet rs) throws SQLException {
        Car car = new Car();
        car.setCar_id(rs.getInt("car_id"));
        car.setCar_make(rs.getString("car_make"));
        car.setCar_model(rs.getString("car_model"));
        car.setCar_year(rs.getInt("car_year"));
        car.setCar_color(rs.getString("car_color"));

        return car;
    }

}
