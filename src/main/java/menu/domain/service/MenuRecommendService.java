package menu.domain.service;

import menu.domain.repository.CoachRepository;
import menu.domain.repository.MenuRepository;

public class MenuRecommendService {
    private final MenuRepository menuRepository;
    private final CoachRepository coachRepository;

    public MenuRecommendService(MenuRepository menuRepository, CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
        this.menuRepository = menuRepository;
    }
}
