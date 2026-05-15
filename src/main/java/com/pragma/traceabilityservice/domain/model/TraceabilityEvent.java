package com.pragma.traceabilityservice.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TraceabilityEvent {
    private String id;
    private Long orderId;
    private Long clientId;
    private String clientEmail;
    private LocalDateTime date;
    private String previousStatus;
    private String newStatus;
    private Long employeeId;
}

