
public record Credits(int credits) {

	public static final Credits ZERO = new Credits(0);

	public Credits add(Credits other) {
		return new Credits(credits + other.credits());
	}

	public int get() {
		return credits;
	}
}
