import java.util.ArrayList;
import java.util.List;

public class ResultadoBusca {
    private int id;
    private List<Especialista> listaEspecialistas;

    // Implementação da função filtrarResultados
    public List<Especialista> filtrarResultados(FiltroDeBusca filtros) {
        List<Especialista> especialistasFiltrados = new ArrayList<>();

        for (Especialista especialista : listaEspecialistas) {
            boolean match = true;

            // Filtro de especialidade
            if (filtros.getEspecialidade() != null && !filtros.getEspecialidade().isEmpty()) {
                if (!especialista.getEspecialidade().equalsIgnoreCase(filtros.getEspecialidade())) {
                    match = false;
                }
            }

            // Filtro de localização
            if (filtros.getLocalizacao() != null && !filtros.getLocalizacao().isEmpty()) {
                if (!especialista.getLocalizacao().equalsIgnoreCase(filtros.getLocalizacao())) {
                    match = false;
                }
            }

            // Filtro de distância
            if (filtros.getDistancia() >= 0) {
                // Aqui você pode adicionar lógica para calcular a distância real entre o usuário e o especialista.
                // No exemplo, estou assumindo que a distância é um valor numérico que deve ser igual ou menor que o filtro.
                // Ajuste a lógica conforme necessário se a distância for calculada de outra forma.
                if (especialista.getPreco() > filtros.getDistancia()) {
                    match = false;
                }
            }

            // Filtro de disponibilidade
            if (filtros.getDisponibilidade() != null && !filtros.getDisponibilidade().isEmpty()) {
                // Supondo que a disponibilidade seja uma string que indica se o especialista está "disponível" ou "indisponível"
                if (!filtros.getDisponibilidade().equalsIgnoreCase("disponível")) {
                    match = false;
                }
            }

            // Filtro de tipo de serviço
            if (filtros.getTipoServico() != null && !filtros.getTipoServico().isEmpty()) {
                // Supondo que o tipo de serviço seja uma string categorizando o serviço do especialista
                if (!filtros.getTipoServico().equalsIgnoreCase("consulta") && 
                    !filtros.getTipoServico().equalsIgnoreCase("tratamento")) {
                    match = false;
                }
            }

            if (match) {
                especialistasFiltrados.add(especialista);
            }
        }

        return especialistasFiltrados;
    }

    // Implementação da função exibirResumoEspecialistas
    public void exibirResumoEspecialistas() {
        if (listaEspecialistas == null || listaEspecialistas.isEmpty()) {
            System.out.println("Nenhum especialista encontrado.");
            return;
        }

        // Exibe um resumo de cada especialista na lista
        System.out.println("Resumo dos Especialistas Encontrados:");
        for (Especialista especialista : listaEspecialistas) {
            System.out.println("Nome: " + especialista.getNome());
            System.out.println("Especialidade: " + especialista.getEspecialidade());
            System.out.println("Localização: " + especialista.getLocalizacao());
            System.out.println("Preço: R$ " + especialista.getPreco());
            System.out.println("---------------------------");
        }
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Especialista> getListaEspecialistas() {
        return listaEspecialistas;
    }

    public void setListaEspecialistas(List<Especialista> listaEspecialistas) {
        this.listaEspecialistas = listaEspecialistas;
    }
}
