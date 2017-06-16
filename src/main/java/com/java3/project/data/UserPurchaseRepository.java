package com.java3.project.data;

import com.java3.project.domain.UserPurchase;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by John Lazaro on 13/06/2017.
 */
public interface UserPurchaseRepository extends CrudRepository<UserPurchase, Integer> {
    List<UserPurchase> getAllByUserId(int UserID);
}
