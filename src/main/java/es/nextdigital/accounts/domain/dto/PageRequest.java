package es.nextdigital.accounts.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
public class PageRequest {
    Integer page;
    Integer pageSize;
}
