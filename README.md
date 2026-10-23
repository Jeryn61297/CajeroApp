# INNBANK - Simulador de cajero automático en Java

## 1. Descripción del proyecto

INNBANK es un programa de consola desarrollado en Java que simula las operaciones básicas de un cajero automático. Permite que varios clientes ingresen con su número de cliente y PIN, consulten su saldo, realicen depósitos y retiros, y transfieran dinero entre cuentas.

Este proyecto tiene fines educativos: sirve para practicar variables, constantes, arreglos, ciclos, condicionales, estructuras `switch`, entrada de datos con `Scanner` y operaciones aritméticas.

> **Importante:** los clientes, PIN y saldos están definidos directamente en el código. Los datos no se guardan en una base de datos y los saldos vuelven a sus valores iniciales cuando se reinicia el programa. No es un sistema bancario real ni debe utilizarse para manejar dinero real.

## 2. Funcionalidades

- Mostrar los clientes disponibles.
- Iniciar sesión con número de cliente y PIN.
- Permitir hasta **3 intentos** para ingresar el PIN correcto.
- Consultar el saldo de la cuenta.
- Realizar depósitos por montos mayores que cero.
- Realizar retiros por montos mayores que cero, siempre que exista saldo suficiente.
- Transferir dinero a otro cliente, validando que el destino exista, que no sea la misma cuenta, que el monto sea positivo y que haya saldo suficiente.
- Repetir el menú hasta elegir la opción **5. Salir**.

## 3. Requisitos previos

- Tener instalado el **JDK 14 o superior**, ya que el código utiliza bloques de texto y la sintaxis de `switch` con flechas. Se recomienda usar **JDK 17 o 21**.
- Tener una terminal, como Git Bash, Símbolo del sistema o PowerShell.
- Un editor de código, por ejemplo Visual Studio Code, IntelliJ IDEA o Eclipse.

Comprueba que Java esté instalado abriendo una terminal y ejecutando:

```bash
java -version
javac -version
```

Ambos comandos deben mostrar una versión compatible del JDK. Si `javac` no se reconoce, instala el JDK y configura la variable `PATH` para incluir su carpeta `bin`.

## 4. Cómo preparar el proyecto

1. Crea una carpeta para el proyecto, por ejemplo `INNBANK`.
2. Dentro de ella, crea un archivo llamado exactamente `Cajero.java`.
3. Copia el código fuente de la clase `Cajero` en ese archivo.
4. Guarda los cambios.
5. Abre una terminal dentro de la carpeta donde guardaste `Cajero.java`.

La estructura mínima debe ser:

```text
INNBANK/
└── Cajero.java
```

El nombre del archivo debe coincidir con el nombre de la clase pública: `Cajero`.

## 5. Cómo compilar y ejecutar

Desde la terminal, ubicada en la carpeta que contiene `Cajero.java`, ejecuta los siguientes pasos.

### Paso 1. Compilar

```bash
javac Cajero.java
```

Si la compilación termina correctamente, se generará el archivo `Cajero.class`.

### Paso 2. Ejecutar

```bash
java Cajero
```

No escribas la extensión `.class` al ejecutar el programa.

### Paso 3. Seguir las instrucciones de la consola

El programa mostrará los clientes disponibles. Ingresa un número de cliente, después su PIN y, si la autenticación es correcta, selecciona una operación del menú.

## 6. Clientes de prueba

Los datos de prueba están definidos en los arreglos `nombres`, `pines` y `saldos`.

| Número de cliente | Nombre | PIN de prueba | Saldo inicial |
|---:|---|---|---:|
| 1 | Ana | `1234` | $1,500.00 |
| 2 | Luis | `5678` | $320.50 |
| 3 | Sofia | `9012` | $8,000.00 |

Estos PIN son únicamente datos de demostración. No deben utilizarse como credenciales reales.

## 7. Guía de uso paso a paso

### Paso 1. Seleccionar un cliente

Al iniciar, el programa muestra la lista de clientes. Escribe el número correspondiente:

- `1` para Ana.
- `2` para Luis.
- `3` para Sofia.

Si el número no está entre 1 y 3, el programa muestra un mensaje de error y termina.

### Paso 2. Ingresar el PIN

Escribe el PIN asociado con el cliente seleccionado. Hay un máximo de tres intentos. Si el PIN es incorrecto, se muestra cuántos intentos quedan. Si se agotan, el acceso se deniega y el programa termina.

### Paso 3. Elegir una operación

Después de iniciar sesión, aparece el menú:

```text
1. Consultar saldo
2. Realizar depósito
3. Realizar retiro
4. Transferir dinero
5. Salir
```

### Opción 1. Consultar saldo

Muestra el nombre del cliente y su saldo disponible.

