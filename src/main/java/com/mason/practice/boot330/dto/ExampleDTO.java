package com.mason.practice.boot330.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

//In 1.18.20 version of lombok, Without @lombok. prefix there will be below error
//Class com.sun.tools.javac.tree.JCTree$JCImport does not have member field 'com.sun.tools.javac.tree.JCTree qualid'
@Data
@NoArgsConstructor // Jackson requires a no-argument constructor to instantiate the class before setting properties through setters.
public class ExampleDTO {
    private String name;

    // When we use DTO for http requests, We need to check nullity of this field.
    // Primitive type has default value of 0 or 0.0. To check nullity of this field, we need to use wrapper type.
    private Double height;
}
