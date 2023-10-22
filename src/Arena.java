import java.util.ArrayList;
import java.util.Random;

public class Arena {
    protected ArrayList<Field> fields; //todos os campos da arena
    protected User player1; //jogador 1
    protected User player2; //jogador 2
    protected Card[] choseDeckplayer1; //deck do jogador 1
    protected int qtdCardInDeckPlayer1;
    protected Card[] choseDeckplayer2; //deck do jogador 2
    protected int qtdCardInDeckPlayer2;
    protected ArrayList<Card> player1Hand; //mao atual do jogador 1
    protected ArrayList<Card> player2Hand; //mao atual do jogador 2
    protected int temporalEnergyplayer1; //número de energia de cada jogador
    protected int temporalEnergyplayer2; //número de energia de cada jogador
    protected ArrayList<Card> garbage; //lugar onde as cartas descartadas vao
    protected ArrayList<Card> cemetery; //lugar onde as cartas destruidas vao
    protected int currentRound; //número da rodada atual
    protected int finalRound; //número da rodada final
    protected boolean gameOver; //se o jogo acabou

    
    public Arena(Lobby lobbyTeamBlue, Lobby lobbyTeamRed) {
        this.player1 = lobbyTeamBlue.getPlayers()[0];
        this.player2 = lobbyTeamRed.getPlayers()[0];
        this.choseDeckplayer1 = player1.getChoseDeck().clone();
        this.choseDeckplayer2 = player2.getChoseDeck().clone();
        this.qtdCardInDeckPlayer1 = choseDeckplayer1.length;
        this.qtdCardInDeckPlayer2 = choseDeckplayer2.length;
        this.garbage = new ArrayList<Card>();
        this.cemetery = new ArrayList<Card>();
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
        if(player.compareTo(player1)){
            for (int i = posCardInDeck; i < choseDeckplayer1.length; i++) {
                if(choseDeckplayer1[i] == null){
                    break;
                }
                if(i == choseDeckplayer1.length-1 && choseDeckplayer1 != null){
                    choseDeckplayer1[i] = null;
                    break;
                }
                choseDeckplayer1[i] = choseDeckplayer1[i+1];
            }
            qtdCardInDeckPlayer1--;
            return choseDeckplayer1[posCardInDeck];
        }else{
            for (int i = posCardInDeck; i < choseDeckplayer2.length; i++) {
                if(choseDeckplayer2[i] == null){
                    break;
                }
                if(i == choseDeckplayer2.length-1 && choseDeckplayer2[i] != null){
                    choseDeckplayer2[i] = null;
                    break;
                }
                choseDeckplayer2[i] = choseDeckplayer2[i+1];
            }
            qtdCardInDeckPlayer2--;
            return choseDeckplayer2[posCardInDeck];
        }
    }
    public void buyCard(int qtdCardToBuy, User player) {
        Random random = new Random();
        if(player.compareTo(player1)){
            for (int i = 0; i < qtdCardToBuy; i++) {
                int posCardInDeck = random.nextInt(qtdCardInDeckPlayer1);
                player1Hand.add(removeCardInDeck(posCardInDeck, player1));
            }
        }else{
            for (int i = 0; i < qtdCardToBuy; i++) {
                int posCardInDeck = random.nextInt(qtdCardInDeckPlayer2);
                player2Hand.add(removeCardInDeck(posCardInDeck, player2));
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