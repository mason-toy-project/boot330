package com.mason.practice.boot330.controller;

import com.mason.practice.boot330.dto.ExampleDTO;
import com.mason.practice.boot330.dto.MandatoryExampleDTO;
import com.mason.practice.boot330.service.BaseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
public class BaseController {
    private final BaseService baseService;

    public BaseController(BaseService baseService) {
        this.baseService = baseService;
    }

    /**
     * Returns a greeting message.
     *
     * @return A string containing the greeting message.
     */
    @GetMapping("/hello")
    public String helloRequestParam(@RequestParam(defaultValue = "World") String name) {
        return baseService.hello() + " " + name;
    }

    @GetMapping("/hello/{pathVariable}")
    public String helloPathParam(@PathVariable String pathVariable) {
        return baseService.hello() + " " + pathVariable;
    }

    //curl -X POST http://127.0.0.1:48080/postTest -H 'Content-Type: application/json'  -d '{ "name":"asdfasdf"}'
    @PostMapping("/postTest")
    public String helloPost(@RequestBody ExampleDTO exampleDTO) {
        System.out.println(exampleDTO);
        return "Received: " + exampleDTO.getName();
    }

    //curl -X POST http://127.0.0.1:48080/postTestMandatory -H 'Content-Type: application/json'  -d '{ "name":"asdfasdf"}'
    @PostMapping("/postTestMandatory")
    public String helloPostMandatory(@Valid @RequestBody MandatoryExampleDTO exampleDTO) {
        System.out.println(exampleDTO);
        return "Received: " + exampleDTO.getName() + " height: " + exampleDTO.getHeight();
    }

}
