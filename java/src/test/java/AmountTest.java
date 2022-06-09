import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class AmountTest {

	@Test
	void testAdd() {
		assertThat(Amount.ZERO.add(new Amount(100))).isEqualTo(new Amount(100));
	}

}
