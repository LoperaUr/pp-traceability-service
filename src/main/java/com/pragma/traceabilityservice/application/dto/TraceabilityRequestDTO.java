package com.pragma.traceabilityservice.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TraceabilityRequestDTO {

    @NotNull
    @Positive
    private Long orderId;

    @NotNull
    @Positive
    private Long clientId;

    @NotBlank
    private String clientEmail;

    private LocalDateTime date;

    private String previousStatus;

    @NotBlank
    private String newStatus;

    private Long employeeId;
}

