package menu.domain.model;

public class Coach {

    private Long id;
    private String name;

    public Coach(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
