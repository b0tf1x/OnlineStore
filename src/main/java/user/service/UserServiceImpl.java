package user.service;

import exceptions.ConflictException;
import exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.dto.UserDto;
import user.mapper.UserMapper;
import user.model.User;
import user.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDto create(UserDto userDto) {
        User user = userRepository.save(UserMapper.toUser(userDto));
        return UserMapper.toUserDto(user);
    }

    @Override
    public UserDto update(UserDto userDto, Long userId) {
        User user = checkUser(userId);
        if (userDto.getEmail() != null && userDto.getEmail().isBlank()) {
            user.setEmail(userDto.getEmail());
        }
        if (userDto.getPhoneNumber() != null && !userDto.getPhoneNumber().isBlank()) {
            user.setPhoneNumber(userDto.getPhoneNumber());
        }
        if (userDto.getDateOfBirth().isAfter(LocalDateTime.now())) {
            throw new ConflictException("Недопустимая дата");
        }
        if (userDto.getDateOfBirth() != null) {
            user.setDateOfBirth(userDto.getDateOfBirth());
        }
        if (userDto.getFirst_name() != null && !userDto.getFirst_name().isBlank()) {
            user.setFirst_name(userDto.getFirst_name());
        }
        if (userDto.getSecond_name() != null && !userDto.getSecond_name().isBlank()) {
            user.setSecond_name(userDto.getSecond_name());
        }
        user = userRepository.save(user);
        return UserMapper.toUserDto(user);
    }

    @Override
    public void delete(Long userId) {
        checkUser(userId);
        userRepository.deleteById(userId);
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(UserMapper::toUserDto)
                .collect(Collectors.toList());
    }

    private User checkUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> {
            throw new NotFoundException("Пользователь не найден");
        });
    }
}
