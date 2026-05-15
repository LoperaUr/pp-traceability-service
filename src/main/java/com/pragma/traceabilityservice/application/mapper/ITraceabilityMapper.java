package com.pragma.traceabilityservice.application.mapper;

import com.pragma.traceabilityservice.application.dto.TraceabilityRequestDTO;
import com.pragma.traceabilityservice.application.dto.TraceabilityResponseDTO;
import com.pragma.traceabilityservice.domain.model.TraceabilityEvent;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ITraceabilityMapper {

    TraceabilityEvent toModel(TraceabilityRequestDTO dto);

    TraceabilityResponseDTO toResponse(TraceabilityEvent event);

    List<TraceabilityResponseDTO> toResponseList(List<TraceabilityEvent> events);
}

