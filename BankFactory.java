package New_Bank_Project;

// Object creational logic

/*class BankFactory {
	
	// Factory or helper method
	
    public static Bank getBank(String bankName) {
        if (bankName.equalsIgnoreCase("SBI")) {
            return new SBI();
        } else if (bankName.equalsIgnoreCase("Axis")) {
            return new Axis();
        }
        return null;
    }
}*/

import java.util.HashMap;
import java.util.Map;

public class BankFactory {
	
    private static Map<String, Bank> visitedBanks = new HashMap<>();

    public static Bank getBank(String bankName) {
        if (visitedBanks.containsKey(bankName)) {
            return visitedBanks.get(bankName);
        }

        Bank bank = null;
        switch (bankName.toLowerCase()) {
            case "axis":
                bank = new Axis();
                break;
            case "sbi":
                bank = new SBI();
                break;
        }

        if (bank != null) {
            visitedBanks.put(bankName, bank);
        }

        return bank;
    }
}

