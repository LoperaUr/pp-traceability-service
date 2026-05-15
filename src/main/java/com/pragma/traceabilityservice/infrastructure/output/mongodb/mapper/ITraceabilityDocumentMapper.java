package com.pragma.traceabilityservice.infrastructure.output.mongodb.mapper;

import com.pragma.traceabilityservice.domain.model.TraceabilityEvent;
import com.pragma.traceabilityservice.infrastructure.output.mongodb.document.TraceabilityDocument;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ITraceabilityDocumentMapper {
    TraceabilityDocument toDocument(TraceabilityEvent event);

    TraceabilityEvent toEvent(TraceabilityDocument document);

    List<TraceabilityEvent> toEventList(List<TraceabilityDocument> documents);
}

