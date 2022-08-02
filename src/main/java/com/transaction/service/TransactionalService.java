package com.transaction.service;

import com.transaction.dto.CreateTransactionDTO;
import com.transaction.dto.SearchTransactionDTO;
import com.transaction.dto.TransactionResponseDTO;
import com.transaction.dto.UpdateTransactionDTO;
import com.transaction.model.Transaction;
import com.transaction.repositories.TransactionRepository;
import com.transaction.repositories.specification.TransactionFilterSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionalService {
    private final TransactionRepository repository;

    public void createTransaction(CreateTransactionDTO dto) {
        try {
            Transaction transaction = new Transaction();
            transaction.setTimeStamp(LocalDateTime.now());
            transaction.setType(dto.getType());
            transaction.setActor(dto.getActor());
            repository.save(transaction);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateTransaction(UpdateTransactionDTO dto) {
        try {
            Transaction transaction = repository.findById(dto.getId())
                            .orElseThrow(() -> new RuntimeException("no transaction found!"));
            transaction.setType(dto.getType());
            transaction.setActor(dto.getActor());
            repository.save(transaction);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TransactionResponseDTO fetchTransactionById(Integer id) {
        Transaction transaction = repository.findById(id).orElse(null);
        if(transaction==null) {
            return null;
        }
        return getTransactionResponseDTO(transaction);
    }

    public List<TransactionResponseDTO> fetchTransactions() {
        return repository.findAll()
                .stream()
                .map(this::getTransactionResponseDTO)
                .collect(Collectors.toList());
    }

    private TransactionResponseDTO getTransactionResponseDTO(Transaction e) {
        TransactionResponseDTO responseDTO = new TransactionResponseDTO();
        responseDTO.setId(e.getId());
        responseDTO.setTimeStamp(e.getTimeStamp());
        responseDTO.setType(e.getType());
        responseDTO.setActor(e.getActor());
        return responseDTO;
    }

    public void deleteTransactionById(Integer id) {
        try {
            Transaction transaction = repository.findById(id)
                    .orElseThrow(() -> new RuntimeException("no transaction found!"));
            repository.delete(transaction);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public List<TransactionResponseDTO> searchTransaction(SearchTransactionDTO dto) {
        List<Transaction> transactions = repository.findAll(TransactionFilterSpecification.searchTransaction(dto));
        return transactions
                .stream()
                .map(this::getTransactionResponseDTO)
                .collect(Collectors.toList());
    }
}
