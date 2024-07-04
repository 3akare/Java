package com.onlinebanking.bank.service.impl;

import com.onlinebanking.bank.dto.TransactionDTO;
import com.onlinebanking.bank.entity.Transaction;
import com.onlinebanking.bank.repository.TransactionRepository;
import com.onlinebanking.bank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public void saveTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = Transaction.builder()
                .transactionType(transactionDTO.transactionType())
                .accountNumber(transactionDTO.accountNumber())
                .status(transactionDTO.status())
                .amount(transactionDTO.amount())
                .build();
        transactionRepository.save(transaction);
    }
}
