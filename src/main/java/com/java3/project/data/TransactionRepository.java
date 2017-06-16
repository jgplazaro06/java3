package com.java3.project.data;

import com.java3.project.domain.Transactions;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by John Lazaro on 13/06/2017.
 */
public interface TransactionRepository extends CrudRepository<Transactions, Integer> {
    List<Transactions> getAllByUserId(int userId);
    List<Transactions> getAllByStockingIsFalse();
    List<Transactions> getAllByStockingIsTrue();

}
