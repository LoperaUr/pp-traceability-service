package com.pragma.traceabilityservice.domain.constants;

public final class DomainConstants {

    private DomainConstants() {
    }

    public static final String KEY_ROLE_NAME = "role_name";
    public static final String KEY_USER_ID = "user_id";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String MSG_AUTHENTICATION_STATE_IMMUTABLE = "Authentication state cannot be changed";
    public static final String MSG_FORBIDDEN_TRACEABILITY_ACCESS = "Client can only query their own order history";
}

