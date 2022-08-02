package com.transaction.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalDateTime timeStamp;
    private String type;
    private String actor;
   // @Type(type = "json")
   // @Column(columnDefinition = "jsonb")
   // private Map<String, String> transactionData = new HashMap<>();

}
