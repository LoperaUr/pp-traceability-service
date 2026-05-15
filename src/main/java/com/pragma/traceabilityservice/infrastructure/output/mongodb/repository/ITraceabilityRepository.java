package com.pragma.traceabilityservice.infrastructure.output.mongodb.repository;

import com.pragma.traceabilityservice.infrastructure.output.mongodb.document.TraceabilityDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ITraceabilityRepository extends MongoRepository<TraceabilityDocument, String> {
    List<TraceabilityDocument> findAllByOrderIdAndClientIdOrderByDateDesc(Long orderId, Long clientId);
}

