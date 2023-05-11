package user.service;

import user.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto create(UserDto userDto);
    UserDto update(UserDto userDto, Long userId);
    void delete(Long userId);
    List<UserDto>findAll();
}
