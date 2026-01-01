package menu.global.exception;

public enum ErrorMessage {

    // 공통
    INPUT_EMPTY_OR_BLANK("[ERROR] 입력값이 비어있거나 공백입니다."),

    // 코치
    INVALID_COACH_NAME("[ERROR] 코치 이름 입력 형식에 맞지 않습니다."),
    INVALID_COACH_COUNT("[ERROR] 코치는 최소 2명 최대 5명만 가능합니다."),
    INVALID_COACH_NAME_LENGTH("[ERROR] 코치 이름은 최소 2자 최대 4자 입니다."),
    INVALID_COACH_MENU_CAN_NOT("[ERROR] 코치가 못먹는 메뉴 형식에 맞지 않습니다."),
    COACH_NOT_FOUND("[ERROR] 해당 코치가 없습니다."),

    // 메뉴
    MENU_NOT_FOUND("[ERROR] 해당 메뉴가 없습니다."),
    MENU_COUNT_OVER("[ERROR] 메뉴 개수는 최대 2개입니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
