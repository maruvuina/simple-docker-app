package com.example.project.handler;

import lombok.Builder;
import lombok.Data;

/**
 * ErrorResponse model.
 */
@Builder
@Data
public class ErrorResponse {

    private String error;

    private String message;

}
