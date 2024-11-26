import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Busca {
    private int id;
    private Date data;
    private FiltroDeBusca filtros;
    private static List<Busca> historicoBuscas = new ArrayList<>(); // Lista estática para armazenar histórico de buscas

    // Construtor correto que aceita (int, Date, FiltroDeBusca)
    public Busca(int id, Date data, FiltroDeBusca filtros) {
        this.id = id;
        this.data = data;
        this.filtros = filtros;
    }

    // Implementação do método processarBusca
    public ResultadoBusca processarBusca(FiltroDeBusca filtros) {
        this.data = new Date();
        this.filtros = filtros;

        // Simulação da lista de especialistas disponíveis (normalmente seria uma consulta a um banco de dados)
        List<Especialista> todosEspecialistas = obterEspecialistasSimulados();

        // Lista para armazenar os especialistas que correspondem aos filtros
        List<Especialista> especialistasFiltrados = new ArrayList<>();

        // Filtragem de especialistas com base nos filtros fornecidos
        for (Especialista especialista : todosEspecialistas) {
            if (correspondeAoFiltro(especialista, filtros)) {
                especialistasFiltrados.add(especialista);
            }
        }

        // Cria um objeto ResultadoBusca com a lista filtrada
        ResultadoBusca resultado = new ResultadoBusca();
        resultado.setListaEspecialistas(especialistasFiltrados);

        // Salva a busca no histórico
        salvarBusca(this);

        return resultado;
    }

    // Método auxiliar para verificar se um especialista corresponde aos filtros
    private boolean correspondeAoFiltro(Especialista especialista, FiltroDeBusca filtros) {
        boolean corresponde = true;

        if (filtros.getEspecialidade() != null && !filtros.getEspecialidade().isEmpty()) {
            corresponde &= especialista.getEspecialidade().equalsIgnoreCase(filtros.getEspecialidade());
        }
        if (filtros.getLocalizacao() != null && !filtros.getLocalizacao().isEmpty()) {
            corresponde &= especialista.getLocalizacao().equalsIgnoreCase(filtros.getLocalizacao());
        }
        if (filtros.getDistancia() > 0) {
            // Aqui pode-se implementar uma lógica de distância, mas estou usando um exemplo simples
            corresponde &= especialista.getPreco() <= filtros.getDistancia(); // Exemplo usando preço como distância
        }
        if (filtros.getTipoServico() != null && !filtros.getTipoServico().isEmpty()) {
            corresponde &= especialista.getEspecialidade().equalsIgnoreCase(filtros.getTipoServico());
        }

        return corresponde;
    }

    // Implementação do método salvarBusca
    public void salvarBusca(Busca busca) {
        historicoBuscas.add(busca);
    }

    // Método auxiliar para obter uma lista simulada de especialistas
    private List<Especialista> obterEspecialistasSimulados() {
        List<Especialista> especialistas = new ArrayList<>();
        
        // Adicionando especialistas simulados para exemplo
        Especialista e1 = new Especialista();
        e1.setId(1);
        e1.setNome("Dr. João");
        e1.setEspecialidade("Cardiologista");
        e1.setLocalizacao("Centro");
        e1.setPreco(150.0f);

        Especialista e2 = new Especialista();
        e2.setId(2);
        e2.setNome("Dra. Maria");
        e2.setEspecialidade("Dermatologista");
        e2.setLocalizacao("Zona Norte");
        e2.setPreco(100.0f);

        Especialista e3 = new Especialista();
        e3.setId(3);
        e3.setNome("Dr. Pedro");
        e3.setEspecialidade("Ortopedista");
        e3.setLocalizacao("Centro");
        e3.setPreco(200.0f);

        especialistas.add(e1);
        especialistas.add(e2);
        especialistas.add(e3);

        return especialistas;
    }

    // Método para gerar um ID único (simples exemplo)
    private int gerarIdUnico() {
        return historicoBuscas.size() + 1; // Usa o tamanho da lista de histórico para gerar um ID único
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public FiltroDeBusca getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltroDeBusca filtros) {
        this.filtros = filtros;
    }

    // Método estático para acessar o histórico de buscas
    public static List<Busca> getHistoricoBuscas() {
        return historicoBuscas;
    }

    // Método para retornar uma descrição da busca (para exibição em testes)
    @Override
    public String toString() {
        return "Busca ID: " + id + ", Data: " + data.toString() + ", Filtros: " + filtros.toString();
    }
}
