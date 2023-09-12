public class Arena {
    private User player1;
    private User player2;
    private Card[][] fieldPlayer1;
    private Card[][] fieldPlayer2;
    private int player1Life;
    private int player2Life;
    private boolean gameOver;

    
    public Arena(User player1, User player2, String gameMode) {
        this.player1 = player1;
        this.player2 = player2;
        this.fieldPlayer1 = new Card[2][5];
        this.fieldPlayer2 = new Card[2][5];
        this.player1Life = 20;
        this.player2Life = 20;
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