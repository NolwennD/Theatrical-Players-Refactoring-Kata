import java.text.NumberFormat;
import java.util.List;

public class Invoice {

	public String customer;
	public List<Performance> perfs;
	private Performances performances;

	public Invoice(String customer, List<Performance> perfs) {
		this.customer = customer;
		this.perfs = perfs;
		performances = new Performances(perfs);
	}
	
	public AmountAndCreditsAndLines amountAndCreditsAndLines(String template, NumberFormat frmt) {
		return performances.amountAndCreditsAndLines(template, frmt);
	}
}
