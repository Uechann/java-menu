package menu.domain.model;

import static menu.global.exception.ErrorMessage.INVALID_COACH_NAME_LENGTH;

public class Coach {

    private String name;

    private Coach(String name) {
        this.name = name;
    }

    public static Coach create(String name) {
        if (!name.matches("^\\S{2,4}$")) {
            throw new IllegalArgumentException(INVALID_COACH_NAME_LENGTH.getMessage());
        }

        return new Coach(name);
    }

    public String getName() {
        return name;
    }
}
