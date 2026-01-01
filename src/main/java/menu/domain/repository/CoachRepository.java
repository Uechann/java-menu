package menu.domain.repository;

import menu.domain.model.Coach;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class CoachRepository {
    private final Map<String, Coach> coaches = new HashMap<>();

    public CoachRepository() {}

    public void save(Coach coach) {
        coaches.put(coach.getName(), coach);
    }

    // 이름으로 찾기
    public Optional<Coach> findByName(String coachName) {
        return Optional.ofNullable(coaches.get(coachName));
    }

}
