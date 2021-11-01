package dgroomes.boggle;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public record Dictionary(
        List<String> words) {

    public boolean isWord(String word) {
        return words.stream().anyMatch(word::equals);
    }

    public boolean isPartialOfWordBeginning(String wordPartial) {
        return words.stream().anyMatch(dictionaryWord -> Pattern.matches("^" + wordPartial + ".*", dictionaryWord));
    }

    public static Dictionary createDictionary() {
        return new Dictionary(List.of("it", "is", "its", "zit", "zits", "sit", "aardvark", "thumb", "speakers", "complimentary", "ski", "ray"));
    }

}
