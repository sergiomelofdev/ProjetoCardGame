package Arenas;
import java.util.ArrayList;
import java.util.Random;
import ClientService.*;
import Cards.*;

public class Arena {
    protected ArrayList<Field> fields; //todos os campos da arena
    protected User player1; //jogador 1
    protected User player2; //jogador 2
    protected QueueCards choseDeckplayer1; //deck do jogador 1
    protected int qtdCardInDeckPlayer1;
    protected QueueCards choseDeckplayer2; //deck do jogador 2
    protected int qtdCardInDeckPlayer2;
    protected QueueCards player1Hand; //mao atual do jogador 1
    protected QueueCards player2Hand; //mao atual do jogador 2
    protected int temporalEnergyplayer1; //número de energia de cada jogador
    protected int temporalEnergyplayer2; //número de energia de cada jogador
    protected QueueCards garbage; //lugar onde as cartas descartadas vao
    protected QueueCards cemetery; //lugar onde as cartas destruidas vao
    protected int currentRound; //número da rodada atual
    protected int finalRound; //número da rodada final
    protected boolean gameOver; //se o jogo acabou

    
    public Arena(Lobby lobbyTeamBlue, Lobby lobbyTeamRed) {
        this.player1 = lobbyTeamBlue.getPlayers()[0];
        this.player2 = lobbyTeamRed.getPlayers()[0];
        this.choseDeckplayer1 = player1.getChosedDeckToPlay().getCards();
        this.choseDeckplayer2 = player2.getChosedDeckToPlay().getCards();
        this.qtdCardInDeckPlayer1 = choseDeckplayer1.getVetorQueue().length;
        this.qtdCardInDeckPlayer2 = choseDeckplayer2.getVetorQueue().length;
        this.garbage = new QueueCards(qtdCardInDeckPlayer1);
        this.cemetery = new QueueCards(qtdCardInDeckPlayer1);
        this.player1Hand = new QueueCards(7);
        this.player2Hand = new QueueCards(7);
        Field field1 = new Field();
        Field field2 = new Field();
        Field field3 = new Field();
        fields.add(field1);
        fields.add(field2);
        fields.add(field3);
        this.finalRound = 7;
        this.gameOver = false;
    }

    public void setFinalRound(int finalRound) {
        this.finalRound = finalRound;
    }

    public Card removeCardInDeck(int posCardInDeck, User player){
        if(player.compareTo(player1) == 1){
            return choseDeckplayer1.removeCardQueue(choseDeckplayer1.getVetorQueue()[posCardInDeck]);
        }else{
            return choseDeckplayer2.removeCardQueue(choseDeckplayer2.getVetorQueue()[posCardInDeck]);
        }
    }
    public void buyCard(int qtdCardToBuy, User player) {
        Random random = new Random();
        if(player.compareTo(player1) == 1){
            for (int i = 0; i < qtdCardToBuy; i++) {
                int posCardInDeck = random.nextInt(qtdCardInDeckPlayer1);
                player1Hand.addCardInQueue(removeCardInDeck(posCardInDeck, player1));
            }
        }else{
            for (int i = 0; i < qtdCardToBuy; i++) {
                int posCardInDeck = random.nextInt(qtdCardInDeckPlayer2);
                player2Hand.addCardInQueue(removeCardInDeck(posCardInDeck, player2));
            }
        }
        
    }
    protected void beginTurn(){
        buyCard(3, player1);
        buyCard(3, player2);
        Random random = new Random();
        int coin = random.nextInt(2);
        if(coin == 0){
            //player 1 começa
        }else{
            //player 2 começa
        }
    }
    // Método para realizar um turno de jogo
    public void playTurn() {
        currentRound++;
        // Verificar se o jogo terminou
        if (currentRound > finalRound) {
            gameOver = true;
            endGame();
            return;
        }
        //inicio do turno
        temporalEnergyplayer1++;
        temporalEnergyplayer2++;
        buyCard(1, player1);
        buyCard(1, player2);
        
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
    protected void endGame() {
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
        beginTurn();
        // Lógica para inicialização do jogo, como distribuir cartas, escolher quem começa, etc.
        while (!gameOver) {
            playTurn();
        }
    }
}