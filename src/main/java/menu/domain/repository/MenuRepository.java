package menu.domain.repository;

import menu.domain.model.Menu;

import java.util.*;

public class MenuRepository {
    private final Map<String, Menu> menus = new HashMap<>();

    public void save(Menu menu) {
        menus.put(menu.getName(), menu);
    }

    public Menu findByName(String menuName) {
        return menus.get(menuName);
    }

    public boolean isPresent(String menuName) {
        return menus.containsKey(menuName);
    }
}
