package New_Bank_Project;


interface Bank {
    void register(User user);
    User login(String username, String password);
    void deposit(String accountNumber, double amount,User user);
    void withdraw(String accountNumber, double amount, User user);
    void transfer(String fromAccount, String toAccount, double amount,User user);
    User findUser(String username);
    void forgotPassword(String username);
    double checkBalance(String accountNumber,User user);
    void transactionHistory(String accountNumber,User user);
}
