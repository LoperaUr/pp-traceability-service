package com.pragma.traceabilityservice.infrastructure.input.rest;

import com.pragma.traceabilityservice.application.dto.TraceabilityRequestDTO;
import com.pragma.traceabilityservice.application.dto.TraceabilityResponseDTO;
import com.pragma.traceabilityservice.application.handler.ITraceabilityHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/traceability")
@RequiredArgsConstructor
public class TraceabilityController {

    private final ITraceabilityHandler traceabilityHandler;

    @PostMapping
    public ResponseEntity<Void> registerEvent(@Valid @RequestBody TraceabilityRequestDTO request) {
        traceabilityHandler.registerEvent(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<List<TraceabilityResponseDTO>> getOrderHistory(@PathVariable Long orderId) {
        List<TraceabilityResponseDTO> response = traceabilityHandler.getOrderHistoryForAuthenticatedClient(orderId);
        return ResponseEntity.ok(response);
    }
}

