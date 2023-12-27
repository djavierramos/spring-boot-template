package es.nextdigital.accounts.infrastructure.apirest.mapper;


import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import es.nextdigital.accounts.domain.dto.Card;
import es.nextdigital.accounts.infrastructure.apirest.dto.CardDTO;

@Mapper(componentModel = "spring")
public abstract class CardDtoToDomainMapper {
    public abstract CardDTO fromDomainToDTO(Card in);
    public abstract Card fromDTOToDomain(CardDTO in);
    public Page<CardDTO> fromPageInDomainToPageinDTO(Page<Card> in) {
        return new PageImpl<>(in.stream().map(this::fromDomainToDTO).collect(Collectors.toList()), in.getPageable(), in.getTotalElements());
    }
}
