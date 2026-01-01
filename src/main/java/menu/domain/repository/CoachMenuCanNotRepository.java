package menu.domain.repository;

import menu.domain.model.Coach;
import menu.domain.model.CoachMenuCanNot;

import java.util.HashMap;
import java.util.Map;

public class CoachMenuCanNotRepository {

    private final Map<Coach, CoachMenuCanNot> coachMenuCanNots = new HashMap<>();

    public void save(CoachMenuCanNot coachMenuCanNot) {
        coachMenuCanNots.put(coachMenuCanNot.getCoach(), coachMenuCanNot);
    }
}
