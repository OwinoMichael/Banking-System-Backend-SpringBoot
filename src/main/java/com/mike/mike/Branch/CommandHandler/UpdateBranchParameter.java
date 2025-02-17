package com.mike.mike.Branch.CommandHandler;

import com.mike.mike.Branch.Branch;

public class UpdateBranchParameter {

    private Integer id;
    private Branch branch;

    public UpdateBranchParameter() {
    }

    public UpdateBranchParameter(Integer id, Branch branch) {
        this.id = id;
        this.branch = branch;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
