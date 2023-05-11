package producer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import producer.dto.ProducerDto;
import producer.service.ProducerService;

@RestController
@RequestMapping("/admin/producer")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AdminProducerController {
    private final ProducerService producerService;
    @PostMapping
    public ProducerDto create(@RequestBody @Validated ProducerDto producerDto){
        return producerService.create(producerDto);
    }
    @PatchMapping("/{producerId}")
    public ProducerDto update(@RequestBody @Validated ProducerDto producerDto, @PathVariable Long producerId){
        return producerService.update(producerDto,producerId);
    }
    @DeleteMapping("/{producerId}")
    public void delete(@PathVariable Long producerId){
        producerService.delete(producerId);
    }
}
