package producer.service;

import exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import producer.dto.ProducerDto;
import producer.mapper.ProducerMapper;
import producer.model.Producer;
import producer.repository.ProducerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ProducerServiceImpl implements ProducerService {
    private final ProducerRepository producerRepository;

    @Override
    public List<ProducerDto> findAll() {
        return producerRepository.findAll().stream()
                .map(ProducerMapper::toProducerDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProducerDto findById(Long producerId) {
        return ProducerMapper.toProducerDto(checkProducer(producerId));
    }

    @Override
    public ProducerDto create(ProducerDto producerDto) {
        Producer producer = producerRepository.save(ProducerMapper.toProducer(producerDto));
        return ProducerMapper.toProducerDto(producer);
    }

    @Override
    public ProducerDto update(ProducerDto producerDto, Long producerId) {
        Producer producer = checkProducer(producerId);
        if (producerDto.getCountry() != null) {
            producer.setCountry(producerDto.getCountry());
        }
        if (producerDto.getName() != null) {
            producer.setName(producerDto.getName());
        }
        producer = producerRepository.save(producer);
        return ProducerMapper.toProducerDto(producer);
    }

    @Override
    public void delete(Long producerId) {
        checkProducer(producerId);
        producerRepository.deleteById(producerId);
    }

    private Producer checkProducer(Long producerId) {
        return producerRepository.findById(producerId).orElseThrow(() -> {
            throw new NotFoundException("Производитель не найден");
        });
    }

}
