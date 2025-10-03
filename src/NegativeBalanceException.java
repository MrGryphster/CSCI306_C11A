import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NegativeBalanceException extends Exception {
	
	private double negativeBalance;
	
	public NegativeBalanceException() {
		super("Error: negative balance");
	}
	
	public NegativeBalanceException(int balance) {
		super("Amount exceeds balance by " + balance);
		negativeBalance = balance;
		
		File f = new File("logfile.txt");
		try {
			f.createNewFile(); 
			FileWriter writer = new FileWriter(f);
			
			writer.write(this.getMessage());
			writer.close();
			
		} catch (IOException e) {
			System.out.println("Error: IO Exception. This message REALLY shouldn't be showing up. Fiddlesticks.");
		}
	}
	
	@Override
	public String toString() {
		return "Balance of " + negativeBalance + " not allowed";
	}
	
}
