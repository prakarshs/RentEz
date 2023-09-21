package com.project.CarService.Services;

import com.project.CarService.Models.CarRequest;
import com.project.CarService.Models.CarResponse;

import java.util.List;

public interface CarService {
    CarResponse addCar(CarRequest carRequest);

    CarResponse reduceCar(Long carRequest);

    CarResponse showCar(Long carId);

    List<CarResponse> showAll();
}
