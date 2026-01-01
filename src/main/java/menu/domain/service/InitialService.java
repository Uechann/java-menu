package menu.domain.service;

import menu.domain.model.Coach;
import menu.domain.model.CoachMenuCanNot;
import menu.domain.model.Menu;
import menu.domain.model.MenuCategory;
import menu.domain.repository.CoachMenuCanNotRepository;
import menu.domain.repository.CoachRepository;
import menu.domain.repository.MenuRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static menu.global.exception.ErrorMessage.*;

public class InitialService {

    private final MenuRepository menuRepository;
    private final CoachRepository coachRepository;
    private final CoachMenuCanNotRepository coachMenuCanNotRepository;

    public InitialService(MenuRepository menuRepository, CoachRepository coachRepository, CoachMenuCanNotRepository coachMenuCanNotRepository) {
        this.menuRepository = menuRepository;
        this.coachRepository = coachRepository;
        this.coachMenuCanNotRepository = coachMenuCanNotRepository;
    }

    /*
        한식: 김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음
        일식: 규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼
        중식: 깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채
        아시안: 팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜
        양식: 라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니
    * */
    public void initialMenu() {
        initialKoreaMenu();
        initialJapanMenu();
        initialChainaMenu();
        initialAsiaMenu();
        initialWesternMenu();
    }


    public List<String> initialCoach(List<String> coachNames) {
        if (coachNames.size() < 2 || coachNames.size() > 5) {
            throw new IllegalArgumentException(INVALID_COACH_COUNT.getMessage());
        }

        for (String coachName : coachNames) {
            Coach coach = Coach.create(coachName);
            coachRepository.save(coach);
        }
        return coachNames;
    }

    public void initialCoachMenuCanNot(String coachName, List<String> coachMenuCanNot) {
        Coach coach = coachRepository.findByName(coachName)
                .orElseThrow(() -> new IllegalArgumentException(COACH_NOT_FOUND.getMessage()));

        if (!coachMenuCanNot.isEmpty()) {
            if (coachMenuCanNot.size() > 2) {
                throw new IllegalArgumentException(MENU_COUNT_OVER.getMessage());
            }
            List<Menu> canNotMenus = coachMenuCanNot.stream()
                    .filter(menuRepository::isPresent)
                    .map(menuRepository::findByName)
                    .toList();
            coachMenuCanNotRepository.save(CoachMenuCanNot.create(coach, canNotMenus));
        }

    }

    private void initialWesternMenu() {
        menuRepository.save(Menu.create(MenuCategory.WESTERN, "라자냐"));
        menuRepository.save(Menu.create(MenuCategory.WESTERN, "그라탱"));
        menuRepository.save(Menu.create(MenuCategory.WESTERN, "뇨끼"));
        menuRepository.save(Menu.create(MenuCategory.WESTERN, "끼슈"));
        menuRepository.save(Menu.create(MenuCategory.WESTERN, "프렌치 토스트"));
        menuRepository.save(Menu.create(MenuCategory.WESTERN, "바게트"));
        menuRepository.save(Menu.create(MenuCategory.WESTERN, "스파게티"));
        menuRepository.save(Menu.create(MenuCategory.WESTERN, "피자"));
        menuRepository.save(Menu.create(MenuCategory.WESTERN, "파니니"));
    }

    private void initialAsiaMenu() {
        menuRepository.save(Menu.create(MenuCategory.ASIAN, "팟타이"));
        menuRepository.save(Menu.create(MenuCategory.ASIAN, "카오 팟"));
        menuRepository.save(Menu.create(MenuCategory.ASIAN, "나시고렝"));
        menuRepository.save(Menu.create(MenuCategory.ASIAN, "파인애플 볶음밥"));
        menuRepository.save(Menu.create(MenuCategory.ASIAN, "쌀국수"));
        menuRepository.save(Menu.create(MenuCategory.ASIAN, "똠얌꿍"));
        menuRepository.save(Menu.create(MenuCategory.ASIAN, "반미"));
        menuRepository.save(Menu.create(MenuCategory.ASIAN, "월남쌈"));
        menuRepository.save(Menu.create(MenuCategory.ASIAN, "분짜"));
    }

    private void initialChainaMenu() {
        menuRepository.save(Menu.create(MenuCategory.CHAINA, "깐풍기"));
        menuRepository.save(Menu.create(MenuCategory.CHAINA, "볶음면"));
        menuRepository.save(Menu.create(MenuCategory.CHAINA, "동파육"));
        menuRepository.save(Menu.create(MenuCategory.CHAINA, "짜장면"));
        menuRepository.save(Menu.create(MenuCategory.CHAINA, "짬뽕"));
        menuRepository.save(Menu.create(MenuCategory.CHAINA, "마파두부"));
        menuRepository.save(Menu.create(MenuCategory.CHAINA, "탕수육"));
        menuRepository.save(Menu.create(MenuCategory.CHAINA, "토마토 달걀볶음"));
        menuRepository.save(Menu.create(MenuCategory.CHAINA, "고추잡채"));
    }

    private void initialJapanMenu() {
        menuRepository.save(Menu.create(MenuCategory.JAPAN, "규동"));
        menuRepository.save(Menu.create(MenuCategory.JAPAN, "우동"));
        menuRepository.save(Menu.create(MenuCategory.JAPAN, "미소시루"));
        menuRepository.save(Menu.create(MenuCategory.JAPAN, "스시"));
        menuRepository.save(Menu.create(MenuCategory.JAPAN, "가츠동"));
        menuRepository.save(Menu.create(MenuCategory.JAPAN, "오니기리"));
        menuRepository.save(Menu.create(MenuCategory.JAPAN, "하이라이스"));
        menuRepository.save(Menu.create(MenuCategory.JAPAN, "라멘"));
        menuRepository.save(Menu.create(MenuCategory.JAPAN, "오코노미야끼"));
    }

    private void initialKoreaMenu() {
        menuRepository.save(Menu.create(MenuCategory.KOREA, "김밥"));
        menuRepository.save(Menu.create(MenuCategory.KOREA, "김치찌개"));
        menuRepository.save(Menu.create(MenuCategory.KOREA, "쌈밥"));
        menuRepository.save(Menu.create(MenuCategory.KOREA, "된장찌개"));
        menuRepository.save(Menu.create(MenuCategory.KOREA, "비빔밥"));
        menuRepository.save(Menu.create(MenuCategory.KOREA, "칼국수"));
        menuRepository.save(Menu.create(MenuCategory.KOREA, "불고기"));
        menuRepository.save(Menu.create(MenuCategory.KOREA, "떡볶이"));
        menuRepository.save(Menu.create(MenuCategory.KOREA, "제육볶음"));
    }
}
