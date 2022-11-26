package com.example.project.service;

import com.example.project.model.Greeting;
import com.example.project.repository.GreetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public Greeting save(Greeting greeting) {
        return greetingRepository.save(greeting);
    }

    public Greeting getById(Long id) {
        return greetingRepository.findById(id).get();
    }

}
