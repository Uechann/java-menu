package menu.global.config;

import menu.controller.MenuController;
import menu.domain.repository.CoachRepository;
import menu.domain.repository.MenuRepository;
import menu.domain.service.InitialService;
import menu.domain.service.MenuRecommendService;

public final class DIConfig {

    private final CoachRepository coachRepository = new CoachRepository();
    private final MenuRepository menuRepository = new MenuRepository();

    public CoachRepository coachRepository() {
        return coachRepository;
    }

    public MenuRepository menuRepository() {
        return menuRepository;
    }

    public InitialService initialService() {
        return new InitialService(
                menuRepository(),
                coachRepository()
        );
    }

    public MenuRecommendService menuRecommendService() {
        return new MenuRecommendService(
                menuRepository(),
                coachRepository()
        );
    }

    public MenuController menuController() {
        return new MenuController(
                initialService(),
                menuRecommendService()
        );
    }
}
