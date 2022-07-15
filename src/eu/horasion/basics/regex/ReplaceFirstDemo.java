package eu.horasion.basics.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * ReplaceFirstDemo
 */
public class ReplaceFirstDemo {

	public static void main(String[] args) {
		GetNumberOfWordsFromString();
	}

	static void clearConsole() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	static void GetNumberOfWordsFromString() {
		final String text = " The quick   brown fox jumps  over the lazy dog.";
		String result;

		clearConsole();

		result = truncateAfterWords(1, text);
		System.out.println("1 = " + result);
		result = truncateAfterWords(2, text);
		System.out.println("2 = " + result);
		result = truncateAfterWords(4, text);
		System.out.println("4 = " + result);
		result = truncateAfterWords(6, text);
		System.out.println("6 = " + result);
		System.out.println("-------------");

		try {
			result = truncateAfterWords2(1, text);
			System.out.println("1 = " + result);
			result = truncateAfterWords2(2, text);
			System.out.println("2 = " + result);
			result = truncateAfterWords2(4, text);
			System.out.println("4 = " + result);
			result = truncateAfterWords2(6, text);
			System.out.println("6 = " + result);
		} catch (Exception e) {
			System.err.println("custom error handler");
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Truncate a string after n number of words.
	 * @param numWords
	 *          number of words to truncate after.
	 * @param inputText
	 *          the text.
	 * @return truncated text.
	 */
	static String truncateAfterWords(int numWords, String inputText) {
		// This regex matches the whole string and captures into capturing group1
		// everything that comes after the first 'numWords' words.
		String regex = String.format("((?:\\W*\\w+){%s})(.*)", numWords);

		// `replaceFirst` or `replaceAll` accepts a regex string,
		// but `replace` works differently (no regex), it won't work here.
		return inputText.replaceFirst(regex, "$1");
	}

	/**
	 * Same as version above but using a different approach.
	 * @param numWords number of words to truncate after.
	 * @param inputText the text.
	 * @return truncated text.
	 * @throws Exception
	 */
	static String truncateAfterWords2(int numWords, String inputText) throws Exception {
		// This regex directly matches the first 'numWord' words, no capt groups.
		String regex = String.format("(?:\\W*\\w+){%s}", numWords);
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(inputText);
		if (!matcher.find()) {
			throw new Exception("truncateAfterWords2; no regex match");
		}
		// Calling .group() in case of no match result would also throw an error.
		return matcher.group();
	}

}

/*

1 =  The
2 =  The quick
4 =  The quick   brown fox
6 =  The quick   brown fox jumps  over
-------------
1 =  The
2 =  The quick
4 =  The quick   brown fox
6 =  The quick   brown fox jumps  over

*/
