import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CreditsTest {

	@Test
	void shouldGetAmountOf100WhenAddingZeroAnd100() {
		assertThat(Credits.ZERO.add(new Credits(100))).isEqualTo(new Credits(100));
	}

}
