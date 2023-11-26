package base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class QuoteContentTest {

	@Test
	public void testQuoteContentArray() {
		assertNotNull("The 'stuff' array should not be null", QuoteContent.stuff);
		assertEquals("The 'stuff' array should have 18 elements", 18, QuoteContent.stuff.length);
	}

	@Test
	public void testSpecificQuote() {
		// Replace these values with the specific quote and author you want to test
		String expectedQuote = "Progress comes from the intelligent use of experience.";
		String expectedAuthor = "Elbert Hubbard";

		assertNotNull("The 'stuff' array should not be null", QuoteContent.stuff);

		// Check the first quote in the 'stuff' array
		assertEquals("The quote should match", expectedQuote, QuoteContent.stuff[0]);
		// Check the corresponding author
		assertEquals("The author should match", expectedAuthor, QuoteContent.stuff[1]);
	}
}