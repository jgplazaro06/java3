package com.java3.project.controllers;

import com.java3.project.data.TransactionRepository;
import com.java3.project.domain.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

/**
 * Created by John Lazaro on 13/06/2017.
 */

@RestController
public class TransactionController {

    @Autowired
    TransactionRepository transactionRepository;

    @RequestMapping(value = "/transactions", method = RequestMethod.GET)
    public ResponseEntity<?> getAllTransactions(){
        return new ResponseEntity<Object>(transactionRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/transactions/outgoing", method = RequestMethod.GET)
    public ResponseEntity<?> getAllOutgoingTransactions(){
        return new ResponseEntity<Object>(transactionRepository.getAllByStockingIsTrue(), HttpStatus.OK);
    }

    @RequestMapping(value = "/transactions/incoming", method = RequestMethod.GET)
    public ResponseEntity<?> getAllIncomingTransactions(){
        return new ResponseEntity<Object>(transactionRepository.getAllByStockingIsFalse(), HttpStatus.OK);
    }

    @RequestMapping(value = "/transactions/{userId}", method = RequestMethod.GET)
    public ResponseEntity<?> getAllTransactionsByUserId(@PathVariable int userId){
        return new ResponseEntity<Object>(transactionRepository.getAllByUserId(userId), HttpStatus.OK);
    }

    @RequestMapping(value = "/transactions/create", method = RequestMethod.POST)
    public void createTransaction(@RequestBody TransactionRequestBody transactionRequestBody){
        Transactions transaction = new Transactions();
        transaction.setProductId(transactionRequestBody.getProductId());
        transaction.setStocking(transactionRequestBody.isStocking());
        Timestamp referenceDate = new Timestamp(System.currentTimeMillis());
        transaction.setTransactionDate(referenceDate);
        transaction.setUserId(transactionRequestBody.getUserId());
        transaction.setQuantity(transactionRequestBody.getQuantity());
        transactionRepository.save(transaction);
    }
}
