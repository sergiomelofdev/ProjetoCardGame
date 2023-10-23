import java.util.Random;

public class ArenaDupla  extends Arena {
    private User player3;
    private User player4;
    private QueueCards choseDeckplayer3;
    private QueueCards choseDeckplayer4;
    private QueueCards player3Hand;
    private QueueCards player4Hand; 
    private int qtdCardInDeckPlayer3;
    private int qtdCardInDeckPlayer4;
    private int temporalEnergyplayer3;
    private int temporalEnergyplayer4;

    public ArenaDupla(Lobby lobbyTeamBlue, Lobby lobbyTeamRed){
        super(lobbyTeamBlue, lobbyTeamRed);
        this.player3 = lobbyTeamBlue.getPlayers()[1];
        this.player4 = lobbyTeamRed.getPlayers()[1];
        this.choseDeckplayer3 = player3.getChosedDeckToPlay().getCards();
        this.choseDeckplayer4 = player4.getChosedDeckToPlay().getCards();
        this.qtdCardInDeckPlayer3 = choseDeckplayer3.getVetorQueue().length;
        this.qtdCardInDeckPlayer4 = choseDeckplayer4.getVetorQueue().length;
        this.player3Hand = new QueueCards(7);
        this.player4Hand = new QueueCards(7);
        Field field4 = new Field();
        Field field5 = new Field();
        fields.add(field4);
        fields.add(field5);
    }

    @Override
    protected void beginTurn(){
        buyCard(3, player1);
        buyCard(3, player2);
        buyCard(3, player3);
        buyCard(3, player4);
        Random random = new Random();
        int coin = random.nextInt(2);
        if(coin == 0){
            //time 1 começa
        }else{
            //time 2 começa
        }
    }

    @Override
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
        temporalEnergyplayer3++;
        temporalEnergyplayer4++;
        buyCard(1, player1);
        buyCard(1, player2);
        buyCard(1, player3);
        buyCard(1, player4);
        
    }

    @Override
    public void buyCard(int qtdCardToBuy, User player) {
        Random random = new Random();
        if(player.compareTo(player1) == 1){
            for (int i = 0; i < qtdCardToBuy; i++) {
                int posCardInDeck = random.nextInt(qtdCardInDeckPlayer1);
                player1Hand.addCardInQueue(removeCardInDeck(posCardInDeck, player1));
            }
        }else if(player.compareTo(player2) == 1){
            for (int i = 0; i < qtdCardToBuy; i++) {
                int posCardInDeck = random.nextInt(qtdCardInDeckPlayer2);
                player2Hand.addCardInQueue(removeCardInDeck(posCardInDeck, player2));
            }
        }else if(player.compareTo(player3) == 1){
            for (int i = 0; i < qtdCardToBuy; i++) {
                int posCardInDeck = random.nextInt(qtdCardInDeckPlayer3);
                player3Hand.addCardInQueue(removeCardInDeck(posCardInDeck, player3));
            }
        }else if(player.compareTo(player4) == 1){
            for (int i = 0; i < qtdCardToBuy; i++) {
                int posCardInDeck = random.nextInt(qtdCardInDeckPlayer4);
                player4Hand.addCardInQueue(removeCardInDeck(posCardInDeck, player4));
            }
        }
        
    }

    @Override
    public Card removeCardInDeck(int posCardInDeck, User player){
        if(player.compareTo(player1) == 1){
            return choseDeckplayer1.removeCardQueue(choseDeckplayer1.getVetorQueue()[posCardInDeck]);
            
        }else if(player.compareTo(player2) == 1){
            return choseDeckplayer2.removeCardQueue(choseDeckplayer2.getVetorQueue()[posCardInDeck]);

        }else if(player.compareTo(player3) == 1){
            return choseDeckplayer3.removeCardQueue(choseDeckplayer3.getVetorQueue()[posCardInDeck]);

        }else{
            return choseDeckplayer4.removeCardQueue(choseDeckplayer4.getVetorQueue()[posCardInDeck]);
        }
    }
}