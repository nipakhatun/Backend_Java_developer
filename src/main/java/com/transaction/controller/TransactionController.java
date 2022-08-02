package com.transaction.controller;

import com.transaction.dto.CreateTransactionDTO;
import com.transaction.dto.SearchTransactionDTO;
import com.transaction.dto.TransactionResponseDTO;
import com.transaction.dto.UpdateTransactionDTO;
import com.transaction.service.TransactionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionalService service;

    @PostMapping(path = "/transactions")
    public ResponseEntity<?>  createTransaction(@RequestBody CreateTransactionDTO transaction) {
        service.createTransaction(transaction);
        return ResponseEntity.ok("transaction is saved successfully!");
    }

    @PutMapping(path = "/transactions")
    public ResponseEntity<?> updateTransaction(@RequestBody UpdateTransactionDTO transactionRequest) {
        service.updateTransaction(transactionRequest);
        return ResponseEntity.ok("transaction is updated successfully!");
    }

    @GetMapping(path = "/transactions/{id}")
    public ResponseEntity<?> fetchTransactionById(@PathVariable("id") Integer id) {
        TransactionResponseDTO response = service.fetchTransactionById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/transactions")
    public ResponseEntity<?> fetchTransactions() {
        List<TransactionResponseDTO> responses = service.fetchTransactions();
        return ResponseEntity.ok(responses);
    }

    @DeleteMapping(path = "/transactions/{id}")
    public ResponseEntity<?> deleteTransactionById(@PathVariable("id") Integer id) {
        service.deleteTransactionById(id);
        return ResponseEntity.ok("transaction is deleted successfully!");
    }

    @PostMapping(path = "/transactions/search")
    public ResponseEntity<?>  searchTransaction(@RequestBody SearchTransactionDTO dto) {
        List<TransactionResponseDTO> responses = service.searchTransaction(dto);
        return ResponseEntity.ok(responses);
    }

}