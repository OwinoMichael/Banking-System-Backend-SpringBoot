package com.mike.mike.Transaction;


import com.mike.mike.Account.Account;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionId;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "amount")
    private Float amount;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "related_transaction_id")
    private Transaction relatedTransaction;

    public Transaction() {
    }

    public Transaction(Integer transactionId, String transactionType, Float amount, LocalDateTime transactionDate, LocalDate createdAt, LocalDate updatedAt, Account account) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.account = account;
    }

    public Transaction(Integer transactionId, String transactionType, Float amount, LocalDateTime transactionDate, LocalDate createdAt, LocalDate updatedAt, Account account, Transaction relatedTransaction) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.account = account;
        this.relatedTransaction = relatedTransaction;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Transaction getRelatedTransaction() {
        return relatedTransaction;
    }

    public void setRelatedTransaction(Transaction relatedTransaction) {
        this.relatedTransaction = relatedTransaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(transactionId, that.transactionId) && Objects.equals(transactionType, that.transactionType) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt) && Objects.equals(account, that.account) && Objects.equals(relatedTransaction, that.relatedTransaction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, transactionType, amount, transactionDate, createdAt, updatedAt, account, relatedTransaction);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", transactionType='" + transactionType + '\'' +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", account=" + account +
                ", relatedTransaction=" + relatedTransaction +
                '}';
    }
}
