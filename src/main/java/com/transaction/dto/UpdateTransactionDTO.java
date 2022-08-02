package com.transaction.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UpdateTransactionDTO {
    private Integer id;
    private String type;
    private String actor;
    private List<TransactionalPropertyDTO> transactionalProperties;

}
