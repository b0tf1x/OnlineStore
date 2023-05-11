package aims.service;

import aims.dto.AimsDto;

import java.util.List;

public interface AimsService {
    List<AimsDto> findAll();
    AimsDto findById(Long aimId);
    AimsDto create(AimsDto aimsDto);
    AimsDto update(AimsDto aimsDto, Long aimId);
    void delete(Long aimId);

}
