/**
 * Nome: Principal1.java
 * Descricao: Consulta a API dos correios com HTTP POST
 * Author: Lucio A. Rocha
 * Ultima atualizacao: 27/05/2025
 *
 */

import java.io.IOException;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

//Requisicao HTTP GET com autenticacao
public class Principal1 {

    private static final String getBasicAuthenticationHeader(String username, String password) {
        String valueToEncode = username + ":" + password;
        String result = "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        System.out.println("PrincipalAPI: envia mensagem para o servidor");
        
        //Funciona e retorna o body
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
	    .uri(URI.create("https://api.correios.com.br/token/v1/autentica"))
	    .POST(HttpRequest.BodyPublishers.noBody())
	    .header("Authorization", getBasicAuthenticationHeader("<SEU_CPF_DO_CADASTRO>", "<CODIGO_DE_ACESSO_DA_API>"))   
	    .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response: " + response.statusCode() + "\n" + response.toString() + "\n" + response.body());
        
        System.out.println("Fim!");
    }
}
