package com.transaction.repositories;

import com.transaction.model.Transactions;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
public interface TransactionRepository extends CrudRepository<Transactions, Integer> {
    Transactions getById(Integer id);

    @Query("SELECT t FROM Transactions t WHERE t.Type LIKE %?1%"
            + " OR t.Actor LIKE %?1%")
    List<Transactions> getTransactions(String value);
}
