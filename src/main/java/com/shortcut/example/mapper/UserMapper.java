package com.shortcut.example.mapper;

import com.shortcut.example.domain.UserEntity;
import com.shortcut.example.web.controller.model.RequestUserDto;
import com.shortcut.example.web.controller.model.ResponseUserDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity toEntity(RequestUserDto dto);

    ResponseUserDto toDto(UserEntity entity);

    List<ResponseUserDto> toListDto(List<UserEntity> entities);

    @BeanMapping(nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
    UserEntity updateEntityFromRequest(UserEntity individual, @MappingTarget UserEntity individualFromDb);
}
