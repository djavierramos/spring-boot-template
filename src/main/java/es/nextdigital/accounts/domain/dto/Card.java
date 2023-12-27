package es.nextdigital.accounts.domain.dto;

import es.nextdigital.accounts.infrastructure.apirest.dto.AccountDTO;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
public class Card {
    @Id
    String id;
    String PAN;
    AccountDTO relatedAccount;  
    Boolean active;      
}
