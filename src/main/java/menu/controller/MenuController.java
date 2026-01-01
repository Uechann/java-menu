package menu.controller;

import menu.domain.service.InitialService;
import menu.domain.service.MenuRecommendService;
import menu.global.util.Parser;
import menu.global.validator.InputValidator;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

import static menu.global.util.Retry.retry;

public class MenuController {

    private final InitialService initialService;
    private final MenuRecommendService menuRecommendService;
    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;
    private final Parser<String> coachNameParser;

    public MenuController(InitialService initialService, MenuRecommendService menuRecommendService, InputView inputView, OutputView outputView, InputValidator inputValidator, Parser<String> coachNameParser) {
        this.initialService = initialService;
        this.menuRecommendService = menuRecommendService;
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidator = inputValidator;
        this.coachNameParser = coachNameParser;
    }

    public void run() {
        // 메뉴 초기화
        initialService.initialMenu();

        // 코치 이름 입력 및 초기화
        List<String> coaches = retry(() -> {
            String coachNamesInput = inputView.inputCoachNames();
            inputValidator.validateCoachNames(coachNamesInput);
            List<String> coachNames = coachNameParser.parse(coachNamesInput);
            return initialService.initialCoach(coachNames);
        });

        // 코치 이름 입력


        // 코치 못먹는 음식 입력


        // 메뉴 추천
    }
}
