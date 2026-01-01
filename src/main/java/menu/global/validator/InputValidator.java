package menu.global.validator;

import static menu.global.exception.ErrorMessage.INVALID_COACH_NAME;

public class InputValidator {

    public void validateCoachNames(String input) {
        // 이름 최소 2글자, 최대 4글자
        // 코치는 최소 2명, 최대 5명까지 함께 식사
        // 쉼표와 공백을 제외한 모든 문자
        // 쉼표로 구분된 문자열
        String coachNameInputRegex = "^[^,\\s]{2,4}(,[^,\\s]{2,4})$";

        if (!input.matches(coachNameInputRegex)) {
            throw new IllegalArgumentException(INVALID_COACH_NAME.getMessage());
        }
    }
}
