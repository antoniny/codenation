package com.challenge.dto;

import com.challenge.entity.Challenge;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class ChallengeDTO {

    private Long id;
    private String name;
    private String slug;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdAt;

    public ChallengeDTO(Challenge challenge) {
        this.id = challenge.getId();
        this.name = challenge.getName();
        this.slug = challenge.getSlug();
        this.createdAt = challenge.getCreatedAt();
    }
}
