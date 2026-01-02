package menu.controller;

import menu.domain.service.InitialService;
import menu.domain.service.MenuRecommendService;
import menu.dto.RecommendResultDto;
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
    private final Parser<String> coachMenuParser;

    public MenuController(InitialService initialService, MenuRecommendService menuRecommendService, InputView inputView, OutputView outputView, InputValidator inputValidator, Parser<String> coachNameParser, Parser<String> coachMenuParser) {
        this.initialService = initialService;
        this.menuRecommendService = menuRecommendService;
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidator = inputValidator;
        this.coachNameParser = coachNameParser;
        this.coachMenuParser = coachMenuParser;
    }

    public void run() {
        outputView.outputStartMessage();
        initialService.initialMenu();

        List<String> coaches = inputCoachNamesAndInitialize();
        inputCoachMenuCanNot(coaches);

        RecommendResultDto recommendResultDto = menuRecommendService.recommendMenu();
        outputView.outputMenuRecommendResult(recommendResultDto);
    }

    private void inputCoachMenuCanNot(List<String> coaches) {
        Object retry = retry(() -> {
            for (String coachName : coaches) {
                String coachMenuCanNot = inputView.inputCoachMenuCanNot(coachName);
                inputValidator.validateCoachMenuCanNot(coachMenuCanNot);
                List<String> coachMenus = coachMenuParser.parse(coachMenuCanNot);
                initialService.initialCoachMenuCanNot(coachName, coachMenus);
            }
            return null;
        });
    }

    private List<String> inputCoachNamesAndInitialize() {
        // 코치 이름 입력 및 초기화
        return retry(() -> {
            String coachNamesInput = inputView.inputCoachNames();
            inputValidator.validateCoachNames(coachNamesInput);
            List<String> coachNames = coachNameParser.parse(coachNamesInput);
            return initialService.initialCoach(coachNames);
        });
    }
}
