package com.java3.project.controllers;

import com.java3.project.domain.Branch;
import com.java3.project.data.BranchRepository;
import com.java3.project.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BranchController {

    @Autowired
    private BranchService branchService;

    @RequestMapping(value = "/branches", method = RequestMethod.GET)
    public ResponseEntity<?> getBranches() {
        return new ResponseEntity<>
                (branchService.getBranches(), HttpStatus.OK);
    }
}