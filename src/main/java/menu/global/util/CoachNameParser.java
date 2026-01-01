package menu.global.util;

import java.util.Arrays;
import java.util.List;

public class CoachNameParser implements Parser<String> {

    private static final String DELIMITER = ",";

    @Override
    public List<String> parse(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .toList();
    }
}
