import com.fasterxml.jackson.annotation.JsonAlias;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ProdutoDTO(
        @JsonAlias({"title"}) String nome,
        @JsonAlias({"price"}) double preco
) {}