package com.example.project.service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.project.dto.GreetingDto;
import com.example.project.exception.GreetingAlreadyExistsException;
import com.example.project.exception.GreetingNotFoundException;
import com.example.project.mapper.GreetingMapper;
import com.example.project.model.Greeting;
import com.example.project.repository.GreetingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Provides functionality to manipulate {@link Greeting}s.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class GreetingService {

    private final GreetingRepository greetingRepository;

    private final GreetingMapper greetingMapper;

    @Transactional
    public GreetingDto save(GreetingDto greetingDto) {
        if (greetingRepository.existsByName(greetingDto.getName())) {
            log.error("Greeting with name {} already exists", greetingDto.getName());
            throw new GreetingAlreadyExistsException("Greeting already exists with name = " + greetingDto.getName());
        }
        Greeting greeting = greetingMapper.fromDto(greetingDto);
        Greeting createdGreeting = greetingRepository.save(greeting);
        return greetingMapper.toDto(createdGreeting);
    }

    public GreetingDto getById(Long id) {
        return greetingMapper.toDto(getByGreetingId(id));
    }

    public List<GreetingDto> getAll() {
        return greetingRepository.findAll()
                .stream()
                .map(greetingMapper::toDto)
                .collect(Collectors.toList());
    }

    public GreetingDto update(Long id, GreetingDto greetingDto) {
        Greeting greeting = getByGreetingId(id);
        greeting.setName(greetingDto.getName());
        return greetingMapper.toDto(greetingRepository.save(greeting));
    }

    public void delete(Long id) {
        greetingRepository.deleteById(id);
        log.info("Greeting with id = {} deleted", id);
    }

    private Greeting getByGreetingId(Long id) {
        return greetingRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Greeting with id = {} not found", id);
                    throw new GreetingNotFoundException("Not found greeting with id = " + id);
                });

    }
}
