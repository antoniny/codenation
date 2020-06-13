package com.challenge.dto;

import com.challenge.entity.Company;
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
public class CompanyDTO {

    private Long id;
    private String name;
    private String slug;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdAt;

    public CompanyDTO(Company company) {
        this.id = company.getId();
        this.name = company.getName();
        this.slug = company.getSlug();
        this.createdAt = company.getCreatedAt();
    }
}
