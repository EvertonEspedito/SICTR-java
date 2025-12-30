import org.json.JSONObject;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.Scanner;

// COMPILAR: javac -cp .:json-20230618.jar ProjetoSICTR.java


public class ProjetoSICTR {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome da cidade: ");
        String cidade = scanner.nextLine();

        try {
            String dadosClimaticos = getDadosClimaticos(cidade);

            // Código 1006 → localização não encontrada
            if (dadosClimaticos.contains("\"code\":1006")) {
                System.out.println("Localização não encontrada!");
            } else {
                imprimirDadosClimaticos(dadosClimaticos);
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        scanner.close();
    }

    // ===============================
    // MÉTODO: BUSCAR DADOS CLIMÁTICOS
    // ===============================
    public static String getDadosClimaticos(String cidade) throws Exception {

        // Lê a API Key do arquivo
        String apiKey = Files.readString(Paths.get("api-key.txt")).trim();

        // Codifica o nome da cidade para URL
        String cidadeFormatada = URLEncoder.encode(cidade, StandardCharsets.UTF_8);

        String apiUrl =
                "http://api.weatherapi.com/v1/current.json?key="
                        + apiKey + "&q=" + cidadeFormatada + "&lang=pt";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    // ===============================
    // MÉTODO: IMPRIMIR DADOS
    // ===============================
    public static void imprimirDadosClimaticos(String dados) {

        JSONObject dadosJson = new JSONObject(dados);

        JSONObject location = dadosJson.getJSONObject("location");
        JSONObject current = dadosJson.getJSONObject("current");

        String cidade = location.getString("name");
        String pais = location.getString("country");

        String condicao = current.getJSONObject("condition").getString("text");
        int umidade = current.getInt("humidity");
        float vento = current.getFloat("wind_kph");
        float pressao = current.getFloat("pressure_mb");
        float sensacao = current.getFloat("feelslike_c");
        float temperatura = current.getFloat("temp_c");
        String dataHora = current.getString("last_updated");

        System.out.println("\n=== INFORMAÇÕES CLIMÁTICAS ===");
        System.out.println("Cidade: " + cidade + " - " + pais);
        System.out.println("Data/Hora: " + dataHora);
        System.out.println("Temperatura: " + temperatura + " °C");
        System.out.println("Sensação Térmica: " + sensacao + " °C");
        System.out.println("Condição: " + condicao);
        System.out.println("Umidade: " + umidade + "%");
        System.out.println("Vento: " + vento + " km/h");
        System.out.println("Pressão: " + pressao + " mb");
    }
}
