package com.project.CarService.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "CAR_DETAILS")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long carId;
    @Column(name = "CAR_NAME")
    private String carName;
    @Column(name = "CAR_DISTANCE")
    private Double carDistance;
    @Column(name = "CAR_QUANTITY")
    private Long carQuantity;
    @Column(name = "CAR_RENT")
    private Long carRentAmount;
    @Column(name = "CAR_TIME")
    private String carAddTime;
}
