package com.transaction.repositories.specification;

import com.transaction.dto.SearchTransactionDTO;
import com.transaction.model.Transaction;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;

public class TransactionFilterSpecification {

    public static Specification<Transaction> searchTransaction(SearchTransactionDTO dto) {
       return ((root, criteriaQuery, criteriaBuilder) -> {
           if(StringUtils.isNotBlank(dto.getType())) {
               Predicate type = criteriaBuilder.equal(root.get("type"), dto.getType());
               criteriaBuilder.and(type);
           }
           if(StringUtils.isNotBlank(dto.getActor())) {
               Predicate actor = criteriaBuilder.equal(root.get("actor"), dto.getActor());
               criteriaBuilder.and(actor);
           }
           if(dto.getTimeStamp()!=null) {
               Predicate timestamp = criteriaBuilder.equal(root.get("timestamp"), dto.getTimeStamp());
               criteriaBuilder.and(timestamp);
           }
            return (Predicate) criteriaBuilder;
       });
    }
}