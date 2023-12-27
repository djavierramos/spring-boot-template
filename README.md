# API de movimientos Bancarios

## Controllers

- Cards Controllers -> Gestiona las tarjetas
  - Get tarjeta por PAN
  - Patch de la tarjeta (Activación, cambio de PIN, etc)
- Accounts Controllers -> Gestiona las cuentas
  - Get Cuenta por IBAN
  - Get Movimientos de la cuenta
  - Realización de movimientos en la cuenta
    - Los movimientos de extracción de débito se realizan sobre la cuenta asociada al pan referido en el header PAN

## Repositories

## Construcción del proyecto

- Java -> mvn clean package (empaquetado spring boot)
- Docker -> uso del Dockerfile en la raíz del proyecto