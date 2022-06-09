
public record AmountAndCreditsAndLines(AmountAndCredits ac, String lines) {

	public Credits credits() {
		return ac.credits();
	}
	
	public Amount amount() {
		return ac.amount();
	}

}
