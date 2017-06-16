package com.java3.project.services;

import com.java3.project.data.BranchRepository;
import com.java3.project.domain.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by John Lazaro on 17/06/2017.
 */
@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;

    public List<Branch> getBranches(){
        return StreamSupport.stream(branchRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }


}
