package base;

/**
 * @author Kevan Buckley, maintained by __student
 * @version 2.0, 2014
 */

public class MultiLingualStringTable {
	private enum LanguageSetting {
		English, Klingon
	}

	private static LanguageSetting currentSelectedLanguage = LanguageSetting.English;
	private static String[] englishLanguageMessage = { "Enter your name:", "Welcome",
			"Have a good time playing Abominodo" };
	private static String[] klingonLanguageMessage = { "'el lIj pong:", "nuqneH", "QaQ poH Abominodo" };

	public static String getMessage(int index) {
		if (currentSelectedLanguage == LanguageSetting.English) {
			return englishLanguageMessage[index];
		} else {
			return klingonLanguageMessage[index];
		}

	}
}
