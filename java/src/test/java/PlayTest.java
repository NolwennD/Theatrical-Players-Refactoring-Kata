import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class PlayTest {

	@Test
	void shouldConvertComedy() {
		assertThat(new Play("toto", "comedy")).isEqualTo(new Play("toto", PlayType.COMEDY));
	}
	
	@Test
	void shouldConvertTragedy() {
		assertThat(new Play("toto", "tragedy")).isEqualTo(new Play("toto", PlayType.TRAGEDY));
	}
	
	@Test
	void shouldConvertUnknown() {
		assertThat(new Play("toto", "tupragedy")).isEqualTo(new Play("toto", PlayType.UNKNOWN));
	}

}
