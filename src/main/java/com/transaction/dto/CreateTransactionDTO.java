package com.transaction.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class CreateTransactionDTO {

    private String type;
    private String actor;
   // private List<TransactionalPropertyDTO> transactionalProperties;
    private Map<String, Object> transactionalProperties;

}
