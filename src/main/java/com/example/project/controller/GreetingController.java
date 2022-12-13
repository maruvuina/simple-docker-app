package com.example.project.controller;

import java.util.List;

import com.example.project.dto.GreetingDto;
import com.example.project.model.Greeting;
import com.example.project.service.GreetingService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("greetings")
@OpenAPIDefinition(
        info = @Info(
                title = "Swagger Greeting App - OpenAPI 3.0",
                version = "2.0.0",
                description = "This is a simple Greeting App based on the OpenAPI 3.0 specification.",
                license = @License(name = "Apache 2.0", url = "http://www.apache.org/licenses/LICENSE-2.0.html")))
public class GreetingController {

    private final GreetingService greetingService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add a new greeting")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The greeting created",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Greeting.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content) })
    public GreetingDto create(@RequestBody GreetingDto greetingDto) {
        return greetingService.save(greetingDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Find a greeting by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the greeting",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Greeting.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Greeting not found",
                    content = @Content) })
    public GreetingDto getById(@PathVariable("id") Long id) {
        return greetingService.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Find all greetings")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Got all greetings",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Greeting.class)) })
    })
    public List<GreetingDto> getAll() {
        return greetingService.getAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update an existing greeting")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated the greeting",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Greeting.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Greeting not found",
                    content = @Content)
    })
    public GreetingDto update(@PathVariable("id") Long id, @RequestBody GreetingDto greetingDto) {
        return greetingService.update(id, greetingDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a greeting")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Deleted the greeting",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Greeting.class)) }),
            @ApiResponse(responseCode = "404", description = "Greeting not found",
                    content = @Content) })
    public void delete(@PathVariable("id") Long id) {
        greetingService.delete(id);
    }
}
