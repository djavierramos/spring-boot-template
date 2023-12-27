package es.nextdigital.accounts.domain.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@Builder
@SuperBuilder
public class Movement {
    String id;
    String movementType;
    Ammount ammount;
    Ammount balance;
    String IBAN;
}
