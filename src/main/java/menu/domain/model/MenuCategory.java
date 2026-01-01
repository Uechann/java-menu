package menu.domain.model;

public enum MenuCategory {
    KOREA("한식"),
    JAPAN("일식"),
    CHAINA("중식"),
    ASIAN("아시안"),
    WESTERN("양식");

    private final String name;

    MenuCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
