package com.pragma.traceabilityservice.domain.api;

import com.pragma.traceabilityservice.domain.model.AuthenticatedUser;

public interface IAuthenticationServicePort {
    AuthenticatedUser getAuthenticatedUser();
}

