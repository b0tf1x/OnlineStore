package producer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import producer.dto.ProducerDto;
import producer.service.ProducerService;

import java.util.List;

@RestController
@RequestMapping("/producer")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ProducerController {
    private final ProducerService producerService;
    @GetMapping
    public List<ProducerDto>findAll(){
        return producerService.findAll();
    }
    @GetMapping("/{producerId}")
    public ProducerDto findById(@PathVariable Long producerId){
        return producerService.findById(producerId);
    }
}
