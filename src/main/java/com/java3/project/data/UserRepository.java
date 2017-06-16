package com.java3.project.data;

import com.java3.project.domain.Users;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by John Lazaro on 16/06/2017.
 */
public interface UserRepository extends CrudRepository<Users, Integer>{
    Users getByUserId(int userId);

}
