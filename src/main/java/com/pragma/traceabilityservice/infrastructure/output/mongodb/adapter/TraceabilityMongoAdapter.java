package com.pragma.traceabilityservice.infrastructure.output.mongodb.adapter;

import com.pragma.traceabilityservice.domain.model.TraceabilityEvent;
import com.pragma.traceabilityservice.domain.spi.ITraceabilityPersistencePort;
import com.pragma.traceabilityservice.infrastructure.output.mongodb.document.TraceabilityDocument;
import com.pragma.traceabilityservice.infrastructure.output.mongodb.mapper.ITraceabilityDocumentMapper;
import com.pragma.traceabilityservice.infrastructure.output.mongodb.repository.ITraceabilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TraceabilityMongoAdapter implements ITraceabilityPersistencePort {

    private final ITraceabilityRepository traceabilityRepository;
    private final ITraceabilityDocumentMapper traceabilityDocumentMapper;

    @Override
    public void registerEvent(TraceabilityEvent event) {
        TraceabilityDocument document = traceabilityDocumentMapper.toDocument(event);
        TraceabilityDocument saved = traceabilityRepository.save(document);
        event.setId(saved.getId());
    }

    @Override
    public List<TraceabilityEvent> getOrderHistoryForClient(Long orderId, Long clientId) {
        List<TraceabilityDocument> documents = traceabilityRepository.findAllByOrderIdAndClientIdOrderByDateDesc(orderId, clientId);
        return traceabilityDocumentMapper.toEventList(documents);
    }
}

