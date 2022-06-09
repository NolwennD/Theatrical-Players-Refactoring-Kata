

public class Performance {

    private static final int COMEDY_BASE_AMOUNT = 30000;
	private static final int TRAGEDY_BASE_AMOUNT = 40000;
    private int audience;
	private Play play;
    
    public Performance(Play play, String playID, int audience) {
		this.play = play;
		this.audience = audience;
	}

	public Performance(Play play, int audience) {
		this.play = play;
		this.audience = audience;
	}

	private int creditsInInt() {
		if (isComedy()) {
			return comedyCredits();
		}
		return baseCredits();
	}
	
	public Credits credits() {
		return new Credits(creditsInInt());
	}
	
	public AmountAndCredits amountAndCredits() {
		return new AmountAndCredits(amount(), credits());
	}

	private boolean isComedy() {
		return play.type() == PlayType.COMEDY;
	}

	private int comedyCredits() {
		return (int) (baseCredits() + Math.floor(audience / 5));
	}

	private int baseCredits() {
		return Math.max(audience - 30, 0);
	}

	private int amountInt() throws Error {
		return switch (play.type()) {
			case TRAGEDY -> computeTragedyAmount();
			case COMEDY -> computeComedyAmount();
			case UNKNOWN -> throw new Error("unknown type: ${play.type}");
		};
	}
	
	public Amount amount() {
		return new Amount(amountInt());
	}

	private int computeTragedyAmount() {
		if (audience > 30) {
			return TRAGEDY_BASE_AMOUNT + 1000 * (audience - 30);
		}
		return TRAGEDY_BASE_AMOUNT;
	}

	private int computeComedyAmount() {
		if (audience > 20) {
			return amountForMoreThanTwenty();
		}
		return comedyAmount(COMEDY_BASE_AMOUNT);
	}

	private int amountForMoreThanTwenty() {
		return comedyAmount(COMEDY_BASE_AMOUNT + 10000 + 500 * (audience - 20));
	}

	private int comedyAmount(int amount) {
		return amount + 300 * audience;
	}

	public Play play() {
		return play;
	}

	public int audience() {
		return audience;
	}
}
