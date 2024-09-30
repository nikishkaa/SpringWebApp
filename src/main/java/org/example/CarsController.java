package org.example;

import org.example.model.Car;
import org.example.model.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/cars")
public class CarsController {

    private static List<Car> cars;

    static {
        cars = new ArrayList<>();
        cars.add(new Car(1, "BMW 1", 150000.5));
        cars.add(new Car(2, "BMW 2", 150000.5));
        cars.add(new Car(3, "BMW 3", 150000.5));
        cars.add(new Car(4, "BMW 4", 150000));
        cars.add(new Car(5, "BMW 5", 150000));
        cars.add(new Car(6, "BMW 6", 150000));
    }
    // show all cars +++

    // show car by id

    // delete car by id

    // 1st: create new car GET -> new Car() -> return "create_car_form"
    // 2st: create new car POST -> new Car(123, "HONDA", 1234) -> cars.add(_)
    // -> return showAllCars()

    // update car

    @RequestMapping("/view-all")
    public ModelAndView showAllCars() {
        ModelAndView mav = new ModelAndView();

        if (!Objects.isNull(cars)) {
            mav.setViewName("cars");
//            cars.stream().forEach(mav::addObject);
            mav.addObject("cars", cars);
        }

        return mav;
    }

    @RequestMapping("/delete_car")
    public ModelAndView deleteCarById(@RequestParam String id) {
        if (id != null) {
            int idToDelete = Integer.parseInt(id);
            int index = -1;
            for (int i = 0; i < cars.size(); i++) {
                Car car = cars.get(i);
                if (car.getId() == idToDelete) {
                    //found
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                cars.remove(index);
                System.out.println("Car ");
            }

        }

        return showAllCars();
    }

    @RequestMapping(value = "/create_car", method = RequestMethod.GET)
    public ModelAndView showCarForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("car_form");
        modelAndView.addObject(new Car()); // stub
        return modelAndView;
    }

    @RequestMapping(value = "/create_car", method = RequestMethod.POST)
    public ModelAndView createCar(@ModelAttribute("car") Car car) {
        if (!Objects.isNull(car)) {
            cars.add(car);
        }

        return showAllCars();
    }
}
