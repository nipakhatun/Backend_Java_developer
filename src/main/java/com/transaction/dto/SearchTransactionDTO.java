package com.transaction.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class SearchTransactionDTO {

    private LocalDateTime timeStamp;
    private String actor;
    private String type;

}
