package user.mapper;

import user.dto.UserDto;
import user.model.User;

public class UserMapper {
    public static User toUser(UserDto userDto) {
        return new User(userDto.getId(),
                userDto.getEmail(),
                userDto.getPhoneNumber(),
                userDto.getFirst_name(),
                userDto.getSecond_name(),
                userDto.getDateOfBirth());
    }

    public static UserDto toUserDto(User user) {
        return new UserDto(user.getId(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getFirst_name(),
                user.getSecond_name(),
                user.getDateOfBirth());
    }
}
