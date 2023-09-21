package com.project.CarService.Services;

import com.project.CarService.Entities.Car;
import com.project.CarService.Errors.CustomError;
import com.project.CarService.Models.CarRequest;
import com.project.CarService.Models.CarResponse;
import com.project.CarService.Repositories.CarRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class CarServiceIMPL implements CarService{
    @Autowired
    private CarRepository carRepository;
    @Override
    public CarResponse addCar(CarRequest carRequest) {
        log.info("CREATING CAR..");
        Car car = Car.builder()
                .carName(carRequest.getCarName())
                .carDistance(carRequest.getCarDistance())
                .carQuantity(carRequest.getCarQuantity())
                .carRentAmount(carRequest.getCarRentAmount())
                .carAddTime(Instant.now())
                .build();
        log.info("ADDING CAR : {}",car.getCarName());
        carRepository.save(car);

        return CarResponse.builder()
                .message("Your Car Has Been Added !!")
                .carName(car.getCarName())
                .carDistance(car.getCarDistance())
                .carQuantity(car.getCarQuantity())
                .carRentAmount(car.getCarRentAmount())
                .carAddTime(car.getCarAddTime())
                .build();
    }

    @Override
    public CarResponse reduceCar(Long carId, Long carRequest) {
        log.info("CHECKING IF CAR EXISTS...");
        Car car = carRepository.findById(carId).orElseThrow(()-> new CustomError("The Car-Id Doesnt Exist.","Try Entering A different Car-Id."));
        log.info("CHECKING IF QUANTITY SUFFICIENT...");
        if(carRequest>car.getCarQuantity())
        {
            log.info("CAR QUANITITY IS LESS.");
            throw new CustomError("The Car Stock Is Insufficient.","Try Entering A Lower Quantity.");
        }
        else {
            log.info("CAR QUANTITY IS SUFFICIENT.");
            car.setCarQuantity(car.getCarQuantity() - carRequest);
            carRepository.save(car);
        }
        return CarResponse.builder()
                .message("Your Car Quantity Been Reduced !!")
                .carName(car.getCarName())
                .carDistance(car.getCarDistance())
                .carQuantity(car.getCarQuantity())
                .carRentAmount(car.getCarRentAmount())
                .carAddTime(car.getCarAddTime())
                .build();
    }

    @Override
    public CarResponse showCar(Long carId) {
        log.info("CHECKING IF CAR EXISTS...");
        Car car = carRepository.findById(carId).orElseThrow(()-> new CustomError("The Car-Id Doesnt Exist.","Try Entering A different Car-Id."));

        return CarResponse.builder()
                .message("Here Is Your Requested Car !!")
                .carName(car.getCarName())
                .carDistance(car.getCarDistance())
                .carQuantity(car.getCarQuantity())
                .carRentAmount(car.getCarRentAmount())
                .carAddTime(car.getCarAddTime())
                .build();
    }

    @Override
    public List<Car> showAll() {
        return new ArrayList<>(carRepository.findAll());
    }
}
