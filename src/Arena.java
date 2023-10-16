import java.util.ArrayList;

public class Arena {
    private ArrayList<User> teamBlue;
    private ArrayList<User> teamRed;
    private ArrayList<Field> fields;
    private int currentRound;
    private int finalRound;
    private boolean gameOver;

    
    public Arena(Lobby lobbyTeamBlue, Lobby lobbyTeamRed) {
        for(int i = 0; i < lobbyTeamBlue.getPlayers().length; i++) {
            teamBlue.add(lobbyTeamBlue.getPlayers()[i]);
        }
        for(int i = 0; i < lobbyTeamRed.getPlayers().length; i++) {
            teamRed.add(lobbyTeamRed.getPlayers()[i]);
        }
        Field field1 = new Field();
        Field field2 = new Field();
        Field field3 = new Field();
        fields.add(field1);
        fields.add(field2);
        fields.add(field3);
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
        int countLocationTeamBlueWins = 0;
        int countLocationTeamRedWins = 0;
        for(int i = 0; i < fields.size(); i++) {
            if(decideSituationField(fields.get(i)) == 1){
                countLocationTeamBlueWins++;
            }else if(decideSituationField(fields.get(i)) == 2){
                countLocationTeamRedWins++;
            }
        }
        if (countLocationTeamBlueWins > countLocationTeamRedWins) {
            for(int i = 0; i < teamBlue.size(); i++) {
                System.out.println(teamBlue.get(i).getUsername() + " venceu!");
            }
        } else if (countLocationTeamBlueWins < countLocationTeamRedWins) {
            for(int i = 0; i < teamRed.size(); i++) {
                System.out.println(teamRed.get(i).getUsername() + " venceu!");
            }
        }else{
            System.out.println("Empate");
        }
    }

    // Método para iniciar o jogo
    public void startGame() {
        System.out.print("Iniciando partida entre ");
        if(teamBlue.size() == 1 && teamRed.size() == 1){
            System.out.println(teamBlue.get(0).getUsername() + " e " + teamRed.get(0).getUsername());
        }else{
            for (int i = 0; i < teamBlue.size(); i++) {
            System.out.print(teamBlue.get(i).getUsername() + " e ");
            }
            System.out.println("VS ");
            for (int i = 0; i < teamRed.size(); i++) {
                System.out.print(teamRed.get(i).getUsername() + " e ");
            }
            System.out.println();
        }
        
        // Lógica para inicialização do jogo, como distribuir cartas, escolher quem começa, etc.
        while (!gameOver) {
            playTurn();
        }
    }
}