package menu.global.config;

import menu.controller.MenuController;
import menu.domain.model.Coach;
import menu.domain.repository.CoachMenuCanNotRepository;
import menu.domain.repository.CoachRepository;
import menu.domain.repository.MenuRecommendRepository;
import menu.domain.repository.MenuRepository;
import menu.domain.service.InitialService;
import menu.domain.service.MenuRecommendService;
import menu.global.util.*;
import menu.global.validator.InputValidator;
import menu.view.InputView;
import menu.view.OutputView;

public final class DIConfig {

    private final CoachRepository coachRepository = new CoachRepository();
    private final MenuRepository menuRepository = new MenuRepository();
    private final CoachMenuCanNotRepository coachMenuCanNotRepository = new CoachMenuCanNotRepository();
    private final MenuRecommendRepository menuRecommendRepository = new MenuRecommendRepository();

    public CoachRepository coachRepository() {
        return coachRepository;
    }

    public MenuRepository menuRepository() {
        return menuRepository;
    }

    public CoachMenuCanNotRepository coachMenuCanNotRepository() {
        return coachMenuCanNotRepository;
    }

    public MenuRecommendRepository menuRecommendRepository() {
        return menuRecommendRepository;
    }

    public InitialService initialService() {
        return new InitialService(
                menuRepository(),
                coachRepository(),
                coachMenuCanNotRepository()
        );
    }

    public MenuRecommendService menuRecommendService() {
        return new MenuRecommendService(
                menuRepository(),
                coachRepository(),
                coachMenuCanNotRepository(),
                menuRecommendRepository(),
                randomNumberGenerator()
        );
    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public InputValidator inputValidator() {
        return new InputValidator();
    }

    public Parser<String> coachNameParser() {
        return new CoachNameParser();
    }

    public Parser<String> coachMenuParser() {
        return new CoachMenuParser();
    }

    public NumberGenerator randomNumberGenerator() {
        return new RandomNumberGenerator();
    }

    public MenuController menuController() {
        return new MenuController(
                initialService(),
                menuRecommendService(),
                inputView(),
                outputView(),
                inputValidator(),
                coachNameParser(),
                coachMenuParser()
        );
    }
}
