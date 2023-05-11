package aims.controller;

import aims.dto.AimsDto;
import aims.service.AimsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/aims")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AimsController {
    private final AimsService aimsService;

    @GetMapping
    public List<AimsDto> findAll() {
        return aimsService.findAll();
    }
    @GetMapping("/{aimId}")
    public AimsDto findById(@PathVariable Long aimId){
        return aimsService.findById(aimId);
    }
}
