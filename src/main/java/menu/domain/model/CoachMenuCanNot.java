package menu.domain.model;

import java.util.List;

public class CoachMenuCanNot {

    private final Coach coach;
    private final List<Menu> menus;

    private CoachMenuCanNot(Coach coach, List<Menu> menus) {
        this.coach = coach;
        this.menus = menus;
    }

    public static CoachMenuCanNot create(Coach coach, List<Menu> menus) {
        return new CoachMenuCanNot(coach, menus);
    }
}
