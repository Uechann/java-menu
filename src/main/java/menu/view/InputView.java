package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public InputView() {}

    // 코치 이름 입력
    public String inputCoachName() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        return Console.readLine();
    }

    // 코치 못먹는 음식 입력
    public String inputCoachMenuCanNot(String coachName) {
        System.out.println(coachName + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        return Console.readLine();
    }
}
