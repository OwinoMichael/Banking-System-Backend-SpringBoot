package com.mike.mike.Branch;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "branch")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch_id")
    private Integer branch_id;

    @Column(name = "branch_name")
    private String branchName;

    @Column(name = "branch_code")
    private String branchCode;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    public Branch() {
    }

    public Branch(Integer branch_id, String branchName, String branchCode, String phone, String address, LocalDate createdAt, LocalDate updatedAt) {
        this.branch_id = branch_id;
        this.branchName = branchName;
        this.branchCode = branchCode;
        this.phone = phone;
        this.address = address;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(Integer person_id) {
        this.branch_id = person_id;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return Objects.equals(branch_id, branch.branch_id) && Objects.equals(branchName, branch.branchName) && Objects.equals(branchCode, branch.branchCode) && Objects.equals(address, branch.address) && Objects.equals(phone, branch.phone) && Objects.equals(createdAt, branch.createdAt) && Objects.equals(updatedAt, branch.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(branch_id, branchName, branchCode, address, phone, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "Branch{" +
                "person_id=" + branch_id +
                ", branchName='" + branchName + '\'' +
                ", branchCode='" + branchCode + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
