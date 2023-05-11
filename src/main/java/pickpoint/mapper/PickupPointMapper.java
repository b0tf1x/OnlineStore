package pickpoint.mapper;

import pickpoint.dto.PickupPointDto;
import pickpoint.model.PickupPoint;

public class PickupPointMapper {
    public static PickupPoint toModel(PickupPointDto pickupPointDto) {
        return new PickupPoint(pickupPointDto.getId(),
                pickupPointDto.getCity(),
                pickupPointDto.getAddress());
    }

    public static PickupPointDto toDto(PickupPoint pickupPoint) {
        return new PickupPointDto(pickupPoint.getId(),
                pickupPoint.getCity(),
                pickupPoint.getAddress());
    }
}
