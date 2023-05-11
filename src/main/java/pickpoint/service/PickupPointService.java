package pickpoint.service;

import pickpoint.dto.PickupPointDto;

import java.util.List;

public interface PickupPointService {
    List<PickupPointDto> findAll();

    PickupPointDto findById(Long pickupPointId);

    PickupPointDto create(PickupPointDto pickupPointDto);

    PickupPointDto update(PickupPointDto pickupPointDto, Long pickupPointId);

    void delete(Long pickupPointId);
}
