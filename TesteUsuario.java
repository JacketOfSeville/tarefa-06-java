import java.util.Date;
import java.util.List;

public class TesteUsuario {
    public static void main(String[] args) {
        // Criação de um objeto Usuario
        Usuario usuario = new Usuario(1, "João Silva", "joao.silva@email.com");

        // Criação de alguns objetos FiltroDeBusca para teste
        FiltroDeBusca filtro1 = new FiltroDeBusca();
        filtro1.definirFiltros("Cardiologista", "Centro", 10.0f, "Disponível", "Consulta");

        FiltroDeBusca filtro2 = new FiltroDeBusca();
        filtro2.definirFiltros("Dermatologista", "Zona Sul", 15.0f, "Indisponível", "Tratamento");

        // Criação de objetos Busca para teste
        Busca busca1 = new Busca(1, new Date(), filtro1);
        Busca busca2 = new Busca(2, new Date(), filtro2);

        // Adiciona as buscas ao histórico do usuário
        usuario.adicionarBuscaAoHistorico(busca1);
        usuario.adicionarBuscaAoHistorico(busca2);

        // Testa a visualização do histórico de buscas
        System.out.println("---- Teste: Visualizar Histórico de Buscas ----");
        List<Busca> historico = usuario.visualizarHistoricoBuscas();
        
        // Verifica o conteúdo do histórico (apenas para garantir)
        if (!historico.isEmpty()) {
            System.out.println("Histórico contém " + historico.size() + " busca(s).");
        } else {
            System.out.println("Histórico está vazio.");
        }
    }
}
