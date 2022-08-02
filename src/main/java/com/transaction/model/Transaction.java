package com.transaction.model;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "transactions")
@TypeDef(name = "json", typeClass = JsonType.class)
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalDateTime timeStamp;
    private String type;
    private String actor;

    @Type(type = "json")
    @Column(name ="transactional_data", columnDefinition = "LONGTEXT")
    private Map<String, Object> transactionalProperty;

    public Object getValueByKey(String key) {
        return transactionalProperty.get(key);
    }

    public void removeByKey(String key) {
        transactionalProperty.remove(key);
    }

}
