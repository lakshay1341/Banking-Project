package New_Bank_Project;

class User {
	
    private String username;
    private String password;
    private String accountNumber;

    public User(String username, String password, String accountNumber) {
        this.username = username;
        this.password = password;
        this.accountNumber = accountNumber;
    }
    
    public User(String username, String accountNumber) {
        this.username = username;
        this.accountNumber = accountNumber;
    }
    
    public void setPassword(String password) {
    	this.password=password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    
}
