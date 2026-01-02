package menu.dto;

import java.util.List;

public record CoachRecommendResultDto(
        String coachName,
        List<String> recommendMenus
) {
    public static CoachRecommendResultDto of(String coachName, List<String> recommendMenus) {
        return new CoachRecommendResultDto(coachName, recommendMenus);
    }

    public void addMenuName(String menuName) {
        recommendMenus.add(menuName);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ").append(coachName).append(" | ");
        stringBuilder.append(String.join(" | ", recommendMenus)).append(" ] ");
        return stringBuilder.toString();
    }
}
