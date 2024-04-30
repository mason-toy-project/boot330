package com.mason.practice.boot330.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
//Cannot use no-arg constructor for mandatory fields
//For null validation, avoid to use primitive type
public class MandatoryExampleDTO {
    private String name;

    @NotNull(message = "Height cannot be null")
    private Double height;

    @NotNull(message = "Age cannot be null")
    private Integer age;
}
