package com.pragma.traceabilityservice.domain.api;

import com.pragma.traceabilityservice.domain.model.TraceabilityEvent;

import java.util.List;

public interface ITraceabilityServicePort {
    void registerEvent(TraceabilityEvent event);

    List<TraceabilityEvent> getOrderHistoryForClient(Long orderId, Long authenticatedClientId);
}

