package menu;

import menu.controller.MenuController;
import menu.global.config.DIConfig;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        DIConfig diConfig = new DIConfig();
        MenuController menuController = diConfig.menuController();
        menuController.run();
    }
}
