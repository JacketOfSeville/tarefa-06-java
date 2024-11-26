public class FiltroDeBusca {
    private String especialidade;
    private String localizacao;
    private float distancia;
    private String disponibilidade;
    private String tipoServico;

    // Construtor padrão
    public FiltroDeBusca() {}

    // Função para validar os filtros definidos
    public boolean validarFiltros() {
        // Verifica se a especialidade é válida
        if (especialidade == null || especialidade.trim().isEmpty()) {
            System.out.println("Erro: Especialidade não pode ser nula ou vazia.");
            return false;
        }

        // Verifica se a localização é válida
        if (localizacao == null || localizacao.trim().isEmpty()) {
            System.out.println("Erro: Localização não pode ser nula ou vazia.");
            return false;
        }

        // Verifica se a distância é positiva
        if (distancia < 0) {
            System.out.println("Erro: Distância deve ser um número positivo.");
            return false;
        }

        // Verifica se a disponibilidade é válida (ex: "disponível" ou "indisponível")
        if (disponibilidade == null || 
            (!disponibilidade.equalsIgnoreCase("disponível") && !disponibilidade.equalsIgnoreCase("indisponível"))) {
            System.out.println("Erro: Disponibilidade deve ser 'disponível' ou 'indisponível'.");
            return false;
        }

        // Verifica se o tipo de serviço é válido
        if (tipoServico == null || tipoServico.trim().isEmpty()) {
            System.out.println("Erro: Tipo de serviço não pode ser nulo ou vazio.");
            return false;
        }

        // Se todos os filtros são válidos
        return true;
    }

    // Função para definir os filtros
    public void definirFiltros(String especialidade, String localizacao, float distancia, String disponibilidade, String tipoServico) {
        this.especialidade = especialidade;
        this.localizacao = localizacao;
        this.distancia = distancia;
        this.disponibilidade = disponibilidade;
        this.tipoServico = tipoServico;
    }

    // Getters e Setters
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

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    // Método para retornar os filtros em forma de String (para facilitar o teste)
    @Override
    public String toString() {
        return "Especialidade: " + especialidade + ", Localização: " + localizacao +
                ", Distância: " + distancia + " km, Disponibilidade: " + disponibilidade +
                ", Tipo de Serviço: " + tipoServico;
    }
}
