# Day 1: Secret Entrance

## Resumen del Problema
Se nos proporciona una lista de rotaciones para la ruleta de una caja fuerte (ej. `L19`, `R24`). La ruleta va del 0 al 99. Empezando en 50, debemos aplicar cada rotación secuencialmente. La verdadera "contraseña" es la cantidad total de veces que la ruleta queda apuntando exactamente al `0` después de cualquier rotación.

## Patrones y Principios Aplicados

### 1. Principio de Responsabilidad Única (SRP) y Alta Cohesión
El código se ha dividido en clases altamente cohesivas, donde cada una tiene una única razón para cambiar:
- `Rotation`: Su única responsabilidad es modelar los datos y realizar el parsing básico de un texto a objeto de dominio.
- `DialSimulator`: Su única responsabilidad es contener la lógica de negocio (simulación de la ruleta y conteo de cruces por cero). No sabe de dónde vienen los datos.
- `Part1`: Actúa como clase ensambladora. Su responsabilidad es coordinar la lectura de datos, el procesamiento y la salida por pantalla.

### 2. Diseño por Contrato y Abstracción
Se ha creado la interfaz `PuzzleReader` en el paquete `shared`.
- **Beneficio**: Las clases que resuelven los problemas (como `Part1`) dependen de la abstracción `PuzzleReader` en lugar de una implementación concreta. Esto reduce el acoplamiento y permite que el origen de los datos cambie sin alterar la lógica.

### 3. Inyección de Dependencias
Aunque simplificada en un script `main`, la dependencia de cómo leer los datos se inyecta utilizando implementaciones de `PuzzleReader`, lo que facilita la modularidad.

### 4. Patrón Factory Method y Ocultación de Constructores
En `FilePuzzleReader`:
- Se utiliza un constructor privado: `private FilePuzzleReader(Path path)`.
- Se expone un Factory Method estático: `public static FilePuzzleReader of(String path)`.
- **Beneficio**: Permite encapsular la lógica de creación del objeto, en este caso la conversión del `String` a `Path`, controlando cómo se instancian los objetos desde fuera.

### 5. Inmutabilidad (Records)
Se utiliza `public record Rotation(char direction, int distance)`.
- **Beneficio**: Los *records* introducidos en Java evitan el código repetitivo (getters, setters, equals) y garantizan la inmutabilidad de los datos, lo cual es fundamental para reducir efectos secundarios inesperados al pasar los objetos entre métodos.

### 6. Uso de la API de Streams (Java 8+)
En lugar de iterar manualmente con bucles `for`, se utiliza programación funcional:
- **Carga de datos**: `.stream().map(Rotation::parse).collect(Collectors.toList())`.
- **Lógica de negocio**: En `DialSimulator`, se utiliza `mapToInt` para ir calculando las posiciones secuenciales y `filter` para encontrar cuántas terminan en cero. Esto mejora la legibilidad, reduce variables de estado intermedias y plantea las operaciones de manera declarativa.
