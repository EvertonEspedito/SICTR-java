import org.json.JSONObject;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.scanner;

public class ProjetoSICTR {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite o nome da cidade: ");
		String cidade = scanner.nextLine();// Ler cidade digitada no teclado

		try{
			String dadosClimaticos = getDadosClimaticos(cidade); //retorna um JSON
			
			// Código 1006 significa que não foi encontrada.
			if (dadosClimaticos.contains("\"code\":1006")) {
				System.out.println("Localização não encontrada!");
			}else{
				imprimirDadosClimaticos(dadosClimaticos);
			}
		}catch(Exception e ){
			System.out.print(e.getMessage());
		}
	}

	//Metodos

	public static String getDadosClimaticos(String cidade) throws Exception{
		String apiKey = Files.readString( Paths.get("api-key.txt")).trim();

		String formataNomeCidade = URLEncoder.encoder(cidade, StandardCharsets.UTF_8);
		String apiurl = "http://api.weatherapi.com/v1/current.json?key=" + apiKey +"&q="+formataNomeCidade;

		HttpRequest request = HttpRequest.newBuilder() //Solicitação HTTP
			.uri(URI.create(apiurl)) // metodo define o URI da solicitação httṕ PAREU EM 7 minutos
	}
}

