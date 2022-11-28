package com.example.project.service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.project.dto.GreetingDto;
import com.example.project.exception.GreetingNotFoundException;
import com.example.project.mapper.GreetingMapper;
import com.example.project.model.Greeting;
import com.example.project.repository.GreetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GreetingService {

    private final GreetingRepository greetingRepository;

    private final GreetingMapper greetingMapper;

    @Transactional
    public GreetingDto save(GreetingDto greetingDto) {
        Greeting greeting = greetingMapper.fromDto(greetingDto);
        Greeting createdGreeting = greetingRepository.save(greeting);
        return greetingMapper.toDto(createdGreeting);
    }

    public GreetingDto getById(Long id) {
        return greetingRepository.findById(id)
                .map(greetingMapper::toDto)
                .orElseThrow(() ->
                        new GreetingNotFoundException("Not found greeting with id = " + id));
    }

    public List<GreetingDto> getAll() {
        return greetingRepository.findAll()
                .stream()
                .map(greetingMapper::toDto)
                .collect(Collectors.toList());
    }

}
