package com.transaction.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TransactionResponseDTO {
    private Integer id;
    private LocalDateTime timeStamp;
    private String type;
    private String actor;
    private List<TransactionalPropertyDTO> TransactionalProperties;
}
