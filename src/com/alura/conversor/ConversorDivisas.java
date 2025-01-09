package com.alura.conversor;

import com.google.gson.Gson;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class ConversorDivisas {

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/5c43e76467d6def59dd8422b/latest/USD";

    public static ExchangeRateResponse getExchangeRates() throws Exception {
        URL url = new URL(API_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        if (connection.getResponseCode() == 200) {
            Gson gson = new Gson();
            InputStreamReader reader = new InputStreamReader(connection.getInputStream());
            return gson.fromJson(reader, ExchangeRateResponse.class);
        } else {
            throw new RuntimeException("Error al obtener los datos de la API.");
        }
    }

    public static double convertir(double monto, double tasa) {
        return monto * tasa;
    }

    public static void mostrarMenuMonedas() {
        System.out.println("Seleccione la moneda a la que desea convertir:");
        System.out.println("1. Peso Argentino (ARS)");
        System.out.println("2. Real Brasileño (BRL)");
        System.out.println("3. Peso Colombiano (COP)");
        System.out.println("4. Peso Mexicano (MXN)");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        List<String> historial = new ArrayList<>();

        try {
            // Obtener tasas de cambio
            ExchangeRateResponse response = getExchangeRates();
            Map<String, Double> tasas = response.getConversion_rates();

            while (continuar) {
                System.out.println("\n=== Conversor de Divisas ===");
                System.out.print("Ingrese el monto en USD: ");
                double monto = scanner.nextDouble();

                // Mostrar opciones
                mostrarMenuMonedas();
                int opcion = scanner.nextInt();
                String monedaSeleccionada = null;

                switch (opcion) {
                    case 1 -> monedaSeleccionada = "ARS";
                    case 2 -> monedaSeleccionada = "BRL";
                    case 3 -> monedaSeleccionada = "COP";
                    case 4 -> monedaSeleccionada = "MXN";
                    default -> {
                        System.out.println("Opción no válida. Intente nuevamente.");
                        continue;
                    }
                }

                // Realizar conversión
                double tasa = tasas.get(monedaSeleccionada);
                double resultado = convertir(monto, tasa);

                // Mostrar resultado y guardar en historial
                String conversion = String.format("%.2f USD = %.2f %s", monto, resultado, monedaSeleccionada);
                System.out.println("Monto convertido: " + conversion);
                historial.add(conversion);

                // Preguntar si desea ver el historial
                System.out.print("¿Desea ver el historial de conversiones? (s/n): ");
                char verHistorial = scanner.next().toLowerCase().charAt(0);
                if (verHistorial == 's') {
                    System.out.println("\n=== Historial de Conversiones ===");
                    for (String registro : historial) {
                        System.out.println(registro);
                    }
                }

                // Preguntar si desea continuar
                System.out.print("¿Desea realizar otra conversión? (s/n): ");
                char respuesta = scanner.next().toLowerCase().charAt(0);
                continuar = (respuesta == 's');
            }

            System.out.println("¡Gracias por usar el conversor de divisas!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}



