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
    private String carName;
    private Long carQuantity;
    private Double carDistance;
    private Long carRentAmount;
    private String carAddTime;
}
