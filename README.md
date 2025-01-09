# Conversor de Monedas

## Descripción
Este es un programa en Java que permite realizar conversiones entre el dólar estadounidense (USD) y cuatro monedas de América Latina:
- Peso Argentino (ARS)
- Real Brasileño (BRL)
- Peso Colombiano (COP)
- Peso Mexicano (MXN)

El programa utiliza la API **ExchangeRate** para obtener las tasas de cambio actuales y permite al usuario realizar varias conversiones en una misma sesión. Además, incluye un historial de conversiones que el usuario puede consultar en cualquier momento.

## Características
- Conversión de USD a las siguientes monedas y viceversa:
  - Peso Argentino (ARS)
  - Real Brasileño (BRL)
  - Peso Colombiano (COP)
  - Peso Mexicano (MXN)
- Historial de conversiones.
- Menú interactivo con opciones numéricas.
- Posibilidad de realizar múltiples conversiones en una sola sesión.

## Requisitos
- **Java** 8 o superior.
- Conexión a Internet para obtener las tasas de cambio desde la API.
- Dependencia de la librería **Gson** para manejar el formato JSON.

## Instalación
1. Clona este repositorio:
   ```bash
   git clone https://github.com/tuusuario/conversor-moneda-ALURA.git
   ```

2. Importa el proyecto en **IntelliJ IDEA**.

3. Agrega la dependencia de **Gson** al proyecto:
   - Si estás usando Maven, agrega lo siguiente al archivo `pom.xml`:
     ```xml
     <dependency>
         <groupId>com.google.code.gson</groupId>
         <artifactId>gson</artifactId>
         <version>2.8.9</version>
     </dependency>
     ```
   - Si estás usando Gradle, agrega lo siguiente a tu archivo `build.gradle`:
     ```gradle
     implementation 'com.google.code.gson:gson:2.8.9'
     ```

4. Reemplaza `YOUR_API_KEY` en el código con tu clave de la API ExchangeRate. Puedes obtenerla registrándote en [ExchangeRate](https://www.exchangerate-api.com/).

5. Compila y ejecuta el proyecto.

## Uso
1. Al iniciar el programa, se te pedirá que ingreses el monto en USD que deseas convertir.
2. Selecciona la moneda a la que deseas convertir utilizando las opciones numeradas.
3. El programa mostrará el resultado de la conversión.
4. Podrás:
   - Realizar otra conversión.
   - Consultar el historial de conversiones.
   - Salir del programa.

## Ejemplo de Ejecución
```
=== Conversor de Divisas ===
Ingrese el monto en USD: 100
Seleccione la moneda a la que desea convertir:
1. Peso Argentino (ARS)
2. Real Brasileño (BRL)
3. Peso Colombiano (COP)
4. Peso Mexicano (MXN)
Opcion: 2
Monto convertido: 100.00 USD = 507.50 BRL
¿Desea ver el historial de conversiones? (s/n): s

=== Historial de Conversiones ===
100.00 USD = 507.50 BRL
¿Desea realizar otra conversión? (s/n): n
¡Gracias por usar el conversor de divisas!
```

## Contribución
Si deseas contribuir a este proyecto:
1. Haz un fork del repositorio.
2. Crea una rama con la funcionalidad o corrección: `git checkout -b mi-rama`.
3. Realiza los cambios y haz un commit: `git commit -m "Mi cambio"`.
4. Sube los cambios: `git push origin mi-rama`.
5. Abre un pull request en este repositorio.

## Licencia
Este proyecto está bajo la licencia MIT. Consulta el archivo `LICENSE` para más detalles.

