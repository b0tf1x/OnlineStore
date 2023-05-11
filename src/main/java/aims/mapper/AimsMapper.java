package aims.mapper;

import aims.dto.AimsDto;
import aims.model.Aim;

public class AimsMapper {
    public static Aim toAim(AimsDto aimsDto) {
        return new Aim(aimsDto.getId(),
                aimsDto.getName(),
                aimsDto.getDescription());
    }

    public static AimsDto toAimDto(Aim aim) {
        return new AimsDto(aim.getId(),
                aim.getName(),
                aim.getDescription());
    }
}
