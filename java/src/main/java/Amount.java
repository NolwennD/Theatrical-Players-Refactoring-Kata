
public record Amount(int amount) {

	public static final Amount ZERO = new Amount(0);
	
	public Amount add(Amount other) {
		return new Amount(amount + other.amount());
	}

	public int get() {
		return amount();
	}

}
