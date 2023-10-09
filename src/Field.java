
// Classe que representa o campo do jogo falta implementar atributos = sub camos e seu tamanho e habilidade/tipo/efeito, metodos de retirar e inserir cartas 
public class Field {
    //atributos referentes ao lado jogador q esta visualizando o jogo 
    private Card[][] yourSubField;
    private int qtdCardsInYourSubField;
    private int yourSideFieldTotalPower;

    //atributos referentes ao lado do oponente
    private Card[][] subFieldOpponent;
    private int qtdCardsSubFieldOpponent;
    private int opponentSideFieldTotalPower;	
    
    private String nameField;	
    private EffectField effectField;
    private final int maxCardsSubField = 4; // tamanho max de cartas em cada campo ainda a ser determinado

    public int getYourSideFieldTotalPower() {
        return yourSideFieldTotalPower;
    }
    public int getOpponentSideFieldTotalPower() {
        return opponentSideFieldTotalPower;
    }

    public enum EffectField {
        noEffect,
        disableCardEffects,
        reduce1PowerCardsPerTurn,
        increasePowerCards,
        discartOneCardBothHands,
        fillBothHands
        //apenas esses efeitos, por enquanto...
    }
    
    public Field(String nameField, EffectField effectField) {
        this.nameField = nameField;
        this.effectField = effectField;
        yourSubField = new Card[maxCardsSubField/2][maxCardsSubField/2];
        subFieldOpponent = new Card[maxCardsSubField/2][maxCardsSubField/2];
    }

    public boolean yourFieldIsFull() {
        return qtdCardsInYourSubField == maxCardsSubField; 
    }
    public boolean opponentFieldIsFull() {
        return qtdCardsSubFieldOpponent == maxCardsSubField;
    }
    public boolean yourFieldIsEmpty() {
        return qtdCardsInYourSubField == 0; 
    }
    public boolean opponentFieldIsEmpty() {
        return qtdCardsSubFieldOpponent == 0;
    }

    public Card putCardInYourField(Card insertedCard) {
        if(yourFieldIsFull()){
            return null;
        }
        for(int lineFieldIndex = 0; lineFieldIndex < (maxCardsSubField/2); lineFieldIndex++) {
            for(int columnFieldIndex = 0; columnFieldIndex < (maxCardsSubField/2); columnFieldIndex++) {
                if(yourSubField[lineFieldIndex][columnFieldIndex] == null) {
                    yourSubField[lineFieldIndex][columnFieldIndex] = insertedCard;
                    qtdCardsInYourSubField++;
                    return insertedCard;
                }
            }
        }
        return null;
    }

    public Card remoCardFromYourField(Card removedCard) {
        if(yourFieldIsEmpty()){
            return null;
        }
        for(int lineFieldIndex = 0; lineFieldIndex < (maxCardsSubField/2); lineFieldIndex++) {
            for(int columnFieldIndex = 0; columnFieldIndex < (maxCardsSubField/2); columnFieldIndex++) {
                if(yourSubField[lineFieldIndex][columnFieldIndex] == removedCard) {
                    //se achar a carta q deseja remover no campo, a carta sera removida e todas as cartas depois dela vao andar como uma fila
                    
                }
            }
        }
    }

    public void updateTotalPowerBothSides(){
        int totalSumPowerYourSide = 0;
        for (int i = 0; i < maxCardsSubField/2; i++) {
            for (int j = 0; j < maxCardsSubField/2; j++) {
                if(yourSubField[i][j] != null){
                    totalSumPowerYourSide += yourSubField[i][j].getPower();
                }
            }
        }
        int totalSumPowerOpponentSide = 0;
        for (int i = 0; i < maxCardsSubField/2; i++) {
            for (int j = 0; j < maxCardsSubField/2; j++) {
                if(subFieldOpponent[i][j] != null){
                    totalSumPowerYourSide += subFieldOpponent[i][j].getPower();
                }
            }
        }
    }

}