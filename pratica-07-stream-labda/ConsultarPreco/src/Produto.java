public class Produto {
    private String nome;
    private double preco;

    // Construtor
    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public boolean emPromocao(double limite) {
        return preco < limite;
    }

    @Override
    public String toString() {
        return nome.toUpperCase() + " - R$ " + preco;
    }
}
