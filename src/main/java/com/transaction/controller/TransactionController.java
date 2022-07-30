package com.transaction.controller;

import com.transaction.model.TransactionRequest;
import com.transaction.model.Transactions;
import com.transaction.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("TransactionController")
@RequestMapping(path = "/transactions")
public class TransactionController {
    @Autowired
    private TransactionRepository transactionRepository;

    @PostMapping(path = "/store")
    public @ResponseBody String createTransaction(@RequestBody Transactions transactions) {
        transactionRepository.save(transactions);
        return "success";
    }
    @PostMapping(path = "/edit")
    public @ResponseBody String uodateTransaction(@RequestBody TransactionRequest transactionRequest) {
        Transactions transactions = transactionRepository.getById(transactionRequest.getId());
        transactions.setActor(transactionRequest.getActor());
        transactions.setType(transactionRequest.getType());
        transactionRepository.save(transactions);
        return "success";
    }

    @DeleteMapping(path = "/deleteTransaction")
    public @ResponseBody String deleteTransaction(@PathVariable Integer transactionId) {
        transactionRepository.deleteById(transactionId);
        return "success";
    }
    @GetMapping(path = "/search")
    public @ResponseBody String getTransactions(@PathVariable String value) {
        transactionRepository.getTransactions(value);
        return "success";
    }
}
