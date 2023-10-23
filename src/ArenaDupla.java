import java.util.Random;

public class ArenaDupla  extends Arena {
    private User player3;
    private User player4;
    private QueueCards choseDeckplayer3;
    private QueueCards choseDeckplayer4;
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
        }else{
            for (int i = 0; i < qtdCardToBuy; i++) {
                int posCardInDeck = random.nextInt(qtdCardInDeckPlayer2);
                player2Hand.addCardInQueue(removeCardInDeck(posCardInDeck, player2));
            }
        }
        
    }

    @Override
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
        }else if(player.compareTo(player2)){
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
}