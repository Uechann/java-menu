package menu.domain.service;

import menu.domain.repository.CoachMenuCanNotRepository;
import menu.domain.repository.CoachRepository;
import menu.domain.repository.MenuRepository;

public class MenuRecommendService {
    private final MenuRepository menuRepository;
    private final CoachRepository coachRepository;
    private final CoachMenuCanNotRepository coachMenuCanNotRepository;

    public MenuRecommendService(MenuRepository menuRepository, CoachRepository coachRepository, CoachMenuCanNotRepository coachMenuCanNotRepository) {
        this.coachRepository = coachRepository;
        this.menuRepository = menuRepository;
        this.coachMenuCanNotRepository = coachMenuCanNotRepository;
    }

    public void recommendMenu() {

    }
}
