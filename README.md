# Librería de Transferencia de dinero para Android

Esta es una librería de Android que proporciona funcionalidades para transferir dinero entre usuarios en aplicaciones bancarias.

## Características

* Transferencia de dinero entre usuarios.
* Consulta de saldo de usuario.
* Historial de transacciones.

## Instalación

Agrega la dependencia a tu archivo build.gradle:

``` groovy
dependencies {
    implementation 'com.example:transfer-lib:1.0.0'
}
```

## Uso
### Inicialización

```kotlin
val transferUseCase = TransferUseCase(context)
```

### Transferencia de Dinero
``` kotlin
val senderId = "sender123"
val recipientId = "recipient456"
val amount = 100.0

val transferRequest = TransferRequest(senderId, recipientId, amount)

transferUseCase.transfer(transferRequest) { result ->
    if (result.isSuccess) {
        // Transferencia exitosa
    } else {
        // Manejar error
    }
}
```

### Consulta de Saldo
```kotlin
val userId = "user123"

val balanceRequest = BalanceRequest(userId)

transferUseCase.getBalance(balanceRequest) { balance ->
    // Utilizar el saldo obtenido
}
```

### Historial de Transacciones
```kotlin
val userId = "user123"

val transactionHistoryRequest = TransactionHistoryRequest(userId)

transferUseCase.getTransactionHistory(transactionHistoryRequest) { transactions ->
    // Utilizar el historial de transacciones obtenido
}
```

## Contribución

¡Contribuciones son bienvenidas! Si tienes sugerencias, problemas o deseas contribuir al proyecto, por favor abre un issue o envía un pull request.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT.



