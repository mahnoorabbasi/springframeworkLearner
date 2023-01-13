package com.mahnoor.springmvc.domain.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductDTO {
    private String description;
    private BigDecimal price;
    private String imageUrl;


    private OffsetDateTime createdDate;
    private OffsetDateTime lastModifiedDate;


}
