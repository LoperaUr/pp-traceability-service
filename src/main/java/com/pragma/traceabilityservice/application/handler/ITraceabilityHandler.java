package com.pragma.traceabilityservice.application.handler;

import com.pragma.traceabilityservice.application.dto.TraceabilityRequestDTO;
import com.pragma.traceabilityservice.application.dto.TraceabilityResponseDTO;

import java.util.List;

public interface ITraceabilityHandler {
    void registerEvent(TraceabilityRequestDTO request);

    List<TraceabilityResponseDTO> getOrderHistoryForAuthenticatedClient(Long orderId);
}

