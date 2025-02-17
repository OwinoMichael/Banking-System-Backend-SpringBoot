package com.mike.mike.Branch.QueryHandler;

import com.mike.mike.Branch.Branch;
import com.mike.mike.Branch.BranchRepository;
import com.mike.mike.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllBranches implements Query<Void, List<Branch>> {

    private final BranchRepository branchRepository;

    public GetAllBranches(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }


    @Override
    public ResponseEntity<List<Branch>> execute(Void input) {
        List<Branch> branches = branchRepository.findAll();
        return ResponseEntity.ok(branches);
    }
}
