import java.util.ArrayList;
import java.util.List;

public class Lobby {
    private List<User> players;

    public Lobby() {
        this.players = new ArrayList<>();
    }

    // Método para um jogador entrar no lobby
    public void enterLobby(User user) {
        players.add(user);
        System.out.println(user.getUsername() + " entrou no lobby.");
        tryMatchPlayers(user);
    }

    // Método para tentar fazer o matchmaking entre jogadores
    private void tryMatchPlayers(User user) {
        int userLevel = user.getLevel();
        String gameMode = "Normal Game"; // Modo de jogo padrão

        // Encontre um jogador compatível
        for (User opponent : players) {
            if (opponent != user && opponent.getLevel() == userLevel && gameMode.equals("Normal Game")) {
                System.out.println("Partida encontrada!");
                startArena(user, opponent, gameMode);
                return;
            }
        }

        System.out.println("Aguardando por um adversário...");
    }

    // Método para iniciar a Arena com dois jogadores
    private void startArena(User user1, User user2, String gameMode) {
        Arena arena = new Arena(user1, user2, gameMode);
        arena.startGame();
    }
}


/*A classe Lobby mantém uma lista de jogadores no lobby.
O método enterLobby permite que um jogador entre no lobby e, em seguida, tenta encontrar um adversário compatível chamando tryMatchPlayers.
O método tryMatchPlayers verifica se há um adversário compatível (mesmo nível e modo de jogo) para o jogador que entrou no lobby. Se um adversário compatível for encontrado, a Arena é iniciada.
O método startArena inicia a Arena com dois jogadores.
Observe que esta é uma implementação básica e que você pode personalizá-la e expandi-la de acordo com as necessidades do seu projeto. Além disso, você pode adicionar mais lógica ao matchmaking para lidar com casos específicos, como priorizar o tempo de espera, adicionar critérios adicionais de correspondência, etc.
*/




