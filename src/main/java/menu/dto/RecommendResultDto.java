package menu.dto;

import java.util.List;

public record RecommendResultDto(
        List<CoachRecommendResultDto> coachRecommendResultDtos
) {
    public static RecommendResultDto of(List<CoachRecommendResultDto> coachRecommendResultDtos) {
        return new RecommendResultDto(coachRecommendResultDtos);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (CoachRecommendResultDto dto : coachRecommendResultDtos) {
            stringBuilder.append(dto.toString()).append("\n");
        }

        return stringBuilder.toString();
    }
}
