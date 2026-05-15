package com.pragma.traceabilityservice.domain.usecase;

import com.pragma.traceabilityservice.domain.api.ITraceabilityServicePort;
import com.pragma.traceabilityservice.domain.model.TraceabilityEvent;
import com.pragma.traceabilityservice.domain.spi.ITraceabilityPersistencePort;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class TraceabilityService implements ITraceabilityServicePort {

    private final ITraceabilityPersistencePort traceabilityPersistencePort;

    @Override
    public void registerEvent(TraceabilityEvent event) {
        if (event.getDate() == null) {
            event.setDate(LocalDateTime.now());
        }
        traceabilityPersistencePort.registerEvent(event);
    }

    @Override
    public List<TraceabilityEvent> getOrderHistoryForClient(Long orderId, Long authenticatedClientId) {
        return traceabilityPersistencePort.getOrderHistoryForClient(orderId, authenticatedClientId);
    }
}

