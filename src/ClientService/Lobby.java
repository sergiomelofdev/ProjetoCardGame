public class Lobby {

    private User[] players;
    private String gameMode;
    private int qtdUsersIntLobby;
    private int lobbyLevel;

    public Lobby() {
        players = new User[2];
    }
    private boolean isFull() {
        return qtdUsersIntLobby >= 2;
    }
    private boolean isEmpty() {
        return qtdUsersIntLobby == 0;
    }

    //metodos getters
    public String getGameMode() {
        return gameMode;
    }
    public int getLobbyLevel() {
        return lobbyLevel;
    }
    public int getQtdUsersIntLobby() {
        return qtdUsersIntLobby;
    }
    public User[] getPlayers() {
        return players;
    }

    // Método para um jogador entrar no lobby
    public void enterLobby(User enterUser) {
        if(isFull()) {
            System.out.println("O lobby está cheio!");
            return;
        }
        players[qtdUsersIntLobby] = enterUser;
        qtdUsersIntLobby++;
        System.out.println(enterUser.getUsername() + " entrou no lobby.");

        changeLobbyLevel();
        selectGameMode();
    }

    // metodo para remover jogadores do lobby
    public void leaveLobby(User leaveUser) {
        if (isEmpty()) {
            return;
        }
        if (players[0] == leaveUser && players[1] != null) {
            players[0] = players[1];
            players[1] = null;
            qtdUsersIntLobby--;
            System.out.println(leaveUser.getUsername() + " saiu do lobby.");
        } else if (players[1] == leaveUser && players[0]!= null) {
            players[1] = null;
            qtdUsersIntLobby--;
            System.out.println(leaveUser.getUsername() + " saiu do lobby.");
        }

        changeLobbyLevel();
        selectGameMode();
        //metodo implementado por enquanto para a penas a situação de apenas podere ter 2 players no lobby
    }

    // definindo o nivel do lobby: partindo do level dos players nele, se tiver dois players recebe o maior nivel dentre os players
    public void changeLobbyLevel() {
        if (qtdUsersIntLobby == 1){
            lobbyLevel = players[0].getLevel();
        }else if (qtdUsersIntLobby == 2){
            if (players[0].getLevel() > players[1].getLevel()){
                lobbyLevel = players[0].getLevel();
            }else{
                lobbyLevel = players[1].getLevel();
            }
        }
    }

    // metodo de definir o modo de jogo a partir do numero de players no lobby
    public void selectGameMode() {
        if(qtdUsersIntLobby == 2){
            gameMode = "Dual_Mode";
        }
        gameMode = "Normal_Game";
        //por enquanto apenas esses dois modos de jogo, porem no futuro...
    }

    // Método para tentar fazer o matchmaking entre jogadores
    public void tryMatchPlayers() {

        if(qtdUsersIntLobby == 1){
        System.out.println("Procurando um oponente digno...");
        }else if(qtdUsersIntLobby == 2){
            System.out.println("Procurando oponentes dignos...");
        }
        Lobby lobbyOpponent = new Lobby(); //lobby oponente ficticio

        //teste de lobby compativel
        if (lobbyOpponent.getGameMode().equals(this.gameMode) && lobbyOpponent.getLobbyLevel() == this.lobbyLevel) {
            startArena(lobbyOpponent);
        }
    }

    // Método para iniciar a Arena
    private void startArena(Lobby lobbyOpponent) {
        if(gameMode.equals("Dual_Mode")){
            ArenaDupla arenaDupla = new ArenaDupla(lobbyOpponent.getPlayers(), getPlayers());
            arenaDupla.startGame();
        }
        Arena arena = new Arena(lobbyOpponent.getPlayers(), getPlayers());
        arena.startGame();
    }
}