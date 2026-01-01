package menu.domain.model;

public class Menu {

    private final MenuCategory category;
    private final String name;

    private Menu(MenuCategory category, String name) {
        this.category = category;
        this.name = name;
    }

    public static Menu create(MenuCategory menuCategory, String name) {
        return new Menu(menuCategory, name);
    }

    public MenuCategory getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }
}
