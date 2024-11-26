import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


public class CharacterSpliterator implements Spliterator<Character> {

    private final String string;
    private int current;

    public CharacterSpliterator(String string) {
        this.string = string;
        this.current = 0;
    }

    @Override
    // Взятие следующего символа и передача его для обработки.
    public boolean tryAdvance(Consumer<? super Character> action) {
        if (current < string.length()) {
            action.accept(string.charAt(current++));
            return true;
        }
        return false;
    }

    @Override
    // При возможности разделение строки на две части
    public Spliterator<Character> trySplit() {
        int remaining = string.length() - current;
        if (remaining <= 1) {
            return null;
        }
        int splitPosition = current + remaining / 2;
        String subString = string.substring(current, splitPosition);
        current = splitPosition;
        return new CharacterSpliterator(subString);
    }

    @Override
    // Счетчик оставшихся символов
    public long estimateSize() {
        return string.length() - current;
    }

    @Override
    // Сообщает свойства (характеристики) сплитератора
    public int characteristics() {
        return ORDERED | SIZED | SUBSIZED | NONNULL | IMMUTABLE;
    }


    public static Stream<Character> streamOff(String string) {
        CharacterSpliterator spliterator = new CharacterSpliterator(string);
        return StreamSupport.stream(spliterator, true);
    }
}
