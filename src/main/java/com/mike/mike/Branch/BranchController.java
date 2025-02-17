package com.mike.mike.Branch;

import com.mike.mike.Branch.CommandHandler.AddBranch;
import com.mike.mike.Branch.CommandHandler.UpdateBranch;
import com.mike.mike.Branch.CommandHandler.UpdateBranchParameter;
import com.mike.mike.Branch.QueryHandler.GetAllBranches;
import com.mike.mike.Branch.QueryHandler.GetBranch;
import com.mike.mike.SuccessResponse.SuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branches/")
public class BranchController {

    private GetAllBranches getAllBranches;
    private GetBranch getBranch;
    private AddBranch addBranch;
    private UpdateBranch updateBranch;

    public BranchController(GetAllBranches getAllBranches, GetBranch getBranch, AddBranch addBranch, UpdateBranch updateBranch) {
        this.getAllBranches = getAllBranches;
        this.getBranch = getBranch;
        this.addBranch = addBranch;
        this.updateBranch = updateBranch;
    }

    @GetMapping("/")
    public ResponseEntity<List<Branch>> getAllBranches(){
       return getAllBranches.execute(null);
    }

    @GetMapping ("/{id}")
    ResponseEntity<Branch> getBranch(@PathVariable Integer id){
        return getBranch.execute(id);
    }

    @PostMapping("/add-branches/")
    ResponseEntity<SuccessResponse> addBranch(@RequestBody Branch branch){
        return addBranch.execute(branch);
    }

    @PutMapping("/update-branches/")
    ResponseEntity<SuccessResponse> updateBranch(@PathVariable Integer id, @RequestBody Branch branch){
        UpdateBranchParameter updateBranchParameter = new UpdateBranchParameter();
        updateBranchParameter.setId(id);
        updateBranchParameter.setBranch(branch);
        return updateBranch.execute(updateBranchParameter);

    }
}
