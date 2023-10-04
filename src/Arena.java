public class Arena {
    private User player1;
    private User player2;
    private Field fieldPlayer1;
    private Field fieldPlayer2;
    private boolean gameOver;

    
    public Arena(User[] lobbyUsers1, User[] lobbyUsers2) {
        this.player1 = lobbyUsers1[0];
        this.player2 = lobbyUsers2[0];
        this.fieldPlayer1 = new Field();
        this.fieldPlayer2 = new Field();
        this.gameOver = false;
    }

    // Método para realizar um turno de jogo
    public void playTurn() {
        // Lógica para um turno de jogo (colocar cartas no campo, atacar, etc.)
        // Atualizar os campos de cartas e pontos de vida conforme necessário

        // Exemplo simples: decrementar 1 ponto de vida de ambos os jogadores a cada turno
        player1Life--;
        player2Life--;

        // Verificar se o jogo terminou
        if (player1Life <= 0 || player2Life <= 0) {
            gameOver = true;
            endGame();
        }
    }

    // Método para finalizar o jogo
    private void endGame() {
        if (player1Life <= 0) {
            System.out.println(player1.getUsername() + " venceu!");
        } else if (player2Life <= 0) {
            System.out.println(player2.getUsername() + " venceu!");
        }
        // Lógica para conceder recompensas, registrar estatísticas, etc.
    }

    // Método para iniciar o jogo
    public void startGame() {
        System.out.println("Iniciando partida entre " + player1.getUsername() + " e " + player2.getUsername());
        // Lógica para inicialização do jogo, como distribuir cartas, escolher quem começa, etc.
        while (!gameOver) {
            playTurn();
        }
    }
}