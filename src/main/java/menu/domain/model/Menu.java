package menu.domain.model;

public class Menu {

    private final MenuCategory category;
    private final String name;

    public Menu(MenuCategory category, String name) {
        this.category = category;
        this.name = name;
    }

    public MenuCategory getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }
}
