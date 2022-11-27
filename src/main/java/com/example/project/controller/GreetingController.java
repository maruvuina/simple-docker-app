package com.example.project.controller;

import com.example.project.dto.GreetingDto;
import com.example.project.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("greetings")
public class GreetingController {

    private final GreetingService greetingService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GreetingDto create(@RequestBody GreetingDto greetingDto) {
        return greetingService.save(greetingDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GreetingDto getById(@PathVariable("id") Long id) {
        return greetingService.getById(id);
    }
}
