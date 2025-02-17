package com.mike.mike.Branch.QueryHandler;

import com.mike.mike.Branch.Branch;
import com.mike.mike.Branch.BranchRepository;
import com.mike.mike.Exception.ResourceNotFound;
import com.mike.mike.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GetBranch implements Query<Integer, Branch> {

    private final BranchRepository branchRepository;

    public GetBranch(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }


    @Override
    public ResponseEntity<Branch> execute(Integer id) {
        Branch branch = branchRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Branch"));
        return ResponseEntity.ok(branch);
    }
}
