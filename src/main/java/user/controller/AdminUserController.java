package user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import user.dto.UserDto;
import user.model.User;
import user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/admin/user")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AdminUserController {
    private final UserService userService;
    @PostMapping
    public UserDto create(@RequestBody @Validated UserDto userDto){
        return userService.create(userDto);
    }
    @PatchMapping("/{userId}")
    public UserDto update(@RequestBody @Validated UserDto userDto, @PathVariable Long userId){
        return userService.update(userDto, userId);
    }
    @DeleteMapping("/{userId}")
    public void delete(@PathVariable Long userId){
        userService.delete(userId);
    }
    @GetMapping
    public List<UserDto> findAll(){
        return userService.findAll();
    }
}
