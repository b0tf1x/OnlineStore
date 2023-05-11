package pickpoint.service;

import exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pickpoint.dto.PickupPointDto;
import pickpoint.mapper.PickupPointMapper;
import pickpoint.model.PickupPoint;
import pickpoint.repository.PickupPointRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PickupPointServiceImpl implements PickupPointService {
    private final PickupPointRepository pickupPointRepository;

    @Override
    public List<PickupPointDto> findAll() {
        return pickupPointRepository.findAll().stream()
                .map(PickupPointMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PickupPointDto findById(Long pickupPointId) {
        return PickupPointMapper.toDto(checkPickupPoint(pickupPointId));
    }

    @Override
    public PickupPointDto create(PickupPointDto pickupPointDto) {
        PickupPoint pickupPoint = pickupPointRepository.save(PickupPointMapper.toModel(pickupPointDto));
        return PickupPointMapper.toDto(pickupPoint);
    }

    @Override
    public PickupPointDto update(PickupPointDto pickupPointDto, Long pickupPointId) {
        PickupPoint pickupPoint = checkPickupPoint(pickupPointId);
        if (pickupPointDto.getAddress() != null && !pickupPointDto.getAddress().isBlank()) {
            pickupPoint.setAddress(pickupPointDto.getAddress());
        }
        if (pickupPointDto.getCity() != null && !pickupPointDto.getCity().isBlank()) {
            pickupPoint.setCity(pickupPointDto.getCity());
        }
        pickupPoint = pickupPointRepository.save(pickupPoint);
        return PickupPointMapper.toDto(pickupPoint);
    }

    @Override
    public void delete(Long pickupPointId) {
        checkPickupPoint(pickupPointId);
        pickupPointRepository.deleteById(pickupPointId);
    }

    private PickupPoint checkPickupPoint(Long id) {
        return pickupPointRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Пункт не найден");
        });
    }

}
