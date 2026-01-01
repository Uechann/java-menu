package menu.domain.model;

import java.time.DayOfWeek;

public class MenuRecommend {

    // 요일
    private DayOfWeek dayOfWeek;

    // 카테고리
    private MenuCategory category;

    // 코치
    private Coach coach;

    // 메뉴
    private Menu menu;

    private MenuRecommend(DayOfWeek dayOfWeek, MenuCategory category, Coach coach, Menu menu) {
        this.dayOfWeek = dayOfWeek;
        this.category = category;
        this.coach = coach;
        this.menu = menu;
    }

    public static MenuRecommend create(DayOfWeek dayOfWeek, MenuCategory category, Coach coach, Menu menu) {
        return new MenuRecommend(dayOfWeek, category, coach, menu);
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public MenuCategory getCategory() {
        return category;
    }

    public Coach getCoach() {
        return coach;
    }

    public Menu getMenu() {
        return menu;
    }

    public boolean isCoach(Coach coach) {
        return this.coach.equals(coach);
    }
}
