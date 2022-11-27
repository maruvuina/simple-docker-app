package com.example.project.mapper;

import com.example.project.dto.GreetingDto;
import com.example.project.model.Greeting;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GreetingMapper {

    GreetingDto toDto(Greeting greeting);

    Greeting fromDto(GreetingDto greetingDto);
}
