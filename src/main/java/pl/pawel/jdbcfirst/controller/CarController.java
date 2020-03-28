package pl.pawel.jdbcfirst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.pawel.jdbcfirst.db.CarDAO;
import pl.pawel.jdbcfirst.model.Car;
import pl.pawel.jdbcfirst.model.SearchParam;

@Controller
public class CarController {


    CarDAO carDAO;

    @Autowired
    public CarController(CarDAO carDAO) {
        this.carDAO = carDAO;
    }


    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("addCar", new Car());
        model.addAttribute("serachParam" , new SearchParam());
        return "home";
    }

    @PostMapping("/car")
    public String addCar(@ModelAttribute Car newCar){
        carDAO.AddCar(newCar);
        return "redirect:/";
    }

    @PostMapping("/searchCars")
    public String searchCars(Model model,@ModelAttribute SearchParam searchParam)
    {
        model.addAttribute("cars", carDAO.getCarsBy(searchParam));
        return "showCars";
    }

}
