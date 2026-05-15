package com.pragma.traceabilityservice.infrastructure.output.mongodb.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "traceability")
@CompoundIndex(name = "idx_order_client_date_desc", def = "{'orderId': 1, 'clientId': 1, 'date': -1}")
public class TraceabilityDocument {
    @Id
    private String id;
    private Long orderId;
    private Long clientId;
    private String clientEmail;
    private LocalDateTime date;
    private String previousStatus;
    private String newStatus;
    private Long employeeId;
}

