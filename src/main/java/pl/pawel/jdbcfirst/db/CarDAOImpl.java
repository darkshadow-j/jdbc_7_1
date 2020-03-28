package pl.pawel.jdbcfirst.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.pawel.jdbcfirst.model.Car;
import pl.pawel.jdbcfirst.model.SearchParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class CarDAOImpl implements  CarDAO {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Car> getAllCars() {

        List<Car> carList = new ArrayList<>();
        String sql = "SELECT * from car";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.stream().forEach(p -> carList.add(new Car(Integer.valueOf(String.valueOf(p.get("id"))),
                String.valueOf(p.get("mark")),
                String.valueOf(p.get("model")),
                String.valueOf(p.get("year")))));
        return carList;
    }

    @Override
    public void AddCar(Car car) {
        String sql="INSERT INTO car values (null,?,?,?)";
        jdbcTemplate.update(sql, car.getMark(),car.getModel(),car.getYear());
    }

    @Override
    public List<Car> getCarsBy(SearchParam searchParam) {
        List<Car> carList = new ArrayList<>();
        String sql="SELECT * from car where year>=? and year<=?";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql,searchParam.getOdSearch(), searchParam.getDoSearch());
        maps.stream().forEach(p->carList.add(new Car(Integer.valueOf(String.valueOf(p.get("id"))),
                String.valueOf(p.get("mark")),
                String.valueOf(p.get("model")),
                String.valueOf(p.get("year")))));
        return carList;
    }


}
