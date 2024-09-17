package New_Bank_Project;

import java.util.Date;

class Transaction {
	
    private String type; // type of transaction
    private double amount;
    private Date date;

    public Transaction(String type, double amount, Date date) {
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type='" + type + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}

