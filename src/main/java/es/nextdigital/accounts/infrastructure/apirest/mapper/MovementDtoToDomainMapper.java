package es.nextdigital.accounts.infrastructure.apirest.mapper;


import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import es.nextdigital.accounts.domain.dto.Movement;
import es.nextdigital.accounts.infrastructure.apirest.dto.MovementDTO;

@Mapper(componentModel = "spring")
public abstract class MovementDtoToDomainMapper {
    public abstract MovementDTO fromDomainToDTO(Movement in);
    public abstract Movement fromDTOToDomain(MovementDTO in);
    public Page<MovementDTO> fromPageInDomainToPageinDTO(Page<Movement> in) {
        return new PageImpl<>(in.stream().map(this::fromDomainToDTO).collect(Collectors.toList()), in.getPageable(), in.getTotalElements());
    }
}
