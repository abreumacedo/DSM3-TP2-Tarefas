import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try {
            // Obter os produtos da API
            List<Produto> produtos = ApiService.obterDados();

            // Leitura do valor máximo informado pelo usuário
            Scanner scanner = new Scanner(System.in);
            System.out.print("Informe o valor máximo (em reais): ");
            double precoMaximo = scanner.nextDouble();

            // Filtrando os produtos imperdíveis
            List<Produto> imperdiveis = produtos.stream()
                    .filter(produto -> produto.getPreco() < precoMaximo)
                    .collect(Collectors.toList());

            // Exibindo os produtos imperdíveis
            System.out.println("Produtos imperdíveis (menos de " + precoMaximo + " reais):");
            for (Produto produto : imperdiveis) {
                System.out.println(produto + " - EM PROMOÇÃO");
            }

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
