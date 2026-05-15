package com.pragma.traceabilityservice.infrastructure.input.rest;

import com.pragma.traceabilityservice.application.dto.TraceabilityRequestDTO;
import com.pragma.traceabilityservice.application.dto.TraceabilityResponseDTO;
import com.pragma.traceabilityservice.application.handler.ITraceabilityHandler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TraceabilityControllerTest {

    @Mock
    private ITraceabilityHandler traceabilityHandler;

    @InjectMocks
    private TraceabilityController traceabilityController;

    @Test
    void registerEventShouldDelegateToHandler() {
        TraceabilityRequestDTO request = new TraceabilityRequestDTO();
        request.setOrderId(12L);
        request.setClientId(30L);
        request.setClientEmail("client@test.com");
        request.setNewStatus("READY");

        traceabilityController.registerEvent(request);

        verify(traceabilityHandler).registerEvent(request);
    }

    @Test
    void getOrderHistoryShouldReturnHandlerResponse() {
        TraceabilityResponseDTO responseDTO = new TraceabilityResponseDTO();
        responseDTO.setOrderId(50L);

        org.mockito.Mockito.when(traceabilityHandler.getOrderHistoryForAuthenticatedClient(50L))
                .thenReturn(List.of(responseDTO));

        List<TraceabilityResponseDTO> response = traceabilityController.getOrderHistory(50L).getBody();

        assertEquals(1, response.size());
        assertEquals(50L, response.get(0).getOrderId());
    }
}

