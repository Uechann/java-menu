package menu.domain.repository;

import menu.domain.model.Coach;

import java.util.*;

public class CoachRepository {
    private final Map<String, Coach> coaches = new LinkedHashMap<>();

    public CoachRepository() {}

    public void save(Coach coach) {
        coaches.put(coach.getName(), coach);
    }

    // 이름으로 찾기
    public Optional<Coach> findByName(String coachName) {
        return Optional.ofNullable(coaches.get(coachName));
    }

    public List<Coach> findAll() {
       return new ArrayList<>(coaches.values());
    }
}
