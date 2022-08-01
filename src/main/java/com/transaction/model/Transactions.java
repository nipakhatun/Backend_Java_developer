package com.transaction.model;

import jdk.jfr.Timestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Table(name = "\"transactions\"")
public class Transactions implements Cloneable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Timestamp
    private LocalDateTime createdAt;
    private String Type;
    private String Actor;
    //-	Transaction data (key-value map of strings)



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getActor() {
        return Actor;
    }

    public void setActor(String actor) {
        Actor = actor;
    }
}
