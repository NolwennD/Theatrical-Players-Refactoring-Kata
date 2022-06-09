import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import org.junit.jupiter.api.Test;

class PerformancesTest {

	@Test
	void shouldReturnZeroAmountAndCreditsWhenEmpty() {
		assertThat(new Performances(List.of()).amountAndCredits()).isEqualTo(AmountAndCredits.ZERO);
	}
	
	@Test
	void shouldGet() {
		var perfs = new Performances(List.of(perf1()));
		
		assertThat(perfs.amountAndCredits()).isEqualTo(perf1().amountAndCredits());
	}

	private Performance perf1() {
		return new Performance(comedy(), 10);
	}
	
	private Play comedy() {
		return new Play("toto", PlayType.COMEDY);
	}

}
