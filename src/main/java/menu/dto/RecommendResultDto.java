package menu.dto;

import menu.domain.model.MenuCategory;

import java.util.List;

public record RecommendResultDto(
        List<String> menuCategories,
        List<CoachRecommendResultDto> coachRecommendResultDtos
) {
    public static RecommendResultDto of(List<String> menuCategories, List<CoachRecommendResultDto> coachRecommendResultDtos) {
        return new RecommendResultDto(menuCategories, coachRecommendResultDtos);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ").append("카테고리 | ").append(String.join(" | ", menuCategories)).append(" ]").append("\n");

        for (CoachRecommendResultDto dto : coachRecommendResultDtos) {
            stringBuilder.append(dto.toString()).append("\n");
        }

        return stringBuilder.toString();
    }
}
