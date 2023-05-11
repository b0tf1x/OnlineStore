package producer.mapper;

import producer.dto.ProducerDto;
import producer.model.Producer;

public class ProducerMapper {
    public static Producer toProducer(ProducerDto producerDto) {
        return new Producer(producerDto.getId(),
                producerDto.getName(),
                producerDto.getCountry());
    }

    public static ProducerDto toProducerDto(Producer producer) {
        return new ProducerDto(producer.getId(),
                producer.getName(),
                producer.getCountry());
    }
}
