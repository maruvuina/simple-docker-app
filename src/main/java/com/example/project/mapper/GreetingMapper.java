package com.example.project.mapper;

import com.example.project.dto.GreetingDto;
import com.example.project.model.Greeting;
import org.mapstruct.Mapper;

/**
 * Provides functionality to convert {@link Greeting} to Dtos.
 */
@Mapper(componentModel = "spring")
public interface GreetingMapper {

    /**
     *
     * @param greeting an instance of {@link Greeting}
     * @return an instance of {@link GreetingDto}
     */
    GreetingDto toDto(Greeting greeting);

    /**
     *
     * @param greetingDto an instance of {@link GreetingDto}
     * @return an instance of {@link Greeting}
     */
    Greeting fromDto(GreetingDto greetingDto);
}
