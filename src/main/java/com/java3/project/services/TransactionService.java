package com.java3.project.services;

import com.java3.project.controllers.TransactionRequestBody;
import com.java3.project.data.TransactionRepository;
import com.java3.project.domain.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * Created by John Lazaro on 17/06/2017.
 */
@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    public void createTransaction(int productId, boolean stocking, int userId, int quantity) {
        Transactions transaction = new Transactions();
        transaction.setProductId(productId);
        transaction.setStocking(stocking);
        Timestamp referenceDate = new Timestamp(System.currentTimeMillis());
        transaction.setTransactionDate(referenceDate);
        transaction.setUserId(userId);
        transaction.setQuantity(quantity);
        transactionRepository.save(transaction);
    }
}