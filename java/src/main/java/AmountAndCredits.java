
public record AmountAndCredits(Amount amount, Credits credits) {

	public static final AmountAndCredits ZERO = new AmountAndCredits(Amount.ZERO, Credits.ZERO);
	
	public AmountAndCredits add(AmountAndCredits other) {
		return new AmountAndCredits(amount.add(other.amount()), credits.add(other.credits()));
	}

}
