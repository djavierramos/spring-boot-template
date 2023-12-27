package es.nextdigital.accounts.domain.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Account {
    String id;
    String IBAN;
    Ammount balance;
}
