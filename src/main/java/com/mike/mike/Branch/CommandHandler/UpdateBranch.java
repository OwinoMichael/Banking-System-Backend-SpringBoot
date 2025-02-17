package com.mike.mike.Branch.CommandHandler;

import com.mike.mike.Branch.Branch;
import com.mike.mike.Branch.BranchRepository;
import com.mike.mike.Command;
import com.mike.mike.Exception.ResourceNotFound;
import com.mike.mike.SuccessResponse.SuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateBranch implements Command<UpdateBranchParameter, SuccessResponse> {

    private final BranchRepository branchRepository;

    public UpdateBranch(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    public ResponseEntity<SuccessResponse> execute(UpdateBranchParameter updateBranch) {
        Branch branch = branchRepository.findById(updateBranch.getId()).orElseThrow(() -> new ResourceNotFound("Branch"));
        Branch branchRequestBody = updateBranch.getBranch();
        branchRequestBody.setBranch_id(updateBranch.getId());
        branchRepository.save(branchRequestBody);
        return ResponseEntity.ok(new SuccessResponse("true", "Branch updates successfully"));
    }
}
