package models;

public class Car {
    Integer car_id;
    String car_make;
    String car_model;
    Integer car_year;
    String car_color;

    public Car(Integer car_id, String car_make, String car_model, Integer car_year, String car_color) {
        this.car_id = car_id;
        this.car_make = car_make;
        this.car_model = car_model;
        this.car_year = car_year;
        this.car_color = car_color;
    }

    public Car() {

    }

    public Integer getCar_id() {
        return car_id;
    }

    public void setCar_id(Integer car_id) {
        this.car_id = car_id;
    }

    public String getCar_make() {
        return car_make;
    }

    public void setCar_make(String car_make) {
        this.car_make = car_make;
    }

    public String getCar_model() {
        return car_model;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }

    public Integer getCar_year() {
        return car_year;
    }

    public void setCar_year(Integer car_year) {
        this.car_year = car_year;
    }

    public String getCar_color() {
        return car_color;
    }

    public void setCar_color(String car_color) {
        this.car_color = car_color;
    }
}
