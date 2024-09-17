package New_Bank_Project;

import java.util.ArrayList;
import java.util.List;

class Account {
	
    private String accountNumber;
    private double balance;
    private List<Transaction> transactions;
    private User owner;

    public Account(String accountNumber,User owner) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
        this.owner=owner;
    }
    
    public User getOwner() {
    	return owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}