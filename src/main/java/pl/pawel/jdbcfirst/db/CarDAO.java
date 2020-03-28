package pl.pawel.jdbcfirst.db;


import pl.pawel.jdbcfirst.model.Car;
import pl.pawel.jdbcfirst.model.SearchParam;

import java.util.List;

public interface CarDAO {

    public List<Car> getAllCars();
    public void AddCar(Car car);
    public List<Car> getCarsBy(SearchParam searchParam);
}
