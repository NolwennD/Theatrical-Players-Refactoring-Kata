import java.text.NumberFormat;
import java.util.Collection;
import java.util.stream.Collectors;

public record Performances(Collection<Performance> performances) {

	public AmountAndCredits amountAndCredits() {
		return performances.stream()
				.collect(Collectors.teeing(Collectors.reducing(Amount.ZERO, Performance::amount, Amount::add),
						Collectors.reducing(Credits.ZERO, Performance::credits, Credits::add), AmountAndCredits::new));
	}
	
	public AmountAndCreditsAndLines amountAndCreditsAndLines(String template, NumberFormat frmt) {
		return performances.stream()
				.collect(Collectors.teeing(
						Collectors.reducing(AmountAndCredits.ZERO, Performance::amountAndCredits, AmountAndCredits::add),
						Collectors.reducing("", perf -> lines(template, frmt, perf), String::concat), 
						AmountAndCreditsAndLines::new));
	}

	private String lines(String template, NumberFormat frmt, Performance perf) {
		return String.format(template, perf.play().name(), frmt.format(perf.amount().get() / 100), perf.audience());
	}
}
