package menu.domain.repository;

import menu.domain.model.Coach;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class CoachRepository {
    private final Map<Long, Coach> coaches = new HashMap<>();
    private final AtomicLong sequense = new AtomicLong(0L);

    public CoachRepository() {}

    public void save(Coach coach) {
        setIdByReflection(coach, sequense.incrementAndGet());
        coaches.put(coach.getId(), coach);
    }

    private void setIdByReflection(Coach coach, Long id) {
        try {
            Field idField = Coach.class.getDeclaredField("id");
            idField.setAccessible(true);
            idField.set(coach, id);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }
}
