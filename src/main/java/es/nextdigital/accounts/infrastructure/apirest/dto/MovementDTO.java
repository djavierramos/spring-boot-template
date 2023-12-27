package es.nextdigital.accounts.infrastructure.apirest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@SuperBuilder
public class MovementDTO {
    String id;
    String type;
    AmmountDTO ammount;
    AmmountDTO balance;
}
