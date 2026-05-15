package com.pragma.traceabilityservice.domain.model;

import lombok.Data;

@Data
public class AuthenticatedUser {
    private Long id;
    private String email;
    private String role;
}

