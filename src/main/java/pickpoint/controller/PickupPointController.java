package pickpoint.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pickpoint.dto.PickupPointDto;
import pickpoint.service.PickupPointService;

import java.util.List;

@RestController
@RequestMapping("/pickuppoint")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PickupPointController {
    private final PickupPointService pickupPointService;
    @GetMapping
    public List<PickupPointDto>findAll(){
        return pickupPointService.findAll();
    }
    @GetMapping("/{pickupPointId")
    public PickupPointDto findById(@PathVariable Long pickupPointId){
        return pickupPointService.findById(pickupPointId);
    }
}
