package menu.domain.repository;

import menu.domain.model.Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuRepository {
    private final List<Menu> menus = new ArrayList<>();

    public void save(Menu menu) {
        menus.add(menu);
    }

    public void saveAll(List<Menu> menus) {
        menus.addAll(menus);
    }
}
