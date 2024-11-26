import java.util.List;

public class Especialista {
    private int id;
    private String nome;
    private String especialidade;
    private String localizacao;
    private float preco;
    private List<Avaliacao> avaliacoes; // Lista de avaliações para este especialista

    // Implementação da função visualizaDetalhes
    public EspecialistaDetalhe visualizaDetalhes() {
        // Cria um novo objeto EspecialistaDetalhe com as informações detalhadas
        EspecialistaDetalhe detalhes = new EspecialistaDetalhe();
        detalhes.setNome(this.nome);
        detalhes.setEspecialidade(this.especialidade);
        detalhes.setEndereco(this.localizacao); // Supondo que a localização é o endereço
        detalhes.setPreco(this.preco);
        detalhes.setAvaliacoes(this.avaliacoes);

        // Adicionar informações adicionais, como horário e mapa, se disponíveis
        detalhes.setHorario("08:00 - 18:00"); // Exemplo de horário padrão, pode ser ajustado conforme necessário
        detalhes.setMapa("Link do Mapa Simulado"); // Exemplo de um link de mapa

        return detalhes;
    }

    // Implementação da função calcularMediaAvaliacoes
    public float calcularMediaAvaliacoes() {
        if (avaliacoes == null || avaliacoes.isEmpty()) {
            return 0; // Se não houver avaliações, retorna 0 como média
        }

        int somaNotas = 0;
        for (Avaliacao avaliacao : avaliacoes) {
            somaNotas += avaliacao.getNota(); // Soma todas as notas das avaliações
        }

        // Calcula a média dividindo a soma pelo número de avaliações
        return (float) somaNotas / avaliacoes.size();
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
}
