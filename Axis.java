package New_Bank_Project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

//Implementation logic

class Axis implements Bank {
    private List<User> users = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();

    @Override
    public void register(User user) {
    	users.add(user);
        accounts.add(new Account(user.getAccountNumber(),user));
        System.out.println("User registered with Axis.");
    }

    @Override
    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void deposit(String accountNumber, double amount,User user) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)&& acc.getOwner().equals(user)) {
                acc.setBalance(acc.getBalance() + amount);
                acc.getTransactions().add(new Transaction("deposit", amount, new Date()));
                System.out.println("Deposit successful.");
                return;
            }else {
            	System.out.println("User does not own this account.");
            	return;
            }
        }
        System.out.println("Account not found.");
    }

    @Override
    public void withdraw(String accountNumber, double amount,User user) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)&& acc.getOwner().equals(user)) {
                if (acc.getBalance() >= amount) {
                    acc.setBalance(acc.getBalance() - amount);
                    acc.getTransactions().add(new Transaction("withdraw", amount, new Date()));
                    System.out.println("Withdrawal successful.");
                } else {
                    System.out.println("Insufficient balance.");
                }
                return;
            }
        }
        System.out.println("Account not found Or wrong Account Number");
    }

    @Override
    public void transfer(String fromAccount, String toAccount, double amount,User user) {
        Account from = null, to = null;
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(fromAccount)&& acc.getOwner().equals(user)) {
                from = acc;
            }else {
            	System.out.println("User does not own this account.");
            	return;
            }
            if (acc.getAccountNumber().equals(toAccount)) {
                to = acc;
            }
        }
        if (from != null && to != null && from.getBalance() >= amount) {
            from.setBalance(from.getBalance() - amount);
            to.setBalance(to.getBalance() + amount);
            from.getTransactions().add(new Transaction("transfer", amount, new Date()));
            to.getTransactions().add(new Transaction("transfer", amount, new Date()));
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Transfer failed.");
        }
    }

    @Override
    public User findUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
    
    @Override
    public void forgotPassword(String username) {
        User user = findUser(username);
        boolean accFound=false;
        for(Account acc: accounts) {
        	if (user != null&& acc.getOwner().equals(user)) {
            	Scanner sc=new Scanner(System.in);
            	System.out.print("Enter new password: ");
                String password = sc.nextLine();
            	user.setPassword(password);
        		System.out.println("Password updated");
        		accFound=true;
            }else if(user ==null) {
            	System.out.println("User not found.");
            	return;
            }
        }
        if(accFound==false) {
        	System.out.println("Error: User does not own this account.");
        }
    }
    
    
    @Override
	public double checkBalance(String accountNumber,User user) {
		for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)&& acc.getOwner().equals(user)) {
                return acc.getBalance();
            }else {
            	System.out.println("User does not own this account.");
            	return 0.0;
            }
        }
        System.out.println("Account not found.");
        return 0.0;
    }
    
    @Override
    public void transactionHistory(String accountNumber,User user) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)&& acc.getOwner().equals(user)) {
                System.out.println("Transaction History for Account: " + accountNumber);
                for (Transaction transaction : acc.getTransactions()) {
                    System.out.println(transaction);
                }
                return;
            }else {
            	System.out.println("User does not own this account.");
            	return;
            }
        }
        System.out.println("Account not found.");
    }
}