package com.project.CarService.Errors;

import lombok.Data;

@Data
public class CustomError extends RuntimeException {
    String resolution;
  public CustomError(String message, String resolution){
        super(message);
        this.resolution = resolution;
    }
}
