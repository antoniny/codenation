package com.challenge.dto;

import com.challenge.entity.Acceleration;
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
public class AccelerationDTO {

    private Long id;
    private String name;
    private String slug;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdAt;

    public AccelerationDTO(Acceleration acceleration) {
        this.id = acceleration.getId();
        this.name = acceleration.getName();
        this.slug = acceleration.getSlug();
        this.createdAt = acceleration.getCreatedAt();
    }
}
