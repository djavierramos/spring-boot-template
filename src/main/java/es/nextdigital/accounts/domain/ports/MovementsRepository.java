package es.nextdigital.accounts.domain.ports;

import java.util.List;
import java.util.Optional;

import es.nextdigital.accounts.domain.dto.Movement;

public interface MovementsRepository {
    Optional<Movement> getMovementsByIBAN(String IBAN);
    String putMovement(Movement Movement);
    void patchMovement(Movement Movement);
    void deleteMovement(Movement Movement);
    List<Movement> getMovements();
    void putAllMovements(List<Movement> Movements);
}
