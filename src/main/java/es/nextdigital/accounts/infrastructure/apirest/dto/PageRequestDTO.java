package es.nextdigital.accounts.infrastructure.apirest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
public class PageRequestDTO {
    Integer page;
    Integer pageSize;
}
