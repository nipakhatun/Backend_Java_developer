package com.transaction.repositories.specification;

import com.transaction.dto.SearchTransactionDTO;
import com.transaction.model.Transaction;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class TransactionFilterSpecification {

    public static Specification<Transaction> searchTransaction(SearchTransactionDTO dto) {
       return ((root, criteriaQuery, criteriaBuilder) -> {
          List<Predicate> predicates = new ArrayList<>();
           if(StringUtils.isNotBlank(dto.getType())) {
               Predicate type = criteriaBuilder.equal(root.get("type"), dto.getType());
               predicates.add(type);
           }
           if(StringUtils.isNotBlank(dto.getActor())) {
               Predicate actor = criteriaBuilder.equal(root.get("actor"), dto.getActor());
               predicates.add(actor);
           }
           if(dto.getTimeStamp()!=null) {
               Predicate timestamp = criteriaBuilder.equal(root.get("timestamp"), dto.getTimeStamp());
               predicates.add(timestamp);
           }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
       });
    }
}