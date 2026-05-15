package com.pragma.traceabilityservice.application.handler;

import com.pragma.traceabilityservice.application.dto.TraceabilityRequestDTO;
import com.pragma.traceabilityservice.application.dto.TraceabilityResponseDTO;
import com.pragma.traceabilityservice.application.mapper.ITraceabilityMapper;
import com.pragma.traceabilityservice.domain.api.IAuthenticationServicePort;
import com.pragma.traceabilityservice.domain.api.ITraceabilityServicePort;
import com.pragma.traceabilityservice.domain.exception.DomainException;
import com.pragma.traceabilityservice.domain.model.AuthenticatedUser;
import com.pragma.traceabilityservice.domain.model.TraceabilityEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TraceabilityHandler implements ITraceabilityHandler {

    private final ITraceabilityServicePort traceabilityServicePort;
    private final IAuthenticationServicePort authenticationServicePort;
    private final ITraceabilityMapper traceabilityMapper;

    @Override
    public void registerEvent(TraceabilityRequestDTO request) {
        TraceabilityEvent event = traceabilityMapper.toModel(request);
        traceabilityServicePort.registerEvent(event);
    }

    @Override
    public List<TraceabilityResponseDTO> getOrderHistoryForAuthenticatedClient(Long orderId) {
        AuthenticatedUser authenticatedUser = authenticationServicePort.getAuthenticatedUser();
        if (authenticatedUser == null || authenticatedUser.getId() == null) {
            throw new DomainException("Authenticated user not found", HttpStatus.UNAUTHORIZED);
        }
        List<TraceabilityEvent> events = traceabilityServicePort.getOrderHistoryForClient(orderId, authenticatedUser.getId());
        return traceabilityMapper.toResponseList(events);
    }
}


