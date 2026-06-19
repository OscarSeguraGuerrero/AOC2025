# Advent of Code 2025 - IS2

Repositorio para la resolución de los problemas de [Advent of Code 2025](https://adventofcode.com/2025), aplicando los principios y patrones de diseño vistos en la asignatura de **Ingeniería del Software II**.

## Estructura del proyecto

El proyecto sigue una arquitectura modular y orientada a objetos:

- `shared/`: Interfaces e implementaciones genéricas compartidas entre diferentes días (ej. `PuzzleReader`).
- `dayXX/`: Resolución específica del día.
  - `model/`: Clases de dominio puros (habitualmente `records`) sin dependencias externas.
  - `Part1.java` / `Part2.java`: Clases de aplicación (ensambladoras) que resuelven cada parte.
  - `README.md`: Documentación de las decisiones de diseño y patrones aplicados para ese día.

## Días resueltos

- [Día 1: Secret Entrance](src/main/java/software/ulpgc/aoc2025/day01/README.md)
