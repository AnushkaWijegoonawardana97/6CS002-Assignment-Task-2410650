package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MultiLingualStringTableTest {

	@Test
	public void testGetMessageInEnglish() {
		MultiLingualStringTable.setCurrentSelectedLanguage(MultiLingualStringTable.LanguageSetting.English);

		assertEquals("Enter your name:", MultiLingualStringTable.getMessage(0));
		assertEquals("Welcome", MultiLingualStringTable.getMessage(1));
		assertEquals("Have a good time playing Abominodo", MultiLingualStringTable.getMessage(2));
	}

	@Test
	public void testGetMessageInKlingon() {
		MultiLingualStringTable.setCurrentSelectedLanguage(MultiLingualStringTable.LanguageSetting.Klingon);

		assertEquals("'el lIj pong:", MultiLingualStringTable.getMessage(0));
		assertEquals("nuqneH", MultiLingualStringTable.getMessage(1));
		assertEquals("QaQ poH Abominodo", MultiLingualStringTable.getMessage(2));
	}
}