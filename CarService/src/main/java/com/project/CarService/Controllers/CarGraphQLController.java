package com.project.CarService.Controllers;

import com.project.CarService.Entities.Car;
import com.project.CarService.Models.CarRequest;
import com.project.CarService.Models.CarResponse;
import com.project.CarService.Services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CarGraphQLController {

    @Autowired
    private CarService carService;

    @MutationMapping("add")
    public CarResponse add(@Argument CarRequest carRequest){
        return carService.addCar(carRequest);
    }
    @MutationMapping("reduce")
    public CarResponse reduce(@Argument Long carId, @Argument Long carRequestQuantity){
        return carService.reduceCar(carId, carRequestQuantity);
    }

    @QueryMapping("show")
    public CarResponse show(@Argument Long carId){
        return carService.showCar(carId);
    }
    @QueryMapping("showAll")
    public List<Car> shoAll(){
        return carService.showAll();
    }
}
