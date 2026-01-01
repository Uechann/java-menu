package menu.domain.model;

public enum MenuCategory {
    JAPAN(1, "일식"),
    KOREA(2, "한식"),
    CHAINA(3, "중식"),
    ASIAN(4, "아시안"),
    WESTERN(5, "양식");

    private final Integer sequence;
    private final String name;

    MenuCategory(Integer sequence, String name) {
        this.name = name;
        this.sequence = sequence;
    }

    public String getName() {
        return name;
    }

    public Integer getSequence() {
        return sequence;
    }
}
