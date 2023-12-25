package com.arianit.CityGuideKosovo.mapper;


import com.arianit.CityGuideKosovo.dto.UserDto;
import com.arianit.CityGuideKosovo.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserDto mapUserToUserDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }
    public User mapUserDtoToUser(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }
}