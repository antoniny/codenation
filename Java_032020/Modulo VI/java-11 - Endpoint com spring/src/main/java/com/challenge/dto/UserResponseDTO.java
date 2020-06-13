package com.challenge.dto;

import com.challenge.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class UserResponseDTO {

    private Long id;
    private String fullname;
    private String email;
    private String nickname;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdAt;

    public UserResponseDTO(User user) {
        super();
        this.id = user.getId();
        this.fullname = user.getFullName();
        this.email = user.getEmail();
        this.nickname = user.getNickname();
        this.createdAt = user.getCreatedAt();
    }

}
