import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class AmountAndCreditsTest {

	@Test
	void testAdd() {
		assertThat(AmountAndCredits.ZERO.add(new AmountAndCredits(new Amount(100), new Credits(100))))
				.isEqualTo(new AmountAndCredits(new Amount(100), new Credits(100)));
	}

}
