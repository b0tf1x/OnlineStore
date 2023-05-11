package aims.controller;

import aims.dto.AimsDto;
import aims.service.AimsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/aims")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AdminAimsController {
    private final AimsService aimsService;
    @PostMapping
    public AimsDto create(@RequestBody @Validated AimsDto aimsDto){
        return aimsService.create(aimsDto);
    }
    @PatchMapping("/{aimId}")
    public AimsDto update(@RequestBody @Validated AimsDto aimsDto,@PathVariable Long aimId){
        return aimsService.update(aimsDto, aimId);
    }
    @DeleteMapping("/{aimId}")
    public void delete(@PathVariable Long aimId){
        aimsService.delete(aimId);
    }
}
