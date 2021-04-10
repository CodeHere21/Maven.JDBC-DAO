package daos;

import com.mysql.cj.exceptions.ClosedOnExpiredPasswordException;
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
            ex.printStackTrace();
            }
        return null;
        }

    public List<Car> findAll() throws ClassNotFoundException, SQLException {
        List<Car> cars = new ArrayList<Car>();
        Connection connection=RUNNER.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from car");

            while (rs.next()) {
                Car car = extractCarFromResultSet(rs);
                cars.add(car);
            }
                return cars;

        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return null;
    }

    public boolean update(Car car) throws ClassNotFoundException {
        Connection connection = RUNNER.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("update car set car_make=?,car_model=?, car_year=?, car_color=? where car_id=?");
            ps.setString(1,car.getCar_make());
            ps.setString(2,car.getCar_model());
            ps.setInt(3,car.getCar_year());
            ps.setString(4, car.getCar_color());
            ps.setInt(5,car.getCar_id());
            int i=ps.executeUpdate();

            if(i==1){
                return true;
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }

    public boolean create(Car car) throws ClassNotFoundException {
        Connection connection = RUNNER.getConnection();
        try{
            PreparedStatement ps=connection.prepareStatement("insert into car (car_id, car_make, car_model, car_year, car_color) values(?,?,?,?,?)");
            ps.setInt(1,car.getCar_id());
            ps.setString(2,car.getCar_make());
            ps.setString(3, car.getCar_model());
            ps.setInt(4, car.getCar_year());
            ps.setString(5,car.getCar_color());

            int i=ps.executeUpdate();
            if(i==1){
                return true;
            }

        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) throws ClassNotFoundException {
        Connection connection=RUNNER.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("delete from car where car_id="+id);
            if(i==1){
                return true;
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return false;
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
