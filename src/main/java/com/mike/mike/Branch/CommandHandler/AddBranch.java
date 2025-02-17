package com.mike.mike.Branch.CommandHandler;

import com.mike.mike.Branch.Branch;
import com.mike.mike.Branch.BranchRepository;
import com.mike.mike.Command;
import com.mike.mike.SuccessResponse.SuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddBranch implements Command<Branch, SuccessResponse> {

    private final BranchRepository branchRepository;

    public AddBranch(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    public ResponseEntity<SuccessResponse> execute(Branch branch) {
        branchRepository.save(branch);
        return ResponseEntity.ok(new SuccessResponse("true", "Branch added successfully"));
    }
}
