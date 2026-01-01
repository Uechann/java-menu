package menu.domain.service;

import menu.domain.repository.CoachRepository;
import menu.domain.repository.MenuRepository;

public class InitialService {

    private final MenuRepository menuRepository;
    private final CoachRepository coachRepository;

    public InitialService(MenuRepository menuRepository, CoachRepository coachRepository) {
        this.menuRepository = menuRepository;
        this.coachRepository = coachRepository;
    }

    public void initialMenu() {

    }

    public void initialCoach() {

    }
}
