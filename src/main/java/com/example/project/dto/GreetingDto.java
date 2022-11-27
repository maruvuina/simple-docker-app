package com.example.project.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GreetingDto {

    private Long id;

    private String name;
}
