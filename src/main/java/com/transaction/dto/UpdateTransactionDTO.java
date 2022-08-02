package com.transaction.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateTransactionDTO {
    private Integer id;
    private String type;
    private String actor;
}
