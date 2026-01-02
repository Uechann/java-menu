package menu.domain.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.model.*;
import menu.domain.model.Menu;
import menu.domain.repository.CoachMenuCanNotRepository;
import menu.domain.repository.CoachRepository;
import menu.domain.repository.MenuRecommendRepository;
import menu.domain.repository.MenuRepository;
import menu.dto.CoachRecommendResultDto;
import menu.dto.RecommendResultDto;
import menu.global.util.NumberGenerator;

import java.time.DayOfWeek;
import java.util.*;
import java.util.List;

public class MenuRecommendService {
    private final MenuRepository menuRepository;
    private final CoachRepository coachRepository;
    private final CoachMenuCanNotRepository coachMenuCanNotRepository;
    private final MenuRecommendRepository menuRecommendRepository;
    private final NumberGenerator randomNumberGenerator;

    public MenuRecommendService(
            MenuRepository menuRepository,
            CoachRepository coachRepository,
            CoachMenuCanNotRepository coachMenuCanNotRepository,
            MenuRecommendRepository menuRecommendRepository,
            NumberGenerator randomNumberGenerator
    ) {
        this.coachRepository = coachRepository;
        this.menuRepository = menuRepository;
        this.coachMenuCanNotRepository = coachMenuCanNotRepository;
        this.menuRecommendRepository = menuRecommendRepository;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public RecommendResultDto recommendMenu() {
        Map<MenuCategory, Integer> categoryCount = new EnumMap<>(MenuCategory.class);
        for (MenuCategory menuCategory : MenuCategory.values()) {
            categoryCount.put(menuCategory, 0);
        }

        List<Coach> coaches = coachRepository.findAll();
        List<String> menuCategories = new ArrayList<>();
        // 요일별 진행
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            if (dayOfWeek.equals(DayOfWeek.SATURDAY)) {
                break;
            }
            MenuCategory category = recommendMenuCategory(categoryCount, menuCategories);
            List<Menu> recommendMenus = new ArrayList<>();
            for (Coach coach : coaches) {
                Menu recommendMenu = recommendCategoryMenu(coach, category, recommendMenus);
                menuRecommendRepository.save(MenuRecommend.create(dayOfWeek, category, coach, recommendMenu));
            }
        }

        List<CoachRecommendResultDto> coachRecommendResultDtos = new ArrayList<>();
        for (Coach coach : coaches) {
            List<MenuRecommend> menuRecommends = menuRecommendRepository.findByCoach(coach);
            List<String> recommendMenuNames = menuRecommends.stream()
                    .sorted(Comparator.comparing(MenuRecommend::getDayOfWeek))
                    .map(MenuRecommend::getMenu)
                    .map(Menu::getName)
                    .toList();
            coachRecommendResultDtos.add(CoachRecommendResultDto.of(coach.getName(), recommendMenuNames));
        }
        return RecommendResultDto.of(menuCategories, coachRecommendResultDtos);
    }

    private Menu recommendCategoryMenu(Coach coach, MenuCategory category, List<Menu> recommendMenus) {
        Menu recommendMenu;
        while (true) {
            List<Menu> categoryMenus = menuRepository.findByCategory(category);
            List<String> MenuNames = categoryMenus.stream()
                    .map(Menu::getName)
                    .toList();

            String menu = Randoms.shuffle(MenuNames).get(0);
            // 못 먹는 음식 조회
            CoachMenuCanNot coachMenuCanNot = coachMenuCanNotRepository.findByCoach(coach)
                    .orElse(null);

            // 추천했던 메뉴인지 조회
            List<MenuRecommend> menuRecommends = menuRecommendRepository.findByCoach(coach);
            List<String> recommendMenuNames = menuRecommends.stream()
                    .map(MenuRecommend::getMenu)
                    .map(Menu::getName)
                    .toList();

            // 못먹는 음식이 아니고 추천 했던 메뉴가 아니면 break
            if ((coachMenuCanNot == null || !coachMenuCanNot.containsMenu(menu))
                    && !recommendMenuNames.contains(menu)) {
                recommendMenu = menuRepository.findByName(menu);
                recommendMenus.add(recommendMenu);
                break;
            }
        }
        return recommendMenu;
    }

    private MenuCategory recommendMenuCategory(Map<MenuCategory, Integer> categoryCount, List<String> menuCategories) {
        MenuCategory category;
        while (true) {
            int number = randomNumberGenerator.generate();
            category = Arrays.stream(MenuCategory.values())
                    .filter(menuCategory -> menuCategory.getSequence().equals(number))
                    .findFirst()
                    .orElse(null);

            // 최대 2회가 넘는지 검증
            int count = categoryCount.get(category);
            if (count < 2) {
                categoryCount.replace(category, count + 1);
                menuCategories.add(category.getName());
                break;
            }
        }
        return category;
    }
}
