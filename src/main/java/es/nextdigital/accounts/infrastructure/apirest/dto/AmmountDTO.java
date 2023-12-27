package es.nextdigital.accounts.infrastructure.apirest.dto;

import java.math.BigDecimal;

import lombok.Data;
import lombok.experimental.SuperBuilder;
@Data
@SuperBuilder
public class AmmountDTO {
    BigDecimal ammount;
    String currency;
}
