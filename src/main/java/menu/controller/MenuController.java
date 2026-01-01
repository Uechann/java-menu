package menu.controller;

import menu.domain.service.InitialService;
import menu.domain.service.MenuRecommendService;

public class MenuController {

    private final InitialService initialService;
    private final MenuRecommendService menuRecommendService;

    public MenuController(InitialService initialService, MenuRecommendService menuRecommendService) {
        this.initialService = initialService;
        this.menuRecommendService = menuRecommendService;
    }

    public void run() {

        // 메뉴 초기화


        // 코치 이름 입력


        // 코치 못먹는 음식 입력


        // 메뉴 추천
    }
}
