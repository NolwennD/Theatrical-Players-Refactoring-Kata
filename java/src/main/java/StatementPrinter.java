import java.text.NumberFormat;
import java.util.Map;

public class StatementPrinter {
	
	private NumberFormat frmt;
	
	public StatementPrinter(NumberFormat frmt) {
		this.frmt = frmt;
	}

	public String print(Invoice invoice, Map<String, Play> plays) {
		AmountAndCreditsAndLines amountAndCreditsAndLines = invoice.amountAndCreditsAndLines("  %s: %s (%s seats)\n", frmt);
		return header(invoice) 
				+ amountAndCreditsAndLines.lines() 
				+ formatTotalAmount(amountAndCreditsAndLines.amount().get(), frmt) 
				+ formatTotalCredits(amountAndCreditsAndLines.credits().get());
	}

	private String header(Invoice invoice) {
		return String.format("Statement for %s\n", invoice.customer);
	}

	private String formatTotalCredits(int volumeCredits) {
		return String.format("You earned %s credits\n", volumeCredits);
	}

	private String formatTotalAmount(int totalAmount, NumberFormat frmt) {
		return String.format("Amount owed is %s\n", frmt.format(totalAmount / 100));
	}
}
