# TallerUnidad1_2 — Operadores y Estructuras de Decisión en Java

Taller práctico intensivo sobre operadores, estructuras condicionales (`if-else`), operador ternario, `switch` (tradicional y moderno) y depuración en Java, desarrollado con IntelliJ IDEA.

## Requisitos

- JDK 21
- IntelliJ IDEA (o cualquier IDE/editor compatible con Java)

## Estructura del proyecto

```
TallerUnidad1_2/
└── src/
    └── com/
        └── taller/
            └── practico/
                ├── Seccion1Operadores.java
                ├── Reto1ClasificacionEdades.java
                ├── Reto2AprobacionNotas.java
                ├── Reto3TarifasEntrada.java
                ├── TernarioRefactor.java
                ├── Seccion3Switch.java
                ├── RetoIntegrador.java
                ├── ErrorAsignacion.java
                ├── ErrorComparacionString.java
                ├── ErrorFallThrough.java
                └── ErrorPrecision.java
```

Cada clase contiene su propio método `main` y se puede ejecutar de forma independiente.

## Contenido

| Clase | Descripción |
|-------|-------------|
| `Seccion1Operadores` | Evaluación de residuo (`%`), incremento prefijo/posfijo, división entera vs real y short-circuit (`&&`) |
| `Reto1ClasificacionEdades` | Clasificación de usuarios por edad con `if-else if-else` |
| `Reto2AprobacionNotas` | Sistema de aprobación según calificación, asistencia y entrega de proyecto |
| `Reto3TarifasEntrada` | Cálculo de precios según tipo de boleto (VIP, ESTUDIANTE, GENERAL, ADULTO_MAYOR) |
| `TernarioRefactor` | Refactorización de `if-else` a operador ternario (`? :`) |
| `Seccion3Switch` | Gestor de días de la semana con `switch` tradicional (`break`) y moderno (`->`) |
| `RetoIntegrador` | Simulador de caja e inventario: subtotal, descuentos por cliente, cupón e IVA |
| `ErrorAsignacion` | Corrección: asignación (`=`) vs comparación (`==`) |
| `ErrorComparacionString` | Corrección: comparación de `String` con `.equals()` |
| `ErrorFallThrough` | Corrección: fall-through involuntario en `switch` tradicional |
| `ErrorPrecision` | Corrección: pérdida de precisión por división entera |

## Cómo ejecutar

### Desde IntelliJ IDEA

1. Abre el proyecto o importa la carpeta `src`.
2. Localiza cualquier clase dentro del paquete `com.taller.practico`.
3. Clic derecho sobre la clase → **Run 'NombreClase.main()'**.
4. Atajo rápido: `Shift + F10` (Windows/Linux) o `Ctrl + R` (macOS).

### Desde terminal

```bash
# Compilar
javac -encoding UTF-8 src/com/taller/practico/*.java

# Ejecutar un reto (ejemplo)
java -cp src com.taller.practico.RetoIntegrador
```

## Resultados esperados del Reto Integrador

**Caso A** — `cantidad = 3`, `tipoCliente = "VIP"`, `cupon = "PROMO1 año"`

| Concepto | Valor |
|----------|-------|
| Subtotal base | $750.00 |
| Descuento VIP (20%) | −$150.00 |
| Cupón aplicado | −$50.00 |
| Base imponible | $550.00 |
| IVA (16%) | +$88.00 |
| **Total a pagar** | **$638.00** |

**Caso B** — `cantidad = 1`, `tipoCliente = "NUEVO"`, `cupon = "PROMO1 año"`

| Concepto | Valor |
|----------|-------|
| Subtotal base | $250.00 |
| Descuento NUEVO (5%) | −$12.50 |
| Cupón (no aplica) | $0.00 |
| Base imponible | $237.50 |
| IVA (16%) | +$38.00 |
| **Total a pagar** | **$275.50** |

## Autor
Juan Dominguez
Taller práctico — Operadores y Estructuras de Decisión en Java
