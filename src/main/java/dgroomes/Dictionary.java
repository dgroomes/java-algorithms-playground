package dgroomes;

import java.util.regex.Pattern;
import java.util.List;
import java.util.Arrays;

public class Dictionary {

	private List<String> words;
	
	public Dictionary(List<String> words) {
		this.words = words;
	}
	
	public boolean isWord(String word) {
		return words.stream().anyMatch(word::equals);
	}
	
	public boolean isPartialOfWordBeginning(String wordPartial) {
		return words.stream().anyMatch(dictionaryWord -> Pattern.matches("^" + wordPartial + ".*", dictionaryWord));
	}
	
	public static Dictionary createDictionary() {
		return new Dictionary(Arrays.asList("it", "is", "its", "zit", "zits", "sit", "aardvark", "thumb", "speakers", "complimentary", "ski", "ray"));
	}

}
