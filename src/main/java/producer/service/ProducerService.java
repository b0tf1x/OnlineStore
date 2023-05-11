package producer.service;

import producer.dto.ProducerDto;

import java.util.List;

public interface ProducerService {
    List<ProducerDto> findAll();

    ProducerDto findById(Long producerId);

    ProducerDto create(ProducerDto producerDto);

    ProducerDto update(ProducerDto producerDto, Long producerId);

    void delete(Long producerId);
}
