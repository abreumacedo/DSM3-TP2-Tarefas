import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiService {

    public static List<Produto> obterDados() throws Exception {
        String url = "https://api.escuelajs.co/api/v1/products/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();

        // Deserializa a resposta em um array de ProdutoDTO
        ProdutoDTO[] produtosDTO = mapper.readValue(response.body(), ProdutoDTO[].class);

        // Converte o array de ProdutoDTO para uma lista de Produto
        return Arrays.stream(produtosDTO)
                .map(dto -> new Produto(dto.nome(), dto.preco()))
                .collect(Collectors.toList());
    }
}
