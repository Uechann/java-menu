package menu.domain.repository;

import menu.domain.model.Coach;
import menu.domain.model.MenuRecommend;

import java.util.*;

public class MenuRecommendRepository {

    private final List<MenuRecommend> menuRecommends = new ArrayList<>();

    public void save(MenuRecommend menuRecommend) {
        menuRecommends.add(menuRecommend);
    }

    public List<MenuRecommend> findByCoach(Coach coach) {
        return menuRecommends.stream()
                .filter(menuRecommend -> menuRecommend.isCoach(coach))
                .toList();
    }
}
