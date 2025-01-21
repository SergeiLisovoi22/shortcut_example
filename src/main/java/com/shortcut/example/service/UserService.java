package com.shortcut.example.service;

import com.shortcut.example.domain.UserEntity;
import com.shortcut.example.exception.UserNotFoundException;
import com.shortcut.example.mapper.UserMapper;
import com.shortcut.example.repository.UserRepository;
import com.shortcut.example.web.controller.model.RequestUserDto;
import com.shortcut.example.web.controller.model.ResponseUserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
//    private static final Logger logger = LoggerFactory.getLogger(UserService.class.getName());
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional(readOnly = true)
    public ResponseUserDto getUser(Long userId) {
        log.info("Get user by id");
        return userMapper.toDto(getEntity(userId));
    }

    @Transactional(readOnly = true)
    public List<ResponseUserDto> getAllUsers() {
        log.info("Get all users");
        return userMapper.toListDto(userRepository.findAll());
    }

    @Transactional
    public ResponseUserDto createUser(RequestUserDto userDto) {
        log.info("Create user");
        UserEntity user = userMapper.toEntity(userDto);
        return userMapper.toDto(userRepository.save(user));
    }

    @Transactional
    public ResponseUserDto updateUser(Long userId, RequestUserDto userDto) {
        log.info("Update task");
        UserEntity targetEntity = getEntity(userId);
        UserEntity user = userMapper.toEntity(userDto);
        return userMapper.toDto(userRepository.save(userMapper.updateEntityFromRequest(user, targetEntity)));
    }

    @Transactional
    public void deleteUser(Long userId) {
        log.info("");
        userRepository.deleteById(userId);
    }

    private UserEntity getEntity(Long userId) {
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        return userEntity.orElseThrow(() -> new UserNotFoundException(String.valueOf(userId)));
    }
}
