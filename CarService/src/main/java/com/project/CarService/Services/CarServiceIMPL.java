package com.project.CarService.Services;

import com.project.CarService.Models.CarRequest;
import com.project.CarService.Models.CarResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceIMPL implements CarService{
    @Override
    public CarResponse addCar(CarRequest carRequest) {
        return null;
    }

    @Override
    public CarResponse reduceCar(Long carRequest) {
        return null;
    }

    @Override
    public CarResponse showCar(Long carId) {
        return null;
    }

    @Override
    public List<CarResponse> showAll() {
        return null;
    }
}
