import java.util.Map;
import java.util.stream.Collectors;

public class first_task {
    public static void main(String[] args) {
        String input = "Hello, World! 123";

        Map<Character, Long> result = CharacterSpliterator.streamOff(input)
                .filter(Character::isLetter) // Оставляем только буквы
                .map(Character::toUpperCase) // Преобразовываем в верхний регистр
                .collect(Collectors.groupingBy(c -> c, Collectors.counting())); // Подсчет частоты символов

        result.forEach((character, count) ->
                System.out.println(character + ": " + count));
    }
}