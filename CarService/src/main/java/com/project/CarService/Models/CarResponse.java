package com.project.CarService.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
@Builder
public class CarResponse {
    private String message;
    private Long carId;
    private String carName;
    private Double carDistance;
    private Long carRentAmount;
    private Instant carAddTime;
}
