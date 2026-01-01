package menu.global.util;

import java.util.Arrays;
import java.util.List;

public class CoachMenuParser implements Parser<String> {

    private static final String DELIMITER = ",";

    @Override
    public List<String> parse(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .toList();
    }
}
