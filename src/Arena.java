public class Arena {
    private User player1;
    private User player2;
    private Field leftField;
    private Field midField;
    private Field rightField;
    private int currentRound;
    private int finalRound;
    private boolean gameOver;

    
    public Arena(User[] lobbyUsers1, User[] lobbyUsers2) {
        this.player1 = lobbyUsers1[0];
        this.player2 = lobbyUsers2[0];
        this.leftField = new Field();
        this.midField = new Field();
        this.rightField = new Field();
        this.currentRound = 1;
        this.finalRound = 7;
        this.gameOver = false;
    }

    public void setFinalRound(int finalRound) {
        this.finalRound = finalRound;
    }

    // Método para realizar um turno de jogo
    public void playTurn() {
        
        // Verificar se o jogo terminou
        if (currentRound > finalRound) {
            gameOver = true;
            endGame();
        }
    }

    private int decideSituationField(Field fieldToSetSituation){
        if(fieldToSetSituation.getYourSideFieldTotalPower() > fieldToSetSituation.getOpponentSideFieldTotalPower()){
            return 1;
        }
        else if(fieldToSetSituation.getYourSideFieldTotalPower() < fieldToSetSituation.getOpponentSideFieldTotalPower()){
            return 2;
        }
        return 0;
    }
    // Método para finalizar o jogo
    private void endGame() {
        int situationLeftField = decideSituationField(leftField);
        int situationMidField = decideSituationField(midField);
        int situationRightField = decideSituationField(rightField);
        int[] situationGame = {situationLeftField, situationMidField, situationRightField};
        int countLocationPlayer1Win = 0;
        int countLocationPlayer2Win = 0;
        for (int i = 0; i < situationGame.length; i++) {
            if(situationGame[i] == 1){
                countLocationPlayer1Win++;
            }
            if(situationGame[i] == 2){
                countLocationPlayer2Win++;
            }
        }
        if (countLocationPlayer1Win > countLocationPlayer2Win) {
            System.out.println(player1.getUsername() + " venceu!");
        } else if (countLocationPlayer1Win < countLocationPlayer2Win) {
            System.out.println(player2.getUsername() + " venceu!");
        }else{
            System.out.println("Empate");
        }
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