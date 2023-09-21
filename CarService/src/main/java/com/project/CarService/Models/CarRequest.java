package com.project.CarService.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@Builder
public class CarRequest {
    private String carName;
    private Double carDistance;
    private Long carRentAmount;
    private Long carQuantity;
}
