package com.pragma.traceabilityservice.infrastructure.configuration;

import com.pragma.traceabilityservice.domain.api.ITraceabilityServicePort;
import com.pragma.traceabilityservice.domain.spi.ITraceabilityPersistencePort;
import com.pragma.traceabilityservice.domain.usecase.TraceabilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final ITraceabilityPersistencePort traceabilityPersistencePort;

    @Bean
    public ITraceabilityServicePort traceabilityServicePort() {
        return new TraceabilityService(traceabilityPersistencePort);
    }
}

