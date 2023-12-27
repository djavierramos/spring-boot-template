package es.nextdigital.accounts.infrastructure.apirest.mapper;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import es.nextdigital.accounts.domain.dto.Account;
import es.nextdigital.accounts.infrastructure.apirest.dto.AccountDTO;

@Mapper(componentModel = "spring")
public abstract class AccountDtoToDomainMapper {
    public abstract AccountDTO fromDomainToDTO(Account account);
    public abstract Account fromDTOToDomain(AccountDTO accountDTO);
    public Page<AccountDTO> fromPageInDomainToPageinDTO(Page<Account> in) {
        return new PageImpl<>(in.stream().map(this::fromDomainToDTO).collect(Collectors.toList()), in.getPageable(), in.getTotalElements());
    }
}
