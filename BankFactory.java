package New_Bank_Project;

// Object creational logic

class BankFactory {
	
	// Factory or helper method
	
    public static Bank getBank(String bankName) {
        if (bankName.equalsIgnoreCase("SBI")) {
            return new SBI();
        } else if (bankName.equalsIgnoreCase("Axis")) {
            return new Axis();
        }
        return null;
    }
}
