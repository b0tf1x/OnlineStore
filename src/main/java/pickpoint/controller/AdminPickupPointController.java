package pickpoint.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pickpoint.dto.PickupPointDto;
import pickpoint.service.PickupPointService;

@RestController
@RequestMapping("/admin/pickuppoint")
@RequiredArgsConstructor
public class AdminPickupPointController {
    private final PickupPointService pickupPointService;
    @PostMapping
    public PickupPointDto create(@RequestBody @Validated PickupPointDto pickupPointDto){
        return pickupPointService.create(pickupPointDto);
    }
    @PatchMapping("/{pickupPointId}")
    public PickupPointDto update(@RequestBody @Validated PickupPointDto pickupPointDto, @PathVariable Long pickupPointId){
        return pickupPointService.update(pickupPointDto, pickupPointId);
    }
    @DeleteMapping("/{pickupPointId")
    public void delete(@PathVariable Long pickupPointId){
        pickupPointService.delete(pickupPointId);
    }
}
