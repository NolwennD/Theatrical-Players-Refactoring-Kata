import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static org.approvaltests.Approvals.verify;

public class StatementPrinterTests {
	
	private StatementPrinter printer;

	@BeforeEach
	void init() {
		printer = new StatementPrinter(NumberFormat.getCurrencyInstance(Locale.US));
	}

    @Test
    void exampleStatement() {
        Play hamlet = new Play("Hamlet", PlayType.TRAGEDY);
		Play asYouLikeIt = new Play("As You Like It", PlayType.COMEDY);
		Play othello = new Play("Othello", PlayType.TRAGEDY);
		Map<String, Play> plays = Map.of(
                "hamlet",  hamlet,
                "as-like", asYouLikeIt,
                "othello", othello);

        Invoice invoice = new Invoice("BigCo", List.of(
                new Performance(hamlet, "hamlet", 55),
                new Performance(asYouLikeIt, "as-like", 35),
                new Performance(othello, "othello", 40)));

        var result = printer.print(invoice, plays);

        verify(result);
    }

    @Test
    void statementWithNewPlayTypes() {
        Play henryV = new Play("Henry V", "history");
		Play asYouLikeIt = new Play("As You Like It", "pastoral");
		Map<String, Play> plays = Map.of(
                "henry-v",  henryV,
                "as-like", asYouLikeIt);

        Invoice invoice = new Invoice("BigCo", List.of(
                new Performance(henryV, "henry-v", 53),
                new Performance(asYouLikeIt, "as-like", 55)));

        Assertions.assertThrows(Error.class, () -> {
            printer.print(invoice, plays);
        });
    }
    
    @Test
    void statementWithNewPlayTypes1() {
    	Play henry = new Play("Henry V", PlayType.TRAGEDY);
		Play asYouLike = new Play("As You Like It", PlayType.COMEDY);
		Map<String, Play> plays = Map.of(
    			"henry-v",  henry,
    			"as-like", asYouLike);
    	
    	Invoice invoice = new Invoice("BigCo", List.of(
    			new Performance(henry, "henry-v", 20),
    			new Performance(asYouLike, "as-like", 10)));
    	
    	var result = printer.print(invoice, plays);
    	
    	verify(result);
    }
}
