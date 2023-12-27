package es.nextdigital.accounts.domain.dto;

import java.math.BigDecimal;

import lombok.Data;
import lombok.experimental.SuperBuilder;
@Data
@SuperBuilder
public class Ammount {
    BigDecimal ammount;
    String currency;
}
