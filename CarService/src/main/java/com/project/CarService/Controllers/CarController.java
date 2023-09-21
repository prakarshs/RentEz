package com.project.CarService.Controllers;

import com.project.CarService.Entities.Car;
import com.project.CarService.Models.CarRequest;
import com.project.CarService.Models.CarResponse;
import com.project.CarService.Services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;
    @PostMapping("/add")
    public ResponseEntity<CarResponse> add(@RequestBody CarRequest carRequest){
        return new ResponseEntity<>(carService.addCar(carRequest), HttpStatus.OK);
    }

    @PutMapping("/reduce/{carId}")
    public ResponseEntity<CarResponse> add(@PathVariable Long carId, @RequestParam Long carRequest){
        return new ResponseEntity<>(carService.reduceCar(carId, carRequest), HttpStatus.OK);
    }

    @GetMapping("/show/{carId}")
    public ResponseEntity<CarResponse> show(@PathVariable Long carId){
        return new ResponseEntity<>(carService.showCar(carId), HttpStatus.OK);
    }

    @GetMapping("/showAll")
    public ResponseEntity<List<Car>> shoAll(){
        return new ResponseEntity<>(carService.showAll(), HttpStatus.OK);
    }
}
