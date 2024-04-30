package com.mason.practice.boot330.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

//In 1.18.20 version of lombok, Without @lombok. prefix there will be below error
//Class com.sun.tools.javac.tree.JCTree$JCImport does not have member field 'com.sun.tools.javac.tree.JCTree qualid'
@Data
@NoArgsConstructor // Jackson requires a no-argument constructor to instantiate the class before setting properties through setters.
public class ExampleDTO {
    private String name;
    private double height;
}
