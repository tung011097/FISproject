package org.example;

import java.time.LocalDateTime;

public class Transaction {
    private String type;
    private String account;
    private int amount;
    private String message;
    private LocalDateTime dateTime;

    public Transaction(String type, String account, int amount, String message, LocalDateTime dateTime) {
        this.type = type;
        this.account = account;
        this.amount = amount;
        this.message = message;
        this.dateTime = dateTime;
    }

    public Transaction() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type='" + type + '\'' +
                ", account='" + account + '\'' +
                ", amount=" + amount +
                ", message='" + message + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
