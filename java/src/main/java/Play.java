public record Play(String name, PlayType type) {

    public Play(String name, String type) {
        this(name, buildType(type));
    }

	private static PlayType buildType(String type) {
		return switch (type) {
			case "comedy" -> PlayType.COMEDY;
			case "tragedy" -> PlayType.TRAGEDY;
			default -> PlayType.UNKNOWN;
		};
	}
}
