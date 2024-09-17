package New_Bank_Project;

import java.util.Scanner;

public class BankingApp {
	
//Consumer or Utilization logic	

	private static Bank currentBank;
	private static Bank previousBank;
	private static Bank selectedBank;
	private static boolean re_run=false;
	//Scanner sc = new Scanner(System.in);
	
	private static void chooseBank(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose a bank: SBI or Axis");
        String bankName = sc.nextLine();
        selectedBank = BankFactory.getBank(bankName);

            if (selectedBank == null) {
            	System.out.println("invalid bank type.");
            	chooseBank();
            }else {
                if (re_run) {
                    previousBank = currentBank;
                    currentBank = selectedBank;
                } else {
                    currentBank = selectedBank;
                    previousBank = currentBank;
                }
            }
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true) {
			chooseBank();
			while(true) {
				if (currentBank != null) {
	                User loggedInUser = null;
	                
	                while (loggedInUser == null) {
	                    System.out.println("1. Register");
	                    System.out.println("2. Login");
	                    System.out.println("3. Reselect-Bank");
	                    System.out.print("Enter your choice: ");
	                    int choice = sc.nextInt();
	                    sc.nextLine();

	                    switch (choice) {
	                        case 1:
	                            System.out.print("Enter username: ");
	                            String username = sc.nextLine();
	                            long randomAccNumber = (long)(Math.random() * 1000);
	                            String accountNumber=String.valueOf(randomAccNumber);                           
	                            int randomInt = (int)(Math.random() * 9000) + 1000;
	                            String password = String.valueOf(randomInt);
	                            System.out.println("Default PIN generated: "+password );
	                            System.out.println("Default AccountNo. generated: "+accountNumber);
	                            User user = new User(username, password, accountNumber);
	                            currentBank.register(user);
	                            break;
	                        case 2:
	                            System.out.print("Enter username: ");
	                            username = sc.nextLine();
	                            System.out.print("Enter password: ");
	                            password = sc.nextLine();
	                            loggedInUser = currentBank.login(username, password);
	                            if (loggedInUser != null) {
	                                System.out.println("Login successful.");
	                                boolean loggedIn = true;
	                                
	                                while (loggedIn) {
	                                	System.out.println("1. Deposit");
	                                    System.out.println("2. Withdraw");
	                                    System.out.println("3. Transfer");
	                                    System.out.println("4. Find User");
	                                    System.out.println("5. Forgot Password");
	                                    System.out.println("6. Check Balance");
	                                    System.out.println("7. Transaction History");
	                                    System.out.println("8. Logout");
	                                    System.out.print("Enter your choice: ");
	                                    int inner_choice = sc.nextInt();
	                                    sc.nextLine(); 

	                                    switch (inner_choice) {
	                                        case 1:
	                                            System.out.print("Enter account number: ");
	                                            accountNumber = sc.nextLine();
	                                            System.out.print("Enter amount to deposit: ");
	                                            double amount = sc.nextDouble();
	                                            currentBank.deposit(accountNumber, amount,loggedInUser);
	                                            break;
	                                        case 2:
	                                            System.out.print("Enter account number: ");
	                                            accountNumber = sc.nextLine();
	                                            System.out.print("Enter amount to withdraw: ");
	                                            amount = sc.nextDouble();
	                                            currentBank.withdraw(accountNumber, amount,loggedInUser);
	                                            break;
	                                        case 3:
	                                            System.out.print("Enter from account number: ");
	                                            String fromAccount = sc.nextLine();
	                                            System.out.print("Enter to account number: ");
	                                            String toAccount = sc.nextLine();
	                                            System.out.print("Enter amount to transfer: ");
	                                            amount = sc.nextDouble();
	                                            currentBank.transfer(fromAccount, toAccount, amount,loggedInUser);
	                                            break;
	                                        case 4:
	                                            System.out.print("Enter username: ");
	                                            username = sc.nextLine();
	                                            user = currentBank.findUser(username);
	                                            if (user != null) {
	                                                System.out.println("User found--> " +"usrName: "+ user.getUsername()+" "+"accNo: "+user.getAccountNumber());
	                                            } else {
	                                                System.out.println("User not found.");
	                                            }
	                                            break;
	                                        case 5:
	                                            System.out.print("Enter username: ");
	                                            username = sc.nextLine();
	            	                            currentBank.forgotPassword(username);
	                                            break;
	                                        case 6:
	                                            System.out.print("Enter account number: ");
	                                            accountNumber = sc.nextLine();
	                                            double balance = currentBank.checkBalance(accountNumber,loggedInUser);
	                                            System.out.println("Current balance: " + balance);
	                                            break;
	                                        case 7:
	                                        	System.out.print("Enter account number: ");
	                                            accountNumber = sc.nextLine();
	                                            currentBank.transactionHistory(accountNumber,loggedInUser);
	                                            break;
	                                        case 8:
	                                        	loggedIn = false;
	                                            loggedInUser = null;
	                                            System.out.println("Logged out successfully.");
	                                            break;
	                                        default:
	                                            System.out.println("Invalid choice.");
	                                    }
	                                }
	                            }else
	                            	System.out.println("Login failed. Please try again.");
	                            break;
	                        case 3:
	                        	chooseBank();
	                        	re_run=true;
	                        	//loggedInUser=null;
	            				break;
	                        default:
	                            System.out.println("Invalid choice.");
	                    }
	                  }
	                
	            } else {
	                System.out.println("Invalid bank choice.");
	            }
			}
		}
	}
}
