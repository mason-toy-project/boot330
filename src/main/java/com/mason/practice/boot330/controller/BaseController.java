package com.mason.practice.boot330.controller;

import com.mason.practice.boot330.dto.DatetimeExampleDTO;
import com.mason.practice.boot330.dto.ExampleDTO;
import com.mason.practice.boot330.dto.MandatoryExampleDTO;
import com.mason.practice.boot330.dto.ValidationExampleDTO;
import com.mason.practice.boot330.service.BaseService;
import com.mason.practice.boot330.util.DatetimeConvertor;
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
    public String requestParamExample(@RequestParam(defaultValue = "World") String name) {
        return baseService.hello() + " " + name;
    }

    @GetMapping("/hello/{pathVariable}")
    public String pathParamExample(@PathVariable String pathVariable) {
        return baseService.hello() + " " + pathVariable;
    }

    //curl -X POST http://127.0.0.1:48080/postTest -H 'Content-Type: application/json'  -d '{ "name":"asdfasdf"}'
    @PostMapping("/postTest")
    public String postExample(@RequestBody ExampleDTO exampleDTO) {
        System.out.println(exampleDTO);
        return "Received: " + exampleDTO.getName();
    }

    //curl -X POST http://127.0.0.1:48080/postTestMandatory -H 'Content-Type: application/json'  -d '{ "name":"asdfasdf"}'
    @PostMapping("/postTestMandatory")
    public String postMandatoryFieldExample(@Valid @RequestBody MandatoryExampleDTO exampleDTO) {
        System.out.println(exampleDTO);
        return "Received: " + exampleDTO.getName() + " height: " + exampleDTO.getHeight();
    }


    // curl -X POST http://127.0.0.1:48080/validationExample -H 'Content-Type: application/json'  -d '{"id": 1,"name": "John Doe","email": "john.doe@example.com","phoneNumber": "1234567890"}'
    @PostMapping("/validationExample")
    public String validationExample(@Valid @RequestBody ValidationExampleDTO exampleDTO) {
        System.out.println(exampleDTO);
        return "Received: " + exampleDTO.toString();
    }

    // Receive a datetime without timezone and consider it as KST. Return it as UTC
    // curl -X POST http://127.0.0.1:48080/datetimeExample -H 'Content-Type: application/json'  -d '{"datetime": "2022-01-01 00:00:00"}'
    @PostMapping("/datetimeExample")
    public String datetimeExample(@Valid @RequestBody DatetimeExampleDTO exampleDTO) {
        System.out.println(exampleDTO);
        return "Received: " + DatetimeConvertor.toStringDatetime(exampleDTO.getDatetime()) + ", Consider it as KST and in UTC: " + DatetimeConvertor.toStringDatetime(exampleDTO.getDatetime(), "UTC");
    }
}
