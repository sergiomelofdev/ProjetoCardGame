import java.util.ArrayList;

public class Arena {
    private ArrayList<Field> fields; //todos os campos da arena
    private User player1; //jogador 1
    private User player2; //jogador 2
    private Card[] choseDeckplayer1; //deck do jogador 1
    private Card[] choseDeckplayer2; //deck do jogador 2
    private ArrayList<Card> player1Hand; //mao atual do jogador 1
    private ArrayList<Card> player2Hand; //mao atual do jogador 2
    private int temporalEnergyplayer1; //número de energia de cada jogador
    private int temporalEnergyplayer2; //número de energia de cada jogador
    private ArrayList<Card> garbage; //lugar onde as cartas descartadas vao
    private ArrayList<Card> cemetery; //lugar onde as cartas destruidas vao
    private int currentRound; //número da rodada atual
    private int finalRound; //número da rodada final
    private boolean gameOver; //se o jogo acabou

    
    public Arena(Lobby lobbyTeamBlue, Lobby lobbyTeamRed) {
        this.player1 = lobbyTeamBlue.getPlayers()[0];
        this.player2 = lobbyTeamRed.getPlayers()[0];
        //this.choseDeckplayer1 = player1.getChoseDeck();
        //this.choseDeckplayer2 = player2.getChoseDeck();
        this.garbage = new ArrayList<Card>();
        this.cemetery = new ArrayList<Card>();
        Field field1 = new Field();
        Field field2 = new Field();
        Field field3 = new Field();
        fields.add(field1);
        fields.add(field2);
        fields.add(field3);
        this.currentRound = 0;
        this.finalRound = 7;
        this.gameOver = false;
    }

    public void setFinalRound(int finalRound) {
        this.finalRound = finalRound;
    }

    public void buyCard(int qtdCardToBuy) {
        Random random = new Random();
        
    }
    // Método para realizar um turno de jogo
    public void playTurn() {
        // Verificar se o jogo terminou
        if (currentRound > finalRound) {
            gameOver = true;
            endGame();
        }
        currentRound++;
        //inicio da partida
        if(currentRound == 1){

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
        int countLocationplayer1Wins = 0;
        int countLocationplayer2Wins = 0; 
        //contando em quantos campos cada jogador venceu
        for(int i = 0; i < fields.size(); i++) {
            if(decideSituationField(fields.get(i)) == 1){
                countLocationplayer1Wins++;
            }else if(decideSituationField(fields.get(i)) == 2){
                countLocationplayer2Wins++;
            }
        }
        // depois da contagem, verifica qual jogador venceu
        if (countLocationplayer1Wins > countLocationplayer2Wins) {
            System.out.println(player1.getUsername() + " venceu!");
        } else if (countLocationplayer1Wins < countLocationplayer2Wins) {
            System.out.println(player2.getUsername() + " venceu!");
        }else{
            System.out.println("Empate");
        }
    }

    // Método para iniciar o jogo
    public void startGame() {
        System.out.print("Iniciando partida entre ");
        System.out.println(player1.getUsername() + " e " + player2.getUsername());
        
        // Lógica para inicialização do jogo, como distribuir cartas, escolher quem começa, etc.
        while (!gameOver) {
            playTurn();
        }
    }
}