package aims.service;

import aims.dto.AimsDto;
import aims.mapper.AimsMapper;
import aims.model.Aim;
import aims.repository.AimsRepository;
import exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AimsServiceImpl implements AimsService {
    private final AimsRepository aimsRepository;

    @Override
    public List<AimsDto> findAll() {
        return aimsRepository.findAll().stream()
                .map(AimsMapper::toAimDto)
                .collect(Collectors.toList());
    }

    @Override
    public AimsDto findById(Long aimId) {
        return AimsMapper.toAimDto(checkAim(aimId));
    }

    @Override
    public AimsDto create(AimsDto aimsDto) {
        Aim aim = aimsRepository.save(AimsMapper.toAim(aimsDto));
        return AimsMapper.toAimDto(aim);
    }

    @Override
    public AimsDto update(AimsDto aimsDto, Long aimId) {
        Aim aim = checkAim(aimId);
        if (aimsDto.getDescription() != null && !aimsDto.getDescription().isBlank()) {
            aim.setDescription(aimsDto.getDescription());
        }
        if (aimsDto.getName() != null && !aimsDto.getName().isBlank()) {
            aim.setName(aimsDto.getName());
        }
        aim = aimsRepository.save(aim);
        return AimsMapper.toAimDto(aim);
    }

    @Override
    public void delete(Long aimId) {
        checkAim(aimId);
        aimsRepository.deleteById(aimId);
    }

    private Aim checkAim(Long aimId) {
        return aimsRepository.findById(aimId).orElseThrow(() -> {
            throw new NotFoundException("Цель не найдена");
        });
    }
}
