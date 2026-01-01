package menu.domain.repository;

import menu.domain.model.Coach;
import menu.domain.model.CoachMenuCanNot;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CoachMenuCanNotRepository {

    private final Map<Coach, CoachMenuCanNot> coachMenuCanNots = new HashMap<>();

    public void save(CoachMenuCanNot coachMenuCanNot) {
        coachMenuCanNots.put(coachMenuCanNot.getCoach(), coachMenuCanNot);
    }

    public Optional<CoachMenuCanNot> findByCoach(Coach coach) {
        return Optional.ofNullable(coachMenuCanNots.get(coach));
    }
}
