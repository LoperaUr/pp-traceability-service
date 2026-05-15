package com.pragma.traceabilityservice.domain.spi;

import com.pragma.traceabilityservice.domain.model.TraceabilityEvent;

import java.util.List;

public interface ITraceabilityPersistencePort {
    void registerEvent(TraceabilityEvent event);

    List<TraceabilityEvent> getOrderHistoryForClient(Long orderId, Long clientId);
}

