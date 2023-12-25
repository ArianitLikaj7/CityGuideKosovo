package com.arianit.CityGuideKosovo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {
    private long userId;
    private String firstName;
    private String lastName;
    private String email;

    @JsonIgnore
    public String getPassword() {
        return "The password is in JsonIgnore";
    }
}
