package es.nextdigital.accounts.infrastructure.apirest.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class AccountDTO {
    private String IBAN;
    private AmmountDTO balance;
}
