package com.pragma.traceabilityservice.domain.usecase;

import com.pragma.traceabilityservice.domain.model.TraceabilityEvent;
import com.pragma.traceabilityservice.domain.spi.ITraceabilityPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TraceabilityServiceTest {

    @Mock
    private ITraceabilityPersistencePort traceabilityPersistencePort;

    @InjectMocks
    private TraceabilityService traceabilityService;

    @Test
    void registerEventShouldSetDateWhenMissing() {
        TraceabilityEvent event = new TraceabilityEvent();
        event.setOrderId(1L);
        event.setClientId(2L);
        event.setClientEmail("client@correo.com");
        event.setNewStatus("PENDING");

        traceabilityService.registerEvent(event);

        ArgumentCaptor<TraceabilityEvent> captor = ArgumentCaptor.forClass(TraceabilityEvent.class);
        verify(traceabilityPersistencePort).registerEvent(captor.capture());
        assertNotNull(captor.getValue().getDate());
    }

    @Test
    void getOrderHistoryForClientShouldDelegateToPersistence() {
        TraceabilityEvent event = new TraceabilityEvent();
        event.setOrderId(10L);
        when(traceabilityPersistencePort.getOrderHistoryForClient(10L, 20L)).thenReturn(List.of(event));

        List<TraceabilityEvent> response = traceabilityService.getOrderHistoryForClient(10L, 20L);

        assertEquals(1, response.size());
        verify(traceabilityPersistencePort).getOrderHistoryForClient(10L, 20L);
    }
}

