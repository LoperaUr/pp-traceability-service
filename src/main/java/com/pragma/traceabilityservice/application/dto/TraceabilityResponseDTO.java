package com.pragma.traceabilityservice.application.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TraceabilityResponseDTO {
    private String id;
    private Long orderId;
    private Long clientId;
    private String clientEmail;
    private LocalDateTime date;
    private String previousStatus;
    private String newStatus;
    private Long employeeId;
}