### Opción 2. Realizar depósito

1. Ingresa el monto que deseas depositar.
2. El monto debe ser mayor que cero.
3. Si es válido, se suma al saldo actual y se muestra el nuevo saldo.
4. Si es cero o negativo, se rechaza la operación.

### Opción 3. Realizar retiro

1. Ingresa el monto que deseas retirar.
2. El monto debe ser mayor que cero.
3. El saldo debe ser suficiente para cubrir el retiro.
4. Si se cumplen ambas condiciones, el monto se resta del saldo y se muestra el saldo actualizado.

### Opción 4. Transferir dinero

1. El programa muestra los otros clientes disponibles.
2. Ingresa el número del cliente destinatario.
3. El destino debe existir y no puede ser tu propia cuenta.
4. Ingresa el monto de la transferencia.
5. El monto debe ser mayor que cero y no puede superar tu saldo disponible.
6. Si la operación es válida, el monto se resta de la cuenta de origen y se suma a la cuenta de destino.
7. El programa muestra los datos de la transferencia y los saldos actualizados.

### Opción 5. Salir

Muestra un mensaje de despedida y termina el ciclo del menú.

Si se introduce una opción distinta de 1 a 5, el programa muestra un mensaje de opción inválida y vuelve a presentar el menú.

## 8. ¿Cómo está organizado el código?

El programa está contenido en una sola clase, `Cajero`, y utiliza los siguientes elementos:

| Elemento | Propósito |
|---|---|
| `Scanner` | Leer datos que el usuario escribe en la consola. |
| `NOMBRE_BANCO` | Constante con el nombre del banco. |
| `MAX_INTENTOS` | Constante que define el máximo de intentos de PIN. |
| `nombres[]` | Arreglo con los nombres de los clientes. |
| `pines[]` | Arreglo con los PIN de prueba. |
| `saldos[]` | Arreglo con los saldos de las cuentas. |
| `indiceCliente` | Índice del cliente que inició sesión. |
| `while` | Repetir la validación del PIN mientras queden intentos. |
| `do-while` | Repetir el menú hasta seleccionar la opción de salida. |
| `switch` | Ejecutar la operación elegida. |
| `if / else` | Validar montos, saldo, PIN y número de destino. |
| `+=` y `-=` | Actualizar los saldos al depositar, retirar o transferir. |
| `printf` | Mostrar cantidades con dos decimales. |

### ¿Por qué se resta uno al número de cliente?

Los números de cliente se muestran desde 1, pero los índices de los arreglos empiezan en 0. Por eso, el código usa:

```java
indiceCliente = numeroCliente - 1;
```

Así, el cliente 1 corresponde al índice 0, el cliente 2 al índice 1 y el cliente 3 al índice 2. La validación del número antes de acceder a los arreglos ayuda a evitar índices fuera de rango.

### ¿Cómo funciona una transferencia?

Una transferencia válida actualiza los dos saldos:

```java
saldos[indiceCliente] -= montoTransferencia;
saldos[indiceDestino] += montoTransferencia;
```

La primera línea descuenta el importe de la cuenta de origen; la segunda lo suma a la cuenta de destino.

## 9. Ejemplo de prueba

Prueba una transferencia de **$100.00** de Ana a Luis:

1. Ejecuta `java Cajero`.
2. Ingresa el número de cliente `1`.
3. Ingresa el PIN `1234`.
4. Selecciona la opción `4`.
5. Ingresa el número de destino `2`.
6. Ingresa `100` como monto.

Resultado esperado:

- Ana pasa de $1,500.00 a **$1,400.00**.
- Luis pasa de $320.50 a **$420.50**.

Para probar otras validaciones, intenta depositar `0`, retirar más de tu saldo, transferir a tu propia cuenta o ingresar un número de destino fuera del rango válido.

## 10. Limitaciones y mejoras futuras

Este es un ejercicio de aprendizaje. Algunas mejoras posibles son:

- Validar entradas no numéricas para evitar errores de entrada (`InputMismatchException`).
- Separar las responsabilidades en clases, por ejemplo `Cliente`, `CuentaBancaria` y `Cajero`.
- Guardar las operaciones y los saldos en una base de datos.
- Registrar un historial de movimientos.
- Implementar autenticación segura y no almacenar PIN en texto plano.
- Utilizar `BigDecimal` para manejar importes monetarios con mayor precisión.
- Agregar pruebas automatizadas para depósitos, retiros y transferencias.

## 11. Autoría y propósito

Proyecto educativo de Java para practicar fundamentos de programación mediante la simulación de un cajero automático por consola.

---

**Tecnología:** Java  
**Interfaz:** Consola  
**Persistencia:** No; los datos se mantienen únicamente durante la ejecución del programa.
