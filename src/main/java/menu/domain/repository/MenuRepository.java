package menu.domain.repository;

import menu.domain.model.Menu;
import menu.domain.model.MenuCategory;

import java.util.*;

public class MenuRepository {
    private final Map<String, Menu> menus = new HashMap<>();

    public void save(Menu menu) {
        menus.put(menu.getName(), menu);
    }

    public Menu findByName(String menuName) {
        return menus.get(menuName);
    }

    public List<Menu> findAll() {
        return new ArrayList<>(menus.values());
    }

    public List<Menu> findByCategory(MenuCategory menuCategory) {
        return new ArrayList<>(menus.values()).stream()
                .filter(menu -> menu.getCategory().equals(menuCategory))
                .toList();
    }

    public boolean isPresent(String menuName) {
        return menus.containsKey(menuName);
    }
}
